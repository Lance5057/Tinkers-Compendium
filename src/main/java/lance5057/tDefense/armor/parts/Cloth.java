//package lance5057.tDefense.armor.parts;
//
//import mantle.items.abstracts.CraftingItem;
//import net.minecraft.item.ItemStack;
//import tconstruct.library.TConstructRegistry;
//import tconstruct.library.util.IToolPart;
//
//public class Cloth extends CraftingItem implements IToolPart
//{
//	public Cloth()
//	{
//		super(toolMaterialNames, buildTextureNames("_cloth"), "parts/", "tinker", TConstructRegistry.materialTab);
//		setHasSubtypes(true);
//		setMaxDamage(0);
//	}
//
//	private static String[] buildTextureNames(String textureType)
//	{
//		final String[] names = new String[toolMaterialNames.length];
//		for(int i = 0; i < toolMaterialNames.length; i++)
//		{
//			if(toolTextureNames[i].equals(""))
//			{
//				names[i] = "";
//			}
//			else
//			{
//				names[i] = toolTextureNames[i] + textureType;
//			}
//		}
//		return names;
//	}
//
//	public static final String[]	toolMaterialNames	= new String[] {"white", "orange", "magenta", "lightblue", "yellow", "lime", "pink", "gray", "lightgray", "cyan", "purple", "blue", "brown", "green", "red", "black"};
//	public static final String[]	toolTextureNames	= new String[] {"white", "orange", "magenta", "lightblue", "yellow", "lime", "pink", "gray", "lightgray", "cyan", "purple", "blue", "brown", "green", "red", "black"};
//
//	@Override
//	public int getMaterialID(ItemStack stack)
//	{
//		if(stack.getItemDamage() >= toolMaterialNames.length)
//		{
//			return -1;
//		}
//		return stack.getItemDamage();
//	}
//}
