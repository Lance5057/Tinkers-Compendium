package lance5057.tDefense.core.tools;

import java.util.List;

import lance5057.tDefense.TinkersDefense;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import tconstruct.tools.TinkerTools;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HeaterShield extends Shield {
	int induceDamage = 0;

	public HeaterShield() {
		super(0);
		this.setUnlocalizedName("heatershield");
	}

	@Override
	public Item getHeadItem() {
		return TinkersDefense.partArmorplate;
	}

	@Override
	public Item getHandleItem() {
		return TinkerTools.toughRod;
	}

	@Override
	public Item getAccessoryItem() {
		return TinkersDefense.partArmorplate;
	}

	@Override
	public Item getExtraItem() {
		return TinkersDefense.partRivet;
	}

	@Override
	public int durabilityTypeAccessory() {
		return 2;
	}

	@Override
	public float getRepairCost() {
		return 4.0f;
	}

	@Override
	public float getDurabilityModifier() {
		return 2.5f;
	}

	@Override
	public float breakSpeedModifier() {
		return 0.4f;
	}

	@Override
	public float getDamageModifier() {
		return 1.4f;
	}

	@Override
	public int getPartAmount() {
		return 4;
	}

	@Override
	public String getIconSuffix(int partType) {
		switch (partType) {
		case 0:
			return "_shield_face";
		case 1:
			return "_shield_face_broken";
		case 2:
			return "_shield_edge";
		case 3:
			return "_shield_face_other";
		case 4:
			return "_shield_binding";
		default:
			return "";
		}
	}

	@Override
	public String getEffectSuffix() {
		return "_shield_effect";
	}

	@Override
	public String getDefaultFolder() {
		return "heatershield";
	}

	// /* tool_TinkerShield specific */
	// @Override
	// public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player,
	// Entity entity) {
	// if (AbilityHelper.onLeftClickEntity(stack, player, entity, this)) {
	// entity.hurtResistantTime += 7;
	// /*
	// * if (entity instanceof EntityLiving) { EntityLiving living =
	// * (EntityLiving) entity; if (living.getHealth() <= 0) {
	// *
	// * } }
	// */
	// // if (entity.getHealth() <= 0)
	// }
	// return true;
	// }

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4,
			boolean par5) {
		super.onUpdate(stack, world, entity, par4, par5);

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		NBTTagCompound tags = par1ItemStack.getTagCompound();
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
		par3List.add("");
		par3List.add(EnumChatFormatting.DARK_GREEN
				+ ItemStack.field_111284_a
						.format(1F / (10f / (tags.getCompoundTag("InfiTool")
								.getInteger("MiningSpeed") / 1.5f)) / 20F)
				+ StatCollector.translateToLocal("attribute.shield.block.time"));
		int arrowCount = getArrowCount(par1ItemStack);
		if (arrowCount > 0) {
			par3List.add(String.format("%s%s %s", EnumChatFormatting.GOLD,
					arrowCount, StatCollector
							.translateToLocal("attribute.shield.arrow.count")));
		}
	}

	@Override
	protected String getHarvestType() {
		return "shield";
	}
}