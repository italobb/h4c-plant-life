package h4c.plantlife.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {
	@Id
	String identityAddress;

	@Column(nullable = false)
	String name;

	Double reputation;

	Date creationDate;

	@OneToMany
	List<Tree> trees;

	@JsonProperty
	public Integer countTrees() {
		return trees == null ? 0 : trees.size();
	}

	@PrePersist
	public void onCreate() {
		creationDate = new Date();
	}

	public String getIdentityAddress() {
		return identityAddress;
	}

	public void setIdentityAddress(String identityAddress) {
		this.identityAddress = identityAddress;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Tree> getTrees() {
		return trees;
	}

	public void setTrees(List<Tree> trees) {
		this.trees = trees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getReputation() {
		return reputation;
	}

	public void setReputation(Double reputation) {
		this.reputation = reputation;
	}

}
