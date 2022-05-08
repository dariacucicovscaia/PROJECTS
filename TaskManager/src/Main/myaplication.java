package Main;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Factory.UserFactory;
import Repository.TaskRepo;
import Repository.UserRepo;

public class myaplication {
	public static void main(String args[]) throws IOException, ClassNotFoundException {

		UserFactory userf = new UserFactory();
		UserRepo userrepo = new UserRepo("Storage.UserFileStorage");
		TaskRepo taskrepo = null;

		try (Scanner scanner = new Scanner(System.in)) {
			String methodname = scanner.next();
			String firstName = null, lastName = null, userName = null, taskTitle = null, taskDescription = null;

			/**
			 * creates a user if console input = -createUser -fn='FirstName' -ln='LastName' -un='UserName'
			 * 
			 */
			if (methodname.equals("-createUser")) {
				String fn = scanner.next();
				if (fn.contains("'")) {
					// get value firstname
					firstName = ExtractXName(fn);// ----------------------------firstName
					String ln = scanner.next();
					if (ln.contains("'")) {
						lastName = ExtractXName(ln);// -------------------------lastName
						String un = scanner.next();
						if (un.contains("'")) {
							userName = ExtractXName(un);// ----------------------userName
							// check if user name already exists
							// add the user

							userrepo.addAndSerializeUser(firstName, lastName, userName); // ------add this to a file or
						 
						}
					}
				}
			}

			/**
			 * shows users if console input = -showAllUsers
			 */
			if (methodname.equals("-showAllUsers")) {

				for (String one : userrepo.showAllUsers()) {
					System.out.println(one);
				}

			}

			/**
			 * adds a task to a specific user if console input = -addTask -un='userName'
			 * -tt='TaskTitle' -td='TaskDescription'
			 */

			if (methodname.equals("-addTask")) {
				String un = scanner.next();
				if (un.contains("'")) {
					// get value firstname
					userName = ExtractXName(un);// ----------------------------userName
					String tt = scanner.next();
					if (tt.contains("'")) {
						taskTitle = ExtractXName(tt);// -------------------------taskTitle
						String td = scanner.next();
						if (un.contains("'")) {
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
			if (methodname.equals("-showTasks")) {
				String un = scanner.next();
				if (un.contains("'")) {
					// System.out.println(ExtractXName(un));
					System.out.println();
					// System.out.println(taskrepo.showTasks(ExtractXName(un)));

				}
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