package ja.mrthor.back.ctlproject.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ja.mrthor.back.ctlproject.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	 Boolean existsByEmail(String email);
	 
	 User findByUserName(String userName);
	 

}
