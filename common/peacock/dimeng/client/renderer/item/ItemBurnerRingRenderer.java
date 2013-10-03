package peacock.dimeng.client.renderer.item;

import org.lwjgl.opengl.GL11;

import peacock.dimeng.client.model.ModelBurnerRing;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemBurnerRingRenderer implements IItemRenderer {
	
	private ModelBurnerRing burnerRing;
	
	public ItemBurnerRingRenderer() {
		burnerRing = new ModelBurnerRing();
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
			renderBurnerRing(-0.5F, 0.0F, 0.5F, 0.5F);
			return;
		case EQUIPPED:
			renderBurnerRing(0.5F, 0.1F, 1.4F, 1.1F);
			return;
		case EQUIPPED_FIRST_PERSON:
			renderBurnerRing(0.5F, 0.3F, 1.5F, 1.1F);
            return;
		case INVENTORY:
			renderBurnerRing(0.0F, -0.3F, 1.0F, 1.0F);
		default:
			break;
		}
	}
	
	private void renderBurnerRing(float x, float y, float z, float scale) {
		GL11.glPushMatrix();
		
		GL11.glDisable(GL11.GL_LIGHTING);
		
		GL11.glScalef(scale, scale, scale);
		GL11.glTranslatef(x,  y,  z - 1);
	    GL11.glRotatef(0F, 1F, 0, 0);
	    
	    FMLClientHandler.instance().getClient().renderEngine.bindTexture(burnerRing.texture);
	    
	    burnerRing.renderPart("Ring");
	    
	    // Re-enable Lighting Calculations
	    GL11.glEnable(GL11.GL_LIGHTING);
	    GL11.glPopMatrix();
	}

}
