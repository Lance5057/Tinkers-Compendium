package lance5057.tDefense.core.tools.modifiers;

import java.util.ArrayList;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersDefense;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class TDModifiers {

	Item item_canister;
	Item item_emptycanister;
	Item item_rebreather;
	Item item_nightvisiongoggles;

	Item item_glowsole;
	Item item_firesole;
	Item item_icesole;
	Item item_feathersole;
	Item item_flippers;
	
	static ArrayList<Item> itemList = new ArrayList<Item>();
	
	public void preInit()
	{
		itemList.add(item_canister = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "canister")).setUnlocalizedName("canister").setCreativeTab(TinkersDefense.tab));
		itemList.add(item_emptycanister = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "empty_canister")).setUnlocalizedName("empty_canister").setCreativeTab(TinkersDefense.tab));
		itemList.add(item_rebreather = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "rebreather")).setUnlocalizedName("rebreather").setCreativeTab(TinkersDefense.tab));
		itemList.add(item_nightvisiongoggles = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "nightvisiongoggles")).setUnlocalizedName("nightvisiongoggles").setCreativeTab(TinkersDefense.tab));
		
		itemList.add(item_glowsole = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "glowsole")).setUnlocalizedName("glowsole").setCreativeTab(TinkersDefense.tab));
		itemList.add(item_firesole = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "firesole")).setUnlocalizedName("firesole").setCreativeTab(TinkersDefense.tab));
		itemList.add(item_icesole = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "icesole")).setUnlocalizedName("icesole").setCreativeTab(TinkersDefense.tab));
		itemList.add(item_feathersole = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "feathersole")).setUnlocalizedName("feathersole").setCreativeTab(TinkersDefense.tab));
		itemList.add(item_flippers = new Item().setRegistryName(new ResourceLocation(Reference.MOD_ID, "flippers")).setUnlocalizedName("flippers").setCreativeTab(TinkersDefense.tab));
	}

	public void registerItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry registry = event.getRegistry();
		
		for (Item i : itemList)
		{
			registry.register(i);
		}
	}
}
