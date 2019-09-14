# Property Source

Biasanya saat kita membuat aplikasi kita juga membuat juga sebuah konfigurasi
penggunaanya cukup mudah kita tinggal menambahkan Anotasi @PropertySource

Kita Buat bean Model/Author.java


Class Belajar Configuration
```java
@SpringBootApplication
@PropertySources({
        @PropertySource("classpath:/configuration/contoh.properties")
})
public class BelajarConfiguration {
    
    @Autowired
    private Environment environment;

    @Bean
    public Author createAuthor(){
        String name = environment.getProperty("author.name");
        String email = environment.getProperty("author.email");
        Author author = new Author(name, email);

        return author;
    }
    
}
```

File Resources/configuration/contoh.properties
```java
author.name=Alfin Andika Pratama
author.email=alfinandika@gmail.com
```


Class Model/Author.java
```java

public class Author {
    private String name;
    private String email;

    public Author(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
```


File BelajarSpringApplication
```java
public class BelajarSpringApplication throws IOException {

	public static void main(String[] args) {
        
		ApplicationContext context = SpringApplication.run(BelajarConfiguration.class, args);

        Author author = context.getBean(Author.class);
		System.out.println(author.getName()+" "+author.getEmail());
    }
}
```

Kita juga bisa menginjectkan langsung di modelnya 

Class Model/Author.java
```java

@Component
public class Author {
    private String name;
    private String email;

    @Autowired
    public Author(@Value("${author.name}") String name,@Value("${author.email}") String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
```