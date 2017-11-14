package h4c.plantlife.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class TreeImage {
	@Id
	String imageName;

<<<<<<< HEAD
	private String userId;
=======
	String userId;
>>>>>>> ae953737a435a9b1c7b3282e900241912a7ed4b5

	String treeId;

	private Date creationDate;

	@PrePersist
	public void onCreation() {
		creationDate = new Date();
	}

	public String getTreeId() {
		return treeId;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
