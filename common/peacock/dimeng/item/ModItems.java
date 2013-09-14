package peacock.dimeng.item;

import peacock.dimeng.lib.ItemIds;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModItems {
	
	public static Item sparklingVial;
	
	public static void init() {
		/*Mod Item Instances*/
		sparklingVial = new ItemSparklingVial(ItemIds.SPARKLING_VIAL, 16, false);
		
		/*Add Recipes*/
		addRecipes();
	}
	
	private static void addRecipes() {
		GameRegistry.addShapedRecipe(new ItemStack(sparklingVial), new Object[] {"p p", "pdp", "ppp", Character.valueOf('p'), Block.thinGlass, Character.valueOf('d'), Item.diamond });
	}
}
