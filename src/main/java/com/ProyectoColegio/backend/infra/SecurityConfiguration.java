package com.ProyectoColegio.backend.infra;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
@Configuration
public class SecurityConfiguration {




    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception{
        return http.csrf(csrf->csrf.disable()).cors(cors->cors.disable())
                .sessionManagement(mg-> mg.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .logout(logout->logout.disable()) // Deshabilitar el manejo predeterminado de logout
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers(HttpMethod.POST,"/login","/**").permitAll()
                                .requestMatchers(HttpMethod.GET,"/usuario/**","/assets/**","/**").permitAll()
                                .requestMatchers(HttpMethod.PUT,"/**","/assets/**","/matricula/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/familia/**").hasAuthority("admin")
                                .requestMatchers(HttpMethod.DELETE, "/**").permitAll()
                                .anyRequest().authenticated())
                .build();

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
