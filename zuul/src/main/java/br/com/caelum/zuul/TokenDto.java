package br.com.caelum.zuul;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {
	
	@JsonProperty("access_token")
	private String Accesstoken;
	
	@JsonProperty("token_type")
	private String tokenType;
	
}
