package edu.poly.spring.reposirity;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import edu.poly.spring.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByUserName(String userName); 
	Optional<User> findByUserNameAndPassword(String userName, String password); 

//	@Query(value = "SELECT * FROM Users u WHERE u.user_name = :user_name and u.password = :password", 
//			  nativeQuery = true)
//			List<User> findUserByUserNameAndPassword(
//			  @Param("user_name") String user_name, @Param("password") String password);
}



