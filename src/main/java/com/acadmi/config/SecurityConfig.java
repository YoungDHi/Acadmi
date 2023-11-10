package com.acadmi.config;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.acadmi.member.MemberService;
import com.acadmi.security.UserLoginFailHandler;
import com.acadmi.security.UserSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserSuccessHandler userSuccessHandler;
	
	 @Bean
	   WebSecurityCustomizer webSecurityConfig() {
	      return web -> web
	            .ignoring()
	            .antMatchers("/images/**")
	            .antMatchers("/css/**")
	            .antMatchers("/js/**")
	            .antMatchers("/favicon/**")
	            ;
	   }
	   
	   @Bean
	   SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
	      httpSecurity
	               .cors()
	               .and()
	               .csrf()
	               .disable()
	               
	               .authorizeRequests()
	                  // URL과 권한 매칭
	               	  .antMatchers("/ws/**").permitAll()
	                  .antMatchers("/member/login").permitAll()
	                  .antMatchers("/member/findPw").permitAll()
	                  .antMatchers("/member/firstEmail").permitAll()
	                  .antMatchers("/").hasAnyRole("ADMIN", "ADMINISTRATOR", "PROFESSOR", "STUDENT")
	                  .antMatchers("/notice/add").hasRole("ADMINISTRATOR")
	                  .antMatchers("/notice/update").hasRole("ADMINISTRATOR")
	                  .antMatchers("/notice/delete").hasRole("ADMINISTRATOR")
	                  .antMatchers("/lectureNotice/add").hasRole("PROFESSOR")
	                  .antMatchers("/lectureNotice/update").hasRole("PROFESSOR")
	                  .antMatchers("/lectureNotice/delete").hasRole("PROFESSOR")
	                  .antMatchers("/qna/add").hasAnyRole("PROFESSOR", "STUDENT", "ADMINISTRATOR")
	                  .antMatchers("/qna/update").hasAnyRole("PROFESSOR", "STUDENT", "ADMINISTRATOR")
	                  .antMatchers("/qna/delete").hasAnyRole("PROFESSOR", "STUDENT", "ADMINISTRATOR")
	                  .antMatchers("/lectureQna/add").hasAnyRole("PROFESSOR", "STUDENT")
	                  .antMatchers("/lectureQna/update").hasAnyRole("PROFESSOR", "STUDENT")
	                  .antMatchers("/lectureQna/delete").hasAnyRole("PROFESSOR", "STUDENT")
	                  .antMatchers("/lecture/*").hasRole("PROFESSOR")
	                  .antMatchers("/credit/*").hasRole("PROFESSOR")
	                  .antMatchers("/chat/*").hasAnyRole("PROFESSOR", "STUDENT", "ADMINISTRATOR")
	                  .antMatchers("/notification/*").hasAnyRole("PROFESSOR", "STUDENT", "ADMINISTRATOR")
	                  .antMatchers("/member/administratorPage").hasRole("ADMINISTRATOR")
	                  .antMatchers("/member/administratorUpdate").hasRole("ADMINISTRATOR")
	                  .antMatchers("/member/professorPage").hasRole("PROFESSOR")
	                  .antMatchers("/member/professorUpdate").hasRole("PROFESSOR")
	                  .antMatchers("/member/studentPage").hasRole("STUDENT")
	                  .antMatchers("/member/studentUpdate").hasRole("STUDENT")
	                  .antMatchers("/administrator/*").hasRole("ADMINISTRATOR")
	                  .antMatchers("/student/**").hasRole("STUDENT")
	                  .and()
	               .formLogin()
	                  .loginPage("/member/login")
	                  //.defaultSuccessUrl("/")
	                  .successHandler(userSuccessHandler)
	                  .failureHandler(new UserLoginFailHandler())
	                  .permitAll()
	                  .and()
	               .logout()
	                  .logoutUrl("/member/logout")
	                  .logoutSuccessUrl("/member/login")
	                  .invalidateHttpSession(true)
	                  .deleteCookies("JSESSIONID")
	                  .permitAll()
	                  .and();
	            // 에러 페이지로 보내는 코드
//	         	.exceptionHandling() // 예외 처리 설정 시작
//       			  .accessDeniedPage("/WEB-INF/views/errorPage.jsp")
//       			  .and();         
	         return httpSecurity.build();
	      }
	      
	   @Bean
	   public PasswordEncoder getPasswordEncoder() {
	      return new BCryptPasswordEncoder();
	   }
}
