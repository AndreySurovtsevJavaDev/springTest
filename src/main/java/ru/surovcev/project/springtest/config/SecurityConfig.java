package ru.surovcev.project.springtest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * 14.  Реализуйте аутентификацию с помощью Spring Security (базовая, без ролей).
 */
@Configuration
/**
 *  @EnableWebSecurity нужна для включения поддержки безопасности веб-приложения.
 *  Это позволяет создать экземпляр фильтра безопасности и зарегистрировать его в контейнере сервлетов
 */
@EnableWebSecurity
public class SecurityConfig {

    /**
     * SecurityFilterChain - главный бин безопасности
     * Spring Security ищет бин типа SecurityFilterChain для настройки всей цепочки фильтров безопасности
     * Без этого бина безопасность не будет работать вообще
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                /**
                 * Настройка авторизации
                 * Отключаем CSRF для REST API, иначе POST-запросы не проходят.
                 * Все запросы - только для аутентифицированных пользователей
                 */
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults()) // Использует Basic Auth вместо формы
                .formLogin(form -> form.disable());
        return http.build();
    }

    /**
     * UserDetailsService - сервис пользователей
     * Spring Security требует бин типа UserDetailsService для работы механизма аутентификации
     * Без него система не будет знать, как искать пользователей
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        /**
         * Создаём in-memory хранилище (пригодно только для тестовых проектов) пользователей с одним тестовым пользователем:
         * Логин: "user"
         * Пароль: "pass" (закодирован)
         */
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("pass"))
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    /**
     * PasswordEncoder - кодировщик паролей
     * Spring Security требует бин PasswordEncoder для безопасного хранения паролей
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

