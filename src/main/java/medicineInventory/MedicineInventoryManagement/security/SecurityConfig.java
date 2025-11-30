package medicineInventory.MedicineInventoryManagement.security;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.configuration.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.*;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
//@RequiredArgsConstructor
public class SecurityConfig {

   // private final JwtAuthenticationFilter jwtFilter;

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//        .csrf(csrf -> csrf.disable())
//        .cors(cors -> {}) // ✅ empty lambda is enough; uses CorsConfigurationSource bean
//        .authorizeHttpRequests(auth -> auth
//        	    .requestMatchers("/", "/login", "/register", "/css/**").permitAll()
//        	    .requestMatchers("/auth/**").permitAll()
//        	    .requestMatchers("/api/medicines/**").hasRole("ADMIN")
//        	    .requestMatchers("/api/view/**").hasAnyRole("ADMIN","VIEWER")
//        	    .anyRequest().authenticated()
//        	)
//            // Stateless session for JWT
//            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//            // Add JWT filter
//            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> {})
            
            // URL Security
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login", "/register", "/css/**").permitAll()
                .requestMatchers("/auth/register").permitAll()
                .requestMatchers("/api/medicines/**").hasRole("ADMIN")
                .requestMatchers("/api/view/**").hasAnyRole("ADMIN", "VIEWER")
                .anyRequest().authenticated()
            )

            // ✅ SESSION LOGIN ENABLED
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/doLogin")        // Thymeleaf form submits here
                .defaultSuccessUrl("/dashboard", true)
                .failureUrl("/login?error=true")
                .permitAll()
            )

            // LOGOUT
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }
}

