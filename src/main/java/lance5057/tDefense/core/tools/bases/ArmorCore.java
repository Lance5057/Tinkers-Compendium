package lance5057.tDefense.core.tools.bases;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Sets;

import lance5057.tDefense.core.materials.ArmorMaterialStats;
import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
import lance5057.tDefense.util.ArmorNBT;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.IMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.tinkering.Category;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.traits.ITrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;
import slimeknights.tconstruct.library.utils.TooltipBuilder;

public abstract class ArmorCore extends ArmorBase {
	public ArmorCore(EntityEquipmentSlot slot, PartMaterialType... requiredComponents) {
		super(slot, requiredComponents);
	}

	protected String getHarvestType() {
		return null;
	}

	@Override
	public abstract NBTTagCompound buildTag(List<slimeknights.tconstruct.library.materials.Material> materials);

	public int getArmorDisplay(ItemStack stack) {
		return TagUtil.getToolStats(stack).get().getInteger("ArmorRating");
	}

	@SideOnly(Side.CLIENT)
	public abstract List<String> getArmorTexture(ItemStack stack);

	@SideOnly(Side.CLIENT)
	@Nullable
    public abstract ArmorRenderer getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack);

	public ArmorNBT buildDefaultArmorTag(List<Material> materials, String type) {
		ArmorNBT data = new ArmorNBT();

		if (materials.size() >= 2) {
			HandleMaterialStats handle = materials.get(0).getStatsOrUnknown(MaterialTypes.HANDLE);
			ArmorMaterialStats head = materials.get(1).getStatsOrUnknown(type);
			// start with head
			data.head(head);

			// add in accessories if present
			if (materials.size() >= 3) {
				ExtraMaterialStats binding = materials.get(2).getStatsOrUnknown(MaterialTypes.EXTRA);
				data.extra(binding);
			}

			// calculate handle impact
			data.handle(handle);
		}

		// 3 free modifiers
		data.modifiers = 5;

		return data;
	}
	
	@Override
	public boolean isValidArmor(ItemStack stack, EntityEquipmentSlot armorType, Entity entity)
    {
        return armorType == getArmorSlot(stack, armorType);
    }
	
	public abstract EntityEquipmentSlot getArmorSlot(ItemStack stack, EntityEquipmentSlot armorType);
	
	@Override
	  public void getTooltip(ItemStack stack, List<String> tooltips) {
	    if(ToolHelper.isBroken(stack)) {
	      tooltips.add("" + TextFormatting.DARK_RED + TextFormatting.BOLD + getBrokenTooltip(stack));
	    }
	    super.getTooltip(stack, tooltips);
	  }

	  protected String getBrokenTooltip(ItemStack itemStack) {
	    return Util.translate(TooltipBuilder.LOC_Broken);
	  }

	  @Override
	  public void getTooltipDetailed(ItemStack stack, List<String> tooltips) {
	    tooltips.addAll(getInformation(stack, false));
	  }
	  
	  public List<String> getInformation(ItemStack stack, boolean detailed) {
		    TooltipBuilder info = new TooltipBuilder(stack);

		    info.addDurability(!detailed);
		    if(hasCategory(Category.HARVEST)) {
		      info.addHarvestLevel();
		      info.addMiningSpeed();
		    }
		    if(hasCategory(Category.LAUNCHER)) {
		      info.addDrawSpeed();
		      info.addRange();
		      info.addProjectileBonusDamage();
		    }
		    info.addAttack();

		    if(ToolHelper.getFreeModifiers(stack) > 0) {
		      info.addFreeModifiers();
		    }

		    if(detailed) {
		      info.addModifierInfo();
		    }

		    return info.getTooltip();
		  }
	  
	  @Override
	  public void getTooltipComponents(ItemStack stack, List<String> tooltips) {
	    List<Material> materials = TinkerUtil.getMaterialsFromTagList(TagUtil.getBaseMaterialsTagList(stack));
	    List<PartMaterialType> component = getRequiredComponents();

	    if(materials.size() < component.size()) {
	      return;
	    }

	    for(int i = 0; i < component.size(); i++) {
	      PartMaterialType pmt = component.get(i);
	      Material material = materials.get(i);

	      // get (one possible) toolpart used to craft the thing
	      Iterator<IToolPart> partIter = pmt.getPossibleParts().iterator();
	      if(!partIter.hasNext()) {
	        continue;
	      }

	      IToolPart part = partIter.next();
	      ItemStack partStack = part.getItemstackWithMaterial(material);
	      if(partStack != null) {
	        // we have the part, add it
	        tooltips.add(material.getTextColor() + TextFormatting.UNDERLINE + partStack.getDisplayName());

	        Set<ITrait> usedTraits = Sets.newHashSet();
	        // find out which stats and traits it contributes and add it to the tooltip
	        for(IMaterialStats stats : material.getAllStats()) {
	          if(pmt.usesStat(stats.getIdentifier())) {
	            tooltips.addAll(stats.getLocalizedInfo());
	            for(ITrait trait : pmt.getApplicableTraitsForMaterial(material)) {
	              if(!usedTraits.contains(trait)) {
	                tooltips.add(material.getTextColor() + trait.getLocalizedName());
	                usedTraits.add(trait);
	              }
	            }
	          }
	        }
	        tooltips.add("");
	      }
	    }
	  }

}
