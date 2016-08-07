package lance5057.tDefense.core.liquids;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MoltenFluid extends BlockFluidClassic
{
	private IIcon	stillIcon;
	private IIcon	flowingIcon;
	private final String	stillIconTexture;
	private final String	flowIconTexture;

	public MoltenFluid(Fluid fluid, String name)
	{
		super(fluid, Material.lava);
		setLightLevel(100.0F);
		setHardness(1.0F);
		setBlockName("Molten" + name);

		stillIconTexture = "tinkersdefense:molten_" + name;
		flowIconTexture = "tinkersdefense:molten_" + name + "_flow";
	}

	@SideOnly(Side.CLIENT)
	public void func_149651_a(IIconRegister icon)
	{
		stillIcon = icon.registerIcon(stillIconTexture);
		flowingIcon = icon.registerIcon(flowIconTexture);

		getFluid().setIcons(stillIcon, flowingIcon);
	}

	public IIcon getStillIcon()
	{
		return stillIcon;
	}

	public IIcon getFlowingIcon()
	{
		return flowingIcon;
	}

	@SideOnly(Side.CLIENT)
	public IIcon func_149691_a(int side, int meta)
	{
		if(side <= 1)
		{
			return stillIcon;
		}
		return flowingIcon;
	}
}
