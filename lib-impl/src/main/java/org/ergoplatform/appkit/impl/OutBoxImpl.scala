package org.ergoplatform.appkit.impl

import org.ergoplatform.ErgoBoxCandidate
import org.ergoplatform.appkit._
import org.ergoplatform.sdk.{ErgoToken, SdkIsos}
import scorex.util.ModifierId
import sigma.ast.ErgoTree

import java.util

class OutBoxImpl(_ergoBoxCandidate: ErgoBoxCandidate) extends OutBox {
  override def getValue: Long = _ergoBoxCandidate.value

  override def getCreationHeight: Int = _ergoBoxCandidate.creationHeight

  override def getTokens: util.List[ErgoToken] = SdkIsos.isoTokensListToPairsColl.from(_ergoBoxCandidate.additionalTokens)

  override def getRegisters: util.List[ErgoValue[_]] = AppkitHelpers.getBoxRegisters(_ergoBoxCandidate)

  override def getBytesWithNoRef: Array[Byte] = _ergoBoxCandidate.bytesWithNoRef

  override def getErgoTree: ErgoTree = _ergoBoxCandidate.ergoTree

  /** Returns {@link BoxAttachment} stored in this box of null. */
  override def getAttachment: BoxAttachment =
    BoxAttachmentBuilder.buildFromTransactionBox(this)

  private[impl] def getErgoBoxCandidate: ErgoBoxCandidate = _ergoBoxCandidate

  override def convertToInputWith(txId: String, boxIndex: Short): InputBox = {
    val box = _ergoBoxCandidate.toBox(ModifierId @@ txId, boxIndex)
    new InputBoxImpl(box)
  }
}

