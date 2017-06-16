package lance5057.tDefense.armor.items.cloth;

import java.util.List;

import lance5057.tDefense.armor.ArmorCore;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.materials.Material;

public class TinkersHood extends ArmorCore
{
	int	induceDamage	= 0;
	

	public TinkersHood()
	{
	    super(ClothMat,
	    		ClothMat,
	    		RivetMat);
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
