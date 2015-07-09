package gmail.Lance5057.armor.items;

import gmail.Lance5057.TinkersDefense;
import gmail.Lance5057.proxy.ClientProxy;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ChainArmor extends ItemArmor {
	public ChainArmor(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par2EnumArmorMaterial, par3, par4);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		String itemName = "tinkersdefense:textures/armor/ChainArmor";
		this.itemIcon = par1IconRegister.registerIcon(itemName);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {
		return "tinkersdefense:textures/armor/ChainArmor.png";
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving,
			ItemStack itemStack, int armorSlot) 
	{
		
//		return ClientProxy.chain;
		ModelBiped armorModel = ClientProxy.chain;
		if (itemStack != null) {
//			if (itemStack.getItem() instanceof TinkerArmor) {
//				int type = ((ItemArmor) itemStack.getItem()).armorType;
//				if (type == 1 || type == 3) {
//					armorModel = TinkersDefense.proxy.getArmorModel(0);
//				} else {
//					armorModel = TinkersDefense.proxy.getArmorModel(1);
//				}
//
//			}
			if (armorModel != null) {
//				armorModel.bipedHead.showModel = armorSlot == 0;
//				armorModel.bipedHeadwear.showModel = armorSlot == 0;
//				armorModel.bipedBody.showModel = armorSlot == 1
//						|| armorSlot == 2;
//				armorModel.bipedRightArm.showModel = armorSlot == 1;
//				armorModel.bipedLeftArm.showModel = armorSlot == 1;
//				armorModel.bipedRightLeg.showModel = armorSlot == 2
//						|| armorSlot == 3;
//				armorModel.bipedLeftLeg.showModel = armorSlot == 2
//						|| armorSlot == 3;
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
	}

}