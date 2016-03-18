package lance5057.tDefense.proxy;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.renderers.ModelMask;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersBreastplate;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersGrieves;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersHelm;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersSabatons;
import lance5057.tDefense.core.blocks.crestMount.Renderer_CrestMount;
import lance5057.tDefense.core.blocks.crestMount.TileEntity_CrestMount;
import lance5057.tDefense.core.renderer.BigFlexibleToolRenderer;
import lance5057.tDefense.finishingAnvil.blocks.finishingAnvil.Renderer_FinishingAnvil;
import lance5057.tDefense.finishingAnvil.blocks.finishingAnvil.TileEntity_FinishingAnvil;
import lance5057.tDefense.models.Renderer_JewelersBench;
import lance5057.tDefense.tileentities.TileEntity_JewelersBench;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.MinecraftForgeClient;
import tconstruct.client.FlexibleToolRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{
	//public static final ModelSheath sheath = new ModelSheath();

	public static final ModelMask				mask		= new ModelMask(null);

	public static final ModelTinkersHelm		helm		= new ModelTinkersHelm();
	public static final ModelTinkersBreastplate	breastplate	= new ModelTinkersBreastplate();
	public static final ModelTinkersGrieves		grieves		= new ModelTinkersGrieves();
	public static final ModelTinkersSabatons	sabatons	= new ModelTinkersSabatons();

	@Override
	public void registerRenderers()
	{
		FlexibleToolRenderer renderer = new FlexibleToolRenderer();
		FlexibleToolRenderer bigrenderer = new BigFlexibleToolRenderer();
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.tool_roundShield, renderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.tool_heaterShield, renderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.tool_wrench, renderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.tool_shears, renderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.tool_zweihander, bigrenderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.armor_TinkerHelm, renderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.armor_TinkerBreastplate, renderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.armor_TinkerGrieves, renderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.armor_TinkerSabatons, renderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.armor_TinkerRobe, renderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.armor_TinkerShawl, renderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.armor_TinkerHood, renderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.armor_TinkerShoes, renderer);

		MinecraftForgeClient.registerItemRenderer(TinkersDefense.armor_TinkerCoif, renderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.armor_TinkerHalberd, renderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.armor_TinkerChausses, renderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.armor_TinkerBoots, renderer);

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntity_CrestMount.class, new Renderer_CrestMount());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntity_FinishingAnvil.class, new Renderer_FinishingAnvil());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntity_JewelersBench.class, new Renderer_JewelersBench());

	}

	@Override
	public ModelBiped getArmorModel(int id)
	{
		return null;
	}
}
