package lance5057.tDefense.armor.items.light;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.parts.ClothMaterial;
import lance5057.tDefense.proxy.ClientProxy;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.tools.CustomMaterial;
import tconstruct.tools.TinkerTools;
import thaumcraft.api.IGoggles;
import thaumcraft.api.nodes.IRevealer;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Optional.InterfaceList({@Optional.Interface(modid = "Thaumcraft", iface = "thaumcraft.api.IGoggles", striprefs = true), @Optional.Interface(modid = "Thaumcraft", iface = "thaumcraft.api.nodes.IRevealer", striprefs = true)})
public class TinkersCoif extends ArmorCore implements IRevealer, IGoggles
{
	public TinkersCoif()
	{
		super(1, 0);
		this.setUnlocalizedName("tinkerscoif");
		this.maxReduction = 100;
		this.reductionPercent = 0.08f;
	}

	@Override
	public Item getHeadItem()
	{
		return TinkersDefense.partChainmaille;
	}

	@Override
	public Item getHandleItem()
	{
		return TinkersDefense.partCloth;
	}

	@Override
	public Item getAccessoryItem()
	{
		return TinkerTools.toughRod;
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
				return "_coif_chain";
			case 1:
				return "_coif_chain_broken";
			case 2:
				return "_coif_cloth";
			case 3:
				return "_coif_circlet";
			default:
				return "";
		}
	}

	@Override
	public String getEffectSuffix()
	{
		return "_coif_effect";
	}

	@Override
	public String getDefaultFolder()
	{
		return "armor/coif";
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
		return "tinkersdefense:textures/armor/TinkersCoif.png";
	}

	@Override
	public String[] getTraits()
	{
		return new String[] {"armor", "head", "coif", "lightarmor"};
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
	{
		String[] color = new String[10];

		for(int j = 0; j < 10; j++)
			color[j] = Integer.toHexString(itemStack.getItem().getColorFromItemStack(itemStack, j));

		int AccessoryID = itemStack.getTagCompound().getCompoundTag("InfiTool").getInteger("RenderHandle");

		CustomMaterial newColor = TConstructRegistry.getCustomMaterial(AccessoryID, ClothMaterial.class);
		color[0] = Integer.toHexString(newColor.color);

		String[] textures = {this.getIconSuffix(2), this.getIconSuffix(0), this.getIconSuffix(3)};
		ClientProxy.coif.SetColors(color, this.getDefaultFolder(), textures);
		return ClientProxy.coif;
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
	{
		return 2;
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot)
	{
		ArmorProperties armorp = new ArmorProperties(0, 0.08, 100); //0.04 per half shirt
		//((EntityPlayer)player).addChatComponentMessage(new ChatComponentText(Double.toString(damage)));
		return armorp;
	}

	@Override
	@Optional.Method(modid = "Thaumcraft")
	public boolean showIngamePopups(ItemStack itemstack, EntityLivingBase player)
	{
		return itemstack.getTagCompound().getCompoundTag("InfiTool").getBoolean("Revealing");
	}

	@Override
	@Optional.Method(modid = "Thaumcraft")
	public boolean showNodes(ItemStack itemstack, EntityLivingBase player)
	{
		return itemstack.getTagCompound().getCompoundTag("InfiTool").getBoolean("Revealing");
	}
}
