package lance5057.tDefense.core.workstations.tileentities;

import lance5057.tDefense.core.tools.basic.Mallet;
import lance5057.tDefense.core.workstations.registries.hammeringtable.HammeringTableRecipeRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.UniversalBucket;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
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
			LootContext.Builder lootcontext$builder = (new LootContext.Builder((WorldServer) this.world).withLuck(0));

			for (int passes = 0; passes < amount; passes++)
				for (ItemStack i : loottable.generateLootForPools(this.world.rand, lootcontext$builder.build())) {
					ItemStack c = i.copy();
					// c.setCount(c.getCount() * amount);

					if (c.getItem() instanceof UniversalBucket) {
						String s = c.getTagCompound().getString("FluidName");

						FluidStack fluid = new FluidStack(FluidRegistry.getFluid(s), 100);
						
						for (EnumFacing face : EnumFacing.values()) {
						    BlockPos adj = getPos().offset(face);

						    TileEntity te = this.world.getTileEntity(adj);
						    if(te != null)
						    {
						    	IFluidHandler tank = te.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null);
						    	
						    	if(tank != null)
						    	{
						    		fluid.amount -= tank.fill(fluid, true);
						    	}
						    }
						}

					} else if (c.getItem() == Items.SPAWN_EGG) {
						String s = c.getTagCompound().getString("EntityTag");
						
					} else {
						EntityItem entityitem = new EntityItem(this.world, this.pos.getX() + 0.5, this.pos.getY() + 1,
								this.pos.getZ() + 0.5, c);
						entityitem.setDefaultPickupDelay();
						this.world.spawnEntity(entityitem);
					}
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
