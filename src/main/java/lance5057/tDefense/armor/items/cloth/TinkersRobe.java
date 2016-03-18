package lance5057.tDefense.armor.items.cloth;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.tools.CustomMaterial;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.parts.ClothMaterial;
import lance5057.tDefense.armor.renderers.cloth.ModelTinkersRobe;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TinkersRobe extends ArmorCore
{
	public TinkersRobe()
	{
		super(0, 2);
		this.setUnlocalizedName("tinkerrobe");
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
		return 2;
	}

	@Override
	public String getIconSuffix(int partType)
	{
		switch(partType)
		{
			case 0:
				return "_robe_cloth";
			case 1:
				return "_robe_cloth_broken";
			case 2:
				return "_robe_trim";
			default:
				return "";
		}
	}

	@Override
	public String getEffectSuffix()
	{
		return "_robe_effect";
	}

	@Override
	public String getDefaultFolder()
	{
		return "armor/robe";
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
		return "tinkersdefense:textures/armor/TinkersRobe.png";
	}

	@Override
	public String[] getTraits()
	{
		return new String[] {"armor", "pants", "robe", "cloth"};
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getModel(String[] color, NBTTagCompound tags)
	{
		String[] textures = {this.getIconSuffix(2), this.getIconSuffix(0)};

		int HeadID = tags.getCompoundTag("InfiTool").getInteger("RenderHead");
		int HandleID = tags.getCompoundTag("InfiTool").getInteger("RenderHandle");

		CustomMaterial newColor = TConstructRegistry.getCustomMaterial(HeadID, ClothMaterial.class);
		color[1] = Integer.toHexString(newColor.color);

		newColor = TConstructRegistry.getCustomMaterial(HandleID, ClothMaterial.class);
		color[0] = Integer.toHexString(newColor.color);

		return new ModelTinkersRobe(color, this.getDefaultFolder(), textures);
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
	{
		return 0;
	}
}
