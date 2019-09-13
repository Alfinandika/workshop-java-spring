# Bean

Object yang dibuat di spring disebut dengan BEAN, jadi setiap kita membuat bean maka bean tersebut adalah sebuah object.

Model/DataBean.java
```java
public class DataBean{
    private String value;

    public DataBean(String value) {
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

Class Belajar Configuration
```java
@SpringBootApplication
public class BelajarConfiguration {

    @Bean
	public DataBean createDataBean(){
        DataBean bean = new DataBean("Alfin");
        return bean;
    }
}
```


Class main
```java
public class BelajarSpringApplication {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BelajarConfiguration.class, args);
        DataBean data = context.getBean(DataBean.class);
		System.out.println(data.getValue());
    }
}
```