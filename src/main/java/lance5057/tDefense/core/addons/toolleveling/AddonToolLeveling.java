package lance5057.tDefense.core.addons.toolleveling;

import lance5057.tDefense.core.library.ModuleBase;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.modifiers.IModifier;
import slimeknights.toolleveling.ModToolLeveling;

public class AddonToolLeveling extends ModuleBase {

	/**
	 * Function to add XP to a given tool. Can be safely called as a NOOP when tool
	 * leveling is not loaded
	 */
	public static XPInterface xpAdder = (tool, amount, player) -> {
	};

	public void init(FMLInitializationEvent event) {
		// find the addXp method and replace the NOOP version
		IModifier modifier = TinkerRegistry.getModifier("toolleveling");
		if (modifier instanceof ModToolLeveling) {
			xpAdder = ((ModToolLeveling) modifier)::addXp;
		}
	}

	public void postInit(FMLPostInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(ToolLevelingEvents.INSTANCE);
	}

	/**
	 * Interface to make the optional dependency easier, as that method can then be
	 * called without needing to reference Tinkers Tool Leveling
	 */
	public interface XPInterface {
		/**
		 * Adds XP to a given tool
		 *
		 * @param tool   Tool item stack
		 * @param amount Amount of XP to add
		 * @param player Player using the tool
		 */
		void addXp(ItemStack tool, int amount, EntityPlayer player);
	}

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void registerItems(Register<Item> event) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void registerBlocks(Register<Block> event) {
//		// TODO Auto-generated method stub
//		
//	}
}