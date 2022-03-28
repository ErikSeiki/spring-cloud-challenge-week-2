package br.com.caelum.zuul;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AutenticaticacaoController {
	
	@Autowired
	private AutenticacaoClient autenticacaoClient; 

	@PostMapping(value = "/login")
	public TokenDto login(@RequestBody OauthTokenClientDto oauthTokenClientDto) {
		
		TokenDto response = null;
		
		try {
			String credenciais = Base64.getEncoder().encodeToString(("clientapi:passwordsecret").getBytes("UTF-8"));
			
			Map<String, Object> headers = new HashMap<>();
			headers.put(HttpHeaders.AUTHORIZATION, "Basic " + credenciais);
			
			Map<String, String> form = new HashMap<>();
			form.put("scope", "web");
			form.put("grant_type", "password");
			form.put("username", oauthTokenClientDto.getUsername());
			form.put("password", oauthTokenClientDto.getPassword());
			
			response = this.autenticacaoClient.oauthToken(headers, form);
		} catch (Exception e) {
			System.out.print("Erro na monstam do request para auteticação: " +  e);
		}
		
		return response;
	}
	
}
