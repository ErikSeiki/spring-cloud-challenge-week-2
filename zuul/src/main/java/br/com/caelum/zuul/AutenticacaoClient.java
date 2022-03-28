package br.com.caelum.zuul;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import feign.Headers;

@FeignClient(name="auth", configuration = AutenticacaoFeignConfig.class)
public interface AutenticacaoClient {
	
	@Headers("Content-Type: application/x-www-form-urlencoded")
	@PostMapping(path = "/oauth/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public TokenDto oauthToken(@RequestHeader Map<String, Object> headers, @RequestBody Map<String, ?> form);

}
