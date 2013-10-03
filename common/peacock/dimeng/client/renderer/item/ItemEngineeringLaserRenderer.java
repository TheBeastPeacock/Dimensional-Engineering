package peacock.dimeng.client.renderer.item;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import peacock.dimeng.client.model.ModelEngineeringLaser;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemEngineeringLaserRenderer implements IItemRenderer {
	
	private ModelEngineeringLaser laserModel;
	
	public ItemEngineeringLaserRenderer() {
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
			renderLaserModel(-0.5F, 0.0F, 0.5F, 1.0F);
			return;
		case EQUIPPED:
			renderLaserModel(0.5F, 0.1F, 1.4F, 1.1F);
			return;
		case EQUIPPED_FIRST_PERSON:
			renderLaserModel(0.5F, 0.1F, 1.4F, 1.1F);
			return;
		case INVENTORY:
			renderLaserModel(0.0F, -0.3F, 1.0F, 1.0F);
			return;
		default:
			break;
		}	
	}
	
	private void renderLaserModel(float x, float y, float z, float scale) {
		GL11.glPushMatrix();
		 
	    // Disable Lighting Calculations
	    GL11.glDisable(GL11.GL_LIGHTING);
	    
	    GL11.glScalef(scale, scale, scale);
	    GL11.glTranslatef(x,  y,  z - 1);
	    GL11.glRotatef(0F, 1F, 0, 0);
	     
	    FMLClientHandler.instance().getClient().renderEngine.bindTexture(laserModel.getTextureName(0));
	    laserModel.renderPart("Stand");
	     
	    // Re-enable Lighting Calculations
	    GL11.glEnable(GL11.GL_LIGHTING);
	    GL11.glPopMatrix();
	}

}
