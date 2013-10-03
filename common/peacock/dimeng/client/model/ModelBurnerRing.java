package peacock.dimeng.client.model;

import peacock.dimeng.lib.Models;
import peacock.dimeng.lib.Reference;
import peacock.dimeng.lib.Textures;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelBurnerRing extends ModelBase {
	
	private IModelCustom modelBurnerRing;
	public ResourceLocation texture = new ResourceLocation(Reference.MOD_ID.toLowerCase(), Textures.BURNER_PLATE_TEXTURE);
	
	public ModelBurnerRing() {
		
		modelBurnerRing = AdvancedModelLoader.loadModel(Models.MODEL_BURNER_PLATE);
	}
	
	public void render() {
		modelBurnerRing.renderAll();
	}
	
	public void renderPart(String part) {
		modelBurnerRing.renderPart(part);
	}
}
