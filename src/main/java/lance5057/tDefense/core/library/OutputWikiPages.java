package lance5057.tDefense.core.library;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import lance5057.tDefense.core.library.materialutilities.MaterialBase;
import lance5057.tDefense.core.library.materialutilities.MaterialHelper;
import lance5057.tDefense.core.materials.stats.ShieldMaterialStats;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.utils.HarvestLevels;

public class OutputWikiPages {
	public static void outputWikiMaterial(MaterialHelper mat) {
		try {
			PrintWriter out = new PrintWriter(
					"C:\\Users\\Tyler\\Documents\\Tinkers-Compendium.wiki\\" + mat.mat.getLocalizedName() + ".md");
			out.write("# " + mat.mat.getLocalizedName() + "\n");

			for (MaterialBase mb : mat.addons) {
				mb.setupWiki(mat, out);
			}

			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void outputWikiSidebar(List<MaterialHelper> materials) {
		try {
			PrintWriter out = new PrintWriter("C:\\Users\\Tyler\\Documents\\Tinkers-Compendium.wiki\\_Sidebar.md");

			out.write("## [Home](https://github.com/Lance5057/Tinkers-Defense/wiki)\n\n");
			out.write("## Materials\n");

			out.write(
					"[Quick Reference](https://github.com/Lance5057/Tinkers-Defense/wiki/Material-Quick-Reference)\n");

			out.write("<details><summary>Materials</summary>\n\n");

			for (MaterialHelper m : materials) {
				out.write("[" + m.mat.getLocalizedName() + "](https://github.com/Lance5057/Tinkers-Compendium/wiki/"
						+ m.mat.getLocalizedName().replace(' ', '_') + ")\n\n");
			}

			out.write("</details>\n\n");

			out.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createMaterialOutput(HeadMaterialStats head, HandleMaterialStats handle,
			ShieldMaterialStats shield, ExtraMaterialStats extra, BowMaterialStats bow, PrintWriter out) {
		out.write("### Tools and Weapons \n\n");

		// Head
		out.write("#### Head \n\n");
		out.write("|||||\n");
		out.write("|-|-|-|-|\n");

		out.write("|Durability|Mining Speed|Harvest Level|Attack|\n");

		out.write("|" + head.durability);
		out.write("|" + head.miningspeed);
		out.write("|" + HarvestLevels.getHarvestLevelName(head.harvestLevel).substring(3));
		out.write("|" + head.attack + "|\n\n");

		// Handle
		out.write("#### Handle \n\n");

		out.write("|||\n");
		out.write("|-|-|\n");

		out.write("|Durability|Modifier|\n");

		out.write("|" + handle.durability);
		out.write("|" + handle.modifier + "|\n\n");

		// Extra
		out.write("#### Extra \n\n");

		out.write("||\n");
		out.write("|-|\n");

		out.write("|Durability|\n");

		out.write("|" + extra.extraDurability + "|\n\n");

		// Bow
		out.write("#### Bow \n\n");
		out.write("||||\n");
		out.write("|-|-|-|\n");

		out.write("|Drawspeed|Range|Bonus Damage|\n");

		out.write("|" + bow.drawspeed);
		out.write("|" + bow.range);
		out.write("|" + bow.bonusDamage + "|\n\n");

		// Shield
		out.write("#### Shield \n\n");
		out.write("|||\n");
		out.write("|-|-|\n");

		out.write("|Durability|Percent Blocked|\n");

		out.write("|" + shield.durability);
		out.write("|" + shield.percentBlocked + "|\n\n");
	}
}
