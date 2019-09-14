# Container Extentions Point

Spring memiliki kemampuan jika kita mau mengcustomize bean.

BeanPostProcessor : ketika bean selesai dibuat kita ingin memproses sesuatu terhadap bean tersebut.
sama seperti membuat plugin yang ingin di extend di spring 

File Plugin/LogPlugin.java
```java
@Component
public class LogPlugin extends InstantiationAwareBeanPostProcessorAdapter {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Telah dibuat bean dengan nama : "+beanName+" dengan type : "+bean.getClass().getName());
        return bean;
    }
}
```