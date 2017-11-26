package lance5057.tDefense.util;

import lance5057.tDefense.core.materials.ShieldMaterialStats;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.materials.ArrowShaftMaterialStats;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.BowStringMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.FletchingMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;

public class TDMatHelper {
	public String name;
	public int color; 
	public FluidMolten fluid;
	
	public boolean isGem;
	
	public HeadMaterialStats head;
	public ShieldMaterialStats shield;
	public BowMaterialStats bow;
	public ExtraMaterialStats extra;
	public FletchingMaterialStats fletching;
	public BowStringMaterialStats bowstring;
	public HandleMaterialStats handle;
	public ArrowShaftMaterialStats shaft;
	
	public TDMatHelper(String n, int c, FluidMolten f)
	{
		name = n;
		color = c;
		fluid = f;
	}
	
	public TDMatHelper(String n, int c)
	{
		name = n;
		color = c;
		fluid = null;
	}
	
	public TDMatHelper(String n, int c, boolean o)
	{
		name = n;
		color = c;
		fluid = null;
		
		isGem = o;
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
}
