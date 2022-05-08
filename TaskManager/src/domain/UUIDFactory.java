package domain;

import java.util.UUID;
/**
 * serves as base for factory
 * generates a unique identifier
 * @author DARIA
 *
 */
public class UUIDFactory {
	public UUID generateUserUUID() {
		return UUID.randomUUID();
	}
}
