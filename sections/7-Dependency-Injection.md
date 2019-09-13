# Dependency Injection
Dependency Injection adalah kemampuan Spring dalam menginject Dependency secara otomatis

Kita buat class baru Model/SampleBean.java

```java
public class SampleBean {

    private DataBean dataBean;

    public SampleBean(DataBean dataBean) {
        this.dataBean = dataBean;
    }

    public DataBean getDataBean() {
        return dataBean;
    }

    public void setDataBean(DataBean dataBean) {
        this.dataBean = dataBean;
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

    @Bean
    public SampleBean createSampleBean(DataBean dataBean){
        SampleBean bean = new SampleBean(dataBean);
        return bean;
    }
}
```


Class main
```java
public class BelajarSpringApplication {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BelajarConfiguration.class, args);

        SampleBean sampleBean = context.getBean(SampleBean.class);
		System.out.println(sampleBean.getDataBean().getValue());
    }
}
```