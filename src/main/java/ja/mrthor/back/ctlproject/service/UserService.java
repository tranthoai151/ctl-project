package ja.mrthor.back.ctlproject.service;

import ja.mrthor.back.ctlproject.entity.User;

public interface UserService {
	
	
	public User register(User user);
	public User getByUsername(String username);
	public boolean checkUserExist(String email);

}
