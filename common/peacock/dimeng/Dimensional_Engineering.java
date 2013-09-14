package peacock.dimeng;

import net.minecraft.creativetab.CreativeTabs;
import peacock.dimeng.block.ModBlocks;
import peacock.dimeng.core.handlers.CraftingHandler;
import peacock.dimeng.core.proxy.CommonProxy;
import peacock.dimeng.creativetab.CreativeTabsDimEng;
import peacock.dimeng.item.ModItems;
import peacock.dimeng.lib.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION)
@NetworkMod(clientSideRequired=true)
public class Dimensional_Engineering {
	
    // The instance of your mod that Forge uses.
    @Instance(value = Reference.MOD_ID)
    public static Dimensional_Engineering instance;
    
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="peacock.dimeng.core.proxy.ClientProxy", serverSide="peacock.dimeng.core.proxy.CommonProxy")
    public static CommonProxy proxy;
    
    public static CreativeTabs tabsDIMENG = new CreativeTabsDimEng(CreativeTabs.getNextID(), Reference.MOD_ID);
    
    @EventHandler // used in 1.6.2
    public void preInit(FMLPreInitializationEvent event) {
            // Stub Method
    	
    }
    
    @EventHandler // used in 1.6.2
    public void load(FMLInitializationEvent event) {
    	//registers Renderers
    	proxy.registerRenderers();
    	
    	//registers test crafting handler
        GameRegistry.registerCraftingHandler(new CraftingHandler());
        
        //initializes items
        ModItems.init();
        
        //initializes blocks
        ModBlocks.init();
    }
    
    @EventHandler // used in 1.6.2
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    }
}
