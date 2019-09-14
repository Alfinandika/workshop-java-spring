package com.alfinandika.spring.belajarspring;

import com.alfinandika.spring.belajarspring.Model.*;
import com.alfinandika.spring.belajarspring.Service.DatabaseConfig;
import com.alfinandika.spring.belajarspring.Service.UserService;
import com.alfinandika.spring.belajarspring.Validation.AuthorValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.io.IOException;
import java.util.Locale;
import java.util.Set;


public class BelajarSpringApplication {

	public static void main(String[] args) throws IOException {
		System.setProperty("spring.profiles.active", "Production");
		Locale.setDefault(new Locale("in", "ID"));

		ApplicationContext context = SpringApplication.run(BelajarConfiguration.class, args);

		//DataBean data = context.getBean(DataBean.class);
		//System.out.println(data.getValue());

		//SampleBean sampleBean = context.getBean(SampleBean.class);
		//System.out.println(sampleBean.getDataBean().getValue());

		//OtherBean otherBean = context.getBean(OtherBean.class);
		//System.out.println(otherBean.getDataBean().getValue());
		//System.out.println(otherBean.getSampleBean().getDataBean().getValue());

//		SayHello sayHello = context.getBean(SayHello.class);
//		System.out.println(sayHello.sayHello("alfin"));

//		DataBean alfin1 = context.getBean("Alfin", DataBean.class);
//		System.out.println(alfin1.getValue());
//		DataBean alfin2 = context.getBean("Alfin", DataBean.class);
//		System.out.println(alfin2.getValue());
//		DataBean alfin3 = context.getBean("Alfin", DataBean.class);
//		System.out.println(alfin3.getValue());

		//Aware
//		DataBean bean = context.getBean("Alfin", DataBean.class);
//		bean.doSomething();

		//profile
//		DatabaseConfig databaseConfig = context.getBean(DatabaseConfig.class);
//		System.out.println(databaseConfig.getValue());

//		//Resource Loader
//		FileBean fileBean = context.getBean(FileBean.class);
//		fileBean.printInfo();

		//Property Resource
		Author author = context.getBean(Author.class);
		System.out.println(author.getName()+" "+author.getEmail());

		//Spring Validation
//		MessageSource messageSource = context.getBean(MessageSource.class);
//
//		Author author = new Author("", "");
//		DataBinder binder = new DataBinder(author);
//		binder.addValidators(new AuthorValidator());
//
//		binder.validate();
//		BindingResult result = binder.getBindingResult();
//
//		if(result.hasErrors()){
//			//error
//			result.getAllErrors().stream().forEach(objectError -> {
//				String message = messageSource.getMessage(objectError.getCode(), null, Locale.getDefault());
//				System.out.println(message);
//			});
//		}else{
//			//tidak error
//			System.out.println("tidak terjadi error");
//		}

		//Bean Validation
		MessageSource messageSource = context.getBean(MessageSource.class);

		//Validator validator = context.getBean(Validator.class);
		User user = new User();
		user.setEmail("salah");
		user.setId("0");
		user.setName("");

//		Set<ConstraintViolation<User>> result = validator.validate(user);
//		result.forEach((constraint) -> {
//			System.out.println(constraint.getMessage());
//		});

		UserService service = context.getBean(UserService.class);


		try{
			service.save(user);
			//service.getById("");
		}catch (ConstraintViolationException ex){
			ex.getConstraintViolations().stream().forEach((error) -> {
				System.out.println(error.getMessage());
			});
		}

	}

}
