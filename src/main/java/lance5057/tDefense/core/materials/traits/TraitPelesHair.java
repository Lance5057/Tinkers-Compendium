package lance5057.tDefense.core.materials.traits;

import java.util.Random;

import lance5057.tDefense.TCConfig;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiScreenEvent.PotionShiftEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

public class TraitPelesHair extends AbstractTDTrait {

    public TraitPelesHair() {
        super("peleshair", TextFormatting.DARK_PURPLE);
    }

    @Override
    public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
        int duration = player.world.rand.nextInt(200) + 1;
        switch (player.world.rand.nextInt(400)) {
            case 1:
                player.addPotionEffect(new PotionEffect(MobEffects.LUCK, duration, 0, true, false));
                break;
            case 2:
                player.addPotionEffect(new PotionEffect(MobEffects.LUCK, duration, 1, true, false));
                break;
            case 3:
                player.addPotionEffect(new PotionEffect(MobEffects.LUCK, duration, -1, true, false));
                break;
            case 4:
                player.addPotionEffect(new PotionEffect(MobEffects.LUCK, duration, 0, true, false));
                break;
            case 5:
                player.addPotionEffect(new PotionEffect(MobEffects.UNLUCK, duration, 1, true, false));
                break;
            case 6:
                player.addPotionEffect(new PotionEffect(MobEffects.UNLUCK, duration, -1));
                break;
        }
    }

}
