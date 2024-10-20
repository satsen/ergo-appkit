package org.ergoplatform.appkit.impl

import org.ergoplatform.SigmaConstants
import org.ergoplatform.appkit._
import org.ergoplatform.sdk.ErgoToken

import scala.collection.mutable.ArrayBuffer

class OutBoxBuilderImpl(_txB: UnsignedTransactionBuilderImpl) extends OutBoxBuilder {
  private val _ctx = _txB.getCtx.asInstanceOf[BlockchainContextImpl]
  private var _value: Long = 0
  private var _contract: ErgoContract = _
  private val _tokens = ArrayBuffer.empty[ErgoToken]
  private val _registers = ArrayBuffer.empty[ErgoValue[_]]
  private var _creationHeightOpt: Option[Int] = None

  override def value(value: Long): OutBoxBuilderImpl = {
    _value = value
    this
  }

  override def contract(contract: ErgoContract): OutBoxBuilderImpl = {
    _contract = contract
    this
  }

  override def tokens(tokens: ErgoToken*): OutBoxBuilderImpl = {
    val maxTokens = SigmaConstants.MaxTokens.value
    require(tokens.size <= maxTokens, SigmaConstants.MaxTokens.description + s": $maxTokens")
    _tokens ++= tokens
    this
  }

  override def tokens(tokens: java.util.List[ErgoToken]): OutBoxBuilderImpl = {
    val maxTokens = SigmaConstants.MaxTokens.value
    require(tokens.size <= maxTokens, SigmaConstants.MaxTokens.description + s": $maxTokens")
    val iterator = tokens.iterator()
    while (iterator.hasNext) {
      _tokens += iterator.next
    }
    this
  }

  override def mintToken(token: Eip4Token): OutBoxBuilder = {
    val tokenNameVal = token.getMintingBoxR4
    val tokenDescVal = token.getMintingBoxR5
    val tokenNumOfDecVal = token.getMintingBoxR6
    _registers ++= Array(tokenNameVal, tokenDescVal, tokenNumOfDecVal)


    if (token.getMintingBoxR9 != null && token.getMintingBoxR8 == null) {
      throw new IllegalArgumentException("Invalid token: R9 cannot exist without R8")
    }

    if (token.getMintingBoxR8 != null && token.getMintingBoxR7 == null) {
      throw new IllegalArgumentException("Invalid token: R8 cannot exist without R7")
    }

    if (token.getMintingBoxR9 != null && token.getMintingBoxR7 == null) {
      throw new IllegalArgumentException("Invalid token: R9 cannot exist without R7")
    }

    // added only if they are non-null values
    _registers ++= Seq(Option(token.getMintingBoxR7)).flatten
    _registers ++= Seq(Option(token.getMintingBoxR8)).flatten
    _registers ++= Seq(Option(token.getMintingBoxR9)).flatten


    _tokens += token
    this
  }


  override def registers(registers: ErgoValue[_]*): OutBoxBuilderImpl = {
    InternalUtil.checkArgument(registers.nonEmpty,
      "At least one register should be specified": Any)
    _registers.clear()
    _registers ++= registers
    this
  }

  override def registers(registers: java.util.List[ErgoValue[_]]): OutBoxBuilderImpl = {
    InternalUtil.checkArgument(!registers.isEmpty,
      "At least one register should be specified": Any)
    _registers.clear()
    val iterator = registers.iterator()
    while (iterator.hasNext)
      _registers += iterator.next()
    this
  }

  override def creationHeight(height: Int): OutBoxBuilder = {
    _creationHeightOpt = Some(height)
    this
  }

  override def build: OutBox = {
    InternalUtil.checkState(_contract != null, "Contract is not defined")
    val tree = _contract.getErgoTree
    val ergoBoxCandidate = AppkitHelpers.createBoxCandidate(
      _value, tree, _tokens.toSeq, _registers.toSeq,
      creationHeight = _creationHeightOpt.getOrElse(_txB.getCtx.getHeight))
    new OutBoxImpl(ergoBoxCandidate)
  }
}

