package h4c.plantlife.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface TreeImageRepository extends CrudRepository<TreeImage, String>, QueryByExampleExecutor<TreeImage> {

	List<TreeImage> findByTreeId(String treeId);

}
