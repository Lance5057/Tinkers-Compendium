package lance5057.tDefense.core.materials.traits;


import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitMythical extends AbstractTDTrait {
    public TraitMythical() {
        super("mythical", 10079487);
    }

    @Override
    public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {
        tool.setTagCompound(new NBTTagCompound());
        return super.onToolDamage(tool, damage, newDamage, entity);
    }
}
