package edu.poly.spring.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import edu.poly.spring.reposirity.UserRepository;
import edu.poly.spring.sevice.UserSevice;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/home").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll().defaultSuccessUrl("/user").failureUrl("/login?message=loginFail")
				.loginProcessingUrl("/userLogin").usernameParameter("userName").passwordParameter("password")
				.and().logout().logoutSuccessUrl("/login?message=logout").permitAll();
	}

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// auth.inMemoryAuthentication().withUser("ledai34").password("{noop}123456")
//  .authorities("ROLE_USER").and().withUser("javainuse").password("{noop}javainuse")
//  .authorities("ROLE_USER", "ROLE_ADMIN");
//
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select user_name,password, 1 as enable from t_user where  user_name =?")
				.passwordEncoder(NoOpPasswordEncoder.getInstance())
				.authoritiesByUsernameQuery("select id, 1 as enable from t_user where  user_name =?");
	}

}
