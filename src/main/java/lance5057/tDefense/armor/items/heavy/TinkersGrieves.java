package lance5057.tDefense.armor.items.heavy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.renderers.heavy.ModelTinkersGrieves;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
import tconstruct.tools.TinkerTools;

public class TinkersGrieves extends ArmorCore 
{
	public TinkersGrieves() {
		super(2,2);
		this.setUnlocalizedName("tinkergrieves");
		this.maxReduction = 100;
		this.reductionPercent = 0.24;
	}
	
	@Override
	public Item getHeadItem() 
	{
		return TinkersDefense.partArmorplate;
	}
	
	@Override
	public Item getHandleItem() {
		return TinkerTools.toughRod;
	}
	
	@Override
	public Item getAccessoryItem() 
	{
		return TinkersDefense.partChainmaille;
	}
	
	@Override
	public Item getExtraItem()
	{
		return TinkersDefense.partArmorplate;
	}
	
	@Override
	public int durabilityTypeAccessory() {
		return 2;
	}

	@Override
	public float getRepairCost() {
		return 4.0f;
	}

	@Override
	public float getDurabilityModifier() {
		return 2.5f;
	}
	
	@Override
	public float getDamageModifier() {
		return 1.4f;
	}

	@Override
	public int getPartAmount() {
		return 4;
	}
	
	@Override
	public String getIconSuffix(int partType) 
	{
		switch (partType) {
		case 0:
			return "_grieves_plate";
		case 1:
			return "_grieves_plate_broken";
		case 2:
			return "_grieves_trim";
		case 3:
			return "_grieves_chain";
		case 4:
			return "_grieves_cod";
		default:
			return "";
		}
	}
	
	@Override
	public String getEffectSuffix() 
	{
		return "_grieves_effect";
	}
	
	@Override
	public String getDefaultFolder()
	{
		return "armor/grieves";
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
		return "tinkersdefense:textures/armor/TinkersGrieves.png";
	}
	
	@Override
	public String[] getTraits() {
		return new String[] {"armor","pants","grieves","heavyarmor"};
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getModel(String[] color,NBTTagCompound tags)
	{
		String[] textures = {this.getIconSuffix(2),this.getIconSuffix(0),this.getIconSuffix(3), this.getIconSuffix(4)};
		
		return new ModelTinkersGrieves(color, this.getDefaultFolder(), textures);
	}
	
	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) 
	{
		return 6;
	}
}
