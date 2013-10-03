package peacock.dimeng.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import peacock.dimeng.Dimensional_Engineering;
import peacock.dimeng.item.ModItems;
import peacock.dimeng.lib.Strings;
import peacock.dimeng.tileentity.TileEngineeringLaser;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEngineeringLaser extends BlockDE {
	
	public BlockEngineeringLaser(int id) {
		super(id, Material.iron);
		this.setTickRandomly(true);
		this.setUnlocalizedName(Strings.NAME_PREFIX + Strings.ENGINEERING_LASER_NAME);
		this.setCreativeTab(Dimensional_Engineering.tabsDIMENG);
		this.setBlockBounds(0.14f, 0f, 0.14f, 0.86f, 1.0f, 0.86f);
		this.setHardness(20.0f);
		this.setResistance(500.0f);
	}
	
	@Override
	public boolean hasTileEntity() {
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEngineeringLaser();
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
		TileEngineeringLaser tile = (TileEngineeringLaser)world.getBlockTileEntity(x, y, z);
		super.breakBlock(world, x, y, z, id, meta);
		if(world.getBlockMetadata(x, y, z) == 1) {
			dropInv(world, x, y, z);
		}
		tile.mode = 0;
	}
	
	private void dropInv(World world, int x, int y, int z) {
		EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(ModItems.ironLaser));
		world.spawnEntityInWorld(entityItem);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().itemID == ModItems.ironLaser.itemID && world.getBlockMetadata(x, y, z) != 1) {
			world.setBlockMetadataWithNotify(x, y, z, 1, 2);
			player.setCurrentItemOrArmor(0, new ItemStack(player.getCurrentEquippedItem().itemID, player.getCurrentEquippedItem().stackSize - 1, 0));
		}
		if(player.isSneaking() && world.getBlockMetadata(x, y, z) == 1) {
			player.inventory.addItemStackToInventory(new ItemStack(ModItems.ironLaser.itemID, 1, 0));
			world.setBlockMetadataWithNotify(x, y, z, 0, 2);
		}
		System.out.println(world.getBlockMetadata(x, y, z));
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		TileEngineeringLaser tile = (TileEngineeringLaser)world.getBlockTileEntity(x, y, z);
		
		if(world.getBlockId(x + 2, y, z - 2) == ModBlocks.burnerPlate.blockID && world.getBlockMetadata(x + 2, y, z - 2) == 1 && world.getBlockMetadata(x, y, z) == 1) {
			if(tile.shouldTick) {
				tile.tickCount = 45;
				tile.shouldTick = false;
				tile.mode = 1;
			}
		}
		else if(world.getBlockId(x - 2, y, z + 2) == ModBlocks.burnerPlate.blockID && world.getBlockMetadata(x - 2, y, z + 2) == 1 && world.getBlockMetadata(x, y, z) == 1) {
			if(tile.shouldTick) {
				tile.tickCount = 45;
				tile.shouldTick = false;
				tile.mode = 2;
			}
		}
		else if(world.getBlockId(x + 2, y, z + 2) == ModBlocks.burnerPlate.blockID && world.getBlockMetadata(x + 2, y, z + 2) == 1 && world.getBlockMetadata(x, y, z) == 1) {
			if(tile.shouldTick) {
				tile.tickCount = 315;
				tile.shouldTick = false;
				tile.mode = 3;
			}
		}
		else if(world.getBlockId(x - 2, y, z - 2) == ModBlocks.burnerPlate.blockID && world.getBlockMetadata(x - 2, y, z - 2) == 1 && world.getBlockMetadata(x, y, z) == 1) {
			if(tile.shouldTick) {
				tile.tickCount = 315;
				tile.shouldTick = false;
				tile.mode = 4;
			}
		} else {
			if(!tile.shouldTick) {
				tile.shouldTick = true;
				tile.mode = 0;
			}
		}
        
		double d0;
		double d1;
		double d2;
		
		switch(tile.mode) {
		case 1:
			d0 = (double)((float)x + 0.75F);
	        d1 = (double)((float)y + 1.0F);
	        d2 = (double)((float)z + 0.15F);
        	world.spawnParticle("flame", d0, d1, d2, 0.1D, 0.0D, -0.1D);
        	return;
		case 2:
			d0 = (double)((float)x + 0.15F);
	        d1 = (double)((float)y + 1.0F);
	        d2 = (double)((float)z + 0.75F);
        	world.spawnParticle("flame", d0, d1, d2, -0.1D, 0.0D, 0.1D);
	        return;
		case 3:
			d0 = (double)((float)x + 0.75F);
	        d1 = (double)((float)y + 1.0F);
	        d2 = (double)((float)z + 0.75F);
        	world.spawnParticle("flame", d0, d1, d2, 0.1D, 0.0D, 0.1D);
        	return;
		case 4:
			d0 = (double)((float)x + 0.15F);
	        d1 = (double)((float)y + 1.0F);
	        d2 = (double)((float)z + 0.15F);
        	world.spawnParticle("flame", d0, d1, d2, -0.1D, 0.0D, -0.1D);
	        return;
		default:
			return;
		}
	}

}
