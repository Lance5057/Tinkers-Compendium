package lance5057.tDefense.core.library.materialutilities;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.library.OutputWikiPages;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;

public class MaterialHelper {
	String name;
	int color;

	public Material mat;
	MaterialIntegration matint;
	public List<MaterialBase> addons;

	boolean preset = false;

	public MaterialHelper(String name, int color) {
		this.name = "td_" + name;
		this.color = color;

		mat = new Material(name, color);
		addons = new ArrayList<MaterialBase>();
	}

	public MaterialHelper(Material mat) {
		this.name = mat.identifier;
		this.color = mat.materialTextColor;

		this.mat = mat;
		addons = new ArrayList<MaterialBase>();

		preset = true;
	}

	public void pre() {
		for (MaterialBase mb : addons) {
			mb.setupPre(this);
		}
	}

	public void init() {
		for (MaterialBase mb : addons) {
			mb.setupInit(this);
		}
	}

	public void integrate() {
		if (!preset) {
			matint = new MaterialIntegration(mat, null, StringUtils.capitalize(mat.identifier));

			for (MaterialBase mb : addons) {
				mb.setupIntegration(matint);
			}
			matint.toolforge().preInit();

			TinkersCompendium.proxy.registerMatColor(mat, color);

			TinkerRegistry.integrate(matint);
		}
	}

	public void post() {
		for (MaterialBase mb : addons) {
			mb.setupPost(this);
		}

		if (!preset)
			matint.integrate();
		
		if(TinkersCompendium.config.developerFeatures)
		{
			OutputWikiPages.outputWikiMaterial(this);
		}
	}

	public void client() {
		for (MaterialBase mb : addons) {
			mb.setupClient(this);
		}
	}

	public void models() {
		for (MaterialBase mb : addons) {
			mb.setupModels(this);
		}
	}
}
