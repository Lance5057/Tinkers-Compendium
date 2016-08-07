package lance5057.tDefense.armor.items.cloth;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.renderers.ArmorRenderer;
import lance5057.tDefense.proxy.ClientProxy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tconstruct.tools.TinkerTools;
import thaumcraft.api.IGoggles;
import thaumcraft.api.IVisDiscountGear;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.nodes.IRevealer;
import vazkii.botania.api.mana.IManaDiscountArmor;
import WayofTime.alchemicalWizardry.api.alchemy.energy.IAlchemyGoggles;
import WayofTime.alchemicalWizardry.api.items.interfaces.ILPGauge;
import cpw.mods.fml.common.Optional;

@Optional.InterfaceList({@Optional.Interface(modid = "Thaumcraft", iface = "thaumcraft.api.IGoggles", striprefs = true), @Optional.Interface(modid = "Thaumcraft", iface = "thaumcraft.api.nodes.IRevealer", striprefs = true), @Optional.Interface(modid = "AWWayofTime", iface = "WayofTime.alchemicalWizardry.api.items.interfaces.ILPGauge", striprefs = true), @Optional.Interface(modid = "AWWayofTime", iface = "WayofTime.alchemicalWizardry.api.alchemy.energy.IAlchemyGoggles", striprefs = true), @Optional.Interface(modid = "Thaumcraft", iface = "thaumcraft.api.IVisDiscountGear", striprefs = true), @Optional.Interface(modid = "Botania", iface = "vazkii.botania.api.mana.IManaDiscountArmor", striprefs = true)})
public class TinkersHood extends ArmorCore implements IRevealer, IGoggles, ILPGauge, IAlchemyGoggles, IVisDiscountGear, IManaDiscountArmor
{
	public TinkersHood()
	{
		super(0, 0);
		setUnlocalizedName("tinkershood");
	}

	@Override
	public Item getHeadItem()
	{
		return TinkersDefense.partCloth;
	}

	@Override
	public Item getHandleItem()
	{
		return TinkerTools.toolRod;
	}

	@Override
	public Item getAccessoryItem()
	{
		return TinkersDefense.partCloth;
	}

	@Override
	public int durabilityTypeAccessory()
	{
		return 1;
	}

	@Override
	public float getRepairCost()
	{
		return 1.0f;
	}

	@Override
	public float getDurabilityModifier()
	{
		return 1f;
	}

	@Override
	public float getDamageModifier()
	{
		return 1f;
	}

	@Override
	public int getPartAmount()
	{
		return 3;
	}

	@Override
	public String getIconSuffix(int partType)
	{
		switch(partType)
		{
			case 0:
				return "_hood_cloth";
			case 1:
				return "_hood_cloth_broken";
			case 2:
				return "_hood_metal";
			case 3:
				return "_hood_trim";
			default:
				return "";
		}
	}

	@Override
	public String getEffectSuffix()
	{
		return "_hood_effect";
	}

	@Override
	public String getDefaultFolder()
	{
		return "armor/hood";
	}

	//	@Override
	//	public void onUpdate(ItemStack stack, World world, Entity entity, int par4,
	//			boolean par5) {
	//		super.onUpdate(stack, world, entity, par4, par5);
	//
	//	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return "tinkersdefense:textures/armor/TinkersHood.png";
	}

	@Override
	public String[] getTraits()
	{
		return new String[] {"armor", "head", "hood", "cloth"};
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
	{
		return 0;
	}

	@Override
	@Optional.Method(modid = "Thaumcraft")
	public int getVisDiscount(ItemStack stack, EntityPlayer player, Aspect aspect)
	{
		return stack.getTagCompound().getCompoundTag("InfiTool").getInteger("VisEmbroidery");
	}

	@Override
	public ArmorRenderer getRenderer()
	{
		return ClientProxy.hood;
	}

	@Override
	public float getDiscount(ItemStack stack, int arg1, EntityPlayer arg2)
	{
		final float i = stack.getTagCompound().getCompoundTag("InfiTool").getInteger("ManaEmbroidery") / 100f;
		return i;
	}

	@Optional.Method(modid = "Thaumcraft")
	@Override
	public boolean showIngamePopups(ItemStack itemstack, EntityLivingBase player)
	{
		return itemstack.getTagCompound().getCompoundTag("InfiTool").getBoolean("Revealing");
	}

	@Optional.Method(modid = "Thaumcraft")
	@Override
	public boolean showNodes(ItemStack itemstack, EntityLivingBase player)
	{
		return itemstack.getTagCompound().getCompoundTag("InfiTool").getBoolean("Revealing");
	}

	@Optional.Method(modid = "AWWayofTime")
	@Override
	public boolean canSeeLPBar(ItemStack stack)
	{
		return stack.getTagCompound().getCompoundTag("InfiTool").getBoolean("Divination");
	}

	@Optional.Method(modid = "AWWayofTime")
	@Override
	public boolean showIngameHUD(World world, ItemStack stack, EntityPlayer player)
	{
		return stack.getTagCompound().getCompoundTag("InfiTool").getBoolean("Divination");
	}
}
