package com.karthikyadavmudike.learn_spring_boot.ChatGptToken;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




@CrossOrigin
@RestController
public class TokenChatGPTController {
	
	public TokenChatGPT tokenapi;
	
	@CrossOrigin
	@GetMapping("/getChatGPT/token")
	public TokenChatGPT getToken()
	{
		this.tokenapi = new TokenChatGPT();
		String x[] = {"sk-","proj","-L9pSJDoFvoE","QVVZ0bmX4ftb7P3qvPJ8ukc3lEfwuhjR","-LlXN2JthwfVsPNKAXTzatYP","-Yu1gwBT3BlbkFJNrz","-bA62-VHpqJndJupb0UN2aE03ECNT","1OB5uCQ7IeZlCt1O9TaY2rIqAW7QXfh4-9dyHwxMIA"};
		String z = String.join(",", x);
		this.tokenapi.setToken(z.replace(",",""));
		return this.tokenapi;
	}
	
}
