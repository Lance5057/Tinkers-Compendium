package lance5057.tDefense.armor.items.cloth;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.parts.ClothMaterial;
import lance5057.tDefense.armor.renderers.cloth.ModelTinkersShawl;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersHelm;
import lance5057.tDefense.proxy.ClientProxy;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.tools.CustomMaterial;
import tconstruct.tools.TinkerTools;
import thaumcraft.api.IVisDiscountGear;
import thaumcraft.api.aspects.Aspect;

public class TinkersShawl extends ArmorCore implements IVisDiscountGear
{
	public TinkersShawl()
	{
		super(0, 1);
		this.setUnlocalizedName("tinkersshawl");
	}

	@Override
	public Item getHeadItem()
	{
		return TinkersDefense.partCloth;
	}

	@Override
	public Item getHandleItem()
	{
		return TinkersDefense.partCloth;
	}

	@Override
	public Item getAccessoryItem()
	{
		return TinkersDefense.partClasp;
	}

	@Override
	public int durabilityTypeAccessory()
	{
		return 1;
	}

	@Override
	public float getRepairCost()
	{
		return 1f;
	}

	@Override
	public float getDurabilityModifier()
	{
		return 1f;
	}

	@Override
	public float getDamageModifier()
	{
		return 1f;
	}

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
				return "_shawl_cloth";
			case 1:
				return "_shawl_cloth_broken";
			case 2:
				return "_shawl_trim";
			case 3:
				return "_shawl_clasp";
			default:
				return "";
		}
	}

	@Override
	public String getEffectSuffix()
	{
		return "_shawl_effect";
	}

	@Override
	public String getDefaultFolder()
	{
		return "armor/shawl";
	}

	//	@Override
	//	public void onUpdate(ItemStack stack, World world, Entity entity, int par4,
	//			boolean par5) {
	//		super.onUpdate(stack, world, entity, par4, par5);
	//
	//	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return "tinkersdefense:textures/armor/TinkersShawl.png";
	}

	@Override
	public String[] getTraits()
	{
		return new String[] {"armor", "chest", "shawl", "cloth"};
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
	{
		String[] color = new String[10];
		String[] textures = {this.getIconSuffix(2), this.getIconSuffix(0), this.getIconSuffix(3)};

		for(int j = 0; j < 10; j++)
			color[j] = Integer.toHexString(itemStack.getItem().getColorFromItemStack(itemStack, j));

		int HeadID = itemStack.getTagCompound().getCompoundTag("InfiTool").getInteger("RenderHead");
		int HandleID = itemStack.getTagCompound().getCompoundTag("InfiTool").getInteger("RenderHandle");

		CustomMaterial newColor = TConstructRegistry.getCustomMaterial(HeadID, ClothMaterial.class);
		color[1] = Integer.toHexString(newColor.color);

		newColor = TConstructRegistry.getCustomMaterial(HandleID, ClothMaterial.class);
		color[0] = Integer.toHexString(newColor.color);

		ClientProxy.shawl.SetColors(color, this.getDefaultFolder(), textures);
		return ClientProxy.shawl;
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
	{
		return 0;
	}

	@Override
	public int getVisDiscount(ItemStack stack, EntityPlayer player, Aspect aspect)
	{
		int test = stack.getTagCompound().getCompoundTag("InfiTool").getInteger("VisEmbroidery");
		return test;
	}
}
