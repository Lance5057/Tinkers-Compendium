package lance5057.tDefense.armor.items.heavy;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.renderers.ArmorRenderer;
import lance5057.tDefense.proxy.ClientProxy;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tconstruct.tools.TinkerTools;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TinkersGrieves extends ArmorCore
{
	public TinkersGrieves()
	{
		super(2, 2);
		setUnlocalizedName("tinkergrieves");
		maxReduction = 100;
		reductionPercent = 6 * 0.04f;
	}

	@Override
	public Item getHeadItem()
	{
		return TinkersDefense.partArmorplate;
	}

	@Override
	public Item getHandleItem()
	{
		return TinkerTools.toughRod;
	}

	@Override
	public Item getAccessoryItem()
	{
		return TinkersDefense.partChainmaille;
	}

	@Override
	public Item getExtraItem()
	{
		return TinkersDefense.partCloth;
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
				return "_grieves_plate";
			case 1:
				return "_grieves_plate_broken";
			case 2:
				return "_grieves_trim";
			case 3:
				return "_grieves_chain";
			case 4:
				return "_grieves_cloth";
			default:
				return "";
		}
	}

	@Override
	public String getEffectSuffix()
	{
		return "_grieves_effect";
	}

	@Override
	public String getDefaultFolder()
	{
		return "armor/grieves";
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
		return "tinkersdefense:textures/armor/TinkersGrieves.png";
	}

	@Override
	public String[] getTraits()
	{
		return new String[] {"armor", "pants", "grieves", "heavyarmor"};
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ArmorRenderer getRenderer()
	{
		return ClientProxy.grieves;
	}
}
