package main;

import java.io.IOException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import domain.TaskRepo;
import domain.UserFactory;
import domain.UserRepo;

public class myaplication {
	public static void main(String args[]) throws IOException, ClassNotFoundException {

		ArgumentsReader argread = new ArgumentsReader();
		UserRepo userrepo = new UserRepo("domain.UserFileStorage");
		TaskRepo taskrepo = new TaskRepo("domain.TaskFileStorage");

		String firstName = null, lastName = null, userName = null, taskTitle = null, taskDescription = null;

		/**
		 * creates a user if console input = -createUser -fn='FirstName' -ln='LastName'
		 * -un='UserName'
		 * 
		 */
		if (args[0].equals("-createUser")) {
			firstName = argread.read(args[1]);
			lastName = argread.read(args[2]);
			userName = argread.read(args[3]);

			userrepo.addAndSerializeUser(firstName, lastName, userName);
		}

		/**
		 * shows users if console input = -showAllUsers
		 */
		if (args[0].equals("-showAllUsers")) {
			System.out.println(userrepo.showAllUsers());
		}

		/**
		 * adds a task to a specific user if console input = -addTask -un='userName'
		 * -tt='Task Title' -td='Task Description'
		 */

		if (args[0].equals("-addTask")) {
			userName = argread.read(args[1]);
			taskTitle = argread.read(args[2]);
			taskDescription = argread.read(args[3]);

			taskrepo.addTasks(userName, taskTitle, taskDescription);

		}

		/**
		 * shows the task of the user if console input = -showTasks -un='userName'
		 */
		if (args[0].equals("-showTasks")) {
			System.out.println(taskrepo.showTasks(argread.read(args[1])));
		}

	}

}
