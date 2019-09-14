# Resource Loader

Class Model/FileBean.java
```java
@Component
public class FileBean implements ResourceLoaderAware {
    private ResourceLoader loader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void printInfo() throws IOException {
        Resource resource= loader.getResource("classpath:/resources/info.txt");
        Scanner scanner = new Scanner(resource.getInputStream());
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();
    }
}
```

File Resources/resources/info.txt
```java
    Java’s standard java.net.URL class and standard handlers for various URL prefixes,
unfortunately, are not quite adequate enough for all access to low-level resources.
For example, there is no standardized URL implementation that may be used to access
a resource that needs to be obtained from the classpath or relative to a ServletContext.
While it is possible to register new handlers for specialized URL prefixes
(similar to existing handlers for prefixes such as http:), this is generally quite
complicated, and the URL interface still lacks some desirable functionality,
such as a method to check for the existence of the resource being pointed to.
```

Lalu kita Test


File BelajarSpringApplication
```java
public class BelajarSpringApplication {

	public static void main(String[] args) {
        
		ApplicationContext context = SpringApplication.run(BelajarConfiguration.class, args);

        FileBean fileBean = context.getBean(FileBean.class);
		fileBean.printInfo();
    }
}
```