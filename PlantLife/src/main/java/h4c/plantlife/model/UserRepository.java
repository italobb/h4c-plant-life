package h4c.plantlife.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface UserRepository extends CrudRepository<User, String>, QueryByExampleExecutor<User> {

}
