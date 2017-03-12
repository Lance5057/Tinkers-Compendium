package lance5057.tDefense.holiday.xmas;

import slimeknights.tconstruct.world.entity.EntityBlueSlime;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.holiday.xmas.gumdropslime.GumDropSlime;
import lance5057.tDefense.util.ModuleBase;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class XmasBase extends ModuleBase {
	public XmasBase() {
		items = new XmasItems();
	}

	@Override
	public void preInit() {
		
		items.preInit();
		EntityRegistry.registerModEntity(GumDropSlime.class, "gumdropslime", 0,
				TinkersDefense.instance, 64, 5, true, 0x963430, 0xDDDDDD);
		//LootTableList.register(GumDropSlime.LOOT_TABLE);
	}
}
