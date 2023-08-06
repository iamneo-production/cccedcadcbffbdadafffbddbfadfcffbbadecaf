//package com.ltimindtree.iplbidding.configurations;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig{
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/admin/**").hasRole("ADMIN")  // Admin endpoints require ADMIN role
//                .antMatchers("/organizer/**").hasRole("ORGANIZER")  // Organizer endpoints require ORGANIZER role
//                .anyRequest().authenticated() // All other endpoints require authentication
//                .and()
//                .formLogin(); // Enable default form-based login
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/", "/home").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin((form) -> form
//                        .loginPage("/login")
//                        .permitAll()
//                )
//                .logout((logout) -> logout.permitAll());
//
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("admin")
//                        .password("admin123")
//                        .roles("ADMIN")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
//
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("admin123").roles("ADMIN")
//                .and()
//                .withUser("organizer").password("organizer123").roles("ORGANIZER");
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        // Use BCryptPasswordEncoder for production environments
//        return NoOpPasswordEncoder.getInstance(); // For demonstration purposes only (not secure)
//    }
//}
