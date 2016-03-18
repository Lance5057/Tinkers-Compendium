package lance5057.tDefense.armor.items;

import lance5057.tDefense.armor.renderers.ModelSheath;
import lance5057.tDefense.armor.renderers.ModelMask;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import tconstruct.library.accessory.IAccessory;
import tconstruct.library.accessory.IAccessoryModel;
import tconstruct.library.tools.ToolCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Mask extends ToolCore implements IAccessoryModel, IAccessory
{

	public Mask()
	{
		super(0);
	}

	@Override
	public boolean canEquipAccessory(ItemStack item, int slot)
	{
		return slot == 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
	{
		String color[] = new String[10];

		for(int i = 0; i < 10; i++)
			color[i] = Integer.toHexString(this.getColorFromItemStack(itemStack, i));

		return new ModelMask(color);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return "tinkersdefense:textures/armor/Mask/_mask_face.png";
	}

	ResourceLocation	texture	= new ResourceLocation("tinkersdefense", "textures/armor/Mask/_mask_face.png");

	@Override
	@SideOnly(Side.CLIENT)
	public ResourceLocation getWearbleTexture(Entity entity, ItemStack stack, int slot)
	{
		return texture;
	}

	@Override
	public Item getAccessoryItem()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDefaultFolder()
	{
		// TODO Auto-generated method stub
		return "Armor/Mask";
	}

	@Override
	public String getEffectSuffix()
	{
		return "_mask_effect";
	}

	@Override
	public Item getHeadItem()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getPartAmount()
	{
		return 3;
	}

	@Override
	public String getIconSuffix(int partType)
	{
		switch(partType)
		{
			case 0:
				return "_mask_face";
			case 1:
				return "hurdur"; //useless
			case 2:
				return "_mask_clasp";
			case 3:
				return "_mask_strap";
			default:
				return "";
		}
	}

	@Override
	public String[] getTraits()
	{
		return new String[] {"mask", "cosmetic"};
	}

}
