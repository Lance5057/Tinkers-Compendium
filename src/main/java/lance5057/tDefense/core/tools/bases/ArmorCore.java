package lance5057.tDefense.core.tools.bases;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolNBT;

public class ArmorCore extends ToolCore
{
	public ArmorCore(PartMaterialType... requiredComponents)
	{
		super(requiredComponents);
	}

	protected String getHarvestType()
	{
		return null;
	}

	@Override
	public float damagePotential() {
		return 0.0f;
	}

	@Override
	public double attackSpeed() {
		return 0;
	}

	@Override
	public NBTTagCompound buildTag(
			List<slimeknights.tconstruct.library.materials.Material> materials) {
		ToolNBT data = buildDefaultTag(materials);
		return data.get();
	}
}
