package lance5057.tDefense.proxy;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.renderers.ModelMask;
import lance5057.tDefense.armor.renderers.ModelSheath;
import lance5057.tDefense.armor.renderers.cloth.ModelTinkersHood;
import lance5057.tDefense.armor.renderers.cloth.ModelTinkersRobe;
import lance5057.tDefense.armor.renderers.cloth.ModelTinkersShawl;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersBreastplate;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersGauntlets;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersGrieves;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersHelm;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersSabatons;
import lance5057.tDefense.armor.renderers.light.ModelTinkersBoots;
import lance5057.tDefense.armor.renderers.light.ModelTinkersChausses;
import lance5057.tDefense.armor.renderers.light.ModelTinkersCoif;
import lance5057.tDefense.armor.renderers.light.ModelTinkersHalberd;
import lance5057.tDefense.core.blocks.crestMount.Renderer_CrestMount;
import lance5057.tDefense.core.blocks.crestMount.TileEntity_CrestMount;
import lance5057.tDefense.core.renderer.BigFlexibleToolRenderer;
import lance5057.tDefense.finishingAnvil.blocks.finishingAnvil.Renderer_FinishingAnvil;
import lance5057.tDefense.finishingAnvil.blocks.finishingAnvil.TileEntity_FinishingAnvil;
import lance5057.tDefense.models.Renderer_JewelersBench;
import lance5057.tDefense.tileentities.TileEntity_JewelersBench;
import net.minecraftforge.client.MinecraftForgeClient;
import tconstruct.client.FlexibleToolRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{
	//public static final ModelSheath sheath = new ModelSheath();

	public static ModelMask					mask		= new ModelMask(null);
	public static ModelSheath				sheath		= new ModelSheath();

	public static ModelTinkersHelm			helm		= new ModelTinkersHelm();
	public static ModelTinkersBreastplate	breastplate	= new ModelTinkersBreastplate();
	public static ModelTinkersGrieves		grieves		= new ModelTinkersGrieves();
	public static ModelTinkersSabatons		sabatons	= new ModelTinkersSabatons();
	public static ModelTinkersGauntlets		gauntlets	= new ModelTinkersGauntlets();

	public static ModelTinkersHood			hood		= new ModelTinkersHood();
	public static ModelTinkersShawl			shawl		= new ModelTinkersShawl();
	public static ModelTinkersRobe			robe		= new ModelTinkersRobe();
	public static ModelTinkersBoots			shoes		= new ModelTinkersBoots();

	public static ModelTinkersCoif			coif		= new ModelTinkersCoif();
	public static ModelTinkersHalberd		halberd		= new ModelTinkersHalberd();
	public static ModelTinkersChausses		chausses	= new ModelTinkersChausses();
	public static ModelTinkersBoots			boots		= new ModelTinkersBoots();

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
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.tool_sheath, renderer);

		MinecraftForgeClient.registerItemRenderer(TinkersDefense.armor_TinkerHelm, renderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.armor_TinkerBreastplate, renderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.armor_TinkerGrieves, renderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.armor_TinkerSabatons, renderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.armor_TinkerGauntlets, renderer);

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
}
