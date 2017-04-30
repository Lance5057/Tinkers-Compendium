package lance5057.tDefense.core.materials.traits;

import lance5057.tDefense.util.TDToolHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitFirestarter extends AbstractTrait {

	public TraitFirestarter() {
		super("firestarter", TextFormatting.RED);
	}

	@Override
	public void onBlock(ItemStack tool, EntityPlayer player,
			LivingHurtEvent event) {
		Entity src = event.getSource().getSourceOfDamage();
		if (src != null && src instanceof EntityLiving) {
			EntityLivingBase liv = (EntityLivingBase) src;

			if (liv.getHeldItemMainhand() != null) {
				ItemStack held = liv.getHeldItemMainhand();
				if(held.getItem() instanceof ToolCore)
				{
					if(TDToolHelper.checkIfMetal(tool))
					{
						Vec3d vec = player.getLookVec();
						BlockPos block = player.getPosition().add(vec.xCoord,-1,vec.zCoord);
						player.world.setBlockState(block, Blocks.FIRE.getDefaultState());
					}
				}
			}
		}
	}
}
