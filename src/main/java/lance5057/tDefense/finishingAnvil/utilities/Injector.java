package lance5057.tDefense.finishingAnvil.utilities;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lance5057.tDefense.TinkersDefense;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.PatternBuilder;
import tconstruct.library.crafting.PatternBuilder.MaterialSet;
import tconstruct.library.tools.ToolCore;

public class Injector extends ToolCore
{
	List<String>						heads		= new ArrayList<String>();
	List<String>						accessories	= new ArrayList<String>();
	List<String>						handles		= new ArrayList<String>();
	List<String>						extras		= new ArrayList<String>();

	public HashMap<String, ToolCoreTip>	tools		= new HashMap<String, ToolCoreTip>();

	public Injector(int baseDamage)
	{
		super(0);
	}

	protected void loadHeads(IIconRegister iconRegister) throws IOException, URISyntaxException
	{

		//		final URL jarFile =
		//				TinkersDefense.class.getResource("assets/tinkersdefense/textures/items/");

		final int toolLength = TConstructRegistry.tools.size();
		for(int i = 0; i < toolLength; i++)
		{
			final String toolName = TConstructRegistry.tools.get(i).getUnlocalizedName().toLowerCase().substring(TConstructRegistry.tools.get(i).getUnlocalizedName().lastIndexOf('.') + 1, TConstructRegistry.tools.get(i).getUnlocalizedName().length());
			final String path = "/assets/tinkersdefense/textures/items/" + toolName + "/";

			final ResourceLocation loc = new ResourceLocation(
					"tinkersdefense:textures/items/");
			//final InputStream in = Minecraft.getMinecraft().getResourceManager().getResource(loc).getInputStream();
			//final List<String> filenames = new ArrayList<String>();
			//final File files = new File(Minecraft.getMinecraft().mcDataDir.getPath() + "/mods/tinkersdefense-1.3.6.jar");

			final Path zipfile = Paths.get(Minecraft.getMinecraft().mcDataDir.getPath() + "/mods/tinkersdefense-1.3.6.jar");
			final FileSystem fs = FileSystems.newFileSystem(zipfile, Minecraft.class.getClassLoader());

			final Path root = fs.getPath(path);
			//final Iterable<FileStore> files = fs.getFileStores();
			final FileGetter fileget = new FileGetter();

			Files.walkFileTree(root, fileget);

			//IDE
			//final File files = new File(url.toURI());

			if(TinkersDefense.config.debug)
			{
				for(final String file : fileget.filenames)
				{
					System.out.println(file);
				}
			}
			setup(TConstructRegistry.tools.get(i), toolName, fileget.filenames, iconRegister);
		}
	}

	//}
	//}

	private void setup(ToolCore tool, String name, List<String> filenames, IIconRegister iconRegister)
	{
		{
			heads.clear();
			accessories.clear();
			handles.clear();
			extras.clear();

			headStrings.clear();
			headIcons.clear();
			accessoryStrings.clear();
			accessoryIcons.clear();
			handleStrings.clear();
			handleIcons.clear();
			extraStrings.clear();
			extraIcons.clear();

			final IIcon origHead = tool.headIcons.get(-1);
			final IIcon origAccessory = tool.accessoryIcons.get(-1);
			final IIcon origHandle = tool.handleIcons.get(-1);
			final IIcon origExtra = tool.extraIcons.get(-1);

			final ToolCoreTip tt = new ToolCoreTip();

			tt.accessory = "Accessory";
			tt.head = "Head";
			tt.handle = "Handle";
			tt.extra = "Extra";

			tt.headTT.add("Standard");
			tt.accessoryTT.add("Standard");
			tt.handleTT.add("Standard");
			tt.extraTT.add("Standard");

			for(int i = 0; i < filenames.size(); i++)
			{
				final String filename = filenames.get(i);

				if(filename.contains("head"))
				{
					String formatted = filename.substring(0, filename.indexOf(".png"));
					heads.add(formatted);
					formatted = formatted.substring(1, formatted.length());
					formatted = formatted.replace('_', ' ');
					tt.headTT.add(formatted);
				}

				if(filename.contains("accessory"))
				{
					String formatted = filename.substring(0, filename.indexOf(".png"));
					accessories.add(formatted);
					formatted = formatted.substring(1, formatted.length());
					formatted.replace("_", " ");
					tt.accessoryTT.add(formatted);
				}

				if(filename.contains("handle"))
				{
					String formatted = filename.substring(0, filename.indexOf(".png"));
					handles.add(formatted);
					formatted = formatted.substring(1, formatted.length());
					formatted.replace("_", " ");
					tt.handleTT.add(formatted);
				}

				if(filename.contains("extra"))
				{
					String formatted = filename.substring(0, filename.indexOf(".png"));
					extras.add(formatted);
					formatted = formatted.substring(1, formatted.length());
					formatted.replace("_", " ");
					tt.extraTT.add(formatted);
				}
			}
			//			tt.headTT.add("Magic Backhead");
			//			tt.headTT.add("Scythe Backhead");
			//
			//			extras.add("_magic_extra");
			//			extras.add("_scythe_extra");
			//			extras.add("_halbard_extra");
			//			extras.add("_ornate_extra");
			//
			//			tt.extraTT.add("Halbard Head");
			//			tt.extraTT.add("Magic Head");
			//			tt.extraTT.add("Scythe Head");
			//			tt.extraTT.add("Ornate Head");
			//
			//			accessories.add("_magic_accessory");
			//			accessories.add("_halbard_accessory");
			//			accessories.add("_knob_accessory");

			//Metallurgy 5

			tools.put(name, tt);

			//			if(tool.getToolName().equals("Battleaxe"))
			//			{
			//				BattleAxe();
			//			}
			//			if(tool.getToolName().equals("Arrow"))
			//			{
			//				Arrow();
			//			}
			//			if(tool.getToolName().equals("Broadsword"))
			//			{
			//				Broadsword();
			//			}
			//			if(tool.getToolName().equals("Battlesign"))
			//			{
			//				Battlesign();
			//			}
			//			if(tool.getToolName().equals("Hatchet"))
			//			{
			//				Axe();
			//			}
			//			if(tool.getToolName().equals("Mattock"))
			//			{
			//				Mattock();
			//			}
			//			if(tool.getToolName().equals("Longbow"))
			//			{
			//				Longbow();
			//			}
			//			if(tool.getToolName().equals("HeaterShield"))
			//			{
			//				HeaterShield();
			//			}
			setupIcons(tool, iconRegister, heads, headStrings, headIcons);
			setupIcons(tool, iconRegister, accessories, accessoryStrings, accessoryIcons);
			setupIcons(tool, iconRegister, handles, handleStrings, handleIcons);
			setupIcons(tool, iconRegister, extras, extraStrings, extraIcons);

			tool.headStrings.putAll(headStrings);
			tool.headIcons.putAll(headIcons);

			tool.accessoryStrings.putAll(accessoryStrings);
			tool.accessoryIcons.putAll(accessoryIcons);

			tool.handleStrings.putAll(handleStrings);
			tool.handleIcons.putAll(handleIcons);

			tool.extraStrings.putAll(extraStrings);
			tool.extraIcons.putAll(extraIcons);

			tool.headIcons.put(-1, origHead);
			tool.accessoryIcons.put(-1, origAccessory);
			tool.handleIcons.put(-1, origHandle);
			tool.extraIcons.put(-1, origExtra);
		}
	}

	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		try
		{
			loadHeads(iconRegister);
		}
		catch(final IOException e)
		{
			System.out.print("No Finishing Anvil for you");
		}
		catch(final URISyntaxException e)
		{
			System.out.print("No Finishing Anvil for you");
		}
	}

	@Override
	public String getDefaultTexturePath()
	{
		return "tinkersdefense:" + getDefaultFolder();
	}

	@Override
	public Item getAccessoryItem()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDefaultFolder()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEffectSuffix()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getHeadItem()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIconSuffix(int arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getTraits()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void setupIcons(ToolCore tool, IIconRegister iconRegister, List<String> newList, HashMap<Integer, String> toolStrings, HashMap<Integer, IIcon> toolIcons)
	{
		for(int i = 0; i < newList.size(); i++)
		{
			final PatternBuilder pb = PatternBuilder.instance;
			for(final Map.Entry<String, MaterialSet> entry : pb.materialSets.entrySet())
			{
				String icon = "tinkersdefense:";
				icon += tool.getDefaultFolder() + "/" + newList.get(i);
				//toolIcons[i] = icon;
				toolStrings.put(entry.getValue().materialID + (TinkersDefense.config.MaterialIndex * (i + 1)), icon);
			}
		}

		addIcons(toolStrings, toolIcons, iconRegister, null, false);
	}

	void BattleAxe()
	{
		final ToolCoreTip tt = new ToolCoreTip();

		tt.accessory = "Front Head";
		tt.head = "Back Head";
		tt.handle = "Handle";
		tt.extra = "Binding";

		heads.add("_halbard_head");
		heads.add("_magic_head");
		heads.add("_scythe_head");

		tt.headTT.add("Halbard Backhead");
		tt.headTT.add("Magic Backhead");
		tt.headTT.add("Scythe Backhead");

		extras.add("_magic_extra");
		extras.add("_scythe_extra");
		extras.add("_halbard_extra");
		extras.add("_ornate_extra");

		tt.extraTT.add("Halbard Head");
		tt.extraTT.add("Magic Head");
		tt.extraTT.add("Scythe Head");
		tt.extraTT.add("Ornate Head");

		accessories.add("_magic_accessory");
		accessories.add("_halbard_accessory");
		accessories.add("_knob_accessory");

		//Metallurgy 5

		tools.put("Battleaxe", tt);
	}

	void Axe()
	{
		final ToolCoreTip tt = new ToolCoreTip();

		tt.head = "Head";
		tt.handle = "Handle";

		heads.add("_thin_head");
		tt.headTT.add("Thin Head");
		heads.add("_minecraft_head");
		tt.headTT.add("Vanilla Head");
		heads.add("_m5zinc_head");
		tt.headTT.add("Metallurgy 5 Zinc Head");
		heads.add("_m5whitegold_head");
		tt.headTT.add("Metallurgy 5 WhiteGold Head");
		heads.add("_m5tin_head");
		tt.headTT.add("Metallurgy 5 Tin Head");
		heads.add("_m5silver_head");
		tt.headTT.add("Metallurgy 5 Silver Head");
		heads.add("_m5rosegold_head");
		tt.headTT.add("Metallurgy 5 RoseGold Head");
		heads.add("_m5platinum_head");
		tt.headTT.add("Metallurgy 5 Platinum Head");
		heads.add("_m5pewter_head");
		tt.headTT.add("Metallurgy 5 Pewter Head");
		heads.add("_m5nickelsteel_head");
		tt.headTT.add("Metallurgy 5 NickelSteel Head");
		heads.add("_m5nickel_head");
		tt.headTT.add("Metallurgy 5 Nickel Head");
		heads.add("_m5monel_head");
		tt.headTT.add("Metallurgy 5 Monel Head");
		heads.add("_m5molybdochalkos_head");
		tt.headTT.add("Metallurgy 5 Molybdochalkos Head");
		heads.add("_m5manganesesteel_head");
		tt.headTT.add("Metallurgy 5 ManganeseSteel Head");
		heads.add("_m5manganese_head");
		tt.headTT.add("Metallurgy 5 Manganese Head");
		heads.add("_m5lead_head");
		tt.headTT.add("Metallurgy 5 Lead Head");
		heads.add("_m5iron_head");
		tt.headTT.add("Metallurgy 5 Iron Head");
		heads.add("_m5ignatius_head");
		tt.headTT.add("Metallurgy 5 Ignatius Head");
		heads.add("_m5hepatizon_head");
		tt.headTT.add("Metallurgy 5 Hepatizon Head");
		heads.add("_m5heavysteel_head");
		tt.headTT.add("Metallurgy 5 HeavySteel Head");
		heads.add("_m5gold_head");
		tt.headTT.add("Metallurgy 5 Gold Head");
		heads.add("_m5fungalsteel_head");
		tt.headTT.add("Metallurgy 5 FungalSteel Head");
		heads.add("_m5electrum_head");
		tt.headTT.add("Metallurgy 5 Electrum Head");
		heads.add("_m5diamond_head");
		tt.headTT.add("Metallurgy 5 Diamond Head");
		heads.add("_m5damascussteel_head");
		tt.headTT.add("Metallurgy 5 DamascusSteel Head");
		heads.add("_m5cupronickel_head");
		tt.headTT.add("Metallurgy 5 Cupronickel Head");
		heads.add("_m5crowngold_head");
		tt.headTT.add("Metallurgy 5 CrownGold Head");
		heads.add("_m5copper_head");
		tt.headTT.add("Metallurgy 5 Copper Head");
		heads.add("_m5bronze_head");
		tt.headTT.add("Metallurgy 5 Bronze Head");
		heads.add("_m5brass_head");
		tt.headTT.add("Metallurgy 5 Brass Head");
		heads.add("_m5angmallen_head");
		tt.headTT.add("Metallurgy 5 Angmallen Head");
		heads.add("_broad_head");
		tt.headTT.add("Broad Head");
		heads.add("_bearded_head");
		tt.headTT.add("Bearded Head");

		handles.add("_long_handle");
		tt.handleTT.add("Long Handle");
		handles.add("_ornate_handle");
		tt.handleTT.add("Ornate Handle");
		handles.add("_longornate_handle");
		tt.handleTT.add("Long Ornate Handle");
		handles.add("_offset_handle");
		tt.handleTT.add("Offset Handle");
		handles.add("_offsetlong_handle");
		tt.handleTT.add("Offset Long Handle");
		handles.add("_offsetornate_handle");
		tt.handleTT.add("Offset Ornate Handle");
		handles.add("_offsetlongornate_handle");
		tt.handleTT.add("Offset Long Ornate Handle");

		tools.put("Hatchet", tt);
	}

	void Battlesign()
	{
		handles.add("_small_handle");
		handles.add("_smalllong_handle");

		heads.add("_arrow_head");
		heads.add("_caution_head");
		heads.add("_noentry_head");
		heads.add("_railroad_head");
		heads.add("_stop_head");
		heads.add("_X_head");
	}

	void Arrow()
	{
		heads.add("_broad_head");
		heads.add("_elven_head");
		heads.add("_horned_head");
		heads.add("_trident_head");
		heads.add("_winged_head");

		handles.add("_bulbous_handle");
		handles.add("_natural_handle");

		accessories.add("_matted_accessory");
		accessories.add("_magic_accessory");
		accessories.add("_pixie_accessory");
		accessories.add("_small_accessory");
	}

	void Broadsword()
	{
		final ToolCoreTip tt = new ToolCoreTip();

		tt.head = "Blade";
		tt.accessory = "Guard";
		tt.handle = "Handle";

		tt.headTT.add("Standard Blade");
		heads.add("_tapered_head");
		tt.headTT.add("Tapered Blade");
		heads.add("_dull_head");
		tt.headTT.add("Dull Blade");
		heads.add("_glass_head");
		tt.headTT.add("Glass Blade");
		heads.add("_plumed_head");
		tt.headTT.add("Plumed Blade");
		heads.add("_spiked_head");
		tt.headTT.add("Spiked Blade");
		heads.add("_widebase_head");
		tt.headTT.add("Widebase Blade");
		heads.add("_mace_head");
		tt.headTT.add("Mace \"Blade\"");
		heads.add("_elusive_head");
		tt.headTT.add("Elusive Blade");
		heads.add("_repulsive_head");
		tt.headTT.add("Repulsive Blade");
		heads.add("_falchion_head");
		tt.headTT.add("Falchion Blade");
		heads.add("_big_head");
		tt.headTT.add("Big Blade");
		heads.add("_nofuller_head");
		tt.headTT.add("No Fuller Blade");
		heads.add("_segmented_head");
		tt.headTT.add("Segmented Blade");
		heads.add("_hourglass_head");
		tt.headTT.add("Hourglass Blade");
		heads.add("_flat_head");
		tt.headTT.add("Flat Tip Blade");

		heads.add("_m5zinc_head");
		tt.headTT.add("Metallurgy 5 Zinc Blade");
		heads.add("_m5whitegold_head");
		tt.headTT.add("Metallurgy 5 WhiteGold Blade");
		heads.add("_m5tin_head");
		tt.headTT.add("Metallurgy 5 Tin Blade");
		heads.add("_m5silver_head");
		tt.headTT.add("Metallurgy 5 Silver Blade");
		heads.add("_m5rosegold_head");
		tt.headTT.add("Metallurgy 5 RoseGold Blade");
		heads.add("_m5platinum_head");
		tt.headTT.add("Metallurgy 5 Platinum Blade");
		heads.add("_m5pewter_head");
		tt.headTT.add("Metallurgy 5 Pewter Blade");
		heads.add("_m5nickelsteel_head");
		tt.headTT.add("Metallurgy 5 NickelSteel Blade");
		heads.add("_m5nickel_head");
		tt.headTT.add("Metallurgy 5 Nickel Blade");
		heads.add("_m5monel_head");
		tt.headTT.add("Metallurgy 5 Monel Blade");
		heads.add("_m5molybdochalkos_head");
		tt.headTT.add("Metallurgy 5 Molybdochalkos Blade");
		heads.add("_m5manganesesteel_head");
		tt.headTT.add("Metallurgy 5 ManganeseSteel Blade");
		heads.add("_m5manganese_head");
		tt.headTT.add("Metallurgy 5 Manganese Blade");
		heads.add("_m5lead_head");
		tt.headTT.add("Metallurgy 5 Lead Blade");
		heads.add("_m5iron_head");
		tt.headTT.add("Metallurgy 5 Iron Blade");
		heads.add("_m5ignatius_head");
		tt.headTT.add("Metallurgy 5 Ignatius Blade");
		heads.add("_m5hepatizon_head");
		tt.headTT.add("Metallurgy 5 Hepatizon Blade");
		heads.add("_m5heavysteel_head");
		tt.headTT.add("Metallurgy 5 HeavySteel Blade");
		heads.add("_m5gold_head");
		tt.headTT.add("Metallurgy 5 Gold Blade");
		heads.add("_m5fungalsteel_head");
		tt.headTT.add("Metallurgy 5 FungalSteel Blade");
		heads.add("_m5electrum_head");
		tt.headTT.add("Metallurgy 5 Electrum Blade");
		heads.add("_m5diamond_head");
		tt.headTT.add("Metallurgy 5 Diamond Blade");
		heads.add("_m5damascussteel_head");
		tt.headTT.add("Metallurgy 5 DamascusSteel Blade");
		heads.add("_m5cupronickel_head");
		tt.headTT.add("Metallurgy 5 Cupronickel Blade");
		heads.add("_m5crowngold_head");
		tt.headTT.add("Metallurgy 5 CrownGold Blade");
		heads.add("_m5copper_head");
		tt.headTT.add("Metallurgy 5 Copper Blade");
		heads.add("_m5bronze_head");
		tt.headTT.add("Metallurgy 5 Bronze Blade");
		heads.add("_m5brass_head");
		tt.headTT.add("Metallurgy 5 Brass Blade");
		heads.add("_m5angmallen_head");
		tt.headTT.add("Metallurgy 5 Angmallen Blade");

		accessories.add("_basket_accessory");
		accessories.add("_curved_accessory");
		accessories.add("_elusive_accessory");
		accessories.add("_extended_accessory");
		accessories.add("_legendary_accessory");
		accessories.add("_no_accessory");
		accessories.add("_basket_accessory");
		accessories.add("_repulsive_accessory");
		accessories.add("_square_accessory");
		accessories.add("_straight_accessory");
		accessories.add("_straight_accessory");
		accessories.add("_bulbous_accessory");
		accessories.add("_sun_accessory");
		accessories.add("_lamenting_accessory");
		accessories.add("_pixie_accessory");
		accessories.add("_forked_accessory");

		handles.add("_ornate_handle");
		handles.add("_thick_handle");
		handles.add("_short_handle");

		tools.put("Broadsword", tt);
	}

	void Mattock()
	{
		heads.add("_head_bearded");
		heads.add("_head_magic");
		heads.add("_head_scythe");
		heads.add("head_wide");

		accessories.add("_back_straight");

		heads.add("_m5copper_head");
		accessories.add("_m5copper_accessory");
	}

	void Longbow()
	{
		heads.add("_m5copper_head");
		accessories.add("_m5copper_accessory");
		handles.add("_m5copper_handle");
		extras.add("_m5copper_extra");
	}

	void HeaterShield()
	{
		final ToolCoreTip tt = new ToolCoreTip();

		tt.head = "Plate";
		tt.accessory = "Emblem";
		tt.handle = "Edge";
		tt.extra = "Binding";

		tt.headTT.add("Standard Plate");
		heads.add("_glass_plate");
		tt.headTT.add("Glass Plate");

		tt.accessoryTT.add("Standard Emblem");
		accessories.add("_test_face");
		tt.accessoryTT.add("Villager Emblem");
		accessories.add("_skeleton_face");
		tt.accessoryTT.add("Skeleton Emblem");
		accessories.add("_ender_face");
		tt.accessoryTT.add("Ender Emblem");
		accessories.add("_creeper_face");
		tt.accessoryTT.add("Creeper Emblem");
		accessories.add("_square_face");
		tt.accessoryTT.add("Block Emblem");
		accessories.add("_angel_face");
		tt.accessoryTT.add("Angel Emblem");
		accessories.add("_fancy_face");
		tt.accessoryTT.add("Fancy Emblem");
		accessories.add("_cross_face");
		tt.accessoryTT.add("Cross Emblem");
		accessories.add("_stripe_face");
		tt.accessoryTT.add("Vertical Stripe Emblem");
		accessories.add("_bar_face");
		tt.accessoryTT.add("Vertical Bars Emblem");
		accessories.add("_horbar_face");
		tt.accessoryTT.add("Horizontal Bars Emblem");
		accessories.add("_horstripe_face");
		tt.accessoryTT.add("Horizontal Stripe Emblem");
		accessories.add("_triangle_face");
		tt.accessoryTT.add("Triangles Emblem");
		accessories.add("_arrow_face");
		tt.accessoryTT.add("Arrow Emblem");
		accessories.add("_checker_face");
		tt.accessoryTT.add("Checkered Emblem");

		tt.handleTT.add("Standard Edge");
		handles.add("_demon_edge");
		tt.handleTT.add("Demonic Edge");
		handles.add("_squared_edge");
		tt.handleTT.add("Squared Edge");
		handles.add("_heart_edge");
		tt.handleTT.add("Heart Edge");

		tt.extraTT.add("Standard Binding");
		extras.add("_spider_binding");
		tt.extraTT.add("Spider Binding");
		extras.add("_love_binding");
		tt.extraTT.add("Heart Binding");
		extras.add("_enforced_binding");
		tt.extraTT.add("Enforced Binding");
		extras.add("_slime_binding");
		tt.extraTT.add("Slimey Binding");
		extras.add("_small_binding");
		tt.extraTT.add("Small Binding");
		extras.add("_demon_binding");
		tt.extraTT.add("Demon Binding");
		extras.add("_pig_binding");
		tt.extraTT.add("Pig Binding");
		extras.add("_wolf_binding");
		tt.extraTT.add("Wolf Binding");
		extras.add("_wide_binding");
		tt.extraTT.add("Wide Binding");
		extras.add("_reinforced_binding");
		tt.extraTT.add("Strong Binding");
		extras.add("_skull_binding");
		tt.extraTT.add("Skull Binding");
		extras.add("_hell_binding");
		tt.extraTT.add("Hell Binding");
		extras.add("_queen_binding");
		tt.extraTT.add("Queen's Binding");
		extras.add("_tri_binding");
		tt.extraTT.add("Tri Binding");
		extras.add("_fancy_binding");
		tt.extraTT.add("Fancy Binding");

		tools.put("Heater Shield", tt);
	}

}
