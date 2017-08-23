package com.example.mvvm.retrofit;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"speed",
"deg"
})
public class Wind {

@JsonProperty("speed")
private double speed;
@JsonProperty("deg")
private double deg;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("speed")
public double getSpeed() {
return speed;
}

@JsonProperty("speed")
public void setSpeed(double speed) {
this.speed = speed;
}

@JsonProperty("deg")
public double getDeg() {
return deg;
}

@JsonProperty("deg")
public void setDeg(double deg) {
this.deg = deg;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}