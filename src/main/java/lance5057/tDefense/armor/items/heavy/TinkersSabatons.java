package lance5057.tDefense.armor.items.heavy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.parts.ClothMaterial;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersSabatons;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.tools.CustomMaterial;
import tconstruct.tools.TinkerTools;

public class TinkersSabatons extends ArmorCore 
{
	public TinkersSabatons() {
		super(2,3);
		this.setUnlocalizedName("tinkersabatons");
		this.maxReduction = 100;
		this.reductionPercent = 0.12;
	}
	
	@Override
	public Item getHeadItem() 
	{
		return TinkersDefense.partArmorplate;
	}
	
	@Override
	public Item getHandleItem() {
		return TinkerTools.toughRod;
	}
	
	@Override
	public Item getAccessoryItem() 
	{
		return TinkersDefense.partArmorplate;
	}
	
	@Override
	public Item getExtraItem()
	{
		return TinkersDefense.partCloth;
	}
	
	@Override
	public int durabilityTypeAccessory() {
		return 2;
	}

	@Override
	public float getRepairCost() {
		return 4.0f;
	}

	@Override
	public float getDurabilityModifier() {
		return 2.5f;
	}
	
	@Override
	public float getDamageModifier() {
		return 1.4f;
	}

	@Override
	public int getPartAmount() {
		return 4;
	}
	
	@Override
	public String getIconSuffix(int partType) 
	{
		switch (partType) {
		case 0:
			return "_sabatons_plates";
		case 1:
			return "_sabatons_plate_broken";
		case 2:
			return "_sabatons_trim";
		case 3:
			return "_sabatons_caps";
		case 4:
			return "_sabatons_soles";
		default:
			return "";
		}
	}
	
	@Override
	public String getEffectSuffix() 
	{
		return "_sabatons_effect";
	}
	
	@Override
	public String getDefaultFolder()
	{
		return "armor/sabatons";
	}
	
//	@Override
//	public void onUpdate(ItemStack stack, World world, Entity entity, int par4,
//			boolean par5) {
//		super.onUpdate(stack, world, entity, par4, par5);
//
//	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {
		return "tinkersdefense:textures/armor/TinkersSabatons.png";
	}
	
	@Override
	public String[] getTraits() {
		return new String[] {"armor","shoes","sabatons","heavyarmor"};
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getModel(String[] color, NBTTagCompound tags)
	{
		String[] textures = {this.getIconSuffix(2),this.getIconSuffix(0),this.getIconSuffix(3), this.getIconSuffix(4)};
		
		int matID = tags.getCompoundTag("InfiTool").getInteger("RenderExtra");
		
		
		CustomMaterial newColor = TConstructRegistry.getCustomMaterial(matID, ClothMaterial.class);
		
		color[3] = Integer.toHexString(newColor.color);
		
		return new ModelTinkersSabatons(color, this.getDefaultFolder(), textures);
	}
	
	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) 
	{
		return 3;
	}
}
