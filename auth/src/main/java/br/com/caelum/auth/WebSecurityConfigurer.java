package br.com.caelum.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter{

	@Override @Bean
	protected AuthenticationManager authenticationManager() throws Exception {
			return super.authenticationManager();
	}
	
	@Override @Bean
	protected UserDetailsService userDetailsService() {
		return super.userDetailsService();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.passwordEncoder(passwordEncoder())
			.withUser("restaurante").password(passwordEncoder().encode("password_restaurante")).roles("RESTAURANTE").and()
			.withUser("administrativo").password(passwordEncoder().encode("password_administrativo")).roles("ADMINISTRATIVO").and()
			.withUser("cliente").password(passwordEncoder().encode("password_cliente")).roles("CLIENTE");
	}
}
