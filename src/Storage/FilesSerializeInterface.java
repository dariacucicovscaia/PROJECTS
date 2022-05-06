package Storage;

import java.util.List;

public interface FilesSerializeInterface<T> {
	void serialize(List<T> object);
	Object deserialize(T object);
	
}
