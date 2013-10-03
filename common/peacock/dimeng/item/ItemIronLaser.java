package peacock.dimeng.item;

import peacock.dimeng.Dimensional_Engineering;
import peacock.dimeng.lib.Strings;

public class ItemIronLaser extends ItemDE {
	
	public ItemIronLaser(int id){
		super(id, 16, false);
		this.setUnlocalizedName(Strings.NAME_PREFIX + Strings.IRON_LASER_NAME);
		this.setCreativeTab(Dimensional_Engineering.tabsDIMENG);
	}

}
