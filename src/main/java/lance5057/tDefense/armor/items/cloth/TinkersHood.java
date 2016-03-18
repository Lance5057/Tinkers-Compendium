package lance5057.tDefense.armor.items.cloth;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.parts.ClothMaterial;
import lance5057.tDefense.armor.renderers.cloth.ModelTinkersHood;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.tools.CustomMaterial;

public class TinkersHood extends ArmorCore
{
	public TinkersHood()
	{
		super(0, 0);
		this.setUnlocalizedName("tinkershood");
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
		return TinkersDefense.partRivet;
	}

	@Override
	public int durabilityTypeAccessory()
	{
		return 1;
	}

	@Override
	public float getRepairCost()
	{
		return 1.0f;
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
				return "_hood_cloth";
			case 1:
				return "_hood_cloth_broken";
			case 2:
				return "_hood_trim";
			case 3:
				return "_hood_rivet";
			default:
				return "";
		}
	}

	@Override
	public String getEffectSuffix()
	{
		return "_hood_effect";
	}

	@Override
	public String getDefaultFolder()
	{
		return "armor/hood";
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
		return "tinkersdefense:textures/armor/TinkersHood.png";
	}

	@Override
	public String[] getTraits()
	{
		return new String[] {"armor", "helmet", "hood", "cloth"};
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getModel(String[] color, NBTTagCompound tags)
	{
		String[] textures = {this.getIconSuffix(2), this.getIconSuffix(0), this.getIconSuffix(3)};

		int HeadID = tags.getCompoundTag("InfiTool").getInteger("RenderHead");
		int HandleID = tags.getCompoundTag("InfiTool").getInteger("RenderHandle");

		CustomMaterial newColor = TConstructRegistry.getCustomMaterial(HeadID, ClothMaterial.class);
		color[1] = Integer.toHexString(newColor.color);

		newColor = TConstructRegistry.getCustomMaterial(HandleID, ClothMaterial.class);
		color[0] = Integer.toHexString(newColor.color);

		return new ModelTinkersHood(color, this.getDefaultFolder(), textures);
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
	{
		return 0;
	}
}
