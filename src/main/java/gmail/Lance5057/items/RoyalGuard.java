package gmail.Lance5057.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.crafting.ToolBuilder;
import tconstruct.library.tools.Weapon;

import java.util.List;

public abstract class RoyalGuard extends Weapon {
	public RoyalGuard() {
		super(10);
	}
	
@Override
public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
super.addInformation(stack, player, list, par4);
list.add(EnumChatFormatting.DARK_PURPLE + "Artisan crafted for the royal family");
}
@Override
public void getSubItems(Item id, CreativeTabs tab, List list) 
{
	super.getSubItems(id, tab, list);
	
	ItemStack tool = ToolBuilder.instance.buildTool(new ItemStack(getHeadItem(), 1, 2), new ItemStack(getHandleItem(), 1, 6), new ItemStack(getAccessoryItem(), 1, 33), "Royal Guard");
	NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
	tags.setInteger("Modifiers", 0);
	tags.setInteger("Attack", 15);
	tags.setInteger("TotalDurability", Integer.MAX_VALUE / 100);
	tags.setInteger("BaseDurability", Integer.MAX_VALUE / 100);
	tags.setInteger("MiningSpeed", Integer.MAX_VALUE / 100);
	tags.setInteger("Unbreaking", 10);
	tags.setBoolean("Built", true);
	tags.setInteger("Fortune", 450);
	list.add(tool);
}
}