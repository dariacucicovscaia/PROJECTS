package Storage;

import java.util.List;

public interface FilesSerializeInterface<T> {
	void serialize(List<T> object);
	List<T> deserialize(List<T> object);
	
}
