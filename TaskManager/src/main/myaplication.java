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

		UserRepo userrepo = new UserRepo("domain.UserFileStorage");
		TaskRepo taskrepo = new TaskRepo("domain.TaskFileStorage");

			String firstName = null, lastName = null, userName = null, taskTitle = null, taskDescription = null;

			/**
			 * creates a user if console input = -createUser -fn='FirstName' -ln='LastName' -un='UserName'
			 * 
			 */
			if (args[0].equals("-createUser")) {
				String fn = args[1];
				if (fn.contains("'")) {
					firstName = ExtractXName(fn);// ----------------------------firstName
					String ln = args[2];
					if (ln.contains("'")) {
						lastName = ExtractXName(ln);    // -------------------------lastName
						String un = args[3];
						if (un.contains("'")) {
							userName = ExtractXName(un);    // ------------------------------userName
							userrepo.addAndSerializeUser(firstName, lastName, userName);
						}
					}
				}
			}

			/**
			 * shows users if console input = -showAllUsers
			 */
			if (args[0].equals("-showAllUsers")) {
			
				System.out.println(userrepo.showAllUsers()); 
			}

			/**
			 * adds a task to a specific user if console input = -addTask -un='userName' -tt='Task Title' -td='Task Description'
			 */

			if (args[0].equals("-addTask")) {
				String un = args[1];
				if (un.contains("'")) {
					// get value firstname
					userName = ExtractXName(un);// ----------------------------userName
					String tt = args[2];
					if (tt.contains("'")) {
						taskTitle = ExtractXName(tt);// -------------------------taskTitle
						String td = args[3];
						if (td.contains("'")) {
							taskDescription = ExtractXName(td);// ---------------------taskDecription
							// check if user name already exists
							// add the user

							taskrepo.addTasks(userName, taskTitle, taskDescription);

						}
					}
				}
			}

			/**
			 * shows the task of the user if console input = -showTasks -un='userName'
			 */
			if (args[0].equals("-showTasks")) {
				String un = args[1];
				if (un.contains("'")) {
					// System.out.println(ExtractXName(un));
					System.out.println(taskrepo.showTasks(ExtractXName(un)));

				}
			}

	}

	/**
	 * 
	 * @param string -> the -un='...'
	 * @return -> the value between ' ' as a variable
	 */

	public static String ExtractXName(String string) {
		String ValueWeNeed = null;
		String[] paras = string.split("\n");
		Pattern pattern = Pattern.compile("'(.*?)'");
		for (int i = 0; i < paras.length; i++) {
			Matcher matcher = pattern.matcher(paras[i]);
			while (matcher.find()) {
				ValueWeNeed = matcher.group(1);
			}
		}

		return ValueWeNeed;
	}

}
