package lk.ijse.spring.config;

import lk.ijse.spring.advisor.AddWideExceptionHandler;
import lk.ijse.spring.controller.CustomerController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = {CustomerController.class, AddWideExceptionHandler.class})
public class WebAppConfig {
}
