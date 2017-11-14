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
@JsonPropertyOrder({ "crs", "words", "bounds", "geometry", "language", "map", "status", "thanks" })
public class What3WordsResponse {

	@JsonProperty("crs")
	private Crs crs;
	@JsonProperty("words")
	private String words;
	@JsonProperty("bounds")
	private Bounds bounds;
	@JsonProperty("geometry")
	private Geometry geometry;
	@JsonProperty("language")
	private String language;
	@JsonProperty("map")
	private String map;
	@JsonProperty("status")
	private Status status;
	@JsonProperty("thanks")
	private String thanks;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("crs")
	public Crs getCrs() {
		return crs;
	}

	@JsonProperty("crs")
	public void setCrs(Crs crs) {
		this.crs = crs;
	}

	@JsonProperty("words")
	public String getWords() {
		return words;
	}

	@JsonProperty("words")
	public void setWords(String words) {
		this.words = words;
	}

	@JsonProperty("bounds")
	public Bounds getBounds() {
		return bounds;
	}

	@JsonProperty("bounds")
	public void setBounds(Bounds bounds) {
		this.bounds = bounds;
	}

	@JsonProperty("geometry")
	public Geometry getGeometry() {
		return geometry;
	}

	@JsonProperty("geometry")
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	@JsonProperty("language")
	public String getLanguage() {
		return language;
	}

	@JsonProperty("language")
	public void setLanguage(String language) {
		this.language = language;
	}

	@JsonProperty("map")
	public String getMap() {
		return map;
	}

	@JsonProperty("map")
	public void setMap(String map) {
		this.map = map;
	}

	@JsonProperty("status")
	public Status getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(Status status) {
		this.status = status;
	}

	@JsonProperty("thanks")
	public String getThanks() {
		return thanks;
	}

	@JsonProperty("thanks")
	public void setThanks(String thanks) {
		this.thanks = thanks;
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