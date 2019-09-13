# Container

Setiap Dependency atau Object yang dibuat di spring disebut dengan BEAN dan bean tersebut disimpan di dalam sebuah container.

Container tersebut direpresentasikan oleh interface
```java
org.springframework.context.ApplicationContext
```

![alt text](../images/5.container.png)

Class main
```java
public class BelajarSpringApplication {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BelajarConfiguration.class, args);
    }
}
```
Class Belajar Configuration
```java
@SpringBootApplication
public class BelajarConfiguration {

	
}