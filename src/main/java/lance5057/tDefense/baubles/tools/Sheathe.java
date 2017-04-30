package lance5057.tDefense.baubles.tools;

import baubles.api.BaubleType;
import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.baubles.BaublesBase;
import lance5057.tDefense.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.tools.TinkerTools;

public class Sheathe extends BaubleTool {
	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/model/sheathe.png");

	public Sheathe(PartMaterialType... requiredComponents) {
		super(PartMaterialType.head(TinkerTools.largePlate), PartMaterialType.handle(TinkerTools.toolRod),
				PartMaterialType.extra(TinkerTools.bowString));

	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) { 
		// TODO Auto-generated method stub
		return BaubleType.BODY;
	}

	@Override
	public void onPlayerBaubleRender(ItemStack stack, EntityPlayer player, RenderType type, float partialTicks) {
		// TODO Auto-generated method stub

		if (type == RenderType.BODY) {
			float s = 1F / 16F;
			GlStateManager.scale(s, s, s);

			GlStateManager.enableLighting();
			GlStateManager.enableRescaleNormal();

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);

			ClientProxy.baubles.sheathe.render(1f, player.inventory.getStackInSlot(0), player.inventory.getStackInSlot(1), player.getHeldItemMainhand(), player.getHeldItemOffhand());
		}
	}

}
