package lance5057.tDefense.core.materials.traits;

import lance5057.tDefense.core.library.ArmorHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitPhotoAbsorbant extends AbstractTDTrait {

    public TraitPhotoAbsorbant() {
        super("photoabsorbant", 0x875e21);
    }

    @Override
    public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
        if (world.isRemote && random.nextInt(600) == 0) {

            if(ToolHelper.getCurrentDurability(tool) < ToolHelper.getMaxDurability(tool)) {
                if (world.canBlockSeeSky(new BlockPos(player)))
                    ArmorHelper.repairTool(tool, 5);
                if (world.isRainingAt(new BlockPos(player)))
                    ArmorHelper.repairTool(tool, 1);

            }
        }
    }
}
