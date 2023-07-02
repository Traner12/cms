package com.doc.cms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig{

    @Bean
    protected UserDetailsService userDetailsService(){

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);

        UserDetails user1 = userBuilder
                .username("myuser1")
                .password("pass")
                .roles("USER")
                .build();

        UserDetails user2 = userBuilder
                .username("myuser2")
                .password("pass")
                .roles("USER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

}
