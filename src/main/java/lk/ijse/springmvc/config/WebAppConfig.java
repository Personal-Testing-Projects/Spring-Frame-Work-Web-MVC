package lk.ijse.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "lk.ijse.springmvc.pojo")
public class WebAppConfig {
    public WebAppConfig() {
        System.out.println("WebAppConfig");
    }
}
