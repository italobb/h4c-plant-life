package h4c.plantlife.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface TreeRepository extends CrudRepository<Tree, String>, QueryByExampleExecutor<Tree> {

}
