package lance5057.tDefense.armor.renderers;

import java.util.ArrayList;
import java.util.List;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import org.lwjgl.opengl.GL11;

public class ArmorRenderer extends ModelBiped
{
	public String[]				colors;

	public ItemStack			stack;
	public String				defaultFolder;

	private final int[]			order		= new int[] {1, 2, 3, 0, 4, 5, 6, 7, 8, 9};

	public List<ModelRenderer>	boxes		= new ArrayList<ModelRenderer>();

	public NBTTagCompound		defaultTags	= new NBTTagCompound();

	public ArmorRenderer(float a, float b, int c, int d)
	{
		super(a, b, c, d);
	}

	public void init()
	{
		defaultTags.getCompoundTag("ArmorRenderer");

		for(int i = 0; i < boxList.size(); i++)
		{
			final String rendertag = ((ModelRenderer) boxList.get(i)).boxName;
			if(rendertag != null)
			{
				defaultTags.setBoolean(rendertag, ((ModelRenderer) boxList.get(i)).isHidden);
			}
		}
	}

	public void SetColors(String[] colors, String defaultFolder, ItemStack stack)
	{
		this.colors = colors;
		this.stack = stack;
		this.defaultFolder = defaultFolder;
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		GL11.glPushMatrix();

		if(TinkersDefense.config.transparency)
		{
			GL11.glEnable(GL11.GL_BLEND);
		}

		final NBTTagCompound tags = stack.getTagCompound().getCompoundTag("ArmorRenderer");

		for(int j = 0; j < boxList.size(); j++)
		{
			final ModelRenderer box = (ModelRenderer) boxList.get(j);
			if(tags.hasKey(box.boxName))
			{
				box.isHidden = tags.getBoolean(box.boxName);
			}
		}

		for(int i = 0; i < 10; i++)
		{
			final String texture = ((ArmorCore) stack.getItem()).getTexture(order[i], stack);
			if(texture != "")
			{
				GL11.glPushMatrix();

				((ArmorCore) stack.getItem()).renderArmor(entity, f, f1, f2, f3, f4, f5, colors, stack, order[i]);
				super.render(entity, f, f1, f2, f3, f4, f5);

				GL11.glPopMatrix();
			}
		}

		if(TinkersDefense.config.transparency)
		{
			GL11.glDisable(GL11.GL_BLEND);
		}

		GL11.glPopMatrix();
		GL11.glColor3d(1.0, 1.0, 1.0);
	}
}
