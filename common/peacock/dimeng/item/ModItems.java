package peacock.dimeng.item;

import peacock.dimeng.lib.ItemIds;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModItems {
	
	public static Item sparklingVial;
	public static Item burnerRing;
	public static Item ironLaser;
	
	public static void init() {
		/*Mod Item Instances*/
		sparklingVial = new ItemSparklingVial(ItemIds.SPARKLING_VIAL, 16, false);
		burnerRing = new ItemBurnerRing(ItemIds.BURNER_RING, 64, false);
		ironLaser = new ItemIronLaser(ItemIds.IRON_LASER);
		
		/*Add Recipes*/
		addRecipes();
	}
	
	private static void addRecipes() {
		GameRegistry.addShapedRecipe(new ItemStack(sparklingVial), new Object[] {"p p", "pdp", "ppp", Character.valueOf('p'), Block.thinGlass, Character.valueOf('d'), Item.diamond });
		GameRegistry.addShapedRecipe(new ItemStack(burnerRing), new Object[] {"iii", "i i", "iii", Character.valueOf('i'), Item.ingotIron});
	}
}
