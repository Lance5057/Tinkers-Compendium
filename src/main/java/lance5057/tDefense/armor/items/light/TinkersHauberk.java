package lance5057.tDefense.armor.items.light;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.renderers.ArmorRenderer;
import lance5057.tDefense.proxy.ClientProxy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tconstruct.tools.TinkerTools;

public class TinkersHauberk extends ArmorCore
{
	public TinkersHauberk()
	{
		super(1, 1);
		setUnlocalizedName("tinkershauberk");
		maxReduction = 100;
		reductionPercent = 0.24f;
	}

	@Override
	public Item getHeadItem()
	{
		return TinkersDefense.partChainmaille;
	}

	@Override
	public Item getHandleItem()
	{
		return TinkerTools.largePlate;
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
				return "_hauberk_chain";
			case 1:
				return "_hauberk_chain_broken";
			case 2:
				return "_hauberk_plate";
			case 3:
				return "_hauberk_cloth";
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
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
	{
		return 6;
	}

	@Override
	public ArmorRenderer getRenderer()
	{
		return ClientProxy.hauberk;
	}
}
