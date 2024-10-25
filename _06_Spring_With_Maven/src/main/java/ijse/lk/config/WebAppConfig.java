package ijse.lk.config;

import ijse.lk.advisor.AddWideExceptionHandler;
import ijse.lk.controller.CustomerController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = {CustomerController.class, AddWideExceptionHandler.class})
public class WebAppConfig {
}
