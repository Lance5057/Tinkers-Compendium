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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TinkersChausses extends ArmorCore
{
	public TinkersChausses()
	{
		super(1, 2);
		setUnlocalizedName("tinkerschausses");
		maxReduction = 100;
		reductionPercent = 0.2f;
	}

	@Override
	public Item getHeadItem()
	{
		return TinkersDefense.partChainmaille;
	}

	@Override
	public Item getHandleItem()
	{
		return TinkersDefense.partArmorplate;
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
				return "_chausses_chain";
			case 1:
				return "_chausses_chain_broken";
			case 2:
				return "_chausses_plate";
			case 3:
				return "_chausses_cloth";
			default:
				return "";
		}
	}

	@Override
	public String getEffectSuffix()
	{
		return "_chausses_effect";
	}

	@Override
	public String getDefaultFolder()
	{
		return "armor/chausses";
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
		return "tinkersdefense:textures/armor/TinkersChausses.png";
	}

	@Override
	public String[] getTraits()
	{
		return new String[] {"armor", "pants", "chausses", "lightarmor"};
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
	{
		return 5;
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot)
	{
		final ArmorProperties armorp = new ArmorProperties(0, 0.2, 100); //0.04 per half shirt
		//((EntityPlayer)player).addChatComponentMessage(new ChatComponentText(Double.toString(damage)));
		return armorp;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ArmorRenderer getRenderer()
	{
		return ClientProxy.chausses;
	}
}
