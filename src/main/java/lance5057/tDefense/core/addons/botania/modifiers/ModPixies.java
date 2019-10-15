package lance5057.tDefense.core.addons.botania.modifiers;

import baubles.api.BaublesApi;
import lance5057.tDefense.core.library.modifiers.ModifierTDTrait;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.items.IItemHandler;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import vazkii.botania.api.item.IPixieSpawner;
import vazkii.botania.common.core.helper.PlayerHelper;
import vazkii.botania.common.entity.EntityPixie;
import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.item.equipment.armor.elementium.ItemElementiumHelm;

public class ModPixies extends ModifierTDTrait {

	public ModPixies() {
		super("mana", 0x5555FF);
	}
	
	private static final Potion[] potions = {
			MobEffects.BLINDNESS,
			MobEffects.WITHER,
			MobEffects.SLOWNESS,
			MobEffects.WEAKNESS
	};

	@Override
	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {
		if(!e.getEntityLiving().world.isRemote && e.getEntityLiving() instanceof EntityPlayer && e.getSource().getTrueSource() instanceof EntityLivingBase) {
			EntityPlayer player = (EntityPlayer) e.getEntityLiving();
			ItemStack stack = PlayerHelper.getFirstHeldItemClass(player, IPixieSpawner.class);

			float chance = getChance(stack);
			for (ItemStack element : player.inventory.armorInventory)
				chance += getChance(element);

			IItemHandler baubles = BaublesApi.getBaublesHandler(player);
			for(int i = 0; i < baubles.getSlots(); i++)
				chance += getChance(baubles.getStackInSlot(i));

			if(Math.random() < chance) {
				EntityPixie pixie = new EntityPixie(player.world);
				pixie.setPosition(player.posX, player.posY + 2, player.posZ);

//				if(((ItemElementiumHelm) ModItems.elementiumHelm).hasArmorSet(player)) { //TODO: include tcom armor
//					pixie.setApplyPotionEffect(new PotionEffect(potions[e.getEntityLiving().world.rand.nextInt(potions.length)], 40, 0));
//				}

				float dmg = 4;
				if(!stack.isEmpty() && stack.getItem() == ModItems.elementiumSword)
					dmg += 2;

				pixie.setProps((EntityLivingBase) e.getSource().getTrueSource(), player, 0, dmg);
				pixie.onInitialSpawn(player.world.getDifficultyForLocation(new BlockPos(pixie)), null);
				player.world.spawnEntity(pixie);
			}
		}
	}

	@Override
	protected ModifierAspect[] getAspects() {
		return new ModifierAspect[] { ModifierAspect.freeModifier };
	}

	private static float getChance(ItemStack stack) {
		if(stack.isEmpty() || !(stack.getItem() instanceof IPixieSpawner) )
			return 0F;
		else if(stack.getItem() instanceof ArmorCore)
			return 0.1f;
		else return ((IPixieSpawner) stack.getItem()).getPixieChance(stack);
	}
}
