package peacock.dimeng.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import peacock.dimeng.Dimensional_Engineering;
import peacock.dimeng.lib.Strings;

public class ItemBurnerRing extends ItemDE {

	public ItemBurnerRing(int id, int stackSize, boolean repair) {
		super(id, stackSize, repair);
		this.setUnlocalizedName(Strings.NAME_PREFIX + Strings.BURNER_RING_NAME);
		this.setCreativeTab(Dimensional_Engineering.tabsDIMENG);
	}
	
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
		return false;
	}
}
