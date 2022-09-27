
package br.com.alura.comex.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.alura.comex.data.repository.UsuarioRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations {

	@Autowired 
	private TokenService tokenService;

	@Autowired
	private AutenticacaoService autenticacaoService;

	@Autowired 
	private UsuarioRepository usuarioRepository;

	// Configurações de autenticação

	@Bean
	public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
		System.out.println(auth);
		return auth.build();
	}

	// Configurações de autorização
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// Libera o spring de qualquer autorização...
		// http.authorizeRequests().anyRequest().permitAll();

		http.authorizeRequests()

				.antMatchers(HttpMethod.POST, "/api/categorias").permitAll()
				.antMatchers(HttpMethod.GET, "/api/categorias").permitAll()
				.antMatchers(HttpMethod.POST, "/auth").permitAll().antMatchers(HttpMethod.GET, "/actuator/**")
				.permitAll().anyRequest().authenticated()
				.and().csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	// Configurações de recursos estáticos(js, css, imagens, etc...)

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**",
				"/swagger-resources/**", "/v3/api-docs/**", "/swagger-ui/**");
	}

	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
