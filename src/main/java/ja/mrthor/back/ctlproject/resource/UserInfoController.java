package ja.mrthor.back.ctlproject.resource;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ja.mrthor.back.ctlproject.configuration.JwtToken;
import ja.mrthor.back.ctlproject.entity.User;
import ja.mrthor.back.ctlproject.service.UserService;
import ja.mrthor.back.ctlproject.util.ResponseData;
import ja.mrthor.back.ctlproject.util.ResponseLogin;

@RestController
@RequestMapping("/users")
public class UserInfoController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private JwtToken jwtTokenUtil;
	
	@PostMapping("/register")
    public ResponseLogin create(@RequestBody User user) throws NoSuchAlgorithmException {
		
		ResponseLogin responseLogin = new ResponseLogin();
		
		User userRegister = new User();
		
		if(userService.checkUserExist(user.getEmail())) {
			responseLogin.setMessage("Email is exits");
			responseLogin.setStatus(HttpStatus.BAD_REQUEST);
			return responseLogin;
		}
		
		userRegister = userService.register(user);
		
		String token = jwtTokenUtil.generateToken(userRegister);
		responseLogin.setToken(token);
		
		return responseLogin;
	}
	

}
