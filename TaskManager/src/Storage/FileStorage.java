package Storage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class FileStorage<T> implements FilesSerializeInterface<T> {

	private Class<T> className;

	public FileStorage(T obj) {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.className = (Class<T>) type.getActualTypeArguments()[0];
	}

	@Override
	public void serialize(List<T> object) {
		try {

			FileOutputStream file = new FileOutputStream(className.getSimpleName());
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(object);

			out.close();
			file.close();

			System.out.println("Object has been serialized\n");

		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		object = null;
	}

	@Override
	public List<T> deserialize(List<T> object) {
		try {
			FileInputStream file = new FileInputStream(className.getSimpleName());
			ObjectInputStream in = new ObjectInputStream(file);

			object = (List<T>) in.readObject();

			in.close();
			file.close();

			//System.out.println("Object has been deserialized\n");

		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException" + " is caught");
		}
		return object;

	}

}
