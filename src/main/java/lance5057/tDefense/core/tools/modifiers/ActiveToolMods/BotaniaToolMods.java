package lance5057.tDefense.core.tools.modifiers.ActiveToolMods;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.tools.ToolCore;
//import vazkii.botania.common.entity.EntityManaBurst;
//import vazkii.botania.common.item.ModItems;
//import vazkii.botania.common.item.equipment.tool.ToolCommons;
//import vazkii.botania.common.item.equipment.tool.terrasteel.ItemTerraSword;
import cpw.mods.fml.common.Optional;

@Optional.InterfaceList({
	@Optional.Interface(modid = "botania", iface = "vazkii.botania.common.entity.EntityManaBurst"),
	@Optional.Interface(modid = "botania", iface = "vazkii.botania.common.item.ModItems"),
	@Optional.Interface(modid = "botania", iface = "vazkii.botania.common.item.equipment.tool.ToolCommons"),
	@Optional.Interface(modid = "botania", iface = "vazkii.botania.common.item.equipment.tool.terrasteel.ItemTerraSword"),
})

public class BotaniaToolMods {
	public void UpdateAll(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
	{
		UpdateTerraCore(tool, stack, world, entity, tags);
	}
	
	public void UpdateTerraCore(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
	{
		if(entity instanceof EntityPlayer) {
//			EntityPlayer player = (EntityPlayer) entity;
//			PotionEffect haste = player.getActivePotionEffect(Potion.digSpeed);
//			float check = haste == null ? 0.16666667F : haste.getAmplifier() == 1 ? 0.5F : 0.4F;

//			if(player.getCurrentEquippedItem() == stack && player.swingProgress == check && !world.isRemote && world.rand.nextInt(2) == 0) 
//			{
//				int color = TConstructRegistry.getMaterial(tags.getInteger("Head")).primaryColor();
//				EntityManaBurst burst = ((ItemTerraSword)ModItems.terraSword).getBurst(player, new ItemStack(ModItems.terraSword));
//				burst.setColor(color);
//				world.spawnEntityInWorld(burst);
//				ToolCommonSoundAtEntity(player, "botania:terraBlade", 0.4F, 1.4F);
//			}
		}
	}

	private void ToolCommonSoundAtEntity(EntityPlayer player, String string,
			float f, float g) {
		// TODO Auto-generated method stub
		
	}
}
