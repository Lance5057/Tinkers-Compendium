package lance5057.tDefense.core.tools.bases;

import java.util.List;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import baubles.api.render.IRenderBauble;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolNBT;

public abstract class BaubleTool extends ToolCore implements IBauble, IRenderBauble {
	protected BaubleType type;

	public BaubleTool(BaubleType type, PartMaterialType... requiredComponents) {
		super(requiredComponents);

		this.type = type;
	}

	public BaubleType getBaubleType(ItemStack itemstack) {
		return this.type;
	}
	
	public abstract NBTTagCompound setupTexture(List<Material> materials);

	/**
	 * How long it takes to use or consume an item
	 */
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 72000;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {

	}

	@Override
	public float damagePotential() {
		// TODO Auto-generated method stub
		return 0.1f;
	}

	@Override
	public double attackSpeed() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public NBTTagCompound buildTag(List<slimeknights.tconstruct.library.materials.Material> materials) {
		ToolNBT data = buildDefaultTag(materials);
		return data.get();
	}
}
