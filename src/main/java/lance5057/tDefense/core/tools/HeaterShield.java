package lance5057.tDefense.core.tools;

import lance5057.tDefense.TinkersDefense;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tconstruct.tools.TinkerTools;

public class HeaterShield extends Shield
{
	int	induceDamage	= 0;

	public HeaterShield()
	{
		super(0);
		setUnlocalizedName("heatershield");
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
		return TinkersDefense.partArmorplate;
	}

	@Override
	public Item getExtraItem()
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
		return 4.0f;
	}

	@Override
	public float getDurabilityModifier()
	{
		return 2.5f;
	}

	@Override
	public float breakSpeedModifier()
	{
		return 0.4f;
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
				return "_shield_plate";
			case 1:
				return "_shield_plate_broken";
			case 2:
				return "_shield_edge";
			case 3:
				return "_shield_face";
			case 4:
				return "_shield_binding";
			default:
				return "";
		}
	}

	@Override
	public String getEffectSuffix()
	{
		return "_shield_effect";
	}

	@Override
	public String getDefaultFolder()
	{
		return "heatershield";
	}

	// /* tool_TinkerShield specific */
	// @Override
	// public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player,
	// Entity entity) {
	// if (AbilityHelper.onLeftClickEntity(stack, player, entity, this)) {
	// entity.hurtResistantTime += 7;
	// /*
	// * if (entity instanceof EntityLiving) { EntityLiving living =
	// * (EntityLiving) entity; if (living.getHealth() <= 0) {
	// *
	// * } }
	// */
	// // if (entity.getHealth() <= 0)
	// }
	// return true;
	// }

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
