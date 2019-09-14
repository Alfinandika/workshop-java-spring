# Scope

Scope adalah bagaimana cara spring dalam membuat bean.
Ketika sebuah bean berkali-kali sebenarnya kita hanya memanggil object yang sama. Jadi spring

File BelajarSpringApplication
```java
public class BelajarSpringApplication {

	public static void main(String[] args) {
        DataBean alfin1 = context.getBean("Alfin", DataBean.class);
		System.out.println(alfin1.getValue());
		DataBean alfin2 = context.getBean("Alfin", DataBean.class);
		System.out.println(alfin2.getValue());
		DataBean alfin3 = context.getBean("Alfin", DataBean.class);
		System.out.println(alfin3.getValue());
    }
}
```

Class Belajar Configuration
```java
@SpringBootApplication
public class BelajarConfiguration {

    @Bean(name = "alfin")
	public DataBean createDataBean(){
        String random = UUID.randomUUID().toString();
        DataBean bean = new DataBean(random);
        return bean;
    }
}
```

Defaulnya spring akan membuat Bean secara singleton

Class Belajar Configuration
```java
@SpringBootApplication
public class BelajarConfiguration {

    @Scope("singleton")
	public DataBean createDataBean(){
        String random = UUID.randomUUID().toString();
        DataBean bean = new DataBean(random);
        return bean;
    }
}
```

agar ketika kita memanggil bean dibuatkan object yang baru maka kita ubah scope nya menjadi prototype

Class Belajar Configuration
```java
@SpringBootApplication
public class BelajarConfiguration {

    @Scope("prototype")
	public DataBean createDataBean(){
        String random = UUID.randomUUID().toString();
        DataBean bean = new DataBean(random);
        return bean;
    }
}
```

@Scope juga bisa diterapkan di component