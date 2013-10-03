package peacock.dimeng.core.proxy;

import peacock.dimeng.tileentity.TileBurnerPlate;
import peacock.dimeng.tileentity.TileEngineeringLaser;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.ForgeDirection;

public class CommonProxy {
	
	public void registerKeyBindingHandler() {

    }

    public void registerRenderTickHandler() {

    }

    public void registerDrawBlockHighlightHandler() {

    }

    public void setKeyBinding(String name, int value) {

    }

    public void registerSoundHandler() {

    }

    public void initRenderingAndTextures() {

    }

    public void registerTileEntities() {
    	GameRegistry.registerTileEntity(TileBurnerPlate.class, "tileBurnerPlate");
    	GameRegistry.registerTileEntity(TileEngineeringLaser.class, "tileEngineeingLaser");
    }

    public void sendRequestEventPacket(byte eventType, int originX, int originY, int originZ, byte sideHit, byte rangeX, byte rangeY, byte rangeZ, String data) {

    }

    public void handleTileEntityPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName) {

    }

    public void handleTileWithItemPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName, int itemID, int metaData, int stackSize, int color) {

    }

}
