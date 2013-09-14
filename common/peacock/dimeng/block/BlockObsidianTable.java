package peacock.dimeng.block;

import peacock.dimeng.Dimensional_Engineering;
import peacock.dimeng.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockObsidianTable extends Block {
	
	public BlockObsidianTable(int id) {
		super(id, Material.iron);
		this.setUnlocalizedName("dimeng:obsidianTable");
		this.setCreativeTab(Dimensional_Engineering.tabsDIMENG);
		this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
	}
	
    @Override
    public boolean renderAsNormalBlock() {

        return true;
    }
    
    @Override
    public boolean isOpaqueCube() {

        return false;
    }
}
