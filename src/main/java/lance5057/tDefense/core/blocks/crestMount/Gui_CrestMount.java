package lance5057.tDefense.core.blocks.crestMount;

import org.lwjgl.opengl.GL11;

import lance5057.tDefense.TinkersDefense;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class Gui_CrestMount extends GuiContainer
{
	private static final ResourceLocation	iconLocation	= new ResourceLocation(
			"tinkersdefense",
			"textures/gui/crest_mount.png");

	private final TileEntity_CrestMount		inventory;

	public Gui_CrestMount(InventoryPlayer invPlayer, TileEntity_CrestMount te_crest)
	{
		super(new Container_CrestMount(invPlayer, te_crest));
		inventory = te_crest;

	}

	@Override
	public void initGui()
	{
		super.initGui();
		buttonList.add(new GuiButton(1, guiLeft + 61,
				guiTop + 8, 18, 18, "Flip"));
		buttonList.add(new GuiButton(3, guiLeft + 79,
				guiTop + 8, 18, 18, "Flip"));
		buttonList.add(new GuiButton(2, guiLeft + 97,
				guiTop + 8, 18, 18, "Flip"));

		buttonList.add(new GuiButton(4, guiLeft + 79,
				guiTop + 63, 18, 18, "Flip"));
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		for(int i = 1; i < 5; i++)
		{
			if(button.id == i)
			{
				if(inventory.flip[i - 1] == false)
				{
					inventory.flip[i - 1] = true;
				}
				else
				{
					inventory.flip[i - 1] = false;
				}

				TinkersDefense.INSTANCE.sendToServer(new Message_CrestMount(
						inventory.getPos(),
						inventory.flip));
			}
		}
	}

	@Override
	public void drawScreen(int par1, int par2, float par3)
	{
		super.drawScreen(par1, par2, par3);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(iconLocation);
		final int k = (width - xSize) / 2;
		final int l = (height - ySize) / 2;
		drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
	}
}
