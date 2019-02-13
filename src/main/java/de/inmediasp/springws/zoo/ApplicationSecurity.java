package de.inmediasp.springws.zoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class ApplicationSecurity {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void initialize(final AuthenticationManagerBuilder authenticationManagerBuilder, final DataSource dataSource) throws Exception {
        //@formatter:off
        authenticationManagerBuilder
                .jdbcAuthentication()
                .dataSource(dataSource)
                .withUser("Keeper")
                .password(passwordEncoder().encode("secret"))
                .roles("KEEPER");
        //@formatter:on
    }
}
