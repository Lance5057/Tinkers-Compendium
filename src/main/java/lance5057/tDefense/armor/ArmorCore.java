package lance5057.tDefense.armor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import scala.Int;
import tconstruct.library.accessory.IAccessoryModel;
import tconstruct.library.tools.AbilityHelper;
import tconstruct.library.tools.ToolCore;

public class ArmorCore extends ToolCore implements ISpecialArmor//, IAccessoryModel
{	
	int slot;
	protected Double reductionPercent = 0.0;
	protected int maxReduction = 0;
	
	public ArmorCore(int baseProtection, int slot) {
		super(baseProtection);
		
		this.slot = slot;
	}
	
//	@Override
//	public void onUpdate(ItemStack stack, World world, Entity entity, int par4,
//			boolean par5) {
//		super.onUpdate(stack, world, entity, par4, par5);
//
//	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player,
			ItemStack armor, DamageSource source, double damage, int slot) 
	{
		NBTTagCompound tags = armor.getTagCompound().getCompoundTag("InfiTool");

		Double enhancedPercent = reductionPercent;
		
		if(tags.hasKey("Protection"))
			enhancedPercent += (calcModifierDamage(tags.getInteger("Protection"), 0.75f, source) * 0.04);
		
		ArmorProperties armorp = new ArmorProperties(0, enhancedPercent, maxReduction); //0.04 per half shirt
		((EntityPlayer)player).addChatComponentMessage(new ChatComponentText(source.getDamageType() + 
				" - Max: " + Double.toString(damage) +
				" - ReductPerc: " + Double.toString(reductionPercent) +
				" - EnhancedPerc: " + Double.toString(enhancedPercent)));
		return armorp;
	}
	
	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) 
	{
		return 0;
	}
	
	public int getSlot()
	{
		return slot;
	}
	
	@SideOnly(Side.CLIENT)
	public ModelBiped getModel(String[] color, NBTTagCompound tags)
	{
		return null;
	}
	
	@Override
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity) 
	{
		return armorType == slot;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack,
			DamageSource source, int damage, int slot) {
		AbilityHelper.damageTool(stack, damage, entity, false);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving,
			ItemStack itemStack, int armorSlot) 
	{
		return null;
	}

	@Override
	public Item getAccessoryItem() 
	{
		return null;
	}

	@Override
	public String getDefaultFolder()
	{
		return null;
	}

	@Override
	public String getEffectSuffix() 
	{
		return null;
	}

	@Override
	public Item getHeadItem() 
	{
		return null;
	}

	@Override
	public String getIconSuffix(int arg0) 
	{
		return null;
	}

	@Override
	public String[] getTraits() {
		return new String[] {"armor"};
	}

//	@Override
//	public ResourceLocation getWearbleTexture(Entity arg0, ItemStack arg1,
//			int arg2) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	public int calcModifierDamage(int level, float typeMod, DamageSource source)
    {
        if (source.canHarmInCreative())
        {
            return 0;
        }
        else
        {
            float f = (float)(6 + level * level) / 3.0F;
            return MathHelper.floor_float(f * typeMod);
        }
    }

}
