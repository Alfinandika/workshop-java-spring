# Component Injection

Kita dapat melakukan dependency injection pada component dengan menambahkan @Autowired

File Model/SayHelloFilter.java
```java
@Component
public class SayHelloFilter {

    public String filter(String value){
        return value.toUpperCase();
    }
}
```


File Model/SayHello.java
```java
@Component
public class SayHello {

    private SayHelloFilter sayHelloFilter;

    @Autowired
    public SayHello(SayHelloFilter sayHelloFilter) {
        this.sayHelloFilter = sayHelloFilter;
    }

    public String hello(String name){
        return sayHelloFilter.filter("hello "+name);
    }

}
```
