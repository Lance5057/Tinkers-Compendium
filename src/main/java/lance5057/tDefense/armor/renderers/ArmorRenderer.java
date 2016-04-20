package lance5057.tDefense.armor.renderers;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class ArmorRenderer extends ModelBiped
{
	public String[]	colors;

	public ItemStack stack;
	public String	defaultFolder;

	public ArmorRenderer(float a, float b, int c, int d)
	{
		super(a, b, c, d);
	}

	public void SetColors(String[] colors, String defaultFolder, ItemStack stack)
	{
		this.colors = colors;
		this.stack = stack;
		this.defaultFolder = defaultFolder;
	}
}
