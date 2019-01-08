package lance5057.tDefense.core.materials.traits;

import java.util.List;

import lance5057.tDefense.TCConfig;
import lance5057.tDefense.util.ArmorTagUtil;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitElectrostaticDischarge extends AbstractTDTrait {

	public TraitElectrostaticDischarge() {
		super("electrostaticdischarge", TextFormatting.YELLOW);
	}

	@Override
	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {
		if (ArmorTagUtil.getCharge(tool) > 10) {
			EntityLivingBase player = e.getEntityLiving();
			
			for (EntityLivingBase entitylivingbase : player.getEntityWorld().getEntitiesWithinAABB(
					EntityLivingBase.class, player.getEntityBoundingBox().expand(2.0D, 0.25D, 2.0D))) {
				if (entitylivingbase != player && entitylivingbase != player && !player.isOnSameTeam(entitylivingbase)
						&& player.getDistanceSq(entitylivingbase) < 9.0D) {
					entitylivingbase.knockBack(player, 0.4F, (double) MathHelper.sin(player.rotationYaw * 0.017453292F),
							(double) (-MathHelper.cos(player.rotationYaw * 0.017453292F)));
				}
			}
			ArmorTagUtil.setCharge(tool, 0);
		} else {
			ArmorTagUtil.setCharge(tool, ArmorTagUtil.getCharge(tool) + 1);
		}

	}
}
