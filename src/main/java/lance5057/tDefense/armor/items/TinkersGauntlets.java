package lance5057.tDefense.armor.items;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.renderers.ArmorRenderer;
import lance5057.tDefense.proxy.ClientProxy;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tconstruct.library.accessory.IAccessory;
import tconstruct.tools.TinkerTools;

public class TinkersGauntlets extends ArmorCore implements IAccessory
{
	public TinkersGauntlets()
	{
		super(0, -1);
		setUnlocalizedName("tinkersgauntlets");
	}

	@Override
	public boolean canEquipAccessory(ItemStack item, int slot)
	{
		return slot == 1;
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
		return TinkersDefense.partRivet;
	}

	@Override
	public int durabilityTypeAccessory()
	{
		return 2;
	}

	@Override
	public float getRepairCost()
	{
		return 1.0f;
	}

	@Override
	public float getDurabilityModifier()
	{
		return 2.5f;
	}

	@Override
	public float getDamageModifier()
	{
		return 0f;
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
				return "_gauntlet_plate";
			case 1:
				return "_gauntlet_plate_broken";
			case 2:
				return "_gauntlet_trim";
			case 3:
				return "_gauntlet_rivet";
			default:
				return "";
		}
	}

	@Override
	public String getEffectSuffix()
	{
		return "_gauntlet_effect";
	}

	@Override
	public String getDefaultFolder()
	{
		return "armor/gauntlets";
	}

	// @Override
	// public void onUpdate(ItemStack stack, World world, Entity entity, int
	// par4,
	// boolean par5) {
	// super.onUpdate(stack, world, entity, par4, par5);
	//
	// }

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return "tinkersdefense:textures/armor/Tinkersgauntlet.png";
	}

	@Override
	public String[] getTraits()
	{
		return new String[] {"hands", "gauntlet"};
	}

	@Override
	public ArmorRenderer getRenderer()
	{
		return ClientProxy.gauntlets;
	}
}
