package domain;

import java.util.UUID;
/**
 * generates a unique identifier
 * @author DARIA
 *
 */
public class UUIDFactory {
	public UUID generateUserUUID() {
		return UUID.randomUUID();
	}
}
