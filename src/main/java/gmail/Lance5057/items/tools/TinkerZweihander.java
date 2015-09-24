package gmail.Lance5057.items.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import tconstruct.library.tools.Weapon;
import tconstruct.tools.TinkerTools;

public class TinkerZweihander extends Weapon
{

	public TinkerZweihander(int baseDamage) {
		super(5);
        this.setUnlocalizedName("zweihander");
	}

	@Override
	public Item getHeadItem() {
		return TinkerTools.largeSwordBlade;
	}

	@Override
	public Item getHandleItem() {
		return TinkerTools.toughRod;
	}
	
	@Override
	public Item getAccessoryItem() {
		return TinkerTools.wideGuard;
	}
	
	@Override
	public Item getExtraItem() {
		return TinkerTools.swordBlade;
	}


//	@Override
//	public int durabilityTypeAccessory() {
//		return 2;
//	}
//	
//	@Override
//    public int durabilityTypeExtra ()
//    {
//        return 1;
//    }

	@Override
	public float getRepairCost() {
		return 4.0f;
	}

	@Override
	public float getDurabilityModifier() {
		return 2.5f;
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
			return "_zweihander_blade";
		case 1:
			return "_zweihander_blade_broken";
		case 2:
			return "_zweihander_handle";
		case 3:
			return "_zweihander_guard";
		case 4:
			return "_zweihander_core";
		default:
			return "";
		}
	}

	@Override
	public String getEffectSuffix() {
		return "_zweihander_effect";
	}

	@Override
	public String getDefaultFolder() {
		return "zweihander";
	}
}
