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



public class PostmanKeyDTO   {
  
    private String id = null;
    private String name = null;
    private String key = null;

  /**
   **/
  public PostmanKeyDTO id(String id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(example = "1", value = "")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  /**
   **/
  public PostmanKeyDTO name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(example = "MyKey 01", required = true, value = "")
  @JsonProperty("name")
  @NotNull
 @Size(min=1,max=255)  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  public PostmanKeyDTO key(String key) {
    this.key = key;
    return this;
  }

  
  @ApiModelProperty(example = "Postman API Key of the User", value = "")
  @JsonProperty("Key")
  public String getKey() {
    return key;
  }
  public void setKey(String key) {
    this.key = key;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostmanKeyDTO postmanKey = (PostmanKeyDTO) o;
    return Objects.equals(id, postmanKey.id) &&
        Objects.equals(name, postmanKey.name) &&
        Objects.equals(key, postmanKey.key);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, key);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostmanKeyDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
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

