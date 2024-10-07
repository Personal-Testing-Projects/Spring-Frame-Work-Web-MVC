package lk.ijse.springmvc.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringOneBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    public SpringOneBean() {
        System.out.println("SpringOneBean : Instantiated");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("SpringOneBean : " + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("SpringOneBean : " + name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("SpringOneBean : Destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("SpringOneBean : Initializing");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("SpringOneBean : " + applicationContext);
    }
}
