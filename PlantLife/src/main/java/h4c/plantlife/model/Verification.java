package h4c.plantlife.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Verification {
	@Id
	String uuid;

	@ManyToOne(optional = false)
	User responsible;

<<<<<<< HEAD
	private String treeId;
=======
	@ManyToOne(optional = false)
	Tree tree;
>>>>>>> ae953737a435a9b1c7b3282e900241912a7ed4b5

	Date creationDate;

	@OneToOne(optional = false)
	TreeImage image;


	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public TreeImage getImage() {
		return image;
	}

	public void setImage(TreeImage image) {
		this.image = image;
	}

	public String getTreeId() {
		return treeId;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}
}
