package lance5057.tDefense.core.tools.basic;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.library.capabilities.handlers.BackpackHandler;
import lance5057.tDefense.core.materials.CompendiumMaterials;
import lance5057.tDefense.core.materials.stats.BackpackMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolNBT;
import vazkii.botania.common.Botania;
import vazkii.botania.common.lib.LibGuiIDs;

public class Backpack extends ToolCore {

	public static final float DURABILITY_MODIFIER = 1.5f;

	public Backpack() {
		super(new PartMaterialType(TDParts.fabric, BackpackMaterialStats.TYPE),
				new PartMaterialType(TDParts.fabric, BackpackMaterialStats.TYPE), PartMaterialType.extra(TDParts.clasp),
				new PartMaterialType(TDParts.fabric, BackpackMaterialStats.TYPE));

		setUnlocalizedName("backpack");
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
		if (this.isInCreativeTab(tab)) {
			addDefaultSubItems(subItems, CompendiumMaterials.white.mat, CompendiumMaterials.white.mat, null,
					CompendiumMaterials.white.mat);
		}
	}

	@Override
	public ICapabilityProvider initCapabilities(@Nonnull ItemStack stack, @Nullable NBTTagCompound nbt) {
		return new BackpackHandler();
	}

	@Override
	public float damagePotential() {
		return 0.0f;
	}

	@Override
	public double attackSpeed() {
		return 5f;
	}

	@Override
	public NBTTagCompound buildTag(List<Material> materials) {
		ToolNBT data = buildDefaultTag(materials);
		data.durability *= DURABILITY_MODIFIER;
		return data.get();
	}

	@Nonnull
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
		player.openGui(TinkersCompendium.instance, CommonProxy.BackpackID, world, hand == EnumHand.OFF_HAND ? 1 : 0, 0,
				0);
		return ActionResult.newResult(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}

}
