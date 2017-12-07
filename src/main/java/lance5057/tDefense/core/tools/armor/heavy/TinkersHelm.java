//package lance5057.tDefense.armor.items.heavy;
//
//import lance5057.tDefense.TinkersDefense;
//import lance5057.tDefense.armor.ArmorCore;
//import lance5057.tDefense.armor.renderers.ArmorRenderer;
//import lance5057.tDefense.proxy.ClientProxy;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.EntityLivingBase;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.world.World;
//import tconstruct.tools.TinkerTools;
//import thaumcraft.api.IGoggles;
//import thaumcraft.api.nodes.IRevealer;
//import WayofTime.alchemicalWizardry.api.alchemy.energy.IAlchemyGoggles;
//import WayofTime.alchemicalWizardry.api.items.interfaces.ILPGauge;
//import cpw.mods.fml.common.Optional;
//
//@Optional.InterfaceList({@Optional.Interface(modid = "Thaumcraft", iface = "thaumcraft.api.IGoggles", striprefs = true), @Optional.Interface(modid = "Thaumcraft", iface = "thaumcraft.api.nodes.IRevealer", striprefs = true), @Optional.Interface(modid = "AWWayofTime", iface = "WayofTime.alchemicalWizardry.api.items.interfaces.ILPGauge", striprefs = true), @Optional.Interface(modid = "AWWayofTime", iface = "WayofTime.alchemicalWizardry.api.alchemy.energy.IAlchemyGoggles", striprefs = true)})
//public class TinkersHelm extends ArmorCore implements IRevealer, IGoggles, ILPGauge, IAlchemyGoggles
//{
//	public TinkersHelm()
//	{
//		super(2, 0);
//		setUnlocalizedName("tinkershelm");
//		maxReduction = 100;
//		reductionPercent = 3 * 0.04f;
//	}
//
//	@Override
//	public Item getHeadItem()
//	{
//		return TinkerTools.frypanHead;
//	}
//
//	@Override
//	public Item getHandleItem()
//	{
//		return TinkerTools.toughRod;
//	}
//
//	@Override
//	public Item getAccessoryItem()
//	{
//		return TinkersDefense.partArmorplate;
//	}
//
//	@Override
//	public Item getExtraItem()
//	{
//		return TinkersDefense.partChainmaille;
//	}
//
//	@Override
//	public int durabilityTypeAccessory()
//	{
//		return 2;
//	}
//
//	@Override
//	public float getRepairCost()
//	{
//		return 4.0f;
//	}
//
//	@Override
//	public float getDurabilityModifier()
//	{
//		return 2.5f;
//	}
//
//	@Override
//	public float getDamageModifier()
//	{
//		return 1.4f;
//	}
//
//	@Override
//	public int getPartAmount()
//	{
//		return 4;
//	}
//
//	@Override
//	public String getIconSuffix(int partType)
//	{
//		switch(partType)
//		{
//			case 0:
//				return "_helm_top";
//			case 1:
//				return "_helm_top_broken";
//			case 2:
//				return "_helm_chain";
//			case 3:
//				return "_helm_plate";
//			case 4:
//				return "_helm_visor";
//			default:
//				return "";
//		}
//	}
//
//	@Override
//	public String getEffectSuffix()
//	{
//		return "_helm_effect";
//	}
//
//	@Override
//	public String getDefaultFolder()
//	{
//		return "armor/helm";
//	}
//
//	//	@Override
//	//	public void onUpdate(ItemStack stack, World world, Entity entity, int par4,
//	//			boolean par5) {
//	//		super.onUpdate(stack, world, entity, par4, par5);
//	//
//	//	}
//
//	@Override
//	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
//	{
//		return "tinkersdefense:textures/armor/TinkersHelm.png";
//	}
//
//	@Override
//	public String[] getTraits()
//	{
//		return new String[] {"armor", "head", "helm", "heavyarmor"};
//	}
//
//	@Override
//	public ArmorRenderer getRenderer()
//	{
//		return ClientProxy.helm;
//	}
//
//	@Optional.Method(modid = "Thaumcraft")
//	@Override
//	public boolean showIngamePopups(ItemStack itemstack, EntityLivingBase player)
//	{
//		return itemstack.getTagCompound().getCompoundTag("InfiTool").getBoolean("Revealing");
//	}
//
//	@Optional.Method(modid = "Thaumcraft")
//	@Override
//	public boolean showNodes(ItemStack itemstack, EntityLivingBase player)
//	{
//		return itemstack.getTagCompound().getCompoundTag("InfiTool").getBoolean("Revealing");
//	}
//
//	@Optional.Method(modid = "AWWayofTime")
//	@Override
//	public boolean canSeeLPBar(ItemStack stack)
//	{
//		return stack.getTagCompound().getCompoundTag("InfiTool").getBoolean("Divination");
//	}
//
//	@Optional.Method(modid = "AWWayofTime")
//	@Override
//	public boolean showIngameHUD(World world, ItemStack stack, EntityPlayer player)
//	{
//		return stack.getTagCompound().getCompoundTag("InfiTool").getBoolean("Divination");
//	}
//}
