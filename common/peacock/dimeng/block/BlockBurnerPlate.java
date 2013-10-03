package peacock.dimeng.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import peacock.dimeng.Dimensional_Engineering;
import peacock.dimeng.item.ModItems;
import peacock.dimeng.lib.Strings;
import peacock.dimeng.tileentity.TileBurnerPlate;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBurnerPlate extends BlockDE {

	public BlockBurnerPlate(int id) {
		super(id, Material.iron);
		this.setTickRandomly(true);
		this.setUnlocalizedName(Strings.NAME_PREFIX + Strings.BURNER_PLATE_NAME);
		this.setCreativeTab(Dimensional_Engineering.tabsDIMENG);
		this.setBlockBounds(0.14f, 0f, 0.14f, 0.86f, 1.0f, 0.86f);
		this.setHardness(20.0f);
		this.setResistance(2000.0f);
	}
	
	@Override
	public boolean hasTileEntity() {
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileBurnerPlate();
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
    public boolean isOpaqueCube() {
        return false;
    }
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, int id, int meta) {
		super.breakBlock(world, x, y, z, id, meta);
		if(world.getBlockMetadata(x, y, z) == 1) {
			dropInv(world, x, y, z);
		}
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		world.setBlockMetadataWithNotify(x, y, z, 0, 2);
	}
	
	private void dropInv(World world, int x, int y, int z) {
		EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(ModItems.burnerRing));
		world.spawnEntityInWorld(entityItem);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		System.out.println(world.getBlockMetadata(x, y, z));
		if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().itemID == ModItems.burnerRing.itemID && world.getBlockMetadata(x, y, z) != 1) {
			world.setBlockMetadataWithNotify(x, y, z, 1, 2);
			player.setCurrentItemOrArmor(0, new ItemStack(player.getCurrentEquippedItem().itemID, player.getCurrentEquippedItem().stackSize - 1, 0));
		}
		if(player.isSneaking() && world.getBlockMetadata(x, y, z) == 1) {
			player.inventory.addItemStackToInventory(new ItemStack(ModItems.burnerRing.itemID, 1, 0));
			world.setBlockMetadataWithNotify(x, y, z, 0, 2);
		}
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		double d0 = (double)((float)x + 0.5F);
        double d1 = (double)((float)y + 0.8F);
        double d2 = (double)((float)z + 0.5F);
        
        if(world.getBlockMetadata(x, y, z) == 1) {
        	world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
        	world.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
	}

}
