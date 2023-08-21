package com.techforb.userdashboard;

import com.techforb.userdashboard.model.*;
import com.techforb.userdashboard.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class UserDashboardApplication {


	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(UserDashboardApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(UserRepository userRepository, AccountRepository accountRepository, CardRepository cardRepository, TransactionRepository transactionRepository, OptionMenuRepository optionMenuRepository, OptionMenuListRepository optionMenuListRepository) {
		return args -> {



			User user1 = new User("Matias Gonzalez","41046444", passwordEncoder.encode("1234"));
			userRepository.save(user1);

			Account account = new Account("20124589574589554125",LocalDateTime.now().minusYears(1),400000);
			user1.setAccount(account);
			account.setUser(user1);
			accountRepository.save(account);
			userRepository.save(user1);

			Transaction transaction1 = new Transaction("20124545274589554125",20.40, LocalDateTime.now().minusDays(1),"Completed");
			transactionRepository.save(transaction1);
			account.addTransaction(transaction1);
			accountRepository.save(account);


			Card card1 = new Card("Matias Gonzalez", "2334444455555554", LocalDate.now(),433, CardType.CREDIT);
			cardRepository.save(card1);
			account.addCard(card1);
			accountRepository.save(account);














			OptionMenu	home = new OptionMenu("Home","/index.html");
			OptionMenu	cards = new OptionMenu("Cards","/cards.html");
			OptionMenu	transactions = new OptionMenu("Transactions","/transactions.html");
			OptionMenu	loans = new OptionMenu("Loans","/loans.html");

			OptionMenuList user_home = new OptionMenuList("User_Home");

			user_home.addOptionMenu(home);
			user_home.addOptionMenu(cards);
			user_home.addOptionMenu(transactions);
			user_home.addOptionMenu(loans);

			optionMenuListRepository.save(user_home);

			optionMenuRepository.save(home);
			optionMenuRepository.save(cards);
			optionMenuRepository.save(transactions);
			optionMenuRepository.save(loans);




		};

	}
}
