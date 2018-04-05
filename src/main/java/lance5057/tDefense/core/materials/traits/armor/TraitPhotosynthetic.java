package lance5057.tDefense.core.materials.traits.armor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.traits.AbstractTraitLeveled;
import slimeknights.tconstruct.library.utils.TinkerUtil;

public class TraitPhotosynthetic extends AbstractTraitLeveled {

	public TraitPhotosynthetic(int level) {
		super("photosynthetic", 0x875e21, 2, level);
	}

	@Override
	public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
		if(!world.isRemote && entity instanceof EntityPlayer && random.nextInt(100) == 0) {
			
			EntityPlayer e = (EntityPlayer) entity;
			ModifierNBT data = new ModifierNBT(TinkerUtil.getModifierTag(tool, name));
			
			if(world.canBlockSeeSky(new BlockPos(e)))
				e.getFoodStats().setFoodSaturationLevel(e.getFoodStats().getSaturationLevel() + (data.level * 0.5f));
			if(world.isRainingAt(new BlockPos(e)))
				e.getFoodStats().setFoodSaturationLevel(e.getFoodStats().getSaturationLevel() + (data.level * 0.5f));
		}
	}
}
