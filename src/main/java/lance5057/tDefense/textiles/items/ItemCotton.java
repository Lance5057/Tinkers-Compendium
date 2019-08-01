package lance5057.tDefense.textiles.items;

import javax.annotation.Nonnull;

import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.textiles.CompendiumTextiles;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class ItemCotton extends Item {

	public ItemCotton() {
		this.setCreativeTab(TinkersCompendium.tab);
		this.setMaxStackSize(64);
	}

	@Nonnull
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemStack = playerIn.getHeldItem(handIn);
		
		int particles = 1;
		
		if (worldIn.rand.nextInt(3) == 0) {
			playerIn.addItemStackToInventory(new ItemStack(CompendiumTextiles.cottonSeed, 1));
			itemStack.setCount(itemStack.getCount() - 1);
			particles = 5;
		}
		
		for (int i = 0; i < particles; ++i)
        {
            Vec3d vec3d = new Vec3d(((double)worldIn.rand.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D);
            vec3d = vec3d.rotatePitch(-playerIn.rotationPitch * 0.017453292F);
            vec3d = vec3d.rotateYaw(-playerIn.rotationYaw * 0.017453292F);
            double d0 = (double)(-worldIn.rand.nextFloat()) * 0.6D - 0.3D;
            Vec3d vec3d1 = new Vec3d(((double)worldIn.rand.nextFloat() - 0.5D) * 0.3D, d0, 0.6D);
            vec3d1 = vec3d1.rotatePitch(-playerIn.rotationPitch * 0.017453292F);
            vec3d1 = vec3d1.rotateYaw(-playerIn.rotationYaw * 0.017453292F);
            vec3d1 = vec3d1.addVector(playerIn.posX, playerIn.posY + (double)playerIn.getEyeHeight(), playerIn.posZ);
            if (playerIn.world instanceof WorldServer) //Forge: Fix MC-2518 spawnParticle is nooped on server, need to use server specific variant
                ((WorldServer)playerIn.world).spawnParticle(EnumParticleTypes.ITEM_CRACK, vec3d1.x, vec3d1.y, vec3d1.z, 0,  vec3d.x, vec3d.y + 0.05D, vec3d.z, 0.0D, Item.getIdFromItem(itemStack.getItem()), itemStack.getMetadata());
            else //Fix the fact that spawning ItemCrack uses TWO arguments.
            	playerIn.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, vec3d1.x, vec3d1.y, vec3d1.z, vec3d.x, vec3d.y + 0.05D, vec3d.z, Item.getIdFromItem(itemStack.getItem()), itemStack.getMetadata());

        }
		
		return new ActionResult<>(EnumActionResult.SUCCESS, itemStack);
	}
}
