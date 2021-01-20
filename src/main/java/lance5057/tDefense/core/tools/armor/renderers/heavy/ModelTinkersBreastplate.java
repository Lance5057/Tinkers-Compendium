package lance5057.tDefense.core.tools.armor.renderers.heavy;

import lance5057.tDefense.core.library.interfaces.IFinishingAnvil;
import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.item.ItemStack;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelTinkersBreastplate extends ArmorRenderer {
    public ModelRenderer BackPlate;
    public ModelRenderer BreastPlate;
    public ModelRenderer Plackart; 
    public ModelRenderer PauldronR;
    public ModelRenderer PauldronL;
    public ModelRenderer ArmR;
    public ModelRenderer ArmL;
    public ModelRenderer Pauldron2L;
    public ModelRenderer Pauldron2R;

    // Gauntlet
    public ModelRenderer gauntletLeft;
    public ModelRenderer gauntletRight;
    public ModelRenderer gauntletLeft2;
    public ModelRenderer gauntletRight2;
    public ModelRenderer ArmSpikesL;
    public ModelRenderer ArmSpikesR;
    public ModelRenderer ArmSpikesBackL;
    public ModelRenderer ArmSpikesBackR;
    public ModelRenderer VamSpikesL;
    public ModelRenderer VamSpikesR;
    public ModelRenderer VamSpikesBackL;
    public ModelRenderer VamSpikesBackR;
    public ModelRenderer KnuckleSpikesL;
    public ModelRenderer KnuckleSpikesR;
    public ModelRenderer KnuckleSpikesMidL;
    public ModelRenderer KnuckleSpikesMidR;
    public ModelRenderer KnuckleSpikesBackR;
    public ModelRenderer KnuckleSpikesBackL;
    public ModelRenderer VambraceL;
    public ModelRenderer VambraceR;

    public ModelTinkersBreastplate(ItemStack stack) {
    	super(0.25f, 0, 128, 128, stack);
        this.textureWidth = 128;
        this.textureHeight = 128;

        this.ArmL = new ModelRenderer(this, 92, 12);
        this.ArmL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ArmL.addBox(-1.0F, -1.5F, -3.0F, 5, 8, 6, 0.0F);
        this.bipedLeftArm.addChild(ArmL);

        this.PauldronR = new ModelRenderer(this, 88, 0);
        this.PauldronR.mirror = true;
        this.PauldronR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.PauldronR.addBox(-4.6F, -2.0F, -3.5F, 4, 5, 7, 0.1F);
        this.setRotateAngle(PauldronR, 0.0F, 0.0F, 0.4363323129985824F);
        this.bipedRightArm.addChild(PauldronR);

        this.Plackart = new ModelRenderer(this, 64, 10);
        this.Plackart.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Plackart.addBox(-4.0F, 5.0F, -3.0F, 8, 7, 6, 0.3F);
        this.bipedBody.addChild(Plackart);
        
        this.ArmR = new ModelRenderer(this, 92, 12);
        this.ArmR.mirror = true;
        this.ArmR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ArmR.addBox(-4.0F, -1.5F, -3.0F, 5, 8, 6, 0.0F);
        this.bipedRightArm.addChild(ArmR);
        
        this.BackPlate = new ModelRenderer(this, 64, 24);
        this.BackPlate.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BackPlate.addBox(-4.0F, -0.1F, 1.0F, 8, 5, 3, 0.41F);
        this.setRotateAngle(BackPlate, -0.08726646259971647F, 0.0F, 0.0F);
        this.bipedBody.addChild(BackPlate);
        
        this.Pauldron2L = new ModelRenderer(this, 88, 0);
        this.Pauldron2L.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Pauldron2L.addBox(0.5F, -2.5F, -3.5F, 4, 4, 7, -0.4F);
        this.setRotateAngle(Pauldron2L, 0.0F, 0.0F, -1.1344640137963142F);
        this.bipedLeftArm.addChild(Pauldron2L);
        
        this.Pauldron2R = new ModelRenderer(this, 88, 0);
        this.Pauldron2R.mirror = true;
        this.Pauldron2R.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Pauldron2R.addBox(-4.5F, -2.5F, -3.5F, 4, 4, 7, -0.4F);
        this.setRotateAngle(Pauldron2R, 0.0F, 0.0F, 1.1344640137963142F);
        this.bipedRightArm.addChild(Pauldron2R);

        this.BreastPlate = new ModelRenderer(this, 64, 0);
        this.BreastPlate.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BreastPlate.addBox(-4.0F, 0.1F, -3.6F, 8, 6, 4, 0.41F);
        this.bipedBody.addChild(BreastPlate);

        this.PauldronL = new ModelRenderer(this, 88, 0);
        this.PauldronL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.PauldronL.addBox(0.5F, -2.0F, -3.5F, 4, 5, 7, 0.1F);
        this.setRotateAngle(PauldronL, 0.0F, 0.0F, -0.4363323129985824F);
        this.bipedLeftArm.addChild(PauldronL);

        this.gauntletLeft = new ModelRenderer(this, 64, 32);
        this.gauntletLeft.setRotationPoint(0.0F, 7.50F, 0.0F);
        this.gauntletLeft.addBox(1.5F, 0.2F, -2.5F, 2, 3, 5, 0.0F);
        this.bipedLeftArm.addChild(gauntletLeft);

        this.gauntletRight = new ModelRenderer(this, 64, 32);
        this.gauntletRight.mirror = true;
        this.gauntletRight.setRotationPoint(0.0F, 7.50F, 0.0F);
        this.gauntletRight.addBox(-3.5F, 0.2F, -2.5F, 2, 3, 5, 0.0F);
        this.bipedRightArm.addChild(gauntletRight);

        this.gauntletLeft2 = new ModelRenderer(this, 78, 32);
        this.gauntletLeft2.setRotationPoint(0.0F, 7.50F, 0.0F);
        this.gauntletLeft2.addBox(-1.5F, 0.3F, -2.5F, 4, 3, 5, -0.2F);
        this.bipedLeftArm.addChild(gauntletLeft2);

        this.gauntletRight2 = new ModelRenderer(this, 78, 32);
        this.gauntletRight2.mirror = true;
        this.gauntletRight2.setRotationPoint(0.0F, 7.50F, 0.0F);
        this.gauntletRight2.addBox(-2.5F, 0.3F, -2.5F, 4, 3, 5, -0.2F);
        this.bipedRightArm.addChild(gauntletRight2);

        VambraceL = new ModelRenderer(this, "Vambrace Left");
        VambraceL.setTextureOffset(0, 48);
        VambraceL.mirror = true;
        VambraceL.setRotationPoint(0.0F, 0.0F, 0.0F);
        VambraceL.addBox(2.95F, 6.7F, -1.5F, 1, 2, 3, 0.0F);
        bipedLeftArm.addChild(VambraceL);

        VambraceR = new ModelRenderer(this, "Vambrace Right");
        VambraceR.setTextureOffset(0, 48);
        VambraceR.mirror = true;
        VambraceR.setRotationPoint(0.0F, 0.0F, 0.0F);
        VambraceR.addBox(-3.9F, 6.7F, -1.5F, 1, 2, 3, 0.0F);
        bipedRightArm.addChild(VambraceR);

        KnuckleSpikesL = new ModelRenderer(this, "Knuckle Spikes Left");
        KnuckleSpikesL.setTextureOffset(56, 40);
        KnuckleSpikesL.setRotationPoint(0.0F, 0.0F, 0.0F);
        KnuckleSpikesL.addBox(8.5F, 5.85F, -2.0F, 1, 1, 1, -0.1F);
        setRotateAngle(KnuckleSpikesL, 0.0F, 0.0F, 0.65F);
        bipedLeftArm.addChild(KnuckleSpikesL);

        KnuckleSpikesMidL = new ModelRenderer(this, "Knuckle Spikes Mid Left");
        KnuckleSpikesMidL.setTextureOffset(56, 40);
        KnuckleSpikesMidL.setRotationPoint(0.0F, 0.0F, 0.0F);
        KnuckleSpikesMidL.addBox(8.5F, 5.85F, -0.5F, 1, 1, 1, -0.1F);
        setRotateAngle(KnuckleSpikesMidL, 0.0F, 0.0F, 0.65F);
        bipedLeftArm.addChild(KnuckleSpikesMidL);

        KnuckleSpikesBackL = new ModelRenderer(this, "Knuckle Spikes Back Left");
        KnuckleSpikesBackL.setTextureOffset(56, 40);
        KnuckleSpikesBackL.setRotationPoint(0.0F, 0.0F, 0.0F);
        KnuckleSpikesBackL.addBox(8.5F, 5.85F, 1.0F, 1, 1, 1, -0.1F);
        setRotateAngle(KnuckleSpikesBackL, 0.0F, 0.0F, 0.65F);
        bipedLeftArm.addChild(KnuckleSpikesBackL);

        KnuckleSpikesR = new ModelRenderer(this, "Knuckle Spikes Right");
        KnuckleSpikesR.setTextureOffset(56, 40);
        KnuckleSpikesR.mirror = true;
        KnuckleSpikesR.setRotationPoint(0.0F, 0.0F, 0.0F);
        KnuckleSpikesR.addBox(3.22F, 9.9F, -2.0F, 1, 1, 1, -0.1F);
        setRotateAngle(KnuckleSpikesR, 0.0F, 0.0F, 0.65F);
        bipedRightArm.addChild(KnuckleSpikesR);

        KnuckleSpikesMidR = new ModelRenderer(this, "Knuckle Spikes Mid Right");
        KnuckleSpikesMidR.setTextureOffset(56, 40);
        KnuckleSpikesMidR.mirror = true;
        KnuckleSpikesMidR.setRotationPoint(0.0F, 0.0F, 0.0F);
        KnuckleSpikesMidR.addBox(3.22F, 9.9F, -0.5F, 1, 1, 1, -0.1F);
        setRotateAngle(KnuckleSpikesMidR, 0.0F, 0.0F, 0.65F);
        bipedRightArm.addChild(KnuckleSpikesMidR);

        KnuckleSpikesBackR = new ModelRenderer(this, "Knuckle Spikes Back Right");
        KnuckleSpikesBackR.setTextureOffset(56, 40);
        KnuckleSpikesBackR.mirror = true;
        KnuckleSpikesBackR.setRotationPoint(0.0F, 0.0F, 0.0F);
        KnuckleSpikesBackR.addBox(3.22F, 9.9F, 1.0F, 1, 1, 1, -0.1F);
        setRotateAngle(KnuckleSpikesBackR, 0.0F, 0.0F, 0.65F);
        bipedRightArm.addChild(KnuckleSpikesBackR);

        ArmSpikesL = new ModelRenderer(this, "Arm Spikes Left");
        ArmSpikesL.setTextureOffset(56, 32);
        ArmSpikesL.setRotationPoint(0.0F, 0.0F, 0.0F);
        ArmSpikesL.addBox(3.5F, 2.5F, 0.5F, 4, 3, 0, 0.0F);
        setRotateAngle(ArmSpikesL, 0.0F, 0.3490658503988659F, 0.0F);
        bipedLeftArm.addChild(ArmSpikesL);

        ArmSpikesR = new ModelRenderer(this, "Arm Spikes Right");
        ArmSpikesR.setTextureOffset(56, 32);
        ArmSpikesR.mirror = true;
        ArmSpikesR.setRotationPoint(0.0F, 0.0F, 0.0F);
        ArmSpikesR.addBox(-7.5F, 2.5F, 0.5F, 4, 3, 0, 0.0F);
        setRotateAngle(ArmSpikesR, 0.0F, -0.3490658503988659F, 0.0F);
        bipedRightArm.addChild(ArmSpikesR);

        ArmSpikesBackL = new ModelRenderer(this, "Arm Spikes Back Left");
        ArmSpikesBackL.setTextureOffset(56, 32);
        ArmSpikesBackL.setRotationPoint(0.0F, 0.0F, 0.0F);
        ArmSpikesBackL.addBox(3.5F, 2.5F, -0.5F, 4, 3, 0, 0.0F);
        setRotateAngle(ArmSpikesBackL, 0.0F, -0.3490658503988659F, 0.0F);
        bipedLeftArm.addChild(ArmSpikesBackL);

        ArmSpikesBackR = new ModelRenderer(this, "Arm Spikes Back Right");
        ArmSpikesBackR.setTextureOffset(56, 32);
        ArmSpikesBackR.mirror = true;
        ArmSpikesBackR.setRotationPoint(0.0F, 0.0F, 0.0F);
        ArmSpikesBackR.addBox(-7.5F, 2.5F, -0.5F, 4, 3, 0, 0.0F);
        setRotateAngle(ArmSpikesBackR, 0.0F, 0.3490658503988659F, 0.0F);
        bipedRightArm.addChild(ArmSpikesBackR);

        VamSpikesL = new ModelRenderer(this, "Vam Spikes Left");
        VamSpikesL.setTextureOffset(56, 35);
        VamSpikesL.setRotationPoint(0.0F, 0.0F, 0.0F);
        VamSpikesL.addBox(5.45F, 5.3F, 0.28F, 1, 2, 1, -0.2F);
        setRotateAngle(VamSpikesL, 0.0F, 0.0F, 0.3F);
        bipedLeftArm.addChild(VamSpikesL);

        VamSpikesR = new ModelRenderer(this, "Vam Spikes Right");
        VamSpikesR.setTextureOffset(56, 35);
        VamSpikesR.mirror = true;
        VamSpikesR.setRotationPoint(0.0F, 0.0F, 0.0F);
        VamSpikesR.addBox(-6.45F, 5.3F, 0.28F, 1, 2, 1, -0.2F);
        setRotateAngle(VamSpikesR, 0.0F, 0.0F, -0.3F);
        bipedRightArm.addChild(VamSpikesR);

        VamSpikesBackL = new ModelRenderer(this, "Vam Spikes Back Left");
        VamSpikesBackL.setTextureOffset(56, 35);
        VamSpikesBackL.setRotationPoint(0.0F, 0.0F, 0.0F);
        VamSpikesBackL.addBox(5.45F, 5.3F, -1.3F, 1, 2, 1, -0.2F);
        setRotateAngle(VamSpikesBackL, 0.0F, 0.0F, 0.3F);
        bipedLeftArm.addChild(VamSpikesBackL);

        VamSpikesBackR = new ModelRenderer(this, "vam Spikes Back Right");
        VamSpikesBackR.setTextureOffset(56, 35);
        VamSpikesBackR.mirror = true;
        VamSpikesBackR.setRotationPoint(0.0F, 0.0F, 0.0F);
        VamSpikesBackR.addBox(-6.45F, 5.3F, -1.3F, 1, 2, 1, -0.2F);
        setRotateAngle(VamSpikesBackR, 0.0F, 0.0F, -0.3F);
        bipedRightArm.addChild(VamSpikesBackR);
        
        //this.partsList = init(stack, this.boxList);
    }
}
