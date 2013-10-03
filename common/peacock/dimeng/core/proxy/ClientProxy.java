package peacock.dimeng.core.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import peacock.dimeng.block.ModBlocks;
import peacock.dimeng.client.renderer.item.ItemBurnerPlateRenderer;
import peacock.dimeng.client.renderer.item.ItemBurnerRingRenderer;
import peacock.dimeng.client.renderer.item.ItemEngineeringLaserRenderer;
import peacock.dimeng.client.renderer.item.ItemIronLaserRenderer;
import peacock.dimeng.client.renderer.tileentity.TileEntityBurnerPlateRenderer;
import peacock.dimeng.client.renderer.tileentity.TileEntityEngineeringLaserRenderer;
import peacock.dimeng.item.ModItems;
import peacock.dimeng.tileentity.TileBurnerPlate;
import peacock.dimeng.tileentity.TileEngineeringLaser;
import net.minecraftforge.client.MinecraftForgeClient;


public class ClientProxy extends CommonProxy {
	
	@Override
	public void initRenderingAndTextures() {
		//Item Renderer Registry
		MinecraftForgeClient.registerItemRenderer(ModBlocks.burnerPlate.blockID, new ItemBurnerPlateRenderer());
		MinecraftForgeClient.registerItemRenderer(ModItems.burnerRing.itemID, new ItemBurnerRingRenderer());
		MinecraftForgeClient.registerItemRenderer(ModBlocks.engineeringLaser.blockID, new ItemEngineeringLaserRenderer());
		MinecraftForgeClient.registerItemRenderer(ModItems.ironLaser.itemID, new ItemIronLaserRenderer());
	}
	
	@Override
	public void registerTileEntities() {
		super.registerTileEntities();
		
		//Tile Renderer Registry
		ClientRegistry.bindTileEntitySpecialRenderer(TileBurnerPlate.class, new TileEntityBurnerPlateRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEngineeringLaser.class, new TileEntityEngineeringLaserRenderer());
	}

}
