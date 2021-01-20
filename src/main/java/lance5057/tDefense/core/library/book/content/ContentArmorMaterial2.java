package lance5057.tDefense.core.library.book.content;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import c4.conarm.lib.ArmoryRegistry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.gson.annotations.SerializedName;

import lance5057.tDefense.core.materials.CompendiumMaterials;
import lance5057.tDefense.core.materials.stats.*;
import lance5057.tDefense.core.parts.TDParts;
import c4.conarm.common.ConstructsRegistry;
import lance5057.tDefense.core.tools.TDTools;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.client.book.data.BookData;
import slimeknights.mantle.client.book.data.element.TextData;
import slimeknights.mantle.client.gui.book.GuiBook;
import slimeknights.mantle.client.gui.book.element.BookElement;
import slimeknights.mantle.client.gui.book.element.ElementItem;
import slimeknights.mantle.client.gui.book.element.ElementText;
import slimeknights.mantle.util.LocUtils;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.book.TinkerPage;
import slimeknights.tconstruct.library.book.content.ContentMaterial;
import slimeknights.tconstruct.library.book.elements.ElementTinkerItem;
import slimeknights.tconstruct.library.materials.IMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.traits.ITrait;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.smeltery.block.BlockCasting;
import slimeknights.tconstruct.tools.TinkerTools;
import slimeknights.tconstruct.tools.common.block.BlockToolTable;

@SideOnly(Side.CLIENT)
public class ContentArmorMaterial2 extends ContentMaterial {

  public static final String ID = "td_armormaterial";

  private transient Material material;
  @SerializedName("td_armormaterial")
  public String materialName;

  public ContentArmorMaterial2(Material material) {
    super(material);
    this.material = material;
  }

  @Override
  public void build(BookData book, ArrayList<BookElement> list, boolean rightSide) {
    addTitle(list, material.getLocalizedNameColored(), true);

    // the cool tools to the left/right
    addDisplayItems(list, rightSide ? GuiBook.PAGE_WIDTH - -8 : 0);

    int col_margin = 22;
    int top = 15;
    int left = rightSide ? 0 : col_margin;

    int y = top + 10;
    int x = left + 10;
    int w = GuiBook.PAGE_WIDTH / 2 - -10;
    int h = GuiBook.PAGE_HEIGHT / 2 - 20;

    LinkedHashSet<ITrait> allTraits = new LinkedHashSet<>();

    addStatsDisplay(x, y, w, list, allTraits, HelmMaterialStats.TYPE);
    addStatsDisplay(x + w, y, w - 10, list, allTraits, ChestMaterialStats.TYPE);
    addStatsDisplay(x, y + h, w, list, allTraits, LegsMaterialStats.TYPE);
    addStatsDisplay(x + w, y + h, w- 10, list, allTraits, FeetMaterialStats.TYPE);

    // inspirational quote
    String flavour = parent.parent.parent.strings.get(String.format("%s.flavour", material.getIdentifier()));
    //flavour = "How much wood could a woodchuck chuck if a woodchuck could chuck wood?";
    if(flavour != null) {
      TextData flavourData = new TextData("\"" + flavour + "\"");
      flavourData.italic = true;
      list.add(new ElementText(x + w, y, w - 16, 60, flavourData));
    }
  }

  public boolean hasUseForStat(IToolPart part, String stat) {
    for(ToolCore tool : TinkerRegistry.getTools()) {
      for(PartMaterialType pmt : tool.getRequiredComponents()) {
        if(pmt.isValidItem(part) && pmt.usesStat(stat)) {
          return true;
        }
      }
    }

    return false;
  }

  private void addStatsDisplay(int x, int y, int w, ArrayList<BookElement> list, LinkedHashSet<ITrait> allTraits, String stattype) {
    IMaterialStats stats = material.getStats(stattype);
    if(stats == null) {
      return;
    }

    List<ITrait> traits = material.getAllTraitsForStats(stats.getIdentifier());
    allTraits.addAll(traits);

    // create a list of all valid toolparts with the stats
    List<ItemStack> parts = Lists.newLinkedList();
    for(IToolPart part : TDParts.getAllToolParts()) {
      if(this.hasUseForStat(part, stats.getIdentifier())) {
        parts.add(part.getItemstackWithMaterial(material));
      }
    }

    // said parts next to the name
    if(parts.size() > 0) {
      ElementItem display = new ElementTinkerItem(x, y + 1, 0.5f, parts);
      list.add(display);
    }

    // and the name itself
    ElementText name = new ElementText(x + 10, y, w - 10, 10, stats.getLocalizedName());
    name.text[0].underlined = true;
    list.add(name);
    y += 12;

    List<TextData> lineData = Lists.newArrayList();
    // add lines of tool information
    lineData.addAll(getStatLines(stats));
    lineData.addAll(getTraitLines(traits, material));

    list.add(new ElementText(x, y, w, GuiBook.PAGE_HEIGHT, lineData));
  }

  public static List<TextData> getStatLines(IMaterialStats stats) {
    List<TextData> lineData = new ArrayList<>();
    for(int i = 0; i < stats.getLocalizedInfo().size(); i++) {
      TextData text = new TextData(stats.getLocalizedInfo().get(i));
      text.tooltip = LocUtils.convertNewlines(stats.getLocalizedDesc().get(i)).split("\n");
      lineData.add(text);
      lineData.add(new TextData("\n"));
    }
    return lineData;
  }

  public static List<TextData> getTraitLines(List<ITrait> traits, Material material) {
    List<TextData> lineData = new ArrayList<>();
    for(ITrait trait : traits) {
      TextData text = new TextData(trait.getLocalizedName());
      text.tooltip = LocUtils.convertNewlines(material.getTextColor() + trait.getLocalizedDesc()).split("\n");
      text.color = TextFormatting.DARK_GRAY.getFriendlyName();
      text.underlined = true;
      lineData.add(text);
      lineData.add(new TextData("\n"));
    }
    return lineData;
  }

  private void addDisplayItems(ArrayList<BookElement> list, int x) {
    List<ElementItem> displayTools = Lists.newArrayList();

    int y = 10;

    // representative item first
    if(!material.getRepresentativeItem().isEmpty()) {
      displayTools.add(new ElementTinkerItem(material.getRepresentativeItem()));
    }
    // then "craftability"
    if(material.isCraftable()) {
      ItemStack partbuilder = new ItemStack(TinkerTools.toolTables, 1, BlockToolTable.TableTypes.PartBuilder.meta);
      ElementItem elementItem = new ElementTinkerItem(partbuilder);
      elementItem.tooltip = ImmutableList.of(parent.translate("material.craft_partbuilder"));
      displayTools.add(elementItem);
    }
    if(material.isCastable()) {
      ItemStack basin = new ItemStack(TinkerSmeltery.castingBlock, 1, BlockCasting.CastingType.BASIN.getMeta());
      ElementItem elementItem = new ElementTinkerItem(basin);
      String text = parent.translate("material.craft_casting");
      elementItem.tooltip = ImmutableList.of(String.format(text, material.getFluid().getLocalizedName(new FluidStack(material.getFluid(), 0))));
      displayTools.add(elementItem);
    }

    // build a range of tools to fill the "bar" at the side
    ArmorCore[] armor = new ArmorCore[]{TDTools.helm, TDTools.breastplate, TDTools.grieves, TDTools.sabatons,
                                        TDTools.coif, TDTools.hauberk, TDTools.chausses, TDTools.chainboots};

    for(ArmorCore tool : armor) {
      if(tool == null) {
        continue;
      }
      ImmutableList.Builder<Material> builder = ImmutableList.builder();
      for(int i = 0; i < tool.getRequiredComponents().size(); i++) {
    	  //if(tool.getRequiredComponents().get(i) instanceof FabricMaterialStats)
        builder.add(material);
      }
      builder.add(CompendiumMaterials.white.mat);
      ItemStack builtTool = tool.buildItem(builder.build());
      displayTools.add(new ElementTinkerItem(builtTool));

      if(displayTools.size() == 10) {
        break;
      }
    }

    // built tools
    if(!displayTools.isEmpty()) {
      for(ElementItem element : displayTools) {
        element.x = x;
        element.y = y;
        element.scale = 1f;
        y += ElementItem.ITEM_SIZE_HARDCODED;
        list.add(element);
      }
    }
  }
}