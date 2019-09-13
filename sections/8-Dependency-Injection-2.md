# Dependency Injection 2
Menentukan prioritas jika ada 2 Bean dengan tipe data yang sama

Ada beberapa cara, cara yang pertama adalah dengan menambahkan Annotation @Primary

Class Belajar Configuration
```java
@SpringBootApplication
public class BelajarConfiguration {

    @Bean
    @Primary
	public DataBean createDataBean(){
        DataBean bean = new DataBean("Alfin");
        return bean;
    }

    @Bean
	public DataBean createDataBean(){
        DataBean bean = new DataBean("Andika");
        return bean;
    }

    @Bean
    public SampleBean createSampleBean(DataBean dataBean){
        SampleBean bean = new SampleBean(dataBean);
        return bean;
    }
}
```

Permasalahan ketika kita menggunakan @Primary ada bean yang tidak akan pernah dipakai
Cara lain adalah kita menambahkan identitas di tiap bean yang kita buat

```java
@SpringBootApplication
public class BelajarConfiguration {

    @Bean(name = "alfin")
    @Primary
	public DataBean createDataBean(){
        DataBean bean = new DataBean("Alfin");
        return bean;
    }

    @Bean(name = "andika")
	public DataBean createDataBean(){
        DataBean bean = new DataBean("Andika");
        return bean;
    }

    @Bean
    public SampleBean createSampleBean(@Qualifier("Andika") DataBean dataBean){
        SampleBean bean = new SampleBean(dataBean);
        return bean;
    }
}
```