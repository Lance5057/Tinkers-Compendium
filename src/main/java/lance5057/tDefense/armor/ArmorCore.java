package lance5057.tDefense.armor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.Nonnull;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

import gnu.trove.set.hash.THashSet;
import lance5057.tDefense.armor.events.ArmorBaseEvents;
import lance5057.tDefense.armor.materials.MaterialArmor;
import lance5057.tDefense.armor.materials.MaterialCloth;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.common.ClientProxy;
import slimeknights.tconstruct.common.config.Config;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.modifiers.TinkerGuiException;
import slimeknights.tconstruct.library.tinkering.Category;
import slimeknights.tconstruct.library.tinkering.IModifyable;
import slimeknights.tconstruct.library.tinkering.IRepairable;
import slimeknights.tconstruct.library.tinkering.ITinkerable;
import slimeknights.tconstruct.library.tinkering.IToolStationDisplay;
import slimeknights.tconstruct.library.tinkering.IndestructibleEntityItem;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.traits.ITrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.Tags;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolBuilder; 
import slimeknights.tconstruct.library.utils.ToolHelper;
import slimeknights.tconstruct.library.utils.TooltipBuilder;

public abstract class ArmorCore extends ToolCore
{
	public float reductionPercent = 0f;
	public int maxReduction = 100;
	
	protected static PartMaterialType ArmorplateMat = new PartMaterialType(ArmorBase.armorPlate, MaterialArmor.TYPE);
	protected static PartMaterialType ChainmailMat = new PartMaterialType(ArmorBase.chainmail, MaterialArmor.TYPE);
	protected static PartMaterialType RivetMat = new PartMaterialType(ArmorBase.rivets, MaterialArmor.TYPE);
	protected static PartMaterialType ClaspMat = new PartMaterialType(ArmorBase.clasp, MaterialArmor.TYPE);
	
	protected static PartMaterialType ClothMat = new PartMaterialType(ArmorBase.cloth, MaterialCloth.TYPE);

	public ArmorCore(PartMaterialType... rc) {
		super(rc);
	}
	
	@Override
	public NBTTagCompound buildTag(List<Material> materials) {
		ToolNBT data = buildDefaultTag(materials);
	    data.durability *= 1;
	    return data.get();
	}
}
