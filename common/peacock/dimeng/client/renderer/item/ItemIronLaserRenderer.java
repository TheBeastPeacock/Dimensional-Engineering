package peacock.dimeng.client.renderer.item;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import peacock.dimeng.client.model.ModelEngineeringLaser;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemIronLaserRenderer implements IItemRenderer {
	
	private ModelEngineeringLaser laserModel;
	
	public ItemIronLaserRenderer() {
		laserModel = new ModelEngineeringLaser();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch(type) {
		case ENTITY:
			renderLaserModel(-0.5F, 0.0F, 0.5F, 0.5F, 0.0f);
			return;
		case EQUIPPED:
			renderLaserModel(0.2F, 0.1F, 1.2F, 1.1F, 45.0f);
			return;
		case EQUIPPED_FIRST_PERSON:
			renderLaserModel(0.5F, 0.1F, 1.4F, 1.1F, -45.0f);
			return;
		case INVENTORY:
			renderLaserModel(0.0F, -0.2F, 1.0F, 1.0F, 0.0f);
			return;
		default:
			break;
		}	
	}
	
	private void renderLaserModel(float x, float y, float z, float scale, float rotate) {
		GL11.glPushMatrix();
		 
	    // Disable Lighting Calculations
	    GL11.glDisable(GL11.GL_LIGHTING);
	    
	    GL11.glScalef(scale + 0.5f, scale + 1, scale + 1);
	    GL11.glTranslatef(x,  y + 0.2f,  z - 1);
	    GL11.glRotatef(rotate, 0f, 1f, 0f);
	    
	    FMLClientHandler.instance().getClient().renderEngine.bindTexture(laserModel.textureIronLaser);
	    laserModel.renderLaser();
	     
	    // Re-enable Lighting Calculations
	    GL11.glEnable(GL11.GL_LIGHTING);
	    GL11.glPopMatrix();
	}

	
	

}
