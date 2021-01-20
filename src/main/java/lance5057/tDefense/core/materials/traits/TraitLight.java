package lance5057.tDefense.core.materials.traits;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class TraitLight extends AbstractTDTrait {

    public TraitLight() {
        super("light", 0xefe0d5);
    }

    public void onArmorTick(ItemStack tool, World world, EntityPlayer player)
    {
        player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST,30, 2, true, false));
    }

}