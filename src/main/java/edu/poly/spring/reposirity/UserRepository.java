package edu.poly.spring.reposirity;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.poly.spring.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByUserName(String userName);

	Optional<User> findByUserNameAndPassword(String userName, String password);

}
