package lance5057.tDefense.core.addons.ebwizardry;

import electroblob.wizardry.constants.Constants;
import electroblob.wizardry.event.SpellCastEvent;
import electroblob.wizardry.util.SpellModifiers;
import electroblob.wizardry.util.WizardryUtilities;
import lance5057.tDefense.Reference;
import lance5057.tDefense.core.materials.traits.AbstractTDTrait;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.mantle.typesafe.config.Optional;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.traits.ITrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EBWizardryEvents {

	@SubscribeEvent(priority = EventPriority.LOW)
	public static void onSpellCastPreEvent(SpellCastEvent.Pre event){
		if (event.getCaster() == null)
			return;
		
		for (ItemStack tool : event.getCaster().getArmorInventoryList()) {
			if (tool != null && tool.getItem() instanceof ArmorCore && !ToolHelper.isBroken(tool)) {
				NBTTagList list = TagUtil.getTraitsTagList(tool);
				for (int i = 0; i < list.tagCount(); i++) {
					if (TinkerRegistry.getTrait(list.getStringTagAt(i)) instanceof ITrait) {
						ITrait trait = TinkerRegistry.getTrait(list.getStringTagAt(i));
						if (trait != null && trait instanceof AbstractTDTrait) {
							((AbstractTDTrait) trait).onSpellCastPre(tool, event);
						}
					}
				}
			}
		}
	}
	
}
