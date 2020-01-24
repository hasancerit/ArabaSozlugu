package com.example.arabasozlugu.ArabaSozlugu.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.context.annotation.Bean;
import com.example.arabasozlugu.ArabaSozlugu.jwt.filters.JWTAuthorizationFilter;
import com.example.arabasozlugu.ArabaSozlugu.utils.SecurityConstants;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	/*@Autowired
	private UserDetailsService userDetailsService;*/
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
		 System.out.println("conf1");
	        http.cors().and().csrf().disable().authorizeRequests()
	                .antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
	                .antMatchers(HttpMethod.POST, "/user/login").permitAll()
	                .anyRequest().authenticated()
	                .and()
	                //.addFilter(new JWTAuthenticationFilter(authenticationManager()))
	                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
	                // this disables session creation on Spring Security
	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	    }
/*
	    @Override
	    public void configure(AuthenticationManagerBuilder auth) throws Exception {
			 System.out.println("conf2");
			 //Auth işlemlerinde şifre karşılaştırması için, bu servisi kullan.
	        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	    }
*/
	    
	    
	  @Bean
	  CorsConfigurationSource corsConfigurationSource() {
			 System.out.println("conf3");
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
	    return source;
	  }
}
