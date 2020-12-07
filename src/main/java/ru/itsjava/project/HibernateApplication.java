package ru.itsjava.project;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itsjava.project.services.UserService;
import ru.itsjava.project.services.UserServiceImpl;
import ru.itsjava.project.model.Mail;
import ru.itsjava.project.model.Pet;
import ru.itsjava.project.model.User;

import java.sql.SQLException;


@SpringBootApplication
public class HibernateApplication {

	public static void main(String[] args) throws SQLException {
		var context = SpringApplication.run(HibernateApplication.class, args);
		Mail mail = new Mail(0l, "alex@mail.ru");
		Mail mail2 = new Mail(0l, "anna@mail.ru");
		Mail mail3 = new Mail(0l, "friend@mail.ru");
		Pet pet = new Pet(0l,"Cat", "Musya");
		Pet pet2 = new Pet(0l,"Dog", "Husky");
		Pet pet3 = new Pet(0l,"Catty", "Nyusha");
		User user = new User(0l, "Alex", 27, mail, pet);
		User user2 = new User(0l, "Anna", 26, mail2, pet2);
		User user3 = new User(0l, "Andrey", 28, mail3, pet3);
		UserService userService = context.getBean(UserServiceImpl.class);
		userService.createUser(user);
		userService.createUser(user2);
		userService.createUser(user3);
//		Console.main(args);
	}

}
