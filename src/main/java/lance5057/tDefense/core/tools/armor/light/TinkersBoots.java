//package lance5057.tDefense.armor.items.light;
//
//import lance5057.tDefense.TinkersDefense;
//import lance5057.tDefense.armor.ArmorCore;
//import lance5057.tDefense.armor.renderers.ArmorRenderer;
//import lance5057.tDefense.proxy.ClientProxy;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//
//public class TinkersBoots extends ArmorCore
//{
//	public TinkersBoots()
//	{
//		super(1, 3);
//		setUnlocalizedName("tinkersboots");
//		maxReduction = 100;
//		reductionPercent = 0.08f;
//	}
//
//	@Override
//	public Item getHeadItem()
//	{
//		return TinkersDefense.partChainmaille;
//	}
//
//	@Override
//	public Item getHandleItem()
//	{
//		return TinkersDefense.partCloth;
//	}
//
//	@Override
//	public Item getAccessoryItem()
//	{
//		return TinkersDefense.partRivet;
//	}
//
//	@Override
//	public int durabilityTypeAccessory()
//	{
//		return 1;
//	}
//
//	@Override
//	public float getRepairCost()
//	{
//		return 1.0f;
//	}
//
//	@Override
//	public float getDurabilityModifier()
//	{
//		return 1f;
//	}
//
//	@Override
//	public float getDamageModifier()
//	{
//		return 1f;
//	}
//
//	@Override
//	public int getPartAmount()
//	{
//		return 3;
//	}
//
//	@Override
//	public String getIconSuffix(int partType)
//	{
//		switch(partType)
//		{
//			case 0:
//				return "_boots_chain";
//			case 1:
//				return "_boots_chain_broken";
//			case 2:
//				return "_boots_cloth";
//			case 3:
//				return "_boots_rivet";
//			default:
//				return "";
//		}
//	}
//
//	@Override
//	public String getEffectSuffix()
//	{
//		return "_boots_effect";
//	}
//
//	@Override
//	public String getDefaultFolder()
//	{
//		return "armor/boots";
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
//		return "tinkersdefense:textures/armor/TinkersBoots.png";
//	}
//
//	@Override
//	public String[] getTraits()
//	{
//		return new String[] {"armor", "feet", "boots", "lightarmor"};
//	}
//
//	@Override
//	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
//	{
//		return 2;
//	}
//
//	@Override
//	public ArmorRenderer getRenderer()
//	{
//		return ClientProxy.boots;
//	}
//}
