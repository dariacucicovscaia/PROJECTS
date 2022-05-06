package Storage;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class FileAccessAbstractObj<Object> implements FilesSerializeInterface<Object> {

	String filename;
	@Override
	public void serialize(List<Object> object) {
		try {
			
			 System.out.println(object.getClass().toGenericString());
			 
			 
			filename = object.getClass().getSimpleName() + "";
			
			
			FileOutputStream file = new FileOutputStream(filename);
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
	public Object deserialize(Object object) {
		try {
			filename = object.getClass().getSimpleName() + "";
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			object = (Object) in.readObject();

			in.close();
			file.close();

			System.out.println("Object has been deserialized\n");

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
