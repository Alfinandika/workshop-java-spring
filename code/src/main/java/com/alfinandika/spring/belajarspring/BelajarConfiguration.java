package com.alfinandika.spring.belajarspring;

import com.alfinandika.spring.belajarspring.Model.*;
import com.alfinandika.spring.belajarspring.Service.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validator;
import java.util.ResourceBundle;
import java.util.UUID;

@SpringBootApplication
//@Import(SalahConfiguration.class)
@PropertySources({
        @PropertySource("classpath:/configuration/contoh.properties")
})
public class BelajarConfiguration {

    @Autowired
    private Environment environment;
//
//    @Bean
//    public Author createAuthor(){
//        String name = environment.getProperty("author.name");
//        String email = environment.getProperty("author.email");
//        Author author = new Author(name, email);
//
//        return author;
//    }

    @Bean(name = "Alfin")
    //@Primary
    @Scope("prototype")
    public DataBean createDataBean(){
        String random = UUID.randomUUID().toString();
        DataBean bean = new DataBean(random);
        return bean;
    }

    @Bean(name = "Andika")
    public DataBean createDataBean2(){
        DataBean bean = new DataBean("Andika");
        return bean;
    }

    @Bean
    public SampleBean createSampleBean(@Qualifier("Andika") DataBean dataBean){
        SampleBean bean = new SampleBean(dataBean);
        return bean;
    }

    @Bean
    public OtherBean createOtherBean(@Qualifier("Alfin") DataBean dataBean, SampleBean sampleBean){
        OtherBean bean = new OtherBean(dataBean, sampleBean);
        return bean;
    }

    //@Bean
    //public SayHello createSayHello(){
    //    return new SayHello();
    //}

    @Bean
    @Profile("Development")
    public DatabaseConfig createDevDatabaseConfig(){
        return new DatabaseConfig("DATABASE DEVELOPMENT");
    }

    @Bean
    @Profile("Production")
    public DatabaseConfig createProdDatabaseConfig(){
        return new DatabaseConfig("DATABASE PRODUCTION");
    }

    @Bean(name = "messageSource")
    public MessageSource createMessageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages.hello");

        return messageSource;
    }

    @Bean
    public Validator createValidator(){
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public MethodValidationPostProcessor createValidationPostProcessor(){
        return new MethodValidationPostProcessor();
    }
}
