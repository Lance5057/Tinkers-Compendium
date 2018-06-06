package lance5057.tDefense.core.materials.traits.armor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import lance5057.tDefense.core.materials.traits.AbstractTDTrait;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitReduceKnockback extends AbstractTrait {

	AttributeModifier knockback = new AttributeModifier(UUID.randomUUID(), "td_knockback", 0.5f, 0);
	
	List<IBlockState> blocks = new ArrayList<IBlockState>();
	float percentReduced;

	public TraitReduceKnockback(String name, int icolor, float percentReduced, IBlockState... iblocks) {
		super(name, icolor);
		blocks.addAll(Arrays.asList(iblocks));
	}

//	@Override
//	public float knockBack(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage,
//			float knockback, float newKnockback, boolean isCritical) {
//		if (blocks.isEmpty() || checkBlock(player))
//			return knockback / percentReduced;
//		return knockback;
//	}
	
	public void onArmorUnequip(EntityPlayer e) {
		IAttributeInstance att = e.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE);
		if(att.hasModifier(knockback))
		{
			att.removeModifier(knockback);
		}
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		IAttributeInstance att = player.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE);
		boolean block = checkBlock(player);
		if(!att.hasModifier(knockback))
		{
			if(block)
				att.applyModifier(knockback);
		}
		else
		{
			if(!block)
				att.removeModifier(knockback);
		}
	}

	private boolean checkBlock(EntityLivingBase e) {
		IBlockState b = e.world.getBlockState(new BlockPos(e.posX, e.posY - 1, e.posZ));
		for (IBlockState bl : blocks) {
			if (bl.equals(b))
				return true;
		}
		return false;
	}
}
