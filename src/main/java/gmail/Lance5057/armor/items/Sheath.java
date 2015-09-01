package gmail.Lance5057.armor.items;

import gmail.Lance5057.proxy.ClientProxy;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import tconstruct.library.accessory.AccessoryCore;
import tconstruct.library.accessory.IAccessoryModel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Sheath extends AccessoryCore implements IAccessoryModel
{

	public Sheath() {
		super("tinkersdefense:textures/armor/Sheath/_sheath_base");
	}

	@Override
	public boolean canEquipAccessory(ItemStack item, int slot) 
	{
		return slot == 3;
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel (EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
    {
        return ClientProxy.sheath;
    }
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {
		return "tinkersdefense:textures/armor/Sheath/_sheath_base.png";
	}
	
	ResourceLocation texture = new ResourceLocation("tinkersdefense", "textures/armor/Sheath/_sheath_base.png");
	
	@Override
    @SideOnly(Side.CLIENT)
    public ResourceLocation getWearbleTexture (Entity entity, ItemStack stack, int slot)
    {
        return texture;
    }

}
