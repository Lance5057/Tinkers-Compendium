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
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import scala.Int;
import tconstruct.library.accessory.IAccessoryModel;
import tconstruct.library.tools.ToolCore;

public class ArmorCore extends ToolCore implements ISpecialArmor//, IAccessoryModel
{
	int slot;
	public ModelBiped armorModel;
	
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
		ArmorProperties armorp = new ArmorProperties(0, 0.8, 100); //TODO figure this out
		((EntityPlayer)player).addChatComponentMessage(new ChatComponentText(Double.toString(damage)));
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
	
	public ModelBiped getModel(String[] color, NBTTagCompound tags)
	{
		return armorModel;
	}
	
	@Override
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity) 
	{
		return armorType == slot;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack,
			DamageSource source, int damage, int slot) {
		if (stack.hasTagCompound())
        {
            NBTTagCompound tags = stack.getTagCompound().getCompoundTag(getBaseTagName());
            if (!tags.getBoolean("Broken"))
            {
                int maxDurability = tags.getInteger("TotalDurability");
                int currentDurability = tags.getInteger("Damage");
                if (currentDurability + damage > maxDurability)
                {
                    tags.setInteger("Damage", 0);
                    tags.setBoolean("Broken", true);
                    stack.setItemDamage(0);
                    entity.worldObj.playSound(entity.posX, entity.posY, entity.posZ, "random.break", 1f, 1f, true);
                }
                else
                {
                    tags.setInteger("Damage", currentDurability + damage);
                    stack.setItemDamage(currentDurability + damage);
                }
            }
        }		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving,
			ItemStack itemStack, int armorSlot) 
	{
		if (itemStack != null) {

			if (armorModel != null) {
				armorModel.isSneak = entityLiving.isSneaking();
				armorModel.isRiding = entityLiving.isRiding();
				armorModel.isChild = entityLiving.isChild();
				armorModel.heldItemRight = entityLiving.getHeldItem() != null ? 1
						: 0;

				if (entityLiving instanceof EntityPlayer) {
					armorModel.aimedBow = ((EntityPlayer) entityLiving)
							.getItemInUseDuration() > 2;
				}
				return armorModel;
			}
		}
		return armorModel;
		//this.armor
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

}
