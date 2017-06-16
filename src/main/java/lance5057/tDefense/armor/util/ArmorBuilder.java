//package lance5057.tDefense.armor.util;
//
//import java.util.List;
//
//import org.apache.logging.log4j.Logger;
//
//import com.google.common.collect.ImmutableList;
//
//import lance5057.tDefense.armor.ArmorCore;
//import lance5057.tDefense.armor.events.ArmorBaseEvents;
//import net.minecraft.nbt.NBTTagCompound;
//import net.minecraft.nbt.NBTTagList;
//import slimeknights.tconstruct.library.TinkerRegistry;
//import slimeknights.tconstruct.library.Util;
//import slimeknights.tconstruct.library.materials.Material;
//import slimeknights.tconstruct.library.modifiers.IModifier;
//import slimeknights.tconstruct.library.modifiers.TinkerGuiException;
//import slimeknights.tconstruct.library.tinkering.PartMaterialType;
//import slimeknights.tconstruct.library.utils.TagUtil;
//import slimeknights.tconstruct.library.utils.Tags;
//import slimeknights.tconstruct.library.utils.TinkerUtil;
//
//public final class ArmorBuilder {
//	private static Logger log = Util.getLogger("ToolBuilder");
//	
//	public static void rebuildTool(NBTTagCompound rootNBT, ArmorCore tinkersItem) throws TinkerGuiException {
//	    boolean broken = TagUtil.getToolTag(rootNBT).getBoolean(Tags.BROKEN);
//	    // Recalculate tool base stats from material stats
//	    NBTTagList materialTag = TagUtil.getBaseMaterialsTagList(rootNBT);
//	    List<Material> materials = TinkerUtil.getMaterialsFromTagList(materialTag);
//	    List<PartMaterialType> pms = tinkersItem.getRequiredComponents();
//
//	    // ensure all needed Stats are present
//	    while(materials.size() < pms.size()) {
//	      materials.add(Material.UNKNOWN);
//	    }
//	    for(int i = 0; i < pms.size(); i++) {
//	      if(!pms.get(i).isValidMaterial(materials.get(i))) {
//	        materials.set(i, Material.UNKNOWN);
//	      }
//	    }
//
//	    // the base stats of the tool
//	    NBTTagCompound toolTag = tinkersItem.buildTag(materials);
//	    TagUtil.setToolTag(rootNBT, toolTag);
//	    // and its copy for reference
//	    rootNBT.setTag(Tags.TOOL_DATA_ORIG, toolTag.copy());
//
//	    // save the old modifiers list and clean up all tags that get set by modifiers/traits
//	    NBTTagList modifiersTagOld = TagUtil.getModifiersTagList(rootNBT);
//	    rootNBT.removeTag(Tags.TOOL_MODIFIERS); // the active-modifiers tag
//	    rootNBT.setTag(Tags.TOOL_MODIFIERS, new NBTTagList());
//	    rootNBT.removeTag("ench"); // and the enchantments tag
//	    rootNBT.removeTag(Tags.ENCHANT_EFFECT); // enchant effect too, will be readded by a trait either way
//
//	    // clean up traits
//	    rootNBT.removeTag(Tags.TOOL_TRAITS);
//	    tinkersItem.addMaterialTraits(rootNBT, materials);
//
//	    // fire event
//	    ArmorBaseEvents.OnArmorBuilding.fireEvent(rootNBT, ImmutableList.copyOf(materials), tinkersItem);
//
//	    // reapply modifiers
//	    NBTTagList modifiers = TagUtil.getBaseModifiersTagList(rootNBT);
//	    NBTTagList modifiersTag = TagUtil.getModifiersTagList(rootNBT);
//	    // copy over and reapply all relevant modifiers
//	    for(int i = 0; i < modifiers.tagCount(); i++) {
//	      String identifier = modifiers.getStringTagAt(i);
//	      IModifier modifier = TinkerRegistry.getModifier(identifier);
//	      if(modifier == null) {
//	        log.debug("Missing modifier: {}", identifier);
//	        continue;
//	      }
//
//	      NBTTagCompound tag;
//	      int index = TinkerUtil.getIndexInList(modifiersTagOld, modifier.getIdentifier());
//
//	      if(index >= 0) {
//	        tag = modifiersTagOld.getCompoundTagAt(index);
//	      }
//	      else {
//	        tag = new NBTTagCompound();
//	      }
//
//	      modifier.applyEffect(rootNBT, tag);
//	      if(!tag.hasNoTags()) {
//	        int indexNew = TinkerUtil.getIndexInList(modifiersTag, modifier.getIdentifier());
//	        if(indexNew >= 0) {
//	          modifiersTag.set(indexNew, tag);
//	        }
//	        else {
//	          modifiersTag.appendTag(tag);
//	        }
//	      }
//	    }
//
//	    // remaining info, get updated toolTag
//	    toolTag = TagUtil.getToolTag(rootNBT);
//	    // adjust free modifiers
//	    int freeModifiers = toolTag.getInteger(Tags.FREE_MODIFIERS);
//	    freeModifiers -= TagUtil.getBaseModifiersUsed(rootNBT);
//	    toolTag.setInteger(Tags.FREE_MODIFIERS, Math.max(0, freeModifiers));
//
//	    // broken?
//	    if(broken) {
//	      toolTag.setBoolean(Tags.BROKEN, true);
//	    }
//
//	    TagUtil.setToolTag(rootNBT, toolTag);
//
//	    if(freeModifiers < 0) {
//	      throw new TinkerGuiException(Util.translateFormatted("gui.error.not_enough_modifiers", -freeModifiers));
//	    }
//	}
//}
