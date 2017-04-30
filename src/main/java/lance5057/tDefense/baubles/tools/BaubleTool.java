package lance5057.tDefense.baubles.tools;

import java.util.List;

import javax.annotation.Nullable;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import baubles.api.render.IRenderBauble;
import lance5057.tDefense.core.materials.ShieldMaterialStats;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.client.model.ToolModelLoader;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.tools.TinkerTools;

//@Optional.InterfaceList({@Optional.Interface(modid = "battlegear2", iface = "mods.battlegear2.api.ISheathed"), @Optional.Interface(modid = "battlegear2", iface = "mods.battlegear2.api.shield.IArrowCatcher"), @Optional.Interface(modid = "battlegear2", iface = "mods.battlegear2.api.shield.IArrowDisplay"), @Optional.Interface(modid = "battlegear2", iface = "mods.battlegear2.api.shield.IShield")})
public abstract class BaubleTool extends ToolCore implements IBauble, IRenderBauble
{
	//protected static PartMaterialType ShieldMat = new PartMaterialType(TinkerTools.largePlate, ShieldMaterialStats.TYPE);
	
	public BaubleTool(PartMaterialType... requiredComponents)
	{
		super(requiredComponents);
		
//		this.addPropertyOverride(new ResourceLocation("block"), new IItemPropertyGetter()
//        {
//            @SideOnly(Side.CLIENT)
//            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
//            {
//            	float i = entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
//                return i;
//            }
//        });
	}

	protected float baseSpeed()
	{
		return 1.5f;
	}

	protected float effectiveSpeed()
	{
		return 15f;
	}

	public float breakSpeedModifier()
	{
		return 1.0f;
	}

//	@Override
//	public float getDigSpeed(ItemStack stack, Block block, int meta)
//	{
//		return 0.0f;
//	}

	/**
	 * returns the action that specifies what animation to play when the items
	 * is being used
	 */
//	@Override
//	public EnumAction getItemUseAction(ItemStack par1ItemStack)
//	{
//		return EnumAction.BLOCK;
//	}
	
//	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
//    {
//        playerIn.setActiveHand(hand);
//        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
//    }
//	
//	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
//    {
//        return super.onItemUse(stack, playerIn, worldIn, pos, hand, facing, hitX, hitY, hitZ);
//    }

	/**
	 * How long it takes to use or consume an item
	 */
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 72000;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
	{
//		super.onUpdate(stack, world, entity, par4, par5);
//		if(entity instanceof EntityPlayerSP)
//		{
//			final EntityPlayerSP player = (EntityPlayerSP) entity;
//			final ItemStack usingItem = player.getActiveItemStack();
//			if(usingItem != null && usingItem.getItem() == this)
//			{
//				player.movementInput.moveForward *= 2.5F;
//				player.movementInput.moveStrafe *= 2.5F;
//			}
//		}
	}

	protected String getHarvestType()
	{
		return null;
	}

	@Override
	public float damagePotential() {
		// TODO Auto-generated method stub
		return 0.1f;
	}

	@Override
	public double attackSpeed() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public NBTTagCompound buildTag(
			List<slimeknights.tconstruct.library.materials.Material> materials) {
		ToolNBT data = buildDefaultTag(materials);
		return data.get();
	}
}
