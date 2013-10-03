package peacock.dimeng.client.model;

import org.lwjgl.opengl.GL11;

import peacock.dimeng.lib.Models;
import peacock.dimeng.lib.Reference;
import peacock.dimeng.lib.Textures;
import peacock.dimeng.tileentity.TileBurnerPlate;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelBurnerPlate extends ModelBase {
	
	private IModelCustom modelBurnerPlate;
	public ResourceLocation texture = new ResourceLocation(Reference.MOD_ID.toLowerCase(), Textures.BURNER_PLATE_TEXTURE);
	
	public ModelBurnerPlate() {
		
		modelBurnerPlate = AdvancedModelLoader.loadModel(Models.MODEL_BURNER_PLATE);
	}
	
	public void render() {
		modelBurnerPlate.renderAll();
	}
	
	public void renderPart(String part) {
		modelBurnerPlate.renderPart(part);
	}
	
	public void render(TileBurnerPlate burnerPlate, double x, double y, double z) {
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		
		GL11.glScalef(1.0F, 1.0F, 1.0F);
        GL11.glTranslatef((float) x + 0.5F, (float) y + 0.25F, (float) z + 0.5F);
        GL11.glRotatef(0F, 0F, 1F, 0F);
        GL11.glRotatef(0F, 1F, 0F, 0F);
        
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.texture);
		this.renderPart("Middle");
		this.renderPart("Plate");
		
		if(burnerPlate.getWorldObj().getBlockMetadata(burnerPlate.xCoord, burnerPlate.yCoord, burnerPlate.zCoord) == 1) {
			GL11.glScalef(0.8F, 0.6F, 0.8F);
			GL11.glTranslatef(0f, 0.3f, 0f);
			this.renderPart("Ring");
		}
		
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}
	
}
