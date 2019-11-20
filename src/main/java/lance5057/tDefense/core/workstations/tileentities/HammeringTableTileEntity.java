package lance5057.tDefense.core.workstations.tileentities;

import java.util.Random;

import lance5057.tDefense.core.tools.basic.Mallet;
import lance5057.tDefense.core.workstations.registries.hammeringtable.HammeringTableRecipeRegistry;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTable;
import slimeknights.tconstruct.tools.tools.Hammer;

public class HammeringTableTileEntity extends GuilessManualWorkstationTileEntity {

	public HammeringTableTileEntity(int inputs, String tag, int timerMax, String in, String out) {
		super(inputs, tag, timerMax, in, out);
	}

	@Override
	public void createItem(ItemStack tool) {
		int amount = 0;

		if (tool.getItem() instanceof Hammer)
			amount = 4;
		if (tool.getItem() instanceof Mallet)
			amount = 1;

		ItemStack itemstack = this.items[0];

		// Try loottables first
		ResourceLocation table = HammeringTableRecipeRegistry.instance().getHammeringLootTableResult(itemstack);
		if (table != null) {
			LootTable loottable = this.world.getLootTableManager().getLootTableFromLocation(table);
            LootContext.Builder lootcontext$builder = (new LootContext.Builder((WorldServer)this.world).withLuck(0));

            for (ItemStack i : loottable.generateLootForPools(this.world.rand, lootcontext$builder.build()))
            {
            	EntityItem entityitem = new EntityItem(this.world, this.pos.getX() + 0.5, this.pos.getY() + 1,
    					this.pos.getZ() + 0.5, i);
    			entityitem.setDefaultPickupDelay();
    			this.world.spawnEntity(entityitem);
            }
		} else {
			ItemStack itemstack1 = HammeringTableRecipeRegistry.instance().getHammeringResult(itemstack);

			if (itemstack.getCount() < amount)
				amount = itemstack.getCount();

			itemstack1.setCount(amount);

			EntityItem entityitem = new EntityItem(this.world, this.pos.getX() + 0.5, this.pos.getY() + 1,
					this.pos.getZ() + 0.5, itemstack1);
			entityitem.setDefaultPickupDelay();
			this.world.spawnEntity(entityitem);
		}

		itemstack.shrink(amount);
		if (itemstack.getCount() <= 0)
			itemstack = ItemStack.EMPTY;
	}
}
