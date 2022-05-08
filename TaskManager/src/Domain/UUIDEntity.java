package Domain;

import java.util.UUID;
/**
 * Creates/generates UUID
 * @author DARIA
 *
 */

public class UUIDEntity {
	private UUID uuid;

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
	public UUID generateUserUUID() {
		return UUID.randomUUID();
	}
}
