package lance5057.tDefense.armor.items.heavy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersBreastplate;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersHelm;
import lance5057.tDefense.proxy.ClientProxy;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
import tconstruct.tools.TinkerTools;

public class TinkersBreastplate extends ArmorCore
{
	public TinkersBreastplate()
	{
		super(2, 1);
		this.setUnlocalizedName("tinkersbreastplate");
		this.maxReduction = 100;
		reductionPercent = 8 * 0.04f;
	}

	@Override
	public Item getHeadItem()
	{
		return TinkerTools.largePlate;
	}

	@Override
	public Item getHandleItem()
	{
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
		return TinkersDefense.partChainmaille;
	}

	@Override
	public int durabilityTypeAccessory()
	{
		return 2;
	}

	@Override
	public float getRepairCost()
	{
		return 4.0f;
	}

	@Override
	public float getDurabilityModifier()
	{
		return 2.5f;
	}

	@Override
	public float getDamageModifier()
	{
		return 1.4f;
	}

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
				return "_breastplate_plate";
			case 1:
				return "_breastplate_plate_broken";
			case 2:
				return "_breastplate_trim";
			case 3:
				return "_breastplate_smallplate";
			case 4:
				return "_breastplate_chain";
			default:
				return "";
		}
	}

	@Override
	public String getEffectSuffix()
	{
		return "_breastplate_effect";
	}

	@Override
	public String getDefaultFolder()
	{
		return "armor/breastplate";
	}

	// @Override
	// public void onUpdate(ItemStack stack, World world, Entity entity, int
	// par4,
	// boolean par5) {
	// super.onUpdate(stack, world, entity, par4, par5);
	//
	// }

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return "tinkersdefense:textures/armor/Tinkersbreastplate.png";
	}

	@Override
	public String[] getTraits()
	{
		return new String[] {"armor", "chest", "breastplate", "heavyarmor"};
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
	{
		String[] color = new String[10];

		for(int j = 0; j < 10; j++)
			color[j] = Integer.toHexString(itemStack.getItem().getColorFromItemStack(itemStack, j));

		//String[] textures = {this.getIconSuffix(2), this.getIconSuffix(0), this.getIconSuffix(3), this.getIconSuffix(4)};
		ClientProxy.breastplate.SetColors(color, this.getDefaultFolder(), itemStack);
		return ClientProxy.breastplate;
	}
}
