package peacock.dimeng.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import peacock.dimeng.client.model.ModelBurnerPlate;
import peacock.dimeng.tileentity.TileBurnerPlate;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

@SideOnly(Side.CLIENT)
public class TileEntityBurnerPlateRenderer extends TileEntitySpecialRenderer {
	
	private ModelBurnerPlate burnerPlate = new ModelBurnerPlate();

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float tick) {
		burnerPlate.render((TileBurnerPlate)tileentity, x, y, z);
	}

}
