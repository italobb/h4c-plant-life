
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
@JsonPropertyOrder({ "southwest", "northeast" })
public class Bounds {

	@JsonProperty("southwest")
	private Southwest southwest;
	@JsonProperty("northeast")
	private Northeast northeast;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("southwest")
	public Southwest getSouthwest() {
		return southwest;
	}

	@JsonProperty("southwest")
	public void setSouthwest(Southwest southwest) {
		this.southwest = southwest;
	}

	@JsonProperty("northeast")
	public Northeast getNortheast() {
		return northeast;
	}

	@JsonProperty("northeast")
	public void setNortheast(Northeast northeast) {
		this.northeast = northeast;
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