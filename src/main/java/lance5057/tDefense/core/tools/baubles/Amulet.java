package lance5057.tDefense.core.tools.baubles;

import baubles.api.BaubleType;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.bases.BaubleTool;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.tools.TinkerTools;

public class Amulet extends BaubleTool
{
	public Amulet()
	{
		super(PartMaterialType.head(TDParts.setting), PartMaterialType.handle(TDParts.chainmail),
				PartMaterialType.extra(TDParts.clasp));
	}
	
	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		// TODO Auto-generated method stub
		return BaubleType.RING;
	}

	@Override
	public void onPlayerBaubleRender(ItemStack stack, EntityPlayer player, RenderType type, float partialTicks) {
		// TODO Auto-generated method stub
		
	}

}
