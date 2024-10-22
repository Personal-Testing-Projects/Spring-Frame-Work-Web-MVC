package main.java.lk.ijse.mappingspec.config;

import main.java.lk.ijse.mappingspec.controller.OneController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = {OneController.class})
public class WebAppConfig {
}
