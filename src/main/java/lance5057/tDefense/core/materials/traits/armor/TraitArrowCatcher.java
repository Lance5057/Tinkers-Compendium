package lance5057.tDefense.core.materials.traits.armor;

import lance5057.tDefense.core.materials.traits.AbstractTDTrait;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.tools.TinkerTools;
import slimeknights.tconstruct.tools.common.entity.EntityArrow;

public class TraitArrowCatcher extends AbstractTDTrait {

	public TraitArrowCatcher() {
		super("arrowcatcher", TextFormatting.WHITE);
	}

	@Override
	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {
		if (e.getSource().getImmediateSource() instanceof EntityArrow) {
			if (e.getEntityLiving() instanceof EntityPlayer) {
				EntityPlayer p = (EntityPlayer) e.getEntityLiving();
				if (p.world.rand.nextInt(100) < 20 && e.getSource().getTrueSource() != p) {
					EntityArrow arrow = (EntityArrow) e.getSource().getImmediateSource();
					ItemStack stack = arrow.tinkerProjectile.getItemStack();

					NBTTagList mats = TagUtil.getBaseMaterialsTagList(stack);
					ItemStack head = TinkerTools.arrowHead
							.getItemstackWithMaterial(TinkerRegistry.getMaterial(mats.getStringTagAt(0)));

					p.addItemStackToInventory(head);
				}
			}
		}
	}
}
