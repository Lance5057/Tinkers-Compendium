package lance5057.tDefense.renderers.deserializers;

import lance5057.tDefense.renderers.info.TDMaterialRenderInfo;
import slimeknights.tconstruct.library.client.MaterialRenderInfo;
import slimeknights.tconstruct.library.client.material.deserializers.AbstractRenderInfoDeserializer;

public class AlphaColorTextureDeserializer extends AbstractRenderInfoDeserializer {

	protected String color;

	@Override
	public MaterialRenderInfo getMaterialRenderInfo() {
		return new TDMaterialRenderInfo.AlphaColor(fromHex(color));
	}
}