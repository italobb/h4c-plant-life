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

	@ManyToOne
	Tree tree;

	Date creationDate;

	@OneToOne
	TreeImage image;

	public Tree getTree() {
		return tree;
	}

	public void setTree(Tree tree) {
		this.tree = tree;
	}

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
}
