package peacock.dimeng.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import peacock.dimeng.client.model.ModelEngineeringLaser;
import peacock.dimeng.tileentity.TileEngineeringLaser;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

@SideOnly(Side.CLIENT)
public class TileEntityEngineeringLaserRenderer extends TileEntitySpecialRenderer {
	
	private ModelEngineeringLaser laserModel = new ModelEngineeringLaser();

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float tick) {
		TileEngineeringLaser tile = (TileEngineeringLaser)tileentity;
		laserModel.render(tile, x, y, z, rotate(tile.tickCount));
	}
	
	private float rotate(int tick) {
		return (float)tick * 3;
	}
}
