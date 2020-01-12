package ja.mrthor.back.ctlproject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ja.mrthor.back.ctlproject.entity.User;
import ja.mrthor.back.ctlproject.respository.UserRepository;
import ja.mrthor.back.ctlproject.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User register(User user) {
		User userRegister = new User();
        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);		
		try {
			userRegister = userRepository.save(user);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userRegister;
	}

	@Override
	public User getByUsername(String username) {
		return userRepository.findByUserName(username);
	}

	@Override
	public boolean checkUserExist(String email) {
		return userRepository.existsByEmail(email);
	}

}
