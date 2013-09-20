package pecee.bedspawncompassfix;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChunkCoordinates;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler {

	private void onPlayerTick(EntityPlayer player) {
		int sleepTicks = player.getSleepTimer();
		if (sleepTicks == 99) {
			Minecraft mc = Minecraft.getMinecraft();
			ChunkCoordinates bed = player.getPlayerCoordinates();
			mc.theWorld.setSpawnLocation(bed.posX, bed.posY, bed.posZ);
			player.setSpawnChunk(bed, true);
			System.out.println("Set bed spawn location to x: " + bed.posX + " y: " + bed.posY + " z: " + bed.posZ);
		}
	}


	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.PLAYER, TickType.CLIENT);
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		if (type.equals(EnumSet.of(TickType.PLAYER))) {
			onPlayerTick((EntityPlayer)tickData[0]);
        }
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
		
	}
}
