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
"message",
"country",
"sunrise",
"sunset"
})
public class Sys {

@JsonProperty("message")
private double message;
@JsonProperty("country")
private String country;
@JsonProperty("sunrise")
private int sunrise;
@JsonProperty("sunset")
private int sunset;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("message")
public double getMessage() {
return message;
}

@JsonProperty("message")
public void setMessage(double message) {
this.message = message;
}

@JsonProperty("country")
public String getCountry() {
return country;
}

@JsonProperty("country")
public void setCountry(String country) {
this.country = country;
}

@JsonProperty("sunrise")
public int getSunrise() {
return sunrise;
}

@JsonProperty("sunrise")
public void setSunrise(int sunrise) {
this.sunrise = sunrise;
}

@JsonProperty("sunset")
public int getSunset() {
return sunset;
}

@JsonProperty("sunset")
public void setSunset(int sunset) {
this.sunset = sunset;
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