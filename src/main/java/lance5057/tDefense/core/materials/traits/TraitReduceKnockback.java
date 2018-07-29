package lance5057.tDefense.core.materials.traits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import lance5057.tDefense.core.tools.TDToolEvents;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitReduceKnockback extends AbstractTrait {

	List<IBlockState> blocks = new ArrayList<IBlockState>();
	float percentReduced;

	public TraitReduceKnockback(String name, TextFormatting darkPurple, float percentReduced, IBlockState... iblocks) {
		super(name, darkPurple);
		blocks.addAll(Arrays.asList(iblocks));
	}
	
	public TraitReduceKnockback(String name, int darkPurple, float percentReduced, IBlockState... iblocks) {
		super(name, darkPurple);
		blocks.addAll(Arrays.asList(iblocks));
	}
	
	public TraitReduceKnockback(String name, TextFormatting darkPurple, float percentReduced) {
		super(name, darkPurple);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		IAttributeInstance att = player.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE);
		boolean block = checkBlock(player);
		if(blocks.isEmpty())
		{
			block = true;
		}
		
		if(!att.hasModifier(TDToolEvents.td_stoned))
		{
			if(block)
				att.applyModifier(TDToolEvents.td_stoned);
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
