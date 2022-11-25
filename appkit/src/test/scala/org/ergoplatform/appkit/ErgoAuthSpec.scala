package org.ergoplatform.appkit

import org.ergoplatform.sdk.SecretString
import org.scalatest.matchers.should.Matchers
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import scorex.util.Random
import sigmastate.interpreter.HintsBag

import java.nio.charset.StandardCharsets

class ErgoAuthSpec extends AnyPropSpec with Matchers with ScalaCheckPropertyChecks
  with AppkitTestingCommon {

  property("ErgoAuth address round trip") {
    val sigmaPropFromAddress = SigmaProp.createFromAddress(address)
    // ---- server side ----
    val serializedSigmaBoolean = sigmaPropFromAddress.toBytes
    // message to sign should be something random and not repeating
    val requestedMessage = addrStr + System.currentTimeMillis().toString

    // ---- transferred to client, and now we are on client side ----

    // EIP-28: "the wallet app adds some own bytes to the obtained message from ErgoAuthRequest"
    val signedMessage = new String(Random.randomBytes(16)) + requestedMessage +
      new String(Random.randomBytes(32))
    val signature = new ColdErgoClient(address.getNetworkType, Parameters.ColdClientMaxBlockCost, Parameters.ColdClientBlockVersion)
      .execute { ctx: BlockchainContext =>

        val prover = ctx.newProverBuilder().withMnemonic(mnemonic, SecretString.empty(), false).build()
        prover.signMessage(SigmaProp.parseFromBytes(serializedSigmaBoolean),
          signedMessage.getBytes(StandardCharsets.UTF_8),
          HintsBag.empty)
      }

    // ---- transferred to server... ----
    ErgoAuthUtils.verifyResponse(sigmaPropFromAddress,
      requestedMessage, signedMessage, signature) shouldBe true

    // and in case someone wanted to fool us
    ErgoAuthUtils.verifyResponse(sigmaPropFromAddress,
      requestedMessage,
      signedMessage,
      new Array[Byte](0)) shouldBe false
  }

}
