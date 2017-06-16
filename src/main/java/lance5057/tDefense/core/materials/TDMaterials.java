package lance5057.tDefense.core.materials;

import static slimeknights.tconstruct.library.utils.HarvestLevels.COBALT;

import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.eventbus.Subscribe;

import lance5057.tDefense.Reference;
import lance5057.tDefense.core.CoreBase;
import lance5057.tDefense.core.materials.traits.TraitAxeLover;
import lance5057.tDefense.core.materials.traits.TraitDulling;
import lance5057.tDefense.core.materials.traits.TraitFirestarter;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.registry.GameRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
//import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.tools.TinkerMaterials;

public class TDMaterials {

	public static final List<Material> materials = Lists.newArrayList();

	String SHIELD = ShieldMaterialStats.TYPE;

	public static final Material aeonsteel = mat("aeonsteel", 0xd200d1);
	public static final Material queensgold = mat("queensgold", 0xdede00);
	public static final Material dogbearium = mat("dogbearium", 0x604933);

	public static FluidColor fluid_aeonsteel;
	
	public static final AbstractTrait axelover = new TraitAxeLover();
	public static final AbstractTrait dulling = new TraitDulling();
	public static final AbstractTrait firestarter = new TraitFirestarter();

	private static Material mat(String name, int color) {
		Material mat = new Material(name, color);
		materials.add(mat);
		return mat;
	}
	
	public void registerMaterials()
	{
		 addMat("aeonsteel", fluid_aeonsteel, 0xd200d1);
	}

	@Subscribe
	public void setupMaterials(FMLInitializationEvent event) {
		Material.UNKNOWN.addStats(new ShieldMaterialStats(35, 33));
		
//		TinkerRegistry.addMaterialStats(Material.UNKNOWN,
//				new ShieldMaterialStats(35, 33));
		
		// TinkerRegistry.addMaterialStats(Material.UNKNOWN,
		// new ShieldMaterialStats(35, 33));
		 TinkerRegistry.addMaterialStats(TinkerMaterials.wood,
		 new ShieldMaterialStats(35, 33));
		 TinkerMaterials.wood.addTrait(axelover, SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.stone,
				new ShieldMaterialStats(120, 33));
		// TinkerRegistry.addMaterialTrait(TinkerMaterials.stone, dulling,
		// SHIELD);
		TinkerMaterials.stone.addTrait(dulling, SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.flint,
				new ShieldMaterialStats(150, 33));
		TinkerRegistry.addMaterialTrait(TinkerMaterials.flint, firestarter, SHIELD);
		
		TinkerRegistry.addMaterialStats(TinkerMaterials.cactus,
				new ShieldMaterialStats(210, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.bone,
				new ShieldMaterialStats(200, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian,
				new ShieldMaterialStats(139, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine,
				new ShieldMaterialStats(430, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.endstone,
				new ShieldMaterialStats(420, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.paper,
				new ShieldMaterialStats(12, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.sponge,
				new ShieldMaterialStats(550, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.firewood,
				new ShieldMaterialStats(550, 33));

		// Slime
		TinkerRegistry.addMaterialStats(TinkerMaterials.slime,
				new ShieldMaterialStats(1000, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime,
				new ShieldMaterialStats(780, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime,
				new ShieldMaterialStats(850, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime,
				new ShieldMaterialStats(600, 33));

		// Nether
		TinkerRegistry.addMaterialStats(TinkerMaterials.netherrack,
				new ShieldMaterialStats(270, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.cobalt,
				new ShieldMaterialStats(780, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.ardite,
				new ShieldMaterialStats(990, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn,
				new ShieldMaterialStats(820, 33));

		// Metals
		TinkerRegistry.addMaterialStats(TinkerMaterials.iron,
				new ShieldMaterialStats(204, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.pigiron,
				new ShieldMaterialStats(380, 33));

		// Mod Integration
		TinkerRegistry.addMaterialStats(TinkerMaterials.copper,
				new ShieldMaterialStats(210, 33));

		TinkerRegistry.addMaterialStats(TinkerMaterials.bronze,
				new ShieldMaterialStats(430, 33));

		TinkerRegistry.addMaterialStats(TinkerMaterials.lead,
				new ShieldMaterialStats(334, 33));

		TinkerRegistry.addMaterialStats(TinkerMaterials.silver,
				new ShieldMaterialStats(250, 33));

		TinkerRegistry.addMaterialStats(TinkerMaterials.electrum,
				new ShieldMaterialStats(50, 33));

		TinkerRegistry.addMaterialStats(TinkerMaterials.steel,
				new ShieldMaterialStats(540, 33));

		TinkerRegistry.addMaterialStats(aeonsteel, new HeadMaterialStats(1000,
				4.0f, 3.00f, COBALT), new HandleMaterialStats(1.10f, 200),
				new ExtraMaterialStats(500));
		// iron.addItemIngot("ingotIron");
		// iron.setRepresentativeItem(Items.field_151042_j);
		// iron.addTrait(magnetic2, HEAD);
		// iron.addTrait(magnetic);

		// TinkerMaterials.stone.addTrait(TinkerMaterials.cheapskate,
		// ShieldMaterialStats.TYPE);
		
		//TAIGA TEST
		Collection<Material> mats = TinkerRegistry.getAllMaterials();
		for (Material i : mats) {
			if(!i.hasStats(SHIELD))
			{
				if(i.hasStats(MaterialTypes.HEAD))
				{
					int dur = ((HeadMaterialStats)i.getStats(MaterialTypes.HEAD)).durability;
					i.addStats(new ShieldMaterialStats(dur, 33));
				}
			}
		}
	}
	
	void addMat(String name, FluidColor myFluid, int color)
	{
		// create fluid.
		// You don't need to add textures for the fluid, just create a Fluid Class that overwrites getColor
		// and pass the following as still and flowing ResourceLocation:
		// still:  "tconstruct:blocks/fluids/molten_metal"
		// flowing: "tconstruct:blocks/fluids/molten_metal_flow"
		myFluid = new FluidColor(name, new ResourceLocation("tconstruct:blocks/fluids/molten_metal"), new ResourceLocation("tconstruct:blocks/fluids/molten_metal_flow"), color);
		//myFluid.setColor(color);
		FluidRegistry.registerFluid(myFluid); // fluid has to be registered
		FluidRegistry.addBucketForFluid(myFluid); // add a bucket for the fluid

		// add block for fluid (if desired)
		ResourceLocation rc = new ResourceLocation(Reference.MOD_ID, "fluid_aeonsteel");
		Block fluidBlock = new BlockFluidClassic(myFluid, net.minecraft.block.material.Material.LAVA).setRegistryName(rc).setUnlocalizedName(rc.toString()).setCreativeTab(CoreBase.tab);
		// <register block regularly>
		GameRegistry.register(new ItemBlock(fluidBlock), fluidBlock.getRegistryName());

		// create NBT for the IMC
		NBTTagCompound tag = new NBTTagCompound();
		tag.setString("fluid", myFluid.getName()); // name of the fluid
		tag.setString("ore", name); // ore-suffix: ingotFoo, blockFoo, oreFoo,...
		tag.setBoolean("toolforge", true); // if set to true, blockFoo can be used to build a toolforge
		//tag.setTag("alloy", alloysTagList); // you can also send an alloy with the registration (see below)

		// send the NBT to TCon
		FMLInterModComms.sendMessage("tconstruct", "integrateSmeltery", tag);
	}
}
