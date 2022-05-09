package main;

import java.io.IOException;
import java.sql.SQLException;

import repository.TaskRepo;
import repository.UserRepo;

public class App {
	public static void main(String args[]) throws IOException, ClassNotFoundException, SQLException {

		ArgumentsReader argread = new ArgumentsReader();
		UserRepo userrepo = new UserRepo();
		TaskRepo taskrepo = new TaskRepo();

		
		String firstName = null, lastName = null, userName = null, taskTitle = null, taskDescription = null;

		/**
		 * creates a user if console input = -createUser -fn='FirstName' -ln='LastName' -un='UserName'
		 * 
		 */
		if (args[0].equals("-createUser")) {
			firstName = argread.read(args[1]);
			lastName = argread.read(args[2]);
			userName = argread.read(args[3]);

			userrepo.addUser(firstName, lastName, userName);
		}

		/**
		 * shows users if console input = -showAllUsers
		 */
		if (args[0].equals("-showAllUsers")) {
			
			userrepo.showAllUsersS().stream().forEach(System.out::println);
		}

		/**
		 * adds a task to a specific user if console input = -addTask -un='UserName' -tt='Task Title' -td='Task Description'
		 */

		taskrepo.addTasks("UserName", "titletask", "description");
//		if (args[0].equals("-addTask")) {
//			userName = argread.read(args[1]);
//			taskTitle = argread.read(args[2]);
//			taskDescription = argread.read(args[3]);
//
//			taskrepo.addTasks(userName, taskTitle, taskDescription);
//
//		}

		/**
		 * shows the task of the user if console input = -showTasks -un='userName'
		 */
		if (args[0].equals("-showTasks")) {
			System.out.println(taskrepo.showTasks(argread.read(args[1])));
		}

	}
}
