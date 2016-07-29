package lance5057.tDefense.core.gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lance5057.tDefense.TinkersDefense;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import org.lwjgl.opengl.GL11;

import tconstruct.library.crafting.ToolBuilder;
import tconstruct.library.tools.DynamicToolPart;
import tconstruct.tools.TinkerTools;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuiTDGuideBook extends GuiScreen
{
	static RenderItem						itemRender		= new RenderItem();
	List<Chapter>							chapters		= new ArrayList<Chapter>();

	private int								chapter			= 0;
	private int								page			= 0;

	private static final ResourceLocation	guiLocation		= new ResourceLocation(
			"tinkersdefense",
			"textures/gui/guide.png");

	private static final ResourceLocation	guiLocation2	= new ResourceLocation(
			"tinkersdefense",
			"textures/gui/guide2.png");

	public GuiTDGuideBook()
	{

	}

	@Override
	public void initGui()
	{
		final List<Page> pages = new ArrayList<Page>();
		Page page;
		chapters.add(new Chapter(0, 1));

		page = new Page(1, 0);
		pages.add(page);

		page = new Page(1, 1, (DynamicToolPart) TinkersDefense.partArmorplate,
				(DynamicToolPart) TinkerTools.toughRod,
				(DynamicToolPart) TinkersDefense.partArmorplate,
				(DynamicToolPart) TinkersDefense.partRivet);
		pages.add(page);

		page = new Page(1, 2, (DynamicToolPart) TinkersDefense.partArmorplate,
				(DynamicToolPart) TinkerTools.toolRod,
				(DynamicToolPart) TinkerTools.frypanHead, null);
		pages.add(page);

		chapters.add(new Chapter(1, pages));

		buttonList.clear();

		buttonList.add(new BookButton(0, ((width - 256) / 2) + 3, 240, false,
				80, 0, 18, 12));
		buttonList.add(new BookButton(1, ((width + 256) / 2) - 3 - 18, 240,
				true, 80, 0, 18, 12));
		buttonList.add(new BookButton(2, ((width - 14) / 2), 238, true, 120, 0,
				14, 13));

		for(int i = 0; i < chapters.size(); i++)
		{
			buttonList.add(chapters.get(i).getButton(3 + i, width, height));
		}

		//		this.buttonList.add(new BookButton(3, ((this.width + 256) / 2) - 8, 15 + 64, true, 71, 180, 35, 21));
		//		this.buttonList.add(new BookButton(4, ((this.width + 256) / 2) - 8, 35 + 64, true, 71, 200, 35, 21));
		//		this.buttonList.add(new BookButton(5, ((this.width + 256) / 2) - 8, 55 + 64, true, 71, 220, 35, 21));
		//		this.buttonList.add(new BookButton(6, ((this.width + 256) / 2) - 8, 75 + 64, true, 144, 180, 35, 21));
		//		this.buttonList.add(new BookButton(7, ((this.width + 256) / 2) - 8, 95 + 64, true, 144, 200, 35, 21));
		//		
		//		
		((GuiButton) buttonList.get(chapter + 3)).enabled = false;
	}

	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(guiLocation);

		drawTexturedModalRect((width - 256) / 2, (height - 224) / 2, 0, 0, 256, 179);

		//chapters.get(chapter - 1).pages.get(page - 1).drawText(fontRendererObj, this.width, this.height);
		if(chapters.size() > 0 && chapters.get(chapter).pages.size() > 0)
		{
			chapters.get(chapter).pages.get(page).draw(this, fontRendererObj, width, height, itemRender);
		}

		mc.getTextureManager().bindTexture(guiLocation2);

		super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		switch(button.id)
		{
			case 0:
				if(page > 0)
				{
					page--;
				}
				else if(chapter > 0)
				{
					((GuiButton) buttonList.get(chapter + 3)).enabled = true;
					chapter--;
					page = 0;
					((GuiButton) buttonList.get(chapter + 3)).enabled = false;
				}
				break;
			case 1:
				if(page + 1 < chapters.get(chapter).pages.size())
				{
					page++;
				}
				else if(chapter + 1 <= chapters.size() - 1)
				{
					((GuiButton) buttonList.get(chapter + 3)).enabled = true;
					chapter++;
					page = 0;
					((GuiButton) buttonList.get(chapter + 3)).enabled = false;
				}
				break;
			case 2:
				((GuiButton) buttonList.get(chapter + 3)).enabled = true;
				chapter = 0;
				page = 0;
				((GuiButton) buttonList.get(chapter + 3)).enabled = false;
				break;
			default:
				((GuiButton) buttonList.get(chapter + 3)).enabled = true;
				chapter = button.id - 3;
				((GuiButton) buttonList.get(chapter + 3)).enabled = false;
				break;
		}
	}

	@SideOnly(Side.CLIENT)
	static class BookButton extends GuiButton
	{
		private final boolean	mirror;

		int						iconX, iconY, iconW, iconH;

		public BookButton(int id, int x, int y, boolean mirror, int iconX, int iconY, int iconW, int iconH)
		{
			super(id, x, y, iconW, iconH, "");
			this.mirror = mirror;
			this.iconX = iconX;
			this.iconY = iconY;
			this.iconW = iconW;
			this.iconH = iconH;
		}

		/**
		 * Draws this button to the screen.
		 */
		@Override
		public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_)
		{
			if(visible)
			{
				final boolean flag = (p_146112_2_ >= xPosition && p_146112_3_ >= yPosition && p_146112_2_ < xPosition + width && p_146112_3_ < yPosition + height) || !enabled;
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				//p_146112_1_.getTextureManager().bindTexture(guiLocation2);
				int k = iconX;
				int l = iconY;

				if(flag)
				{
					k += iconW;
				}

				if(!mirror)
				{
					l += iconH;
				}

				drawTexturedModalRect(xPosition, yPosition, k, l, iconW, iconH);
			}
		}

	}

	@SideOnly(Side.CLIENT)
	static class Chapter
	{
		List<Page>	pages;
		int			buttonU, buttonV;
		int			number;

		public Chapter(int number, int pages2)
		{
			this.number = number;

			pages = new ArrayList<Page>();

			for(int i = 0; i < pages2; i++)
			{
				pages.add(new Page(number, i));
			}
		}

		public Chapter(int number, List<Page> pages)
		{
			this.number = number;
			this.pages = pages;
		}

		public BookButton getButton(int id, int w, int h)
		{
			return new BookButton(id, ((w + 256) / 2) - 8,
					64 + 15 + (id - 3) * 22, true, 0, (id - 3) * 22, 35, 22);
		}
	}

	@SideOnly(Side.CLIENT)
	static class Page
	{
		/*		enum TYPES {TEXT, CRAFTING1, CRAFTING2, FORGE1, FORGE2, FORGE3, ALLOY};
				0 = TEXT
				1 = CRAFTING1
				2 = CRAFTING2
				3 = FORGE1
				4 = FORGE2
				5 = FORGE3
				6 = ALLOY

				because apparently java overcomplicated enums to all hell
		 */

		int						type;
		int						chapter;
		int						page;

		List<DynamicToolPart>	TCRecipe;
		int						TCCycleTimer	= 0;
		List<Integer>			TCItemCycle		= new ArrayList<Integer>();

		ItemStack				result1, result2, result3;

		//Text
		public Page(int chapter, int number)
		{
			type = 0;
			this.chapter = chapter;
			page = number;
		}

		/*Crafting 1 recipe
		 * recipe - up to 9 stacks
		 * 
		 * list to grid looks like
		 * 1 2 3
		 * 4 5 6
		 * 7 8 9
		 */
		public Page(int chapter, int number, ItemStack result)
		{
			type = 1;
			this.chapter = chapter;
			page = number;
			result1 = result;
		}

		/*Crafting 2 recipe
		 * recipe1 - up to 9 stacks
		 * recipe2 - up to 9 stacks
		 * 
		 * list to grid looks like
		 * 1 2 3
		 * 4 5 6
		 * 7 8 9
		 */
		public Page(int chapter, int number, ItemStack result1, ItemStack result2)
		{
			type = 2;
			this.chapter = chapter;
			page = number;

			this.result1 = result1;
			this.result2 = result2;
		}

		public Page(int chapter, int number, DynamicToolPart item1, DynamicToolPart item2, DynamicToolPart item3, DynamicToolPart item4)
		{
			type = 3;
			this.chapter = chapter;
			page = number;

			TCRecipe = new ArrayList<DynamicToolPart>();
			TCRecipe.add(item1);
			TCRecipe.add(item2);
			if(item3 != null)
			{
				TCRecipe.add(item3);
			}
			if(item4 != null)
			{
				TCRecipe.add(item4);
			}
		}

		public void draw(GuiScreen gui, FontRenderer fontRendererObj, int w, int h, RenderItem itemRender)
		{
			drawText(fontRendererObj, w, h);
			switch(type)
			{
				case 0:
					drawTextRight(fontRendererObj, w, h);
					break;
				case 1:
					drawCraftPage(gui, 1, w, h, fontRendererObj, itemRender);
					break;
				case 2:
					drawCraftPage(gui, 2, w, h, fontRendererObj, itemRender);
					break;
				case 3:
					drawForgePage(gui, 2, w, h, fontRendererObj, itemRender);
					break;
			}
		}

		public void drawText(FontRenderer fontRendererObj, int w, int h)
		{
			final int titleSize = fontRendererObj.getStringWidth(StatCollector.translateToLocal("book.chapter" + chapter + ".page" + page + ".titleL"));
			fontRendererObj.drawString(StatCollector.translateToLocal("book.chapter" + chapter + ".page" + page + ".titleL"), ((w - 256) / 2) + 64 - titleSize, 64 + 14, 0);

			drawCenteredSplit(((w - 256) / 2) + 68, 84, StatCollector.translateToLocal("book.chapter" + chapter + ".page" + page + ".ContentL"), fontRendererObj);
		}

		public void drawTextRight(FontRenderer fontRendererObj, int w, int h)
		{
			final int titleSize = fontRendererObj.getStringWidth(StatCollector.translateToLocal("book.chapter" + chapter + ".page" + page + ".titleR"));
			fontRendererObj.drawString(StatCollector.translateToLocal("book.chapter" + chapter + ".page" + page + ".titleR"), ((w + 256) / 2) - 72 - titleSize, 64 + 14, 0);

			drawCenteredSplit(((w + 256) / 2) - 72, 84, StatCollector.translateToLocal("book.chapter" + chapter + ".page" + page + ".ContentR"), fontRendererObj);
		}

		private void drawCraftPage(GuiScreen gui, int numOfCrafts, int w, int h, FontRenderer fontRendererObj, RenderItem itemRender)
		{
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			gui.mc.getTextureManager().bindTexture(guiLocation2);
			final IRecipe recipe;
			switch(numOfCrafts)
			{
				case 1:
					gui.drawTexturedModalRect(w / 2 + 7, h / 2 - 49, 157, 0, 99, 56);
					recipe = lookUpRecipe(result1);

					DrawRecipe(fontRendererObj, gui.mc.getTextureManager(), recipe, 10, -46, w, h);
					break;
				case 2:
					gui.drawTexturedModalRect((w - 256) / 2 + 7, 64 + 33, 157, 0, 99, 56);

					recipe = lookUpRecipe(result1);

					DrawRecipe(fontRendererObj, gui.mc.getTextureManager(), recipe, 7, 60, w, h);

					gui.drawTexturedModalRect((w - 256) / 2 + 7, 64 + 94, 157, 0, 99, 56);
					break;
				default:
					break;
			}
			GL11.glEnable(GL11.GL_BLEND);
		}

		private void drawForgePage(GuiScreen gui, int numOfCrafts, int w, int h, FontRenderer fontRendererObj, RenderItem itemRender)
		{
			if(TCCycleTimer == 0)
			{
				TCItemCycle.clear();
				for(int i = 0; i < 4; i++)
				{
					TCItemCycle.add(gui.mc.theWorld.rand.nextInt(18));
				}
				TCCycleTimer = 100;
			}
			else
			{
				TCCycleTimer--;
			}

			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			RenderHelper.enableGUIStandardItemLighting();
			gui.mc.getTextureManager().bindTexture(guiLocation2);
			final IRecipe recipe;

			gui.drawTexturedModalRect(w / 2 + 7, h / 2 - 48, 157, 57, 99, 40);

			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, gui.mc.getTextureManager(), new ItemStack(
					TCRecipe.get(0), 1, TCItemCycle.get(0)), w / 2 + 45, h / 2 - 37);
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, gui.mc.getTextureManager(), new ItemStack(
					TCRecipe.get(1), 1, TCItemCycle.get(1)), w / 2 + 27, h / 2 - 45);
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, gui.mc.getTextureManager(), new ItemStack(
					TCRecipe.get(2), 1, TCItemCycle.get(2)), w / 2 + 28, h / 2 - 27);

			if(TCRecipe.size() <= 3)
			{
				itemRender.renderItemAndEffectIntoGUI(fontRendererObj, gui.mc.getTextureManager(), ToolBuilder.instance.buildTool(new ItemStack(
						TCRecipe.get(0), 1, TCItemCycle.get(0)), new ItemStack(
								TCRecipe.get(1), 1, TCItemCycle.get(1)), new ItemStack(
										TCRecipe.get(2), 1, TCItemCycle.get(2)), "Result"), w / 2 + 87, h / 2 - 37);
			}
			else
			{

				itemRender.renderItemAndEffectIntoGUI(fontRendererObj, gui.mc.getTextureManager(), new ItemStack(
						TCRecipe.get(3), 1, TCItemCycle.get(3)), w / 2 + 11, h / 2 - 37);
				itemRender.renderItemAndEffectIntoGUI(fontRendererObj, gui.mc.getTextureManager(), ToolBuilder.instance.buildTool(new ItemStack(
						TCRecipe.get(0), 1, TCItemCycle.get(0)), new ItemStack(
						TCRecipe.get(1), 1, TCItemCycle.get(1)), new ItemStack(
						TCRecipe.get(2), 1, TCItemCycle.get(2)), new ItemStack(
						TCRecipe.get(3), 1, TCItemCycle.get(3)), "Result"), w / 2 + 87, h / 2 - 37);
			}

			GL11.glEnable(GL11.GL_BLEND);
		}
	}

	static void drawCenteredSplit(int x, int y, String str, FontRenderer fontRendererObj)
	{
		int index = 0;
		int h = 0;
		int endIndex = 0;
		int spaceIndex = 0;
		while(str.length() > index)
		{
			endIndex = index + 22;
			if(index + 22 > str.length())
			{
				endIndex = str.length();
			}

			String sub = "";
			spaceIndex = endIndex;

			for(int i = index; i < endIndex; i++)
			{
				final char test = str.toCharArray()[i];
				if(test == ' ')
				{
					spaceIndex = i;
				}
				if(i == endIndex - 1)
				{
					if(test != ' ' && i != str.length() - 1)
					{
						sub = str.substring(index, spaceIndex);
						index = spaceIndex;
					}
					else
					{
						sub = str.substring(index, endIndex);
						index = endIndex;
					}
				}
			}

			h += fontRendererObj.FONT_HEIGHT;
			fontRendererObj.drawString(sub, x - fontRendererObj.getStringWidth(sub) / 2, h + y, 0);
		}
	}

	static IRecipe lookUpRecipe(ItemStack stack)
	{
		final List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		final Iterator<IRecipe> recipe = recipes.iterator();

		while(recipe.hasNext())
		{
			final ItemStack next = recipe.next().getRecipeOutput();
			if(next != null)
			{
				if(next.getItem() == stack.getItem())
					return recipe.next();
			}
		}
		return null;
	}

	static void DrawRecipe(FontRenderer font, TextureManager tex, IRecipe recipe, int x, int y, int w, int h)
	{
		if(recipe instanceof ShapelessRecipes)
		{
			final ShapelessRecipes SRecipe = (ShapelessRecipes) recipe;
			for(int i = 0; i < 9; i++)
			{
				if(SRecipe.recipeItems.get(i) != null)
				{
					if(((ItemStack) SRecipe.recipeItems.get(i)).getItem() instanceof ItemBlock)
					{
						RenderHelper.enableStandardItemLighting();
					}
					else
					{
						RenderHelper.enableGUIStandardItemLighting();
					}
					itemRender.renderItemAndEffectIntoGUI(font, tex, (ItemStack) SRecipe.recipeItems.get(i), w / 2 + x + ((i % 3) * 17), h / 2 + y + (i / 3 * 17));
				}
			}
		}
		else if(recipe instanceof ShapedOreRecipe)
		{
			//			final ShapedOreRecipe SRecipe = (ShapedOreRecipe) recipe;
			//			for(int i = 0; i < 9; i++)
			//			{
			//				if(SRecipe.getInput() != null && OreDictionary. SRecipe.getInput()[i] instanceof ItemStack)
			//				{
			//					if(((ItemStack) SRecipe.getInput()[i]).getItem() instanceof ItemBlock)
			//					{
			//						RenderHelper.enableStandardItemLighting();
			//					}
			//					else
			//					{
			//						RenderHelper.enableGUIStandardItemLighting();
			//					}
			//					itemRender.renderItemAndEffectIntoGUI(font, tex, (ItemStack) SRecipe.getInput()[i], w / 2 + x + ((i % 3) * 17), h / 2 + y + (i / 3 * 17));
			//				}
			//			}
		}
		else if(recipe instanceof ShapelessOreRecipe)
		{
			//			final ShapelessOreRecipe SRecipe = (ShapelessOreRecipe) recipe;
			//			for(int i = 0; i < 9; i++)
			//			{
			//				if(SRecipe.getInput() != null && SRecipe.getInput().get(i) instanceof ItemStack)
			//				{
			//					if(((ItemStack) SRecipe.getInput().get(i)).getItem() instanceof ItemBlock)
			//					{
			//						RenderHelper.enableStandardItemLighting();
			//					}
			//					else
			//					{
			//						RenderHelper.enableGUIStandardItemLighting();
			//					}
			//					itemRender.renderItemAndEffectIntoGUI(font, tex, (ItemStack) SRecipe.getInput().get(i), w / 2 + x + ((i % 3) * 17), h / 2 + y + (i / 3 * 17));
			//				}
			//			}
		}
		else
		{
			final ShapedRecipes SRecipe = (ShapedRecipes) recipe;
			for(int i = 0; i < 9; i++)
			{
				if(SRecipe.recipeItems[i] != null)
				{
					if(SRecipe.recipeItems[i].getItem() instanceof ItemBlock)
					{
						RenderHelper.enableStandardItemLighting();
					}
					else
					{
						RenderHelper.enableGUIStandardItemLighting();
					}
					itemRender.renderItemAndEffectIntoGUI(font, tex, SRecipe.recipeItems[i], w / 2 + x + ((i % 3) * 17), h / 2 + y + (i / 3 * 17));
				}
			}
		}
		itemRender.renderItemAndEffectIntoGUI(font, tex, recipe.getRecipeOutput(), w / 2 + 87, 64 + 83);

	}
}
