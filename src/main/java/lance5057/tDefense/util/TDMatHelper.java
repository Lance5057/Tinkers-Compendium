package lance5057.tDefense.util;

import javax.annotation.Nullable;

import lance5057.tDefense.core.materials.BootsMaterialStats;
import lance5057.tDefense.core.materials.ChestMaterialStats;
import lance5057.tDefense.core.materials.HelmMaterialStats;
import lance5057.tDefense.core.materials.LegsMaterialStats;
import lance5057.tDefense.core.materials.ShieldMaterialStats;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.materials.ArrowShaftMaterialStats;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.BowStringMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.FletchingMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;

public class TDMatHelper
{
	public String		name;
	public int			color;
	public FluidMolten	fluid;

	public boolean isGem;

	public HeadMaterialStats		head;
	public ShieldMaterialStats		shield;
	public BowMaterialStats			bow;
	public ExtraMaterialStats		extra;
	public FletchingMaterialStats	fletching;
	public BowStringMaterialStats	bowstring;
	public HandleMaterialStats		handle;
	public ArrowShaftMaterialStats	shaft;
	public HelmMaterialStats 		helm;
	public ChestMaterialStats 		chest;
	public LegsMaterialStats 		legs;
	public BootsMaterialStats 		boots;

	public ItemStack	gem;
	public ItemStack	ingot;
	public ItemStack	dust;
	public ItemStack	nugget;
	public ItemStack	grain;

	public boolean createMat = true;

	public TDMatHelper(String n, int c, FluidMolten f, boolean doMat)
	{
		name = n;
		color = c;
		fluid = f;
		createMat = doMat;
	}

	public TDMatHelper(String n, int c, boolean doMat)
	{
		init(n, c, null, false, doMat);
	}

	public TDMatHelper(String n, int c, boolean o, boolean doMat)
	{
		init(n, c, null, o, doMat);
	}

	public TDMatHelper(String n, int c, @Nullable FluidMolten f, boolean o, boolean doMat)
	{
		init(n, c, f, o, doMat);
	}

	public TDMatHelper(String n, int c)
	{
		init(n, c, null, false, true);
	}

	private void init(String n, int c, @Nullable FluidMolten f, boolean o, boolean doMat)
	{
		name = n;
		color = c;
		fluid = f;

		isGem = o;
		createMat = doMat;
	}

	public TDMatHelper setHead(HeadMaterialStats h)
	{
		head = h;
		return this;
	}

	public TDMatHelper setHandle(HandleMaterialStats h)
	{
		handle = h;
		return this;
	}

	public TDMatHelper setShield(ShieldMaterialStats h)
	{
		shield = h;
		return this;
	}

	public TDMatHelper setExtra(ExtraMaterialStats h)
	{
		extra = h;
		return this;
	}

	public TDMatHelper setBow(BowMaterialStats h)
	{
		bow = h;
		return this;
	}

	public TDMatHelper setFletching(FletchingMaterialStats h)
	{
		fletching = h;
		return this;
	}

	public TDMatHelper setString(BowStringMaterialStats h)
	{
		bowstring = h;
		return this;
	}

	public TDMatHelper setShaft(ArrowShaftMaterialStats h)
	{
		shaft = h;
		return this;
	}
	
	public TDMatHelper setHelm(HelmMaterialStats h)
	{
		helm = h;
		return this;
	}
	
	public TDMatHelper setChest(ChestMaterialStats h)
	{
		chest = h;
		return this;
	}
	
	public TDMatHelper setLegs(LegsMaterialStats h)
	{
		legs = h;
		return this;
	}
	
	public TDMatHelper setBoots(BootsMaterialStats h)
	{
		boots = h;
		return this;
	}

	public TDMatHelper setGem(Item i)
	{
		gem = new ItemStack(i);
		return this;
	}

	public TDMatHelper setGem(ItemStack i)
	{
		gem = i;
		return this;
	}

	public TDMatHelper setIngot(Item i)
	{
		ingot = new ItemStack(i);
		return this;
	}

	public TDMatHelper setDust(Item i)
	{
		dust = new ItemStack(i);
		return this;
	}

	public TDMatHelper setGrain(Item i)
	{
		grain = new ItemStack(i);
		return this;
	}

	public TDMatHelper setNugget(Item i)
	{
		nugget = new ItemStack(i);
		return this;
	}
}
