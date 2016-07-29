package lance5057.tDefense.proxy;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.TDArmorAddon;
import lance5057.tDefense.armor.renderers.ModelTinkersGauntlets;
import lance5057.tDefense.armor.renderers.ModelTinkersTabard;
import lance5057.tDefense.armor.renderers.cloth.ModelTinkersHood;
import lance5057.tDefense.armor.renderers.cloth.ModelTinkersRobe;
import lance5057.tDefense.armor.renderers.cloth.ModelTinkersShawl;
import lance5057.tDefense.armor.renderers.cloth.ModelTinkersShoes;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersBreastplate;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersGrieves;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersHelm;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersSabatons;
import lance5057.tDefense.armor.renderers.light.ModelTinkersBoots;
import lance5057.tDefense.armor.renderers.light.ModelTinkersChausses;
import lance5057.tDefense.armor.renderers.light.ModelTinkersCoif;
import lance5057.tDefense.armor.renderers.light.ModelTinkersHauberk;
import lance5057.tDefense.baubles.models.Renderer_JewelersBench;
import lance5057.tDefense.baubles.tileentities.TileEntity_JewelersBench;
import lance5057.tDefense.core.blocks.crestMount.Renderer_CrestMount;
import lance5057.tDefense.core.blocks.crestMount.TileEntity_CrestMount;
import lance5057.tDefense.core.renderer.MoreFlexibleToolRenderer;
import lance5057.tDefense.core.tools.modifiers.ModifierSoulHandler;
//import lance5057.tDefense.core.renderer.TestSkinChanger;
import lance5057.tDefense.finishingAnvil.blocks.finishingAnvil.Renderer_FinishingAnvil;
import lance5057.tDefense.finishingAnvil.blocks.finishingAnvil.TileEntity_FinishingAnvil;
import net.minecraftforge.client.MinecraftForgeClient;
import tconstruct.client.FlexibleToolRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{
	//public static final ModelSheath sheath = new ModelSheath();
	//ModifierSoulHandler						SoulHandler;

	public static ModelTinkersTabard		sheath;

	public static ModelTinkersHelm			helm;
	public static ModelTinkersBreastplate	breastplate;
	public static ModelTinkersGrieves		grieves;
	public static ModelTinkersSabatons		sabatons;
	public static ModelTinkersGauntlets		gauntlets;

	public static ModelTinkersHood			hood;
	public static ModelTinkersShawl			shawl;
	public static ModelTinkersRobe			robe;
	public static ModelTinkersShoes			shoes;

	public static ModelTinkersCoif			coif;
	public static ModelTinkersHauberk		hauberk;
	public static ModelTinkersChausses		chausses;
	public static ModelTinkersBoots			boots;

	@Override
	public void registerRenderers()
	{
		SoulHandler = new ModifierSoulHandler(2, "Steve");

		sheath = new ModelTinkersTabard();

		helm = new ModelTinkersHelm();
		breastplate = new ModelTinkersBreastplate();
		grieves = new ModelTinkersGrieves();
		sabatons = new ModelTinkersSabatons();
		gauntlets = new ModelTinkersGauntlets();

		hood = new ModelTinkersHood();
		shawl = new ModelTinkersShawl();
		robe = new ModelTinkersRobe();
		shoes = new ModelTinkersShoes();

		coif = new ModelTinkersCoif();
		hauberk = new ModelTinkersHauberk();
		chausses = new ModelTinkersChausses();
		boots = new ModelTinkersBoots();

		//		final FlexibleToolRenderer renderer = new FlexibleToolRenderer();
		//		final FlexibleToolRenderer bigrenderer = new MoreFlexibleToolRenderer(2);
		//		final FlexibleToolRenderer smallrenderer = new MoreFlexibleToolRenderer(
		//				1.0f);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.tool_roundShield, new MoreFlexibleToolRenderer(
				0.75f, 0.0f, 0.2f, 0f));
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.tool_heaterShield, new FlexibleToolRenderer());
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.tool_wrench, new FlexibleToolRenderer());
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.tool_shears, new FlexibleToolRenderer());
		//MinecraftForgeClient.registerItemRenderer(TinkersDefense.tool_hookshot, renderer);
		MinecraftForgeClient.registerItemRenderer(TinkersDefense.tool_zweihander, new MoreFlexibleToolRenderer(
				1.5f, -0.325f, -0.025f, 0f));
		//MinecraftForgeClient.registerItemRenderer(TinkersDefense.tool_hookshot, renderer);

		//RenderingRegistry.registerEntityRenderingHandler(EntityHookshotHook.class, new HookRenderer());

		if(TinkersDefense.config.ArmorAddon)
		{
			TDArmorAddon.clientProxy(new FlexibleToolRenderer());
		}

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntity_CrestMount.class, new Renderer_CrestMount());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntity_FinishingAnvil.class, new Renderer_FinishingAnvil());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntity_JewelersBench.class, new Renderer_JewelersBench());
	}
}
