package demo;

import java.time.LocalDate;

import takeMe.VzemiMe;
import users.User;

public class Demo {
	public static void main(String[] args) {
		
		VzemiMe vzemiMe = VzemiMe.getInstance();
		
		User u1 = new User("vankata96", "Vankata1234", "Ivan Petrov", LocalDate.of(1996, 2, 13), "vankdasdsa", "dasadsda", -12);
		
		
	}
}
