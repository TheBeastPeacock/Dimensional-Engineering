package peacock.dimeng.client.model;

import org.lwjgl.opengl.GL11;

import peacock.dimeng.lib.Models;
import peacock.dimeng.lib.Reference;
import peacock.dimeng.lib.Textures;
import peacock.dimeng.tileentity.TileEngineeringLaser;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelEngineeringLaser extends ModelBase {
	
	private IModelCustom engineeringLaser;
	private IModelCustom laser;
	
	public ResourceLocation textureStand = new ResourceLocation(Reference.MOD_ID.toLowerCase(), Textures.ENGIEERING_LASER_STAND_TEXTURE);
	public ResourceLocation textureIronLaser = new ResourceLocation(Reference.MOD_ID.toLowerCase(), Textures.IRON_LASER_TEXTURE);
	
	public ModelEngineeringLaser() {
		engineeringLaser = AdvancedModelLoader.loadModel(Models.MODEL_ENGINEERING_LASER);
		laser = AdvancedModelLoader.loadModel(Models.MODEL_ENGINEERING_LASER_LASER);
	}
	
	public void render() {
		engineeringLaser.renderAll();
	}
	
	public void renderPart(String string) {
		engineeringLaser.renderPart(string);
	}
	
	public void renderLaser() {
		laser.renderPart("Laser");
	}
	
	public void render(TileEngineeringLaser laser, double x, double y, double z, float rotate) {
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		
		GL11.glScalef(1F, 1F, 1F);
        GL11.glTranslatef((float) x + 0.5F, (float) y + 0.0F, (float) z + 0.5F);
        GL11.glRotatef(0F, 0F, 1F, 0F);
        GL11.glRotatef(0F, 1F, 0F, 0F);
        
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(getTextureName(0));
        this.renderPart("Stand");
        
        if(laser.getWorldObj().getBlockMetadata(laser.xCoord, laser.yCoord, laser.zCoord) == 1) {
        	GL11.glTranslatef(0f, 0.9f, 0f);
        	GL11.glRotatef(rotate, 0f, 1f, 0f);
        	FMLClientHandler.instance().getClient().renderEngine.bindTexture(getTextureName(1));
        	this.renderLaser();
        }
        
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}
	
	public void setTextureName(String string) {
		
	}
	
	public ResourceLocation getTextureName(int name) {
		switch(name) {
		case 0:
			return textureStand;
		case 1:
			return textureIronLaser;
		default:
			return null;
		}
	}

}
