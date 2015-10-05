package lance5057.tDefense.proxy;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.renderers.ModelChainArmor;
import lance5057.tDefense.armor.renderers.ModelClothArmor;
import lance5057.tDefense.armor.renderers.ModelTinkerArmor;
import lance5057.tDefense.core.blocks.crestMount.Renderer_CrestMount;
import lance5057.tDefense.core.blocks.crestMount.TileEntity_CrestMount;
import lance5057.tDefense.finishingAnvil.blocks.finishingAnvil.Renderer_FinishingAnvil;
import lance5057.tDefense.finishingAnvil.blocks.finishingAnvil.TileEntity_FinishingAnvil;
import lance5057.tDefense.models.Renderer_JewelersBench;
import lance5057.tDefense.tileentities.TileEntity_JewelersBench;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.MinecraftForgeClient;
import tconstruct.client.FlexibleToolRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
	public static final ModelTinkerArmor tutChest = new ModelTinkerArmor(1.0f);
	//public static final ModelSheath sheath = new ModelSheath();
	public static final ModelChainArmor chain = new ModelChainArmor(0.1f);
	public static final ModelClothArmor cloth = new ModelClothArmor();
	
	@Override
	public void registerRenderers() {
		FlexibleToolRenderer renderer = new FlexibleToolRenderer();
		MinecraftForgeClient.registerItemRenderer(
				TinkersDefense.tool_roundShield, renderer);
		MinecraftForgeClient.registerItemRenderer(
				TinkersDefense.tool_heaterShield, renderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.tool_wrench,
				renderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.tool_zweihander,
				renderer);

		ClientRegistry.bindTileEntitySpecialRenderer(
				TileEntity_CrestMount.class, new Renderer_CrestMount());
		ClientRegistry.bindTileEntitySpecialRenderer(
				TileEntity_FinishingAnvil.class, new Renderer_FinishingAnvil());
		ClientRegistry.bindTileEntitySpecialRenderer(
				TileEntity_JewelersBench.class, new Renderer_JewelersBench());
		
	}

	@Override
	public ModelBiped getArmorModel(int id) {
		switch (id) {
		case 0:
			return tutChest;
		default:
			break;
		}
		return tutChest; // default, if whenever you should have passed on a
							// wrong id
	}
}