package lance5057.tDefense.core.materials.traits;

import lance5057.tDefense.TD_Config;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.utils.TagUtil;

public class TraitMagnetism extends AbstractTDTrait {

	public TraitMagnetism() {
		super("magnetism", TextFormatting.GRAY);
	}

	@Override
	public void onBlock(ItemStack tool, EntityPlayer player, LivingHurtEvent event) {
		Magnetism(tool, event);
	}

	@Override
	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {
		Magnetism(tool, e);
	}

	void Magnetism(ItemStack tool, LivingHurtEvent e) {
		Entity ent = e.getSource().getTrueSource();
		if (ent instanceof EntityLivingBase) {
			EntityLivingBase entLiv = (EntityLivingBase) ent;
			ItemStack i = entLiv.getHeldItemMainhand();

			if (i.getItem() instanceof ToolCore || i.getItem() instanceof ArmorCore) {
				NBTTagList tag = TagUtil.getBaseMaterialsTagList(i);
				boolean isMagnetic = false;
				for (NBTBase s : tag) {
					if (TD_Config.Traits.isMetal(((NBTTagString) s).getString()))
						isMagnetic = true;
				}
				if (isMagnetic) {
					if (i.getItem() instanceof ToolCore) {
						int chance = entLiv.world.rand.nextInt(100);
						if (entLiv instanceof EntityPlayer && chance < 5) {
							entLiv.entityDropItem(i.copy(), 0);
							entLiv.setHeldItem(entLiv.getActiveHand(), new ItemStack(Items.AIR));
						}
						else if(chance < 15)
						{
							entLiv.entityDropItem(i.copy(), 0);
							entLiv.setHeldItem(entLiv.getActiveHand(), new ItemStack(Items.AIR));
						}
					}
				}
			}
		}
	}
}
