package ja.mrthor.back.ctlproject.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ja.mrthor.back.ctlproject.configuration.JwtToken;
import ja.mrthor.back.ctlproject.entity.User;
import ja.mrthor.back.ctlproject.service.UserService;
import ja.mrthor.back.ctlproject.util.JwtRequest;
import ja.mrthor.back.ctlproject.util.ResponseData;
import ja.mrthor.back.ctlproject.util.ResponseLogin;

@RestController
@RequestMapping("/users")
public class AuthenticationResource {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtToken jwtTokenUtil;

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseLogin ResponseLogin(@RequestBody JwtRequest authenticationRequest) throws Exception {

		ResponseLogin responseLogin = new ResponseLogin();

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));

		} catch (DisabledException e) {
			responseLogin.setStatus(HttpStatus.UNAUTHORIZED);
			responseLogin.setMessage("Please login again!");
			return responseLogin;
		} catch (BadCredentialsException e) {
			
			responseLogin.setStatus(HttpStatus.UNAUTHORIZED);
			responseLogin.setMessage("Please login again!");
			return responseLogin;

        }

		User userLogin = userService.getByUsername(authenticationRequest.getUsername());
		String token = jwtTokenUtil.generateToken(userLogin);
		responseLogin.setToken(token);
		return responseLogin;
	}
}
