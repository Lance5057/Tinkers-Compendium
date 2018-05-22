package lance5057.tDefense.core.tools.armor.cloth;

import java.util.ArrayList;
import java.util.List;

import lance5057.tDefense.core.materials.ArmorMaterialStats.ClothMaterialStats;
import lance5057.tDefense.core.materials.ArmorMaterialStats.LegsMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
import lance5057.tDefense.core.tools.armor.renderers.cloth.ModelTinkersRobe;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import lance5057.tDefense.util.ArmorNBT;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;

public class TinkersRobe extends ArmorCore
{
	int	induceDamage	= 0;
	

	public TinkersRobe()
	{
	    super(EntityEquipmentSlot.CHEST,new PartMaterialType(TDParts.cloth, ClothMaterialStats.TYPE),
	    	new PartMaterialType(TDParts.cloth, ClothMaterialStats.TYPE),
	    	PartMaterialType.extra(TDParts.clasp));
		setUnlocalizedName("tinkerrobe");
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
	{
		super.onUpdate(stack, world, entity, par4, par5);

	}

	@SideOnly(Side.CLIENT)
	@Override
	public List<String> getArmorTexture(ItemStack stack) {
		List<String> textures = new ArrayList();
		textures.add("textures/armor/robe/_robe_cloth.png");
		textures.add("textures/armor/robe/_robe_trim.png");
		textures.add("textures/armor/robe/_robe_metal.png");

		return textures;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ArmorRenderer getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack)
	{
		return new ModelTinkersRobe(itemStack);
	}

	@Override
	public NBTTagCompound buildTag(List<Material> materials) {
		ArmorNBT data = buildDefaultArmorTag(materials, LegsMaterialStats.TYPE);
	    return data.get();
	}
	
	@Override
	public EntityEquipmentSlot getArmorSlot(ItemStack stack, EntityEquipmentSlot armorType) {
		return EntityEquipmentSlot.LEGS;
	}

	@Override
	public void getTooltipDetailed(ItemStack stack, List<String> tooltips) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getTooltipComponents(ItemStack stack, List<String> tooltips) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage,
			int slot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
		// TODO Auto-generated method stub
		
	}
}
