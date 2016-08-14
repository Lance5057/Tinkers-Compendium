package lance5057.tDefense.armor.items.light;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.renderers.ArmorRenderer;
import lance5057.tDefense.proxy.ClientProxy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import tconstruct.tools.TinkerTools;
import thaumcraft.api.IGoggles;
import thaumcraft.api.nodes.IRevealer;
import WayofTime.alchemicalWizardry.api.alchemy.energy.IAlchemyGoggles;
import WayofTime.alchemicalWizardry.api.items.interfaces.ILPGauge;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Optional.InterfaceList({@Optional.Interface(modid = "Thaumcraft", iface = "thaumcraft.api.IGoggles", striprefs = true), @Optional.Interface(modid = "Thaumcraft", iface = "thaumcraft.api.nodes.IRevealer", striprefs = true), @Optional.Interface(modid = "AWWayofTime", iface = "WayofTime.alchemicalWizardry.api.items.interfaces.ILPGauge", striprefs = true), @Optional.Interface(modid = "AWWayofTime", iface = "WayofTime.alchemicalWizardry.api.alchemy.energy.IAlchemyGoggles", striprefs = true)})
public class TinkersCoif extends ArmorCore implements IRevealer, IGoggles, ILPGauge, IAlchemyGoggles
{
	public TinkersCoif()
	{
		super(1, 0);
		setUnlocalizedName("tinkerscoif");
		maxReduction = 100;
		reductionPercent = 0.08f;
	}

	@Override
	public Item getHeadItem()
	{
		return TinkersDefense.partChainmaille;
	}

	@Override
	public Item getHandleItem()
	{
		return TinkerTools.toughRod;
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
				return "_coif_chain";
			case 1:
				return "_coif_chain_broken";
			case 2:
				return "_coif_circlet";
			case 3:
				return "_coif_cloth";
			default:
				return "";
		}
	}

	@Override
	public String getEffectSuffix()
	{
		return "_coif_effect";
	}

	@Override
	public String getDefaultFolder()
	{
		return "armor/coif";
	}

	//	@Override
	//	public void onUpdate(ItemStack stack, World world, Entity entity, int par4,
	//			boolean par5) {
	//		super.onUpdate(stack, world, entity, par4, par5);
	//
	//	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return "tinkersdefense:textures/armor/TinkersCoif.png";
	}

	@Override
	public String[] getTraits()
	{
		return new String[] {"armor", "head", "coif", "lightarmor"};
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
	{
		return 2;
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot)
	{
		final ArmorProperties armorp = new ArmorProperties(0, 0.08, 100); //0.04 per half shirt
		//((EntityPlayer)player).addChatComponentMessage(new ChatComponentText(Double.toString(damage)));
		return armorp;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ArmorRenderer getRenderer()
	{
		// TODO Auto-generated method stub
		return ClientProxy.coif;
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
