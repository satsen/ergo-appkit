/*
 * Ergo Node API
 * API docs for Ergo Node. Models are shared between all Ergo products
 *
 * OpenAPI spec version: 4.0.12
 * Contact: ergoplatform@protonmail.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package org.ergoplatform.restapi.client;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

/**
 * ErgoTransactionOutput
 */


public class ErgoTransactionOutput {
  @SerializedName("boxId")
  private String boxId = null;

  @SerializedName("value")
  private Long value = null;

  @SerializedName("ergoTree")
  private String ergoTree = null;

  @SerializedName("creationHeight")
  private Integer creationHeight = null;

  @SerializedName("assets")
  private java.util.List<Asset> assets = null;

  @SerializedName("additionalRegisters")
  private Registers additionalRegisters = null;

  @SerializedName("transactionId")
  private String transactionId = null;

  @SerializedName("index")
  private Integer index = null;

  public ErgoTransactionOutput boxId(String boxId) {
    this.boxId = boxId;
    return this;
  }

   /**
   * Get boxId
   * @return boxId
  **/
  @Schema(description = "")
  public String getBoxId() {
    return boxId;
  }

  public void setBoxId(String boxId) {
    this.boxId = boxId;
  }

  public ErgoTransactionOutput value(Long value) {
    this.value = value;
    return this;
  }

   /**
   * Amount of Ergo token
   * minimum: 0
   * @return value
  **/
  @Schema(example = "147", required = true, description = "Amount of Ergo token")
  public Long getValue() {
    return value;
  }

  public void setValue(Long value) {
    this.value = value;
  }

  public ErgoTransactionOutput ergoTree(String ergoTree) {
    this.ergoTree = ergoTree;
    return this;
  }

   /**
   * Get ergoTree
   * @return ergoTree
  **/
  @Schema(required = true, description = "")
  public String getErgoTree() {
    return ergoTree;
  }

  public void setErgoTree(String ergoTree) {
    this.ergoTree = ergoTree;
  }

  public ErgoTransactionOutput creationHeight(Integer creationHeight) {
    this.creationHeight = creationHeight;
    return this;
  }

   /**
   * Height the output was created at
   * @return creationHeight
  **/
  @Schema(example = "9149", required = true, description = "Height the output was created at")
  public Integer getCreationHeight() {
    return creationHeight;
  }

  public void setCreationHeight(Integer creationHeight) {
    this.creationHeight = creationHeight;
  }

  public ErgoTransactionOutput assets(java.util.List<Asset> assets) {
    this.assets = assets;
    return this;
  }

  public ErgoTransactionOutput addAssetsItem(Asset assetsItem) {
    if (this.assets == null) {
      this.assets = new java.util.ArrayList<Asset>();
    }
    this.assets.add(assetsItem);
    return this;
  }

   /**
   * Assets list in the transaction
   * @return assets
  **/
  @Schema(description = "Assets list in the transaction")
  public java.util.List<Asset> getAssets() {
    return assets;
  }

  public void setAssets(java.util.List<Asset> assets) {
    this.assets = assets;
  }

  public ErgoTransactionOutput additionalRegisters(Registers additionalRegisters) {
    this.additionalRegisters = additionalRegisters;
    return this;
  }

   /**
   * Get additionalRegisters
   * @return additionalRegisters
  **/
  @Schema(required = true, description = "")
  public Registers getAdditionalRegisters() {
    return additionalRegisters;
  }

  public void setAdditionalRegisters(Registers additionalRegisters) {
    this.additionalRegisters = additionalRegisters;
  }

  public ErgoTransactionOutput transactionId(String transactionId) {
    this.transactionId = transactionId;
    return this;
  }

   /**
   * Get transactionId
   * @return transactionId
  **/
  @Schema(description = "")
  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public ErgoTransactionOutput index(Integer index) {
    this.index = index;
    return this;
  }

   /**
   * Index in the transaction outputs
   * @return index
  **/
  @Schema(description = "Index in the transaction outputs")
  public Integer getIndex() {
    return index;
  }

  public void setIndex(Integer index) {
    this.index = index;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErgoTransactionOutput ergoTransactionOutput = (ErgoTransactionOutput) o;
    return Objects.equals(this.boxId, ergoTransactionOutput.boxId) &&
        Objects.equals(this.value, ergoTransactionOutput.value) &&
        Objects.equals(this.ergoTree, ergoTransactionOutput.ergoTree) &&
        Objects.equals(this.creationHeight, ergoTransactionOutput.creationHeight) &&
        Objects.equals(this.assets, ergoTransactionOutput.assets) &&
        Objects.equals(this.additionalRegisters, ergoTransactionOutput.additionalRegisters) &&
        Objects.equals(this.transactionId, ergoTransactionOutput.transactionId) &&
        Objects.equals(this.index, ergoTransactionOutput.index);
  }

  @Override
  public int hashCode() {
    return Objects.hash(boxId, value, ergoTree, creationHeight, assets, additionalRegisters, transactionId, index);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErgoTransactionOutput {\n");
    
    sb.append("    boxId: ").append(toIndentedString(boxId)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    ergoTree: ").append(toIndentedString(ergoTree)).append("\n");
    sb.append("    creationHeight: ").append(toIndentedString(creationHeight)).append("\n");
    sb.append("    assets: ").append(toIndentedString(assets)).append("\n");
    sb.append("    additionalRegisters: ").append(toIndentedString(additionalRegisters)).append("\n");
    sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
