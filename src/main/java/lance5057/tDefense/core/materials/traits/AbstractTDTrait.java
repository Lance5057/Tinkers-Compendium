package lance5057.tDefense.core.materials.traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogDensity;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public abstract class AbstractTDTrait extends AbstractTrait {
	public AbstractTDTrait() 
	{
		super("", 0x000000);
	}
	
	public AbstractTDTrait(String identifier, TextFormatting color) {
		super("td_"+identifier, color);
	}

	public AbstractTDTrait(String identifier, int color) {
		super("td_"+identifier, color);
	}

	public void onArmorEquip(EntityPlayer e) {

	}

	public void onArmorUnequip(EntityPlayer e) {

	}

	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {
	}

	public void onFoodEaten(LivingEntityUseItemEvent.Finish e) {

	}

	public void onDamagePre(ItemStack tool, LivingAttackEvent e) {

	}

	public void onItemPickup(EntityItemPickupEvent e) {

	}

	public void onDeath(LivingDeathEvent e) {

	}
	
	public void onJump(LivingJumpEvent e)
	{
		
	}
	
	@SideOnly(Side.CLIENT)
	public void alterFogDensity(FogDensity event)
	{
		
	}

	@SideOnly(Side.CLIENT)
	public void renderHUD(RenderGameOverlayEvent.Post e)
	{
		
	}
}
