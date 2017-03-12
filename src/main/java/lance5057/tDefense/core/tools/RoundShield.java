package lance5057.tDefense.core.tools;

import lance5057.tDefense.TinkersDefense;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.tools.TinkerTools;

public class RoundShield extends Shield
{
	int	induceDamage	= 0;

	public RoundShield()
	{
	    super(PartMaterialType.handle(TinkerTools.toolRod),
	    		ShieldMat,
	            PartMaterialType.head(TinkerTools.panHead));
		setUnlocalizedName("shield");
	}

	@Override
	public float breakSpeedModifier()
	{
		return 0.4f;
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
	{
		super.onUpdate(stack, world, entity, par4, par5);

	}

	@Override
	protected String getHarvestType()
	{
		return "shield";
	}
}
