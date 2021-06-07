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
 * Ergo transaction
 */
@Schema(description = "Ergo transaction")

public class ErgoTransaction {
  @SerializedName("id")
  private String id = null;

  @SerializedName("inputs")
  private java.util.List<ErgoTransactionInput> inputs = new java.util.ArrayList<ErgoTransactionInput>();

  @SerializedName("dataInputs")
  private java.util.List<ErgoTransactionDataInput> dataInputs = new java.util.ArrayList<ErgoTransactionDataInput>();

  @SerializedName("outputs")
  private java.util.List<ErgoTransactionOutput> outputs = new java.util.ArrayList<ErgoTransactionOutput>();

  @SerializedName("size")
  private Integer size = null;

  public ErgoTransaction id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @Schema(description = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ErgoTransaction inputs(java.util.List<ErgoTransactionInput> inputs) {
    this.inputs = inputs;
    return this;
  }

  public ErgoTransaction addInputsItem(ErgoTransactionInput inputsItem) {
    this.inputs.add(inputsItem);
    return this;
  }

   /**
   * Inputs of the transaction
   * @return inputs
  **/
  @Schema(required = true, description = "Inputs of the transaction")
  public java.util.List<ErgoTransactionInput> getInputs() {
    return inputs;
  }

  public void setInputs(java.util.List<ErgoTransactionInput> inputs) {
    this.inputs = inputs;
  }

  public ErgoTransaction dataInputs(java.util.List<ErgoTransactionDataInput> dataInputs) {
    this.dataInputs = dataInputs;
    return this;
  }

  public ErgoTransaction addDataInputsItem(ErgoTransactionDataInput dataInputsItem) {
    this.dataInputs.add(dataInputsItem);
    return this;
  }

   /**
   * Data inputs of the transaction
   * @return dataInputs
  **/
  @Schema(required = true, description = "Data inputs of the transaction")
  public java.util.List<ErgoTransactionDataInput> getDataInputs() {
    return dataInputs;
  }

  public void setDataInputs(java.util.List<ErgoTransactionDataInput> dataInputs) {
    this.dataInputs = dataInputs;
  }

  public ErgoTransaction outputs(java.util.List<ErgoTransactionOutput> outputs) {
    this.outputs = outputs;
    return this;
  }

  public ErgoTransaction addOutputsItem(ErgoTransactionOutput outputsItem) {
    this.outputs.add(outputsItem);
    return this;
  }

   /**
   * Outputs of the transaction
   * @return outputs
  **/
  @Schema(required = true, description = "Outputs of the transaction")
  public java.util.List<ErgoTransactionOutput> getOutputs() {
    return outputs;
  }

  public void setOutputs(java.util.List<ErgoTransactionOutput> outputs) {
    this.outputs = outputs;
  }

  public ErgoTransaction size(Integer size) {
    this.size = size;
    return this;
  }

   /**
   * Size in bytes
   * @return size
  **/
  @Schema(description = "Size in bytes")
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErgoTransaction ergoTransaction = (ErgoTransaction) o;
    return Objects.equals(this.id, ergoTransaction.id) &&
        Objects.equals(this.inputs, ergoTransaction.inputs) &&
        Objects.equals(this.dataInputs, ergoTransaction.dataInputs) &&
        Objects.equals(this.outputs, ergoTransaction.outputs) &&
        Objects.equals(this.size, ergoTransaction.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, inputs, dataInputs, outputs, size);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErgoTransaction {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    inputs: ").append(toIndentedString(inputs)).append("\n");
    sb.append("    dataInputs: ").append(toIndentedString(dataInputs)).append("\n");
    sb.append("    outputs: ").append(toIndentedString(outputs)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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
