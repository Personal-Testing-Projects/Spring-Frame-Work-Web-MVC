package lk.ijse.springmvc.config;

import lk.ijse.springmvc.controller.CustomerController;
import lk.ijse.springmvc.pojo.SpringBeanOne;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"lk.ijse.springmvc.pojo","lk.ijse.springmvc.controller"})
//we can use this also -> @ComponentScan(basePackageClasses = {SpringBeanOne.class, CustomerController.class})
public class WebAppConfig {
    public WebAppConfig() {
        System.out.println("WebAppConfig : Instantiated");
    }
}
