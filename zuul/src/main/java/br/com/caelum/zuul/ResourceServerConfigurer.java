package br.com.caelum.zuul;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter{
		
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/**/parceiros/restaurantes").hasAnyRole("RESTAURANTE", "ADMINISTRATIVO")
			.antMatchers(HttpMethod.PUT, "/**/parceiros/restaurantes/**").hasAnyRole("RESTAURANTE", "ADMINISTRATIVO")
			.antMatchers("/**/admin/**").hasRole("ADMINISTRATIVO")
			.antMatchers("/**/pedidos").hasAnyRole("ADMINISTRATIVO", "CLIENTE");
	}
	
}
