package lance5057.tDefense.core.tools;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.library.tools.AbilityHelper;
import tconstruct.library.tools.Weapon;
import tconstruct.tools.TinkerTools;
import buildcraft.api.tools.IToolWrench;

public class TinkerWrench extends Weapon implements IToolWrench {
	int induceDamage = 0;

	public TinkerWrench() {
		super(0);
		this.setUnlocalizedName("tinkerwrench");
	}

	@Override
	public Item getHeadItem() {
		return TinkerTools.handGuard;
	}

	@Override
	public Item getHandleItem() {
		return TinkerTools.toolRod;
	}

	@Override
	public Item getAccessoryItem() {
		return TinkerTools.binding;
	}

	@Override
	public int durabilityTypeAccessory() {
		return 2;
	}

	@Override
	public float getRepairCost() {
		return 1.0f;
	}

	@Override
	public float getDurabilityModifier() {
		return 0.1f;
	}

	@Override
	public float getDamageModifier() {
		return 0.4f;
	}

	@Override
	public int getPartAmount() {
		return 3;
	}

	@Override
	public String getIconSuffix(int partType) {
		switch (partType) {
		case 0:
			return "_wrench_head";
		case 1:
			return "_wrench_head_broken";
		case 2:
			return "_wrench_handle";
		case 3:
			return "_wrench_binding";
		default:
			return "";
		}
	}

	@Override
	public String getEffectSuffix() {
		return "_wrench_effect";
	}

	@Override
	public String getDefaultFolder() {
		return "wrench";
	}

	@Override
	public boolean canWrench(EntityPlayer player, int x, int y, int z) {
		NBTTagCompound tags = player.inventory.getCurrentItem()
				.getTagCompound().getCompoundTag("InfiTool");

		if (!tags.getBoolean("Broken")) {
			return true;
		}
		return false;
	}

	@Override
	public void wrenchUsed(EntityPlayer player, int x, int y, int z) {

		player.swingItem();
		AbilityHelper.damageTool(player.inventory.getCurrentItem(), 1, player,
				false);

	}
}