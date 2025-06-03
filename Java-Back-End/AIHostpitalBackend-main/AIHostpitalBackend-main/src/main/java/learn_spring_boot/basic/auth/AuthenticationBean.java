package learn_spring_boot.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import java.lang.*;


@CrossOrigin
@RestController
public class AuthenticationBean
{
	private String message;

	public AuthenticationBean(String string) {
		this.message = string;
	}
	
	public AuthenticationBean() {
	}

	public String getMessage() {
		return message; //JSON uses getters to display the value in that objects
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Name: "+this.message; //This only called in SysOutprintln(Object);
	}

}
