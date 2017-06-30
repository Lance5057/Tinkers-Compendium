package lance5057.tDefense.armor.items.cloth;

import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.core.parts.TDParts;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TinkersHood extends ArmorCore
{
	int	induceDamage	= 0;
	

	public TinkersHood()
	{
	    super(TDParts.ClothMat,
	    		TDParts.ClothMat,
	    		TDParts.RivetMat);
		setUnlocalizedName("tinkerhood");
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
	{
		super.onUpdate(stack, world, entity, par4, par5);

	}

	@Override
	public float damagePotential() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double attackSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
