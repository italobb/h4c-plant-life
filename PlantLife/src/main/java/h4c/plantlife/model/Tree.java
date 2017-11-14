package h4c.plantlife.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tree {
	@Id
	String uuid;

	Double lat;
	Double lng;

	String word1;
	String word2;
	String word3;

	@OneToMany(mappedBy = "tree")
	List<Verification> verifications;

	@OneToMany(mappedBy = "treeId")
	List<TreeImage> images;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public String getWord1() {
		return word1;
	}

	public void setWord1(String word1) {
		this.word1 = word1;
	}

	public String getWord2() {
		return word2;
	}

	public void setWord2(String word2) {
		this.word2 = word2;
	}

	public String getWord3() {
		return word3;
	}

	public void setWord3(String word3) {
		this.word3 = word3;
	}

	public List<Verification> getVerifications() {
		return verifications;
	}

	public void setVerifications(List<Verification> verifications) {
		this.verifications = verifications;
	}

	public List<TreeImage> getImages() {
		return images;
	}

	public void setImages(List<TreeImage> images) {
		this.images = images;
	}
}
