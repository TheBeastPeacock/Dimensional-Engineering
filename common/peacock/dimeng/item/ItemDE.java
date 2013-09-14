package peacock.dimeng.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemDE extends Item {

	public ItemDE(int id) {
		super(id);
	}
	
	public ItemDE(int id, int stackSize, boolean repair) {
		super(id);
		maxStackSize = stackSize;
		if (!repair)
			setNoRepair();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		/*Registers Textures for Items*/
		itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
}
