package artifacts.common.item;

import artifacts.Artifacts;
import artifacts.client.render.model.curio.PendantModel;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

public abstract class PendantItem extends CurioItem {

    private final ResourceLocation texture;

    public PendantItem(String name) {
        texture = new ResourceLocation(Artifacts.MODID, String.format("textures/entity/curio/%s.png", name));
        MinecraftForge.EVENT_BUS.addListener(this::onLivingHurt);
    }

    public void onLivingHurt(LivingHurtEvent event) {
        if (isEquippedBy(event.getEntityLiving())
                && !event.getEntity().world.isRemote()
                && event.getAmount() >= 1
                && event.getSource().getTrueSource() instanceof LivingEntity) {
            applyEffect(event.getEntityLiving(), (LivingEntity) event.getSource().getTrueSource());
        }
    }

    public abstract void applyEffect(LivingEntity target, LivingEntity attacker);

    @Override
    public ICurio.SoundInfo getEquipSound(SlotContext slotContext, ItemStack stack) {
        return new ICurio.SoundInfo(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1, 1);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    protected BipedModel<LivingEntity> createModel() {
        return new PendantModel();
    }

    @Override
    protected ResourceLocation getTexture() {
        return texture;
    }
}
