package lance5057.tDefense.core.materials.traits;

import lance5057.tDefense.util.ArmorTagUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.Tags;

public class TraitGlassine extends AbstractTDTrait {

	public TraitGlassine() {
		super("glassine", TextFormatting.WHITE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {
		if(e.getSource() == DamageSource.MAGIC)
		{
			e.setAmount(e.getAmount() * 0.5f);
		}
	}

	@Override
	public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
		// add the trait to the traitlist so it gets processed
		NBTTagList traits = TagUtil.getTraitsTagList(rootCompound);
		// if it's not already present
		for (int i = 0; i < traits.tagCount(); i++) {
			if (identifier.equals(traits.getStringTagAt(i))) {
				return;
			}
		}

		traits.appendTag(new NBTTagString(identifier));
		TagUtil.setTraitsTagList(rootCompound, traits);
		NBTTagCompound n = ArmorTagUtil.getToolTag(rootCompound);
		n.setInteger(Tags.DURABILITY, (int) (n.getInteger(Tags.DURABILITY) * 0.7));
		TagUtil.setToolTag(rootCompound, n);
	}
}
