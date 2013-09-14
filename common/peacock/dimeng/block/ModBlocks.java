package peacock.dimeng.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import peacock.dimeng.lib.BlockIds;
import peacock.dimeng.lib.Strings;

public class ModBlocks {
	
	/*Block Instances*/
	public static Block obisdianTable;
	
	public static void init() {
		/*Assigning Blocks*/
		obisdianTable = new BlockObsidianTable(BlockIds.OBISDIAN_TABLE);
		/*Registering Blocks*/
		GameRegistry.registerBlock(obisdianTable, Strings.OBSIDIAN_TABLE_NAME);
		/*Recipes Initialization*/
		initBlockRecipes();
	}
	
	private static void initBlockRecipes() {
		
	}

}
