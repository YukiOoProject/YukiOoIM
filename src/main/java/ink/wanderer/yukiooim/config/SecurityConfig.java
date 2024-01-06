package ink.wanderer.yukiooim.config;

import ink.wanderer.yukiooim.handler.LoginAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                        .requestMatchers("/api/login", "/api/register").permitAll()
                        .requestMatchers("/web/login").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/web/login")
                        .permitAll()
                        .loginProcessingUrl("/api/login")
                        .permitAll()
                        .successHandler(new LoginAuthenticationSuccessHandler())
                        .defaultSuccessUrl("/test", true)
                        .failureUrl("/web/login?error")
                )
                .logout(LogoutConfigurer::permitAll)
                .sessionManagement(manager -> manager
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                )
        ;

        return http.build();
    }
}
