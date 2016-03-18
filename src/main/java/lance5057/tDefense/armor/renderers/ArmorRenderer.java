package lance5057.tDefense.armor.renderers;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;

public class ArmorRenderer extends ModelBiped
{
	public String[]	colors;

	public String[]	textures;
	public String	defaultFolder;

	public ArmorRenderer(float a, float b, int c, int d)
	{
		super(a, b, c, d);
	}

	public void SetColors(String[] colors, String defaultFolder, String[] textures)
	{
		this.colors = colors;
		this.textures = textures;
		this.defaultFolder = defaultFolder;
	}
}
