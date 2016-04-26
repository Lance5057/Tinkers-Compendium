package lance5057.tDefense.armor.items.light;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.proxy.ClientProxy;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TinkersHauberk extends ArmorCore
{
	public TinkersHauberk()
	{
		super(1, 1);
		this.setUnlocalizedName("tinkershauberk");
		this.maxReduction = 100;
		this.reductionPercent = 0.24f;
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
		return TinkersDefense.partRivet;
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
				return "_hauberk_chain";
			case 1:
				return "_hauberk_chain_broken";
			case 2:
				return "_hauberk_plate";
			case 3:
				return "_hauberk_rivet";
			default:
				return "";
		}
	}

	@Override
	public String getEffectSuffix()
	{
		return "_hauberk_effect";
	}

	@Override
	public String getDefaultFolder()
	{
		return "armor/hauberk";
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
		return "tinkersdefense:textures/armor/TinkersHauberk.png";
	}

	@Override
	public String[] getTraits()
	{
		return new String[] {"armor", "chest", "hauberk", "lightarmor"};
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
	{
		String[] color = new String[10];

		for(int j = 0; j < 10; j++)
			color[j] = Integer.toHexString(itemStack.getItem().getColorFromItemStack(itemStack, j));

		//String[] textures = {this.getIconSuffix(2), this.getIconSuffix(0), this.getIconSuffix(3)};
		ClientProxy.hauberk.SetColors(color, this.getDefaultFolder(), itemStack);
		return ClientProxy.hauberk;
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
	{
		return 6;
	}
}
