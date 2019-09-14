# Aware

Aware adalah sebuah interface dimana nanti akan interface itu akan implementasi satu buah method dimana method tersebut akan diinject oleh spring sesuai dengan parameternya.
ada beberapa aware pada spring contohnya adalah ApplicationContextAware

Example
```java
public interface ApplicationContextAware{

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
```

kadang ada kasus ketika kita membuat bean, di dalam bean tersebut kita butuh mendapatkan ApplicationContext spring. caranya gampang tinggal kita mengimpelemtasi Interface ApplicationContextAware yang ada diatas.
kita tinggal implement saja

File Model/OtherBean.java
```java
public class OtherBean implements ApplicationContextAware {
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void doSomething(){
        if(context != null){
            System.out.println("OK, Contect Ada!");
        }else{
            System.out.println("NO, Contect tidak Ada!");
        }
    }
}

```

File BelajarSpringApplication
```java
public class BelajarSpringApplication {

	public static void main(String[] args) {
        

		OtherBean bean = context.getBean(OtherBean.class);
		bean.doSomething();
    }
}
```