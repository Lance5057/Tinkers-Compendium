package gmail.Lance5057.proxy;

import gmail.Lance5057.TinkersDefense;
import gmail.Lance5057.armor.renderers.ModelChainArmor;
import gmail.Lance5057.armor.renderers.ModelClothArmor;
import gmail.Lance5057.armor.renderers.ModelSheath;
import gmail.Lance5057.armor.renderers.ModelTinkerArmor;
import gmail.Lance5057.models.Renderer_ArmorAnvil;
import gmail.Lance5057.models.Renderer_CrestMount;
import gmail.Lance5057.models.Renderer_JewelersBench;
import gmail.Lance5057.tileentities.TileEntity_CrestMount;
import gmail.Lance5057.tileentities.TileEntity_FinishingAnvil;
import gmail.Lance5057.tileentities.TileEntity_JewelersBench;
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

		ClientRegistry.bindTileEntitySpecialRenderer(
				TileEntity_CrestMount.class, new Renderer_CrestMount());
		ClientRegistry.bindTileEntitySpecialRenderer(
				TileEntity_FinishingAnvil.class, new Renderer_ArmorAnvil());
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