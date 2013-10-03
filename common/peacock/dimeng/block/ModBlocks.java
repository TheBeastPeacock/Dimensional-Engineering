package peacock.dimeng.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import peacock.dimeng.lib.BlockIds;
import peacock.dimeng.lib.Strings;

public class ModBlocks {
	
	/*Block Instances*/
	public static Block burnerPlate;
	public static Block engineeringLaser;
	
	public static void init() {
		/*Assigning Blocks*/
		burnerPlate = new BlockBurnerPlate(BlockIds.BURNER_PLATE);
		engineeringLaser = new BlockEngineeringLaser(BlockIds.ENGINEERING_LASER);
		/*Registering Blocks*/
		GameRegistry.registerBlock(burnerPlate, Strings.BURNER_PLATE_NAME);
		GameRegistry.registerBlock(engineeringLaser, Strings.ENGINEERING_LASER_NAME);
		/*Recipes Initialization*/
		initBlockRecipes();
	}
	
	private static void initBlockRecipes() {
		
	}

}
