package Storage;

import domain.User;

public class UserFileStorage extends FileStorage<User>{

	public UserFileStorage(User obj) {
		super(obj);
	}

}
