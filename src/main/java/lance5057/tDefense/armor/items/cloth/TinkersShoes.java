package lance5057.tDefense.armor.items.cloth;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.parts.ClothMaterial;
import lance5057.tDefense.armor.renderers.light.ModelTinkersBoots;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.tools.CustomMaterial;

public class TinkersShoes extends ArmorCore 
{
	public TinkersShoes() {
		super(0,3);
		this.setUnlocalizedName("tinkersshoes");
	}
	
	@Override
	public Item getHeadItem() 
	{
		return TinkersDefense.partCloth;
	}
	
	@Override
	public Item getHandleItem() {
		return TinkersDefense.partClasp;
	}
	
	@Override
	public Item getAccessoryItem() 
	{
		return TinkersDefense.partRivet;
	}
	
	@Override
	public int durabilityTypeAccessory() {
		return 1;
	}

	@Override
	public float getRepairCost() {
		return 1.0f;
	}

	@Override
	public float getDurabilityModifier() {
		return 1f;
	}
	
	@Override
	public float getDamageModifier() {
		return 1f;
	}

	@Override
	public int getPartAmount() {
		return 3;
	}
	
	@Override
	public String getIconSuffix(int partType) 
	{
		switch (partType) {
		case 0:
			return "_shoes_cloth";
		case 1:
			return "_shoes_cloth_broken";
		case 2:
			return "_shoes_clasp";
		case 3:
			return "_shoes_rivet";
		default:
			return "";
		}
	}
	
	@Override
	public String getEffectSuffix() 
	{
		return "_shoes_effect";
	}
	
	@Override
	public String getDefaultFolder()
	{
		return "armor/shoes";
	}
	
//	@Override
//	public void onUpdate(ItemStack stack, World world, Entity entity, int par4,
//			boolean par5) {
//		super.onUpdate(stack, world, entity, par4, par5);
//
//	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {
		return "tinkersdefense:textures/armor/TinkersShoes.png";
	}
	
	@Override
	public String[] getTraits() {
		return new String[] {"armor","helmet","shoes","cloth"};
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getModel(String[] color,NBTTagCompound tags)
	{
		String[] textures = {this.getIconSuffix(2),this.getIconSuffix(0),this.getIconSuffix(3)};
		
		int HeadID = tags.getCompoundTag("InfiTool").getInteger("RenderHead");
		
		CustomMaterial newColor = TConstructRegistry.getCustomMaterial(HeadID, ClothMaterial.class);
		color[1] = Integer.toHexString(newColor.color);
		
		return (ModelBiped) new ModelTinkersBoots(color, this.getDefaultFolder(), textures);
	}
	
	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) 
	{
		return 0;
	}
}
