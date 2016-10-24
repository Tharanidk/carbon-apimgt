package org.wso2.carbon.apimgt.rest.api.publisher.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tier
 */
@javax.annotation.Generated(value = "class org.wso2.maven.plugins.JavaMSF4JServerCodegen", date = "2016-10-24T10:47:36.442+05:30")
public class Tier   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  /**
   * Gets or Sets tierLevel
   */
  public enum TierLevelEnum {
    API("api"),
    
    APPLICATION("application");

    private String value;

    TierLevelEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TierLevelEnum fromValue(String text) {
      for (TierLevelEnum b : TierLevelEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("tierLevel")
  private TierLevelEnum tierLevel = null;

  @JsonProperty("attributes")
  private Map<String, String> attributes = new HashMap<String, String>();

  @JsonProperty("requestCount")
  private Long requestCount = null;

  @JsonProperty("unitTime")
  private Long unitTime = null;

  /**
   * This attribute declares whether this tier is available under commercial or free 
   */
  public enum TierPlanEnum {
    FREE("FREE"),
    
    COMMERCIAL("COMMERCIAL");

    private String value;

    TierPlanEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TierPlanEnum fromValue(String text) {
      for (TierPlanEnum b : TierPlanEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("tierPlan")
  private TierPlanEnum tierPlan = null;

  @JsonProperty("stopOnQuotaReach")
  private Boolean stopOnQuotaReach = null;

  public Tier name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Tier description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Tier tierLevel(TierLevelEnum tierLevel) {
    this.tierLevel = tierLevel;
    return this;
  }

   /**
   * Get tierLevel
   * @return tierLevel
  **/
  @ApiModelProperty(value = "")
  public TierLevelEnum getTierLevel() {
    return tierLevel;
  }

  public void setTierLevel(TierLevelEnum tierLevel) {
    this.tierLevel = tierLevel;
  }

  public Tier attributes(Map<String, String> attributes) {
    this.attributes = attributes;
    return this;
  }

  public Tier putAttributesItem(String key, String attributesItem) {
    this.attributes.put(key, attributesItem);
    return this;
  }

   /**
   * Custom attributes added to the tier policy 
   * @return attributes
  **/
  @ApiModelProperty(value = "Custom attributes added to the tier policy ")
  public Map<String, String> getAttributes() {
    return attributes;
  }

  public void setAttributes(Map<String, String> attributes) {
    this.attributes = attributes;
  }

  public Tier requestCount(Long requestCount) {
    this.requestCount = requestCount;
    return this;
  }

   /**
   * Maximum number of requests which can be sent within a provided unit time 
   * @return requestCount
  **/
  @ApiModelProperty(required = true, value = "Maximum number of requests which can be sent within a provided unit time ")
  public Long getRequestCount() {
    return requestCount;
  }

  public void setRequestCount(Long requestCount) {
    this.requestCount = requestCount;
  }

  public Tier unitTime(Long unitTime) {
    this.unitTime = unitTime;
    return this;
  }

   /**
   * Get unitTime
   * @return unitTime
  **/
  @ApiModelProperty(required = true, value = "")
  public Long getUnitTime() {
    return unitTime;
  }

  public void setUnitTime(Long unitTime) {
    this.unitTime = unitTime;
  }

  public Tier tierPlan(TierPlanEnum tierPlan) {
    this.tierPlan = tierPlan;
    return this;
  }

   /**
   * This attribute declares whether this tier is available under commercial or free 
   * @return tierPlan
  **/
  @ApiModelProperty(required = true, value = "This attribute declares whether this tier is available under commercial or free ")
  public TierPlanEnum getTierPlan() {
    return tierPlan;
  }

  public void setTierPlan(TierPlanEnum tierPlan) {
    this.tierPlan = tierPlan;
  }

  public Tier stopOnQuotaReach(Boolean stopOnQuotaReach) {
    this.stopOnQuotaReach = stopOnQuotaReach;
    return this;
  }

   /**
   * If this attribute is set to false, you are capabale of sending requests  even if the request count exceeded within a unit time 
   * @return stopOnQuotaReach
  **/
  @ApiModelProperty(required = true, value = "If this attribute is set to false, you are capabale of sending requests  even if the request count exceeded within a unit time ")
  public Boolean getStopOnQuotaReach() {
    return stopOnQuotaReach;
  }

  public void setStopOnQuotaReach(Boolean stopOnQuotaReach) {
    this.stopOnQuotaReach = stopOnQuotaReach;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tier tier = (Tier) o;
    return Objects.equals(this.name, tier.name) &&
        Objects.equals(this.description, tier.description) &&
        Objects.equals(this.tierLevel, tier.tierLevel) &&
        Objects.equals(this.attributes, tier.attributes) &&
        Objects.equals(this.requestCount, tier.requestCount) &&
        Objects.equals(this.unitTime, tier.unitTime) &&
        Objects.equals(this.tierPlan, tier.tierPlan) &&
        Objects.equals(this.stopOnQuotaReach, tier.stopOnQuotaReach);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, tierLevel, attributes, requestCount, unitTime, tierPlan, stopOnQuotaReach);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tier {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    tierLevel: ").append(toIndentedString(tierLevel)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    requestCount: ").append(toIndentedString(requestCount)).append("\n");
    sb.append("    unitTime: ").append(toIndentedString(unitTime)).append("\n");
    sb.append("    tierPlan: ").append(toIndentedString(tierPlan)).append("\n");
    sb.append("    stopOnQuotaReach: ").append(toIndentedString(stopOnQuotaReach)).append("\n");
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

