package lance5057.tDefense.armor.modifiers;

import lance5057.tDefense.TinkersDefense;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.crafting.ModifyBuilder;
import tconstruct.library.tools.ToolCore;

public class ArmorMods
{

	public ArmorMods()
	{
		LoadItems();
		RegisterRecipes();
		RegisterModifiers();
	}

	public void LoadItems()
	{
		// protKit = new Item()
		// .setUnlocalizedName("protectionkit")
		// .setCreativeTab(TinkersDefense.tabName)
		// .setTextureName("tinkersdefense:protectionkit");
		//
		// GameRegistry.registerItem(protKit, "protectionkit");
	}

	public void RegisterRecipes()
	{
		// GameRegistry.addShapelessRecipe(new ItemStack(protKit,1), new
		// ItemStack(TinkersDefense.partArmorplate,1,2),
		// TinkerArmor.heartCanister, Items.iron_ingot);
	}

	public void RegisterModifiers()
	{
		ModifyBuilder.registerModifier(new modifierProtection(new ItemStack[] {new ItemStack(TinkersDefense.partArmorplate, 1, 2)}, TinkersDefense.config.ArmorProtectionID, 1, "\u00A77", "Protection"));
		ModifyBuilder.registerModifier(new modifierProtection(new ItemStack[] {new ItemStack(Items.magma_cream, 1)}, TinkersDefense.config.ArmorFireProtectionID, 1, "\u00A7c", "Fire Protection"));
		ModifyBuilder.registerModifier(new modifierProtection(new ItemStack[] {new ItemStack(Blocks.wool, 1)}, TinkersDefense.config.ArmorBlastProtectionID, 1, "\u00A72", "Blast Protection"));
		ModifyBuilder.registerModifier(new modifierProtection(new ItemStack[] {new ItemStack(TinkersDefense.partRivet, 1, 2)}, TinkersDefense.config.ArmorProjectileProtectionID, 1, "\u00A7f", "Projectile Protection"));
		ModifyBuilder.registerModifier(new modifierProtection(new ItemStack[] {new ItemStack(Blocks.hay_block)}, TinkersDefense.config.FeatherfallID, 1, "\u00A7f", "Featherfall"));

		for(ToolCore tool : TConstructRegistry.getToolMapping())
		{
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.ArmorProtectionID, "tinker", "protection", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.ArmorFireProtectionID, "tinker", "fireprotection", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.ArmorBlastProtectionID, "tinker", "blastprotection", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.ArmorProjectileProtectionID, "tinker", "projprotection", true);
			TConstructClientRegistry.addEffectRenderMapping(tool, TinkersDefense.config.FeatherfallID, "tinker", "featherfall", true);
		}
	}

	public void UpdateAll(ToolCore tool, ItemStack stack, World world, Entity entity, NBTTagCompound tags)
	{
		if(!world.isRemote)
		{
			UpdateWalker(tool, stack, world, entity, Material.water, TinkersDefense.block_Unstable, 0);
			UpdateWalker(tool, stack, world, entity, Material.lava, TinkersDefense.block_Unstable, 1);
			UpdateGlowstep(tool, stack, world, entity);
		}
	}

	public void UpdateWalker(ToolCore tool, ItemStack stack, World world, Entity entity, Material mat, Block replacement, int meta)
	{
		int x = (int) Math.floor(entity.posX);
		int y = (int) (entity.posY - entity.getYOffset());
		int z = (int) Math.floor(entity.posZ);

		Block block;

		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
			{
				block = world.getBlock(x + (i - 2), y - 1, z + (j - 2));
				if(block instanceof BlockLiquid)
				{
					if(((BlockLiquid) block).getMaterial() == mat && world.getBlockMetadata(x + (i - 2), y - 1, z + (j - 2)) == 0)
					{
						world.setBlock(x + (i - 2), y - 1, z + (j - 2), replacement, meta, 3);
						world.notifyBlocksOfNeighborChange(x + (i - 2), y - 1, z + (j - 2), world.getBlock(x + (i - 2), y - 1, z + (j - 2)));
					}
				}
			}
	}

	int	glowTimer	= 8;
	int	prevX		= 0;
	int	prevZ		= 0;

	public void UpdateGlowstep(ToolCore tool, ItemStack stack, World world, Entity entity)
	{
		int x = (int) Math.floor(entity.posX);
		int y = (int) (entity.posY - entity.getYOffset());
		int z = (int) Math.floor(entity.posZ);

		if(glowTimer == 0)
		{
			if(world.getBlock(x, y, z) == Blocks.air && world.getBlock(x, y - 1, z).isNormalCube())
			{
				world.setBlock(x, y, z, TinkersDefense.block_GlowCrumbs, 0, 3);
				//world.notifyBlocksOfNeighborChange(x + (i - 2), y - 1, z + (j - 2), world.getBlock(x + (i - 2), y - 1, z + (j - 2)));
			}
			glowTimer = 8;
		}
		else if(Math.abs(x - prevX) >= 1 || Math.abs(z - prevZ) >= 1)
		{
			glowTimer--;
		}

		prevX = x;
		prevZ = z;
	}
}
