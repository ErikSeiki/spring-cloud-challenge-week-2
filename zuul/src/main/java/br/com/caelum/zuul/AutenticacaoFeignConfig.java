package br.com.caelum.zuul;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import feign.codec.Encoder;
import feign.form.FormEncoder;

public class AutenticacaoFeignConfig {

    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    @Primary
    public Encoder feignFormEncoder() {
        return new FormEncoder(new SpringEncoder(this.messageConverters));
    }

}