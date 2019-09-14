# Component

Dengan menambahkan @Component pada class, maka spring akan otomatis membuatkan bean berdasarkan class tersebut

File Model/SayHello.java
```java
@Component
public class SayHello {

    public String hello(String name){
        return "hello "+name;
    }

}
```


File Model/SayHello.java
```java
public class BelajarSpringApplication {

	public static void main(String[] args) {
        SayHello sayHello = context.getBean(SayHello.class);
		System.out.println(sayHello.sayHello("alfin"));
    }
}
```