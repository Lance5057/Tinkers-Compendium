package lance5057.tDefense.core.materials.traits;


import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.traits.AbstractTraitLeveled;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.Tags;

public class TraitMythical extends AbstractTraitLeveled {

    public TraitMythical(int levels) {
        super("mythical", String.valueOf(levels),0x10079487, 3, 1);
    }

    @Override
    public void applyModifierEffect(NBTTagCompound rootCompound) {
        NBTTagCompound toolTag = TagUtil.getToolTag(rootCompound);
        int modifiers = toolTag.getInteger(Tags.FREE_MODIFIERS) + levels;
        toolTag.setInteger(Tags.FREE_MODIFIERS, Math.max(0, modifiers));
        TagUtil.setToolTag(rootCompound, toolTag);
    }

    @Override
    public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {
//        if (newDamage > tool.getMaxDamage() - tool.getItemDamage()){
            NBTTagCompound readyForModifier = TagUtil.getTagSafe(tool);
            readyForModifier.setBoolean("readyForModifier", true);
        System.out.println("Ready for modifier!");
//        }
        return super.onToolDamage(tool, damage, newDamage, entity);
    }
}
