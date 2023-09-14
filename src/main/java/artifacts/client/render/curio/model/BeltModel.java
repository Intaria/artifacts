package artifacts.client.render.curio.model;

import artifacts.client.render.curio.CurioLayers;
import artifacts.client.render.curio.CurioRenderers;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

import java.util.function.Function;

public class BeltModel extends HumanoidModel<LivingEntity> {

    protected final ModelPart charm = body.getChild("charm");

    private final float xOffset;
    private final float zOffset;
    private final float rotation;

    public BeltModel(ModelPart part, Function<ResourceLocation, RenderType> renderType, float xOffset, float zOffset, float rotation) {
        super(part, renderType);
        this.xOffset = xOffset;
        this.zOffset = zOffset;
        this.rotation = rotation;
    }

    public BeltModel(ModelPart part, float xOffset, float zOffset, float rotation) {
        this(part, RenderType::entityCutoutNoCull, xOffset, zOffset, rotation);
    }

    public void setCharmPosition(int slot) {
        float xOffset = slot % 2 == 0 ? this.xOffset : -this.xOffset;
        float zOffset = slot % 4 < 2 ? this.zOffset : -this.zOffset;
        charm.setPos(xOffset, 9, zOffset);

        float rotation = slot % 4 < 2 ? 0 : (float) -Math.PI;
        rotation += slot % 2 == 0 ^ slot % 4 >= 2 ? this.rotation : -this.rotation;
        charm.yRot = rotation;
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of();
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(body);
    }

    public static BeltModel createAntidoteVesselModel() {
        return new BeltModel(CurioRenderers.bakeLayer(CurioLayers.ANTIDOTE_VESSEL), 4, -3, -0.5F);
    }

    public static BeltModel createCrystalHeartModel() {
        return new BeltModel(CurioRenderers.bakeLayer(CurioLayers.CRYSTAL_HEART), RenderType::entityTranslucent, 2.5F, -3.01F, 0);
    }

    private static MeshDefinition createBelt(CubeListBuilder charm) {
        CubeDeformation deformation = new CubeDeformation(0.5F);
        MeshDefinition mesh = createMesh(CubeDeformation.NONE, 0);

        mesh.getRoot().addOrReplaceChild(
                "body",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-4, 0, -2, 8, 12, 4, deformation),
                PartPose.ZERO
        );

        mesh.getRoot().getChild("body").addOrReplaceChild(
                "charm",
                charm,
                PartPose.ZERO
        );

        return mesh;
    }

    public static MeshDefinition createAntidoteVessel() {
        CubeListBuilder charm = CubeListBuilder.create();

        // jar
        charm.texOffs(0, 16);
        charm.addBox(-2, 0, -2, 4, 6, 4);

        // lid
        charm.texOffs(0, 26);
        charm.addBox(-1, -1, -1, 2, 1, 2);

        return createBelt(charm);
    }

    public static MeshDefinition createCrystalHeart() {
        CubeListBuilder charm = CubeListBuilder.create();

        charm.texOffs(0, 16);
        charm.addBox(-2.5F, 0, 0, 2, 3, 1);
        charm.texOffs(6, 16);
        charm.addBox(0.5F, 0, 0, 2, 3, 1);
        charm.texOffs(0, 20);
        charm.addBox(-0.5F, 1, 0, 1, 4, 1);
        charm.texOffs(4, 20);
        charm.addBox(-1.5F, 3, 0, 1, 1, 1);
        charm.texOffs(8, 20);
        charm.addBox(0.5F, 3, 0, 1, 1, 1);

        return createBelt(charm);
    }
}
