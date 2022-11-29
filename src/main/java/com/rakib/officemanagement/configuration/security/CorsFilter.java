package com.rakib.officemanagement.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@EnableWebFlux
@Configuration
public class CorsFilter implements WebFluxConfigurer {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder ();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping ("/**")
                .allowedOrigins ("*")
                .allowedMethods ("GET", "POST", "PUT", "DELETE")
                .allowedHeaders ("x-auth-token", "appKey", "appSecret",
                        "Content-Type", "x-upload-bucket",
                        "x-upload-token", "x-upload-id", "x-upload-part-number", "x-upload-object-key",
                        "x-upload-content-length", "x-upload-content-type", "authorization", "content-range"
                )
                .exposedHeaders ("Content-Type", "x-upload-bucket", "x-upload-token", "x-upload-id",
                        "x-upload-part-number", "x-upload-object-key", "x-upload-content-length",
                        "x-upload-content-type", "authorization", "content-range"
                )
                .allowCredentials (false).maxAge (3600);
    }
}
