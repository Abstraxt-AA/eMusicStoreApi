package org.example.emusicstore.emusicstoreapi.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Security configuration to specify which endpoints are not secured and which
 * security method to use for the secure ones. Also returns a browser-friendly
 * 401 response.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Anonymous access for the actuator endpoint and the product get endpoint
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/product/get/**", "/actuator");
    }

    // Securing all other requests using OAuth2 provided by Okta. Providing CORS
    // support as well as browser-friendly 401 response.
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .oauth2ResourceServer().jwt();
        http.cors();
        Okta.configureResourceServer401ResponseBody(http);
    }
}
