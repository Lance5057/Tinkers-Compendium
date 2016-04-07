package lance5057.tDefense.armor.items;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.parts.ClothMaterial;
import lance5057.tDefense.armor.renderers.ModelSheath;
import lance5057.tDefense.proxy.ClientProxy;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.accessory.IAccessory;
import tconstruct.library.accessory.IAccessoryModel;
import tconstruct.library.tools.ToolCore;
import tconstruct.tools.TinkerTools;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Sheath extends ToolCore implements IAccessory
{

	public Sheath()
	{
		super(0);
	}

	@Override
	public boolean canEquipAccessory(ItemStack item, int slot)
	{
		return slot == 3;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
	{
		String[] color = new String[10];

		for(int j = 0; j < 10; j++)
			color[j] = Integer.toHexString(itemStack.getItem().getColorFromItemStack(itemStack, j));
		
		int HandleID = itemStack.getTagCompound().getCompoundTag("InfiTool").getInteger("RenderExtra");
		
		color[3] = Integer.toHexString(TConstructRegistry.getCustomMaterial(HandleID, ClothMaterial.class).color);

		String[] textures = {this.getIconSuffix(2), this.getIconSuffix(0), this.getIconSuffix(4), this.getIconSuffix(3)};

		ClientProxy.sheath.SetColors(color, this.getDefaultFolder(), textures);
		return ClientProxy.sheath;
	}

	@Override
	public Item getHeadItem()
	{
		return TinkersDefense.partArmorplate;
	}

	@Override
	public Item getHandleItem()
	{
		return TinkerTools.toolRod;
	}

	@Override
	public Item getAccessoryItem()
	{
		return TinkersDefense.partClasp;
	}

	@Override
	public Item getExtraItem()
	{
		return TinkersDefense.partCloth;
	}

	@Override
	public String getDefaultFolder()
	{
		// TODO Auto-generated method stub
		return "Armor/Sheath";
	}

	@Override
	public String getEffectSuffix()
	{
		return "_sheath_effect";
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getPartAmount()
	{
		return 4;
	}

	@Override
	public String getIconSuffix(int partType)
	{
		switch(partType)
		{
			case 0:
				return "_sheath_base";
			case 1:
				return "_shield_base_broken"; //useless
			case 2:
				return "_sheath_filigree";
			case 3:
				return "_sheath_belt";
			case 4:
				return "_sheath_clasp";
			default:
				return "";
		}
	}

	@Override
	public String[] getTraits()
	{
		return new String[] {"sheath", "cosmetic"};
	}

}
