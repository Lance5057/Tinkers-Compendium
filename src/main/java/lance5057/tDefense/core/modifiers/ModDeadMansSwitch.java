package lance5057.tDefense.core.modifiers;

import lance5057.tDefense.core.library.modifiers.ModifierTDTrait;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class ModDeadMansSwitch extends ModifierTDTrait {

	public ModDeadMansSwitch() {
		super("deadmansswitch", TextFormatting.RED.getColorIndex());
	}

	@Override
	public void onDeath(LivingDeathEvent e) {
		boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(e.getEntityLiving().world, e.getEntityLiving());
		
		e.getEntityLiving().world.createExplosion(e.getEntityLiving(), e.getEntityLiving().posX, e.getEntityLiving().posY, e.getEntityLiving().posZ, 3, flag);
	}
}
