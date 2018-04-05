package lance5057.tDefense.core.materials.traits.shields;

import java.util.Optional;

import lance5057.tDefense.util.TDToolHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.mantle.util.RecipeMatch.Match;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitFirestarter extends AbstractTrait {

	public TraitFirestarter() {
		super("firestarter", TextFormatting.RED);
	}

	@Override
	public void onBlock(ItemStack tool, EntityPlayer player,
			LivingHurtEvent event) {
		Entity src = event.getSource().getTrueSource();
		if (src != null && src instanceof EntityLiving) {
			EntityLivingBase liv = (EntityLivingBase) src;

			if (liv.getHeldItemMainhand() != null) {
				ItemStack held = liv.getHeldItemMainhand();
				if(held.getItem() instanceof ToolCore)
				{
					if(TDToolHelper.checkIfMetal(tool))
					{
						Vec3d vec = player.getLookVec();
						BlockPos block = player.getPosition().add(vec.x,-1,vec.z);
						player.world.setBlockState(block, Blocks.FIRE.getDefaultState());
					}
				}
			}
		}
	}

	@Override
	public Optional<Match> matches(NonNullList<ItemStack> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
