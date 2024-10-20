package lk.ijse.springmvc.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanOne implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    public SpringBeanOne() {
        System.out.println("SpringBeanOne : Instantiated");
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("SpringBeanOne : beanFactoryAware");
    }

    public void setBeanName(String s) {
        System.out.println("SpringBeanOne : BeanNameAware");
    }

    public void destroy() throws Exception {
        System.out.println("SpringBeanOne : DisposableBean");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("SpringBeanOne : InitializingBean");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("SpringBeanOne : ApplicationContextAware");
    }
}
