package learn_spring_boot.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class BasicAuthenticationController {

	@GetMapping("/basicAuth")
	public AuthenticationBean helloWorldBeam()
	{
		return new AuthenticationBean("you are authenticated");
	}
}
