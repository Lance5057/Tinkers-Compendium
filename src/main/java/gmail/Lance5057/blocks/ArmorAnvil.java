package gmail.Lance5057.blocks;

import gmail.Lance5057.tileentities.TileEntity_ArmorAnvil;
import gmail.Lance5057.tileentities.TileEntity_CrestMount;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ArmorAnvil extends Block implements ITileEntityProvider
{

	public ArmorAnvil() {
		super(Material.iron);
	}

	//You don't want the normal render type, or it wont render properly.
	@Override
	public int getRenderType() {
	        return -1;
	}
	
	//It's not an opaque cube, so you need this.
	@Override
	public boolean isOpaqueCube() {
	        return false;
	}
	
	//It's not a normal block, so you need this too.
	public boolean renderAsNormalBlock() {
	        return false;
	}
	
	//This is the icon to use for showing the block in your hand.
	public void registerIcons(IIconRegister icon) {
		//TODO fix the icon
	        this.blockIcon = icon.registerIcon("tinkersdefense:textures/items/QueensGoldIngot.png");
	}
	
	@Override
	public TileEntity createNewTileEntity(World w, int md) {
		TileEntity_ArmorAnvil te = new TileEntity_ArmorAnvil();
	    return te;
	}
}
