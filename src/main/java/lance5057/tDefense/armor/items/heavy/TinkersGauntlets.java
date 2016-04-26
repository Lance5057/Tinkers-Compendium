package lance5057.tDefense.armor.items.heavy;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import tconstruct.library.accessory.IAccessory;
import tconstruct.library.accessory.IAccessoryModel;
import tconstruct.library.tools.ToolCore;
import tconstruct.tools.TinkerTools;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TinkersGauntlets extends ArmorCore implements IAccessory
{
	public TinkersGauntlets()
	{
		super(0,-1);
		this.setUnlocalizedName("tinkersgauntlets");
	}

	@Override
	public boolean canEquipAccessory(ItemStack item, int slot)
	{
		return slot == 1;
	}

	@Override
	public Item getHeadItem()
	{
		return TinkersDefense.partArmorplate;
	}

	@Override
	public Item getHandleItem()
	{
		return TinkerTools.toughRod;
	}

	@Override
	public Item getAccessoryItem()
	{
		return TinkersDefense.partRivet;
	}

	@Override
	public int durabilityTypeAccessory()
	{
		return 2;
	}

	@Override
	public float getRepairCost()
	{
		return 1.0f;
	}

	@Override
	public float getDurabilityModifier()
	{
		return 2.5f;
	}

	@Override
	public float getDamageModifier()
	{
		return 0f;
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
				return "_gauntlet_plate";
			case 1:
				return "_gauntlet_plate_broken";
			case 2:
				return "_gauntlet_trim";
			case 3:
				return "_gauntlet_rivet";
			default:
				return "";
		}
	}

	@Override
	public String getEffectSuffix()
	{
		return "_gauntlet_effect";
	}

	@Override
	public String getDefaultFolder()
	{
		return "armor/gauntlets";
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
		return "tinkersdefense:textures/armor/Tinkersgauntlet.png";
	}

	@Override
	public String[] getTraits()
	{
		return new String[] {"hands", "gauntlet"};
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
	{
		String[] color = new String[10];

		for(int j = 0; j < 10; j++)
			color[j] = Integer.toHexString(itemStack.getItem().getColorFromItemStack(itemStack, j));

		//String[] textures = {this.getIconSuffix(2), this.getIconSuffix(0), this.getIconSuffix(3)};
		
		ClientProxy.gauntlets.SetColors(color, this.getDefaultFolder(), itemStack);
		return ClientProxy.gauntlets;
	}
}
