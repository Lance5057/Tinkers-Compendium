package lance5057.tDefense.core.materials.traits;


import lance5057.tDefense.TCConfig;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.traits.AbstractTraitLeveled;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.Tags;
import slimeknights.tconstruct.library.utils.TinkerUtil;

/**
 * Mythical: Damaging the tool after repairing it after it has been broken will consume 30 levels and add a modifier
 */
public class TraitMythical extends AbstractTraitLeveled {

    private static final String READY_FOR_MODIFIER = "readyForModifier";
    private static final String BREAK_FOR_MODIFIER = "breakForModifier";
    private static final String MAX_MODIFIERS = "maxModifiers";
    private static final String BONUS_MODIFIERS = "bonusModifiers";

    public TraitMythical(int levels) {
        super("mythical", String.valueOf(levels), 0x10079487, 3, levels);
    }

    /**
     * Apply NBT tags for the maximum number of modifiers and the number of bonus modifiers
     */
    @Override
    public void applyModifierEffect(NBTTagCompound rootCompound) {
        ModifierNBT data = new ModifierNBT(TinkerUtil.getModifierTag(rootCompound, "mythical"));
        rootCompound.setInteger(MAX_MODIFIERS, TCConfig.traits.extraModifiers * data.level);
        rootCompound.setInteger(BONUS_MODIFIERS, 0);
    }

    /**
     * When tool breaks and the number of bonus modifiers is below the max number of bonus modifiers, apply a ready for
     * modifier tag. When tool takes damage after it's been repaired, consume 30 levels and add a modifier and increment
     * the bonus modifier tag.
     */
    @Override
    public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {
        NBTTagCompound itemTag = TagUtil.getTagSafe(tool);
        if (newDamage >= tool.getMaxDamage() - tool.getItemDamage() && itemTag.getInteger(BONUS_MODIFIERS) < itemTag.getInteger(MAX_MODIFIERS) && !itemTag.getBoolean(READY_FOR_MODIFIER)) {
            itemTag.setBoolean(READY_FOR_MODIFIER, true);
            entity.sendMessage(new TextComponentString("A voice rings in your head\n§9Repair me fully. Then, when wielding vast worldly knowledge, I shall bestow a gift when you use me again."));
        }

        //When tool takes damage, increase the modifier count and deduct XP
        if (itemTag.getBoolean(BREAK_FOR_MODIFIER) && entity instanceof EntityPlayer && ((EntityPlayer) entity).experienceTotal >= 825) {
            //Deduct XP
            EntityPlayer player = (EntityPlayer) entity;
            player.addExperience(-825);

            //Add modifier
            NBTTagCompound toolTag = TagUtil.getToolTag(itemTag);
            int modifiers = toolTag.getInteger(Tags.FREE_MODIFIERS) + 1;
            toolTag.setInteger(Tags.FREE_MODIFIERS, Math.max(0, modifiers));
            TagUtil.setToolTag(itemTag, toolTag);

            //Increment bonus modifier tag
            int bonusModifiers = itemTag.getInteger(BONUS_MODIFIERS) + 1;
            itemTag.setInteger(BONUS_MODIFIERS, bonusModifiers);

            //Revert tags
            TagUtil.setEnchantEffect(tool, false);
            itemTag.setBoolean(READY_FOR_MODIFIER, false);
            itemTag.setBoolean(BREAK_FOR_MODIFIER, false);

            entity.sendMessage(new TextComponentString("§9Upon using the tool, new opportunities reveal themselves to you."));
            return super.onToolDamage(tool, damage, 0, entity);
        }
        return super.onToolDamage(tool, damage, newDamage, entity);
    }

    /**
     * When tool is healed to max durability, apply break for new modifier tag and add enchantment glow
     */
    @Override
    public int onToolHeal(ItemStack tool, int amount, int newAmount, EntityLivingBase entity) {
        System.out.println(tool.getItemDamage());
        System.out.println(newAmount);
        if (tool.getItemDamage() <= newAmount * -1 && TagUtil.getTagSafe(tool).getBoolean(READY_FOR_MODIFIER)) {
            TagUtil.getTagSafe(tool).setBoolean(BREAK_FOR_MODIFIER, true);
            System.out.println("Break for a new modifier");
            TagUtil.setEnchantEffect(tool, true);
        }
        return super.onToolHeal(tool, amount, newAmount, entity);
    }
}
