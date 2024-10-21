package main.java.lk.ijse.springcontroller.config;

import main.java.lk.ijse.springcontroller.controller.CustomerController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = {CustomerController.class})
public class WebAppConfig {
}
