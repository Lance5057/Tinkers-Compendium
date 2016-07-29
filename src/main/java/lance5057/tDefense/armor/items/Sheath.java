package lance5057.tDefense.armor.items;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.renderers.ArmorRenderer;
import lance5057.tDefense.proxy.ClientProxy;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tconstruct.library.accessory.IAccessory;
import tconstruct.tools.TinkerTools;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Sheath extends ArmorCore implements IAccessory
{

	public Sheath()
	{
		super(0, -1);
	}

	@Override
	public boolean canEquipAccessory(ItemStack item, int slot)
	{
		return slot == 3;
	}

	@Override
	public Item getHeadItem()
	{
		return TinkersDefense.partArmorplate;
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

	//	@Override
	//	public Item getExtraItem()
	//	{
	//		return TinkersDefense.partCloth;
	//	}

	@Override
	public String getDefaultFolder()
	{
		// TODO Auto-generated method stub
		return "Armor/Sheath";
	}

	@Override
	public String getEffectSuffix()
	{
		return "_sheath_effect";
	}

	@SideOnly(Side.CLIENT)
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
				return "_tabard_cloth";
			case 1:
				return "_shield_base_broken"; //useless
			case 2:
				return "_tabard_trim";
			case 3:
				return "_tabard_filigree";
				//			case 4:
				//				return "_sheath_clasp";
			default:
				return "";
		}
	}

	@Override
	public String[] getTraits()
	{
		return new String[] {"sheath", "cosmetic"};
	}

	@Override
	public ArmorRenderer getRenderer()
	{
		// TODO Auto-generated method stub
		return ClientProxy.sheath;
	}

}
