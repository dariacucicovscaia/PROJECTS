package domain;

import java.util.UUID;
/**
 * serves as structural base for user and task entity
 * Creates UUID
 * @author DARIA
 *
 */

public class UUIDEntity implements UUIDEntityInterface<UUID> {
	private UUID uuid;

	public UUID getUuid() {
		return uuid;
	}

	@Override
	public void setUUID(UUID uuid) {
		// TODO Auto-generated method stub
		this.uuid = uuid;
	}
	
	
}
