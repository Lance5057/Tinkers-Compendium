package lance5057.tDefense.armor;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import thaumcraft.api.IGoggles;
import thaumcraft.api.nodes.IRevealer;
import WayofTime.alchemicalWizardry.api.alchemy.energy.IAlchemyGoggles;
import WayofTime.alchemicalWizardry.api.items.interfaces.ILPGauge;
import cpw.mods.fml.common.Optional;

@Optional.InterfaceList({@Optional.Interface(modid = "Thaumcraft", iface = "thaumcraft.api.IGoggles", striprefs = true), @Optional.Interface(modid = "Thaumcraft", iface = "thaumcraft.api.nodes.IRevealer", striprefs = true), @Optional.Interface(modid = "Thaumcraft", iface = "thaumcraft.api.IVisDiscountGear", striprefs = true), @Optional.Interface(modid = "Botania", iface = "vazkii.botania.api.mana.IManaDiscountArmor", striprefs = true), @Optional.Interface(modid = "Botania", iface = "vazkii.botania.api.wand.IWandHUD", striprefs = true), @Optional.Interface(modid = "AWWayofTime", iface = "WayofTime.alchemicalWizardry.api.items.interfaces.ILPGauge", striprefs = true), @Optional.Interface(modid = "AWWayofTime", iface = "WayofTime.alchemicalWizardry.api.alchemy.energy.IAlchemyGoggles", striprefs = true)})
public abstract class TDHelmet extends ArmorCore implements IRevealer, IGoggles, ILPGauge, IAlchemyGoggles
{

	public TDHelmet(int baseProtection, int slot)
	{
		super(baseProtection, slot);
	}

	@Override
	@Optional.Method(modid = "Thaumcraft")
	public boolean showIngamePopups(ItemStack itemstack, EntityLivingBase player)
	{
		return itemstack.getTagCompound().getCompoundTag("InfiTool").getBoolean("Revealing");
	}

	@Override
	@Optional.Method(modid = "Thaumcraft")
	public boolean showNodes(ItemStack itemstack, EntityLivingBase player)
	{
		return itemstack.getTagCompound().getCompoundTag("InfiTool").getBoolean("Revealing");
	}

	@Override
	@Optional.Method(modid = "AWWayofTime")
	public boolean canSeeLPBar(ItemStack stack)
	{
		return stack.getTagCompound().getCompoundTag("InfiTool").getBoolean("Divination");
	}

	@Override
	@Optional.Method(modid = "AWWayofTime")
	public boolean showIngameHUD(World world, ItemStack stack, EntityPlayer player)
	{
		return stack.getTagCompound().getCompoundTag("InfiTool").getBoolean("Divination");
	}
}
