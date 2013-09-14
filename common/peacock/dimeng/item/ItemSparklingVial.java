package peacock.dimeng.item;

import peacock.dimeng.Dimensional_Engineering;
import peacock.dimeng.lib.Strings;

public class ItemSparklingVial extends ItemDE {


	public ItemSparklingVial(int id, int stackSize, boolean repair) {
		super(id, stackSize, repair);
		this.setUnlocalizedName(Strings.NAME_PREFIX + Strings.SPARKLING_VIAL_NAME);
		this.setCreativeTab(Dimensional_Engineering.tabsDIMENG);
	}
}
