package ja.mrthor.back.ctlproject.util;

import org.springframework.http.HttpStatus;

public class ResponseLogin {
	private HttpStatus status;
    private String message;
    private String token;
    
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
    
}
