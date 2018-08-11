package lance5057.tDefense.core.parts;

import java.util.List;

import javax.annotation.Nullable;

import lance5057.tDefense.TinkersDefense;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import slimeknights.tconstruct.common.config.Config;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.tools.ToolPart;

public class ComponentPart extends ToolPart {

	boolean cast = true;
	boolean craft = true;

	public ComponentPart setCast(boolean cast) {
		this.cast = cast;
		return this;
	}

	public ComponentPart setCraft(boolean craft) {
		this.craft = craft;
		return this;
	}

	public ComponentPart(int cost) {
		super(cost);
		this.setCreativeTab(TinkersDefense.tab);
	}

	public ComponentPart(int cost, boolean craft, boolean cast) {
		super(cost);
		this.setCreativeTab(TinkersDefense.tab);
		this.cast = cast;
		this.craft = craft;
	}

	@Override
	public boolean canBeCrafted() {
		return craft;
	}

	@Override
	public boolean canBeCasted() {
		return cast;
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
		if (this.isInCreativeTab(tab)) {
			// this adds a variant of each material to the creative menu
			for (Material mat : TinkerRegistry.getAllMaterials()) {
				if (mat.hasStats(MaterialTypes.HEAD) && (mat.isCraftable() || mat.isCastable())) {
					subItems.add(getItemstackWithMaterial(mat));
					if (!Config.listAllMaterials) {
						break;
					}
				}
			}
		}
	}

	@Override
	public boolean canUseMaterial(Material mat) {
		return true;
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		// no stats n stuff
	}
}