package artifacts.client.render.curio;

import artifacts.client.render.curio.model.*;
import artifacts.client.render.curio.renderer.*;
import artifacts.common.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

public class CurioRenderers {

    public static void register() {
        // head
        CuriosRendererRegistry.register(ModItems.PLASTIC_DRINKING_HAT.get(), () -> new CurioRenderer("drinking_hat/plastic_drinking_hat", new HeadModel(bakeLayer(CurioLayers.DRINKING_HAT))));
        CuriosRendererRegistry.register(ModItems.NIGHT_VISION_GOGGLES.get(), () -> new GlowingCurioRenderer("night_vision_goggles", new HeadModel(bakeLayer(CurioLayers.NIGHT_VISION_GOGGLES))));
        CuriosRendererRegistry.register(ModItems.SUPERSTITIOUS_HAT.get(), () -> new CurioRenderer("superstitious_hat", new HeadModel(bakeLayer(CurioLayers.SUPERSTITIOUS_HAT), RenderType::entityCutoutNoCull)));
        CuriosRendererRegistry.register(ModItems.VILLAGER_HAT.get(), () -> new CurioRenderer("villager_hat", new HeadModel(bakeLayer(CurioLayers.VILLAGER_HAT))));

        // necklace
        CuriosRendererRegistry.register(ModItems.LUCKY_SCARF.get(), () -> new CurioRenderer("scarf/lucky_scarf", new ScarfModel(bakeLayer(CurioLayers.SCARF), RenderType::entityCutoutNoCull)));
        CuriosRendererRegistry.register(ModItems.CROSS_NECKLACE.get(), () -> new CurioRenderer("cross_necklace", new NecklaceModel(bakeLayer(CurioLayers.CROSS_NECKLACE))));
        CuriosRendererRegistry.register(ModItems.PANIC_NECKLACE.get(), () -> new CurioRenderer("panic_necklace", new NecklaceModel(bakeLayer(CurioLayers.PANIC_NECKLACE))));
        CuriosRendererRegistry.register(ModItems.SHOCK_PENDANT.get(), () -> new CurioRenderer("pendant/shock_pendant", new NecklaceModel(bakeLayer(CurioLayers.PENDANT))));
        CuriosRendererRegistry.register(ModItems.FLAME_PENDANT.get(), () -> new CurioRenderer("pendant/flame_pendant", new NecklaceModel(bakeLayer(CurioLayers.PENDANT))));
        CuriosRendererRegistry.register(ModItems.THORN_PENDANT.get(), () -> new CurioRenderer("pendant/thorn_pendant", new NecklaceModel(bakeLayer(CurioLayers.PENDANT))));

        // belt
        CuriosRendererRegistry.register(ModItems.ANTIDOTE_VESSEL.get(), () -> new BeltCurioRenderer("antidote_vessel", BeltModel.createAntidoteVesselModel()));
        CuriosRendererRegistry.register(ModItems.CRYSTAL_HEART.get(), () -> new BeltCurioRenderer("crystal_heart", BeltModel.createCrystalHeartModel()));

        // hands
        CuriosRendererRegistry.register(ModItems.DIGGING_CLAWS.get(), () -> new GloveCurioRenderer("claws/digging_claws", "claws/digging_claws", ArmsModel.createClawsModel(false), ArmsModel.createClawsModel(true)));
        CuriosRendererRegistry.register(ModItems.FERAL_CLAWS.get(), () -> new GloveCurioRenderer("claws/feral_claws", "claws/feral_claws", ArmsModel.createClawsModel(false), ArmsModel.createClawsModel(true)));
        CuriosRendererRegistry.register(ModItems.POWER_GLOVE.get(), () -> new GloveCurioRenderer("power_glove", ArmsModel.createGloveModel(false), ArmsModel.createGloveModel(true)));
        CuriosRendererRegistry.register(ModItems.POCKET_PISTON.get(), () -> new GloveCurioRenderer("pocket_piston", ArmsModel.createGloveModel(false), ArmsModel.createGloveModel(true)));
        CuriosRendererRegistry.register(ModItems.GOLDEN_HOOK.get(), () -> new GloveCurioRenderer("golden_hook/golden_hook_default", "golden_hook/golden_hook_slim", ArmsModel.createGoldenHookModel(false), ArmsModel.createGoldenHookModel(true)));

        // feet
        CuriosRendererRegistry.register(ModItems.AQUA_DASHERS.get(), () -> new CurioRenderer("aqua_dashers", new LegsModel(bakeLayer(CurioLayers.AQUA_DASHERS))));
        CuriosRendererRegistry.register(ModItems.BUNNY_HOPPERS.get(), () -> new CurioRenderer("bunny_hoppers", new LegsModel(bakeLayer(CurioLayers.BUNNY_HOPPERS))));
        CuriosRendererRegistry.register(ModItems.KITTY_SLIPPERS.get(), () -> new CurioRenderer("kitty_slippers", new LegsModel(bakeLayer(CurioLayers.KITTY_SLIPPERS))));
        CuriosRendererRegistry.register(ModItems.RUNNING_SHOES.get(), () -> new CurioRenderer("running_shoes", new LegsModel(bakeLayer(CurioLayers.RUNNING_SHOES))));
        CuriosRendererRegistry.register(ModItems.STEADFAST_SPIKES.get(), () -> new CurioRenderer("steadfast_spikes", new LegsModel(bakeLayer(CurioLayers.STEADFAST_SPIKES))));
        CuriosRendererRegistry.register(ModItems.FLIPPERS.get(), () -> new CurioRenderer("flippers", new LegsModel(bakeLayer(CurioLayers.FLIPPERS))));
    }

    public static ModelPart bakeLayer(ModelLayerLocation layerLocation) {
        return Minecraft.getInstance().getEntityModels().bakeLayer(layerLocation);
    }
}
