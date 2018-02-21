package lance5057.tDefense.core.tools.armor.straps;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class ItemStraps extends ItemArmor implements ISpecialArmor
{
	public static ArmorMaterial ARMOR = EnumHelper.addArmorMaterial("NAME", "blank", 0, new int[] {0, 0, 0, 0}, 0, null, 0);
	
	public EntityEquipmentSlot equipSlot;
	
	@SideOnly(Side.CLIENT)
	private ModelBiped model;
	
	private ItemStack stack;
	
	public ItemStraps(EntityEquipmentSlot slot)
	{
		super(ARMOR, 0, slot);
		// ItemStacks that store an NBT Tag Compound are limited to stack size
		// of 1
		setMaxStackSize(1);
		// you'll want to set a creative tab as well, so you can get your item
		setCreativeTab(TinkersDefense.tab);
		this.setRegistryName("straps" + slot.getName()).setUnlocalizedName("straps" + slot.getName());
	}
	
	@Override
	@Nullable
	@SideOnly(Side.CLIENT)
	public final String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
	{
//		ItemStack in = stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).getStackInSlot(0);
//		if(in.getItem() instanceof ArmorCore)
//		{
//			return ((ArmorCore)in.getItem()).getArmorTexture(stack, 0);
//		}
		return null;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    @Nullable
    public net.minecraft.client.model.ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, net.minecraft.client.model.ModelBiped _default)
    {
		ItemStack in = itemStack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).getStackInSlot(0);
		if(in.getItem() instanceof ArmorCore)
		{
			if(model == null || stack == null || !stack.equals(in))
			{
				model = ((ArmorCore)in.getItem()).getArmorModel(in);
				stack = in;
			}
			return model;
		}
		return null;
    }

	@Nonnull
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound oldCapNbt)
	{
		return new InvProvider();
	}

	private static class InvProvider implements ICapabilitySerializable<NBTBase> {

		private final IItemHandler inv = new ItemStackHandler(1);

		@Override
		public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
			return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
		}

		@Override
		public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
			if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
				return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(inv);
			else return null;
		}

		@Override
		public NBTBase serializeNBT() {
			return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.writeNBT(inv, null);
		}

		@Override
		public void deserializeNBT(NBTBase nbt) {
			CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.readNBT(inv, null, nbt);
		}
	}
	
	// Without this method, your inventory will NOT work!!!
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return 1; // return any value greater than zero
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
		if (!worldIn.isRemote)
		{
			// If player not sneaking, open the inventory gui
			if (!playerIn.isSneaking())
			{
				playerIn.openGui(TinkersDefense.instance, TinkersDefense.GUI_STRAPS_INV, worldIn, 0, 0, 0);
			}
		}

		return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
	{
		ItemStack in = armor.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).getStackInSlot(0);
		if(in.getItem() instanceof ArmorCore)
		{
			int i = ((ArmorCore)in.getItem()).getArmorDisplay(in);
			return i;
		}
		return 0;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot)
	{
		stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).getStackInSlot(0).damageItem(damage, entity);
	}
}