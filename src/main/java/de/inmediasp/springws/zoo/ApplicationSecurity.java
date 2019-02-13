package de.inmediasp.springws.zoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import javax.sql.DataSource;

@Configuration
public class ApplicationSecurity {

    @Autowired
    public void initialize(final AuthenticationManagerBuilder authenticationManagerBuilder, final DataSource dataSource) throws Exception {
        //@formatter:off
        authenticationManagerBuilder
                .jdbcAuthentication()
                .dataSource(dataSource)
                .withUser("Keeper")
                .password("secret")
                .roles("KEEPER");
        //@formatter:on
    }
}
