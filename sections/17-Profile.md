# Environment Abstraction (Profile)

Kita bisa set profile saat aplikasi tersebut berjalan hanya dengan menambahkan Anotasi @Profile

File Service/DatabaseConfig.java
```java
public class DatabaseConfig {

    private String value;

    public DatabaseConfig(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

```


Kemudian kita buan Bean nya

Class Belajar Configuration
```java
@SpringBootApplication
public class BelajarConfiguration {

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
}
```

Dan kita set profile nya sebelum ApplicationContext

```java
public class BelajarSpringApplication {

	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "Production");

		ApplicationContext context = SpringApplication.run(BelajarConfiguration.class, args);

        DatabaseConfig databaseConfig = context.getBean(DatabaseConfig.class);
		System.out.println(databaseConfig.getValue());
    }
}
```