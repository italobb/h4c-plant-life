package h4c.plantlife.w3w;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "lng", "lat" })
public class Northeast {

	@JsonProperty("lng")
	private Double lng;
	@JsonProperty("lat")
	private Double lat;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("lng")
	public Double getLng() {
		return lng;
	}

	@JsonProperty("lng")
	public void setLng(Double lng) {
		this.lng = lng;
	}

	@JsonProperty("lat")
	public Double getLat() {
		return lat;
	}

	@JsonProperty("lat")
	public void setLat(Double lat) {
		this.lat = lat;
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
