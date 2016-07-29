//package lance5057.tDefense.core.renderer;
//
//import java.util.Map;
//
//import com.google.common.collect.Maps;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.model.ModelHorse;
//import net.minecraft.client.renderer.entity.RenderHorse;
//import net.minecraft.client.renderer.texture.ITextureObject;
//import net.minecraft.client.renderer.texture.LayeredTexture;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.passive.EntityHorse;
//import net.minecraft.util.ResourceLocation;
//
//public class TestSkinChanger extends RenderHorse
//{
//	private static final Map	textures	= Maps.newHashMap();
//    private static final String[] horseArmorTextures = new String[] {null, "textures/entity/horse/armor/horse_armor_iron.png", "textures/entity/horse/armor/horse_armor_gold.png", "textures/entity/horse/armor/horse_armor_diamond.png"};
//    private String[] combinedHorseTextures = new String[3];
//
//	public TestSkinChanger()
//	{
//		super(new ModelHorse(), 1);
//	}
//
//	@Override
//	protected ResourceLocation getEntityTexture(Entity ent)
//	{
//		if(ent instanceof EntityHorse)
//		{
//			EntityHorse entHorse = (EntityHorse) ent;
//
//			String rc = "tinkersdefense:textures/skin/horse/horse_witherskeleton.png";
//
//			return renderHorse(entHorse, rc);
//		}
//		return null;
//	}
//
//	private ResourceLocation renderHorse(EntityHorse ent, String rc)
//	{
//		String s = ent.getHorseTexture();
//        ResourceLocation resourcelocation = (ResourceLocation)textures.get(s);
//
//        if (resourcelocation == null)
//        {
//            resourcelocation = new ResourceLocation(s);
//            String[] str = ent.getVariantTexturePaths();
//            str[0] = rc;
//            str[1] = null;
//            Minecraft.getMinecraft().getTextureManager().loadTexture(resourcelocation, new LayeredTexture(str));
//            textures.put(s, resourcelocation);
//        }
//
//        return resourcelocation;
//	}
//}
