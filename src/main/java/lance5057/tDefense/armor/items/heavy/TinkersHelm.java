package lance5057.tDefense.armor.items.heavy;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.TDHelmet;
import lance5057.tDefense.armor.renderers.ArmorRenderer;
import lance5057.tDefense.proxy.ClientProxy;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tconstruct.tools.TinkerTools;

public class TinkersHelm extends TDHelmet
{
	public TinkersHelm()
	{
		super(2, 0);
		setUnlocalizedName("tinkershelm");
		maxReduction = 100;
		reductionPercent = 3 * 0.04f;
	}

	@Override
	public Item getHeadItem()
	{
		return TinkerTools.frypanHead;
	}

	@Override
	public Item getHandleItem()
	{
		return TinkersDefense.partChainmaille;
	}

	@Override
	public Item getAccessoryItem()
	{
		return TinkersDefense.partArmorplate;
	}

	@Override
	public Item getExtraItem()
	{
		return TinkerTools.toughRod;
	}

	@Override
	public int durabilityTypeAccessory()
	{
		return 2;
	}

	@Override
	public float getRepairCost()
	{
		return 4.0f;
	}

	@Override
	public float getDurabilityModifier()
	{
		return 2.5f;
	}

	@Override
	public float getDamageModifier()
	{
		return 1.4f;
	}

	@Override
	public int getPartAmount()
	{
		return 4;
	}

	@Override
	public String getIconSuffix(int partType)
	{
		switch(partType)
		{
			case 0:
				return "_helm_top";
			case 1:
				return "_helm_top_broken";
			case 2:
				return "_helm_chain";
			case 3:
				return "_helm_plate";
			case 4:
				return "_helm_visor";
			default:
				return "";
		}
	}

	@Override
	public String getEffectSuffix()
	{
		return "_helm_effect";
	}

	@Override
	public String getDefaultFolder()
	{
		return "armor/helm";
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
		return "tinkersdefense:textures/armor/TinkersHelm.png";
	}

	@Override
	public String[] getTraits()
	{
		return new String[] {"armor", "head", "helm", "heavyarmor"};
	}

	@Override
	public ArmorRenderer getRenderer()
	{
		return ClientProxy.helm;
	}
}
