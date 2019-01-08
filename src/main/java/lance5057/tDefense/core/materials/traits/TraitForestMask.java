package lance5057.tDefense.core.materials.traits;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitForestMask extends AbstractTDTrait {
	public TraitForestMask() {
		super("forestmask", TextFormatting.GREEN);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		if (player.isSneaking()) {
			int width = 2;
			int grass = 0;
			for (int x = -width; x < width; x++) {
				for (int y = -width; y < width; y++) {
					for (int z = -width; z < width; z++) {
						BlockPos pos = new BlockPos(player.posX + x,player.posY + y,player.posZ + z);
						
						Block b = world.getBlockState(pos).getBlock();
						if(b instanceof BlockTallGrass || b instanceof BlockGrass)
						{
							grass++;
						}
					}
				}
			}
			
			if(grass > 3)
				player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10));
		}
	}
}
