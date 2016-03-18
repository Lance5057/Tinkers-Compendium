package lance5057.tDefense.core.tools;

import java.util.List;

import lance5057.tDefense.TinkersDefense;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import tconstruct.tools.TinkerTools;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RoundShield extends Shield
{
	int	induceDamage	= 0;

	public RoundShield()
	{
		super(0);
		this.setUnlocalizedName("shield");
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
		return TinkerTools.frypanHead;
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
		return 1.5f;
	}

	@Override
	public float breakSpeedModifier()
	{
		return 0.4f;
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
				return "_shield_face";
			case 1:
				return "_shield_face_broken";
			case 2:
				return "_shield_edge";
			case 3:
				return "_shield_boss";
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
		return "shield";
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
