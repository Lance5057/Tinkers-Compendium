package lance5057.tDefense.core;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tconstruct.tools.items.Pattern;
import tconstruct.util.Reference;

public class TD_Patterns extends Pattern
{
	private static final String[]	patternName	= new String[] {"rivets", "clasp", "armorplate", "cloth", "chainmaille"};

	public TD_Patterns(String patternType, String name)
	{
		super(patternName, getPatternNames(patternName, patternType), "patterns/");

		this.setUnlocalizedName(Reference.prefix(name));
	}

	public static String[] getPatternNames(String[] patternName, String partType)
	{
		String[] names = new String[patternName.length];
		for(int i = 0; i < patternName.length; i++)
			names[i] = partType + patternName[i];
		return names;
	}

	@Override
	public void getSubItems(Item b, CreativeTabs tab, List list)
	{
		for(int i = 0; i < patternName.length; i++)
		{
			// if (i != 23)
			list.add(new ItemStack(b, 1, i));
		}
	}

	@Override
	public int getPatternCost(ItemStack pattern)
	{
		switch(pattern.getItemDamage())
		{
			case 0:
				return 1; //rivets
			case 1:
				return 2; //clasp
			case 2:
				return 8; //armorplate
			case 3:
				return 6; //cloth
			case 4:
				return 6; //chainmaille
		}
		return 0;
	}
}
