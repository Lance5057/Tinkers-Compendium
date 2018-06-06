package lance5057.tDefense.holiday;

import java.util.Calendar;

import lance5057.tDefense.Reference;
import lance5057.tDefense.core.library.ModuleBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.conditions.RandomChance;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class HolidayBase extends ModuleBase
{
	public HolidayBase()
	{
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static ItemFood	item_redmintcane;
	public static ItemFood	item_greenmintcane;
	public static ItemFood	item_gingerbread;

	@Override
	public void preInit(FMLPreInitializationEvent e)
	{

	}

	@Override
	public void init(FMLInitializationEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void postInit(FMLPostInitializationEvent e)
	{
		// TODO Auto-generated method stub

	}

	public void registerItems(final RegistryEvent.Register<Item> event)
	{
		final IForgeRegistry registry = event.getRegistry();

		item_redmintcane = new ItemFood(2, 0, false);
		item_greenmintcane = new ItemFood(2, 0, false);
		item_gingerbread = new ItemFood(20, 20, false);

		item_redmintcane.setRegistryName("redmintcane");
		item_greenmintcane.setRegistryName("greenmintcane");
		item_gingerbread.setRegistryName("gingerbread");

		registry.register(item_gingerbread);
		registry.register(item_redmintcane);
		registry.register(item_greenmintcane);
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{
		ModelLoader.setCustomModelResourceLocation(item_gingerbread, 0, new ModelResourceLocation(Reference.MOD_ID + ":gingerbread", "inventory"));
		ModelLoader.setCustomModelResourceLocation(item_redmintcane, 0, new ModelResourceLocation(Reference.MOD_ID + ":redmintcane", "inventory"));
		ModelLoader.setCustomModelResourceLocation(item_greenmintcane, 0, new ModelResourceLocation(Reference.MOD_ID + ":greenmintcane", "inventory"));

	}

	@SubscribeEvent
	public void EditLootTables(LootTableLoadEvent e)
	{
		if (Calendar.getInstance().get(Calendar.MONTH) == Calendar.DECEMBER)
		{
			LootTable t = e.getTable();
			if (e.getName().toString().equals("minecraft:entities/skeleton") || e.getName().toString().equals("minecraft:entities/zombie"))
			{
				LootCondition[] testchance = { new RandomChance(1.01F) };
				LootCondition[] chance = { new RandomChance(0.25F) };
				t.getPool("main").addEntry(new LootEntryItem(item_redmintcane, 5, 1, new LootFunction[0], chance, "redcandy"));
				t.getPool("main").addEntry(new LootEntryItem(item_greenmintcane, 5, 1, new LootFunction[0], chance, "greencandy"));

				LootCondition[] chance2 = { new RandomChance(0.05F) };
				t.getPool("main").addEntry(new LootEntryItem(item_gingerbread, 1, 5, new LootFunction[0], chance2, "gingerbread"));
			}
		}
	}

}
