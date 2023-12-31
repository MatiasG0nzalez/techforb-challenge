package com.techforb.userdashboard.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@EnableWebSecurity
@Configuration
public class WebAuthorization extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeRequests()

                .antMatchers("/api/user/register").permitAll()
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/api/user/**").hasAuthority("CLIENT");






        httpSecurity.formLogin()

                .usernameParameter("dni")

                .passwordParameter("password")

                .loginPage("/auth/login");


        httpSecurity.logout().logoutUrl("/auth/logout").deleteCookies("JSESSIONID");

        //es para confirmar que los datos de login son enviados desde la ruta que definimos y no de un formulario externo, es decir desactivo la comprobacion
        // csrf  Cross side request forgery
        httpSecurity.csrf().disable();

        //disabling frameOptions so h2-console can be accessed
        httpSecurity.headers().frameOptions().disable();

        //if user is not authenticated, just send an authentication failure response
        httpSecurity.exceptionHandling().authenticationEntryPoint((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));

        //if login is successful, just clear the flags asking for authentication
        httpSecurity.formLogin().successHandler((req, res, auth) -> {
            clearAuthenticationAttributes(req);
            res.setContentType("application/json"); // Configurar el tipo de contenido
            res.getWriter().write("{\"message\": \"Inicio de sesión exitoso\"}");
            res.setStatus(HttpServletResponse.SC_OK); });

        //if login fails, just send an authentication failure response
        httpSecurity.formLogin().failureHandler((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));

        //if logout is successful, just send a success response
        httpSecurity.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());



    }

    //Clear the flags asking for authentication
    private void clearAuthenticationAttributes(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if (session != null) {

            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

        }

    }
}