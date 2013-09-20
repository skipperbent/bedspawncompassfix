package pecee.bedspawncompassfix;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = "bedspawncompassfix", name = "Bed Spawn Compass Fix", version = "1.0")
@cpw.mods.fml.common.network.NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class mod_BedSpawnCompassFix
{
    public static String MOD_ID = "bedspawncompassfix";
    @Mod.Init
    public void load(FMLInitializationEvent event)
    {
    	TickRegistry.registerTickHandler(new ServerTickHandler(), Side.CLIENT);
    	//MinecraftForge.EVENT_BUS.register(new EventHookContainer());
    }
}
