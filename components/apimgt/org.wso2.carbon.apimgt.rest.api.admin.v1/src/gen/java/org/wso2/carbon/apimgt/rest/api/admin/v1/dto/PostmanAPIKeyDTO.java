package org.wso2.carbon.apimgt.rest.api.admin.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;

import javax.xml.bind.annotation.*;
import org.wso2.carbon.apimgt.rest.api.common.annotations.Scope;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.Valid;



public class PostmanAPIKeyDTO   {
  
    private String id = null;
    private String keyName = null;
    private String keyValue = null;

  /**
   **/
  public PostmanAPIKeyDTO id(String id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(example = "01234567-0123-0123-0123-012345678901", value = "")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  /**
   **/
  public PostmanAPIKeyDTO keyName(String keyName) {
    this.keyName = keyName;
    return this;
  }

  
  @ApiModelProperty(example = "MyKey 01", required = true, value = "")
  @JsonProperty("keyName")
  @NotNull
 @Size(min=1,max=255)  public String getKeyName() {
    return keyName;
  }
  public void setKeyName(String keyName) {
    this.keyName = keyName;
  }

  /**
   **/
  public PostmanAPIKeyDTO keyValue(String keyValue) {
    this.keyValue = keyValue;
    return this;
  }

  
  @ApiModelProperty(example = "Postman API Key of the User", required = true, value = "")
  @JsonProperty("keyValue")
  @NotNull
  public String getKeyValue() {
    return keyValue;
  }
  public void setKeyValue(String keyValue) {
    this.keyValue = keyValue;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostmanAPIKeyDTO postmanAPIKey = (PostmanAPIKeyDTO) o;
    return Objects.equals(id, postmanAPIKey.id) &&
        Objects.equals(keyName, postmanAPIKey.keyName) &&
        Objects.equals(keyValue, postmanAPIKey.keyValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, keyName, keyValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostmanAPIKeyDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    keyName: ").append(toIndentedString(keyName)).append("\n");
    sb.append("    keyValue: ").append(toIndentedString(keyValue)).append("\n");
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

