package peacock.dimeng.creativetab;

import peacock.dimeng.item.ModItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabsDimEng extends CreativeTabs {

	public CreativeTabsDimEng(int tabId, String tabName) {
		super(tabId, tabName);
		// TODO Auto-generated constructor stub
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    /**
     * the itemID for the item to be displayed on the tab
     */
    public int getTabIconItemIndex() {

        return ModItems.sparklingVial.itemID;
    }

}
