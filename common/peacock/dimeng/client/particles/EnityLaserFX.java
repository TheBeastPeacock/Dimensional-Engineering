package peacock.dimeng.client.particles;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EnityLaserFX extends EntityFX {

	public EnityLaserFX(World world, double x, double y, double z, double mx, double my, double mz) {
		super(world, x, y, z, mx, my, mz);
		this.motionX = this.motionX * 0.009999999776482582D + mx;
        this.motionY = this.motionY * 0.009999999776482582D + my;
        this.motionZ = this.motionZ * 0.009999999776482582D + mz;
	}
	
	public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {
		
	}
	
	public int getBrightnessForRender(float par1) {
		return 0;
	}
	
	public float getBrightness(float par1) {
		return 0;
	}
	
	public void onUpdate() {
		
	}
	
}
