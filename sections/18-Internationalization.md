# Internationalization (Message Source)

Fitur Spring yang mendukung multi bahasa

Yang pertama harus dilakukan kita cukup membuat Bean

Class Belajar Configuration
```java
@SpringBootApplication
public class BelajarConfiguration {

    @Bean(name = "messageSource")
    public MessageSource createMessageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages.hello");

        return messageSource;
    }
}
```

File Resources/messages/hello.properties
```java
    hello=hello
```

File Resources/messages/hello_in_ID.properties
```java
    hello=halo
```

Kita ingin memodifikasi tulisan 'hello' di class SayHello sesuai dengan lokasi user

Kita Modifikasi file Model/SayHello.java
```java
@Component
public class SayHello implements MessageSourceAware {

    private SayHelloFilter sayHelloFilter;

    private MessageSource messageSource;

    @Autowired
    public SayHello(SayHelloFilter sayHelloFilter) {
        this.sayHelloFilter = sayHelloFilter;
    }

    public String sayHello(String name){
        return sayHelloFilter.filter( messageSource.getMessage("hello", null, Locale.getDefault())+name);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
```

File BelajarSpringApplication
```java
public class BelajarSpringApplication {

	public static void main(String[] args) {
        
        Locale.setDefault(new Locale("in", "ID"));
		ApplicationContext context = SpringApplication.run(BelajarConfiguration.class, args);

        SayHello sayHello = context.getBean(SayHello.class);
		System.out.println(sayHello.sayHello("alfin"));
    }
}
```