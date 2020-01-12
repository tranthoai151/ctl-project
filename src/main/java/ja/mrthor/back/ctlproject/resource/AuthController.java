package ja.mrthor.back.ctlproject.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ja.mrthor.back.ctlproject.configuration.JwtToken;
import ja.mrthor.back.ctlproject.serviceImpl.JwtUserServiceImpl;
import ja.mrthor.back.ctlproject.util.JwtRequest;
import ja.mrthor.back.ctlproject.util.JwtResponse;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class AuthController {
	
//	 @Autowired
//	    private AuthenticationManager authenticationManager;
//
//	    @Autowired
//	    private JwtToken jwtToken;
//
//	    @Autowired
//	    private JwtUserServiceImpl jwtUserDetailsService;
//	    
//	    
//	    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//	    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
//
//
//	        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//
//	        final UserDetails userDetails = jwtUserDetailsService
//
//	                .loadUserByUsername(authenticationRequest.getUsername());
//
//	        final String token = jwtToken.generateToken(userDetails);
//
//	        return ResponseEntity.ok(new JwtResponse(token));
//
//	    }

//	    private void authenticate(String username, String password) throws Exception {
//
//	        try {
//
//	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//
//	        } catch (DisabledException e) {
//
//	            throw new Exception("USER_DISABLED", e);
//
//	        } catch (BadCredentialsException e) {
//
//	            throw new Exception("INVALID_CREDENTIALS", e);
//
//	        }
//
//	    }



}
