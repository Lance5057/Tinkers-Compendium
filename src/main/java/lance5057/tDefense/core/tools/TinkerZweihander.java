package lance5057.tDefense.core.tools;

import java.util.List;

import mods.battlegear2.api.PlayerEventChild;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import tconstruct.library.tools.Weapon;
import tconstruct.tools.TinkerTools;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Optional.InterfaceList({
    @Optional.Interface(modid = "battlegear2", iface = "mods.battlegear2.api.weapons.IBattlegearWeapon"),
})

public class TinkerZweihander extends Weapon {

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

	@Override
    public ItemStack onItemRightClick (ItemStack stack, World world, EntityPlayer player)
    {
		if(!player.isPotionActive(Potion.moveSlowdown))
		{
			List entities = player.worldObj.getEntitiesWithinAABBExcludingEntity(player, AxisAlignedBB.getBoundingBox(player.posX - 2, player.posY - 2, player.posZ - 2, player.posX + 2, player.posY + 2, player.posZ + 2));
	        
			for(int i = 0; i<entities.size(); i++)
			{
				if(((Entity)entities.get(i)) instanceof EntityLivingBase)
				{
					player.attackTargetEntityWithCurrentItem((Entity) entities.get(i));
					player.worldObj.spawnParticle("largeexplode", ((Entity)entities.get(i)).posX, ((Entity)entities.get(i)).posY + (((Entity)entities.get(i)).height/2), ((Entity)entities.get(i)).posZ, 0, 0, 0);
					player.worldObj.playSoundAtEntity((Entity) entities.get(i), "mob.zombie.metal", 15f, 1f);
				}
			}
			player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20, 3));
			player.addPotionEffect(new PotionEffect(Potion.weakness.id, 200, 1));
		}
		
		return stack;
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
	
//	@Override
//	@SideOnly(Side.CLIENT)
//	public void onUpdate(ItemStack stack, World world, Entity entity, int par4,
//			boolean par5) {
//		super.onUpdate(stack, world, entity, par4, par5);
//		if (entity instanceof EntityPlayerSP) {
//			EntityPlayerSP player = (EntityPlayerSP) entity;
//			ItemStack usingItem = player.inventory.getCurrentItem();
//			if (usingItem != null && usingItem.getItem() == this) {
//				player.addPotionEffect(new PotionEffect(Potion.resistance.getId(),2,1));
//				
//			}
//		}
//	}

	@Override
    @Optional.Method(modid = "battlegear2")
    public boolean isOffhandHandDual(ItemStack off) {
        return false;
    }
	
    @Override
    @Optional.Method(modid = "battlegear2")
    public boolean offhandAttackEntity(PlayerEventChild.OffhandAttackEvent event, ItemStack mainhandItem, ItemStack offhandItem) {
        return false;
    }
    
    @Override
    @Optional.Method(modid = "battlegear2")
    public boolean allowOffhand(ItemStack mainhand, ItemStack offhand) {
    	return false;
    }
}
