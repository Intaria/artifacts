package artifacts.common.item.curio;

import artifacts.common.config.ModConfig;
import artifacts.common.item.ArtifactItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.type.inventory.IDynamicStackHandler;

import javax.annotation.Nullable;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class CurioItem extends ArtifactItem implements ICurioItem {

    public boolean isEquippedBy(@Nullable LivingEntity entity) {
        return !ModConfig.server.isCosmetic(this) && entity != null && CuriosApi.getCuriosHelper().findEquippedCurio(this, entity).isPresent();
    }

    protected <T extends Event, S extends LivingEntity> void addListener(EventPriority priority, Class<T> eventClass, BiConsumer<T, S> listener, Function<T, S> wearerSupplier) {
        MinecraftForge.EVENT_BUS.addListener(priority, true, eventClass, event -> {
            S wearer = wearerSupplier.apply(event);
            if (isEquippedBy(wearer)) {
                listener.accept(event, wearer);
            }
        });
    }

    protected <T extends Event, S extends LivingEntity> void addListener(Class<T> eventClass, BiConsumer<T, S> listener, Function<T, S> wearerSupplier) {
        addListener(EventPriority.NORMAL, eventClass, listener, wearerSupplier);
    }

    protected <T extends LivingEvent> void addListener(EventPriority priority, Class<T> eventClass, BiConsumer<T, LivingEntity> listener) {
        addListener(priority, eventClass, listener, LivingEvent::getEntity);
    }

    protected <T extends LivingEvent> void addListener(Class<T> eventClass, BiConsumer<T, LivingEntity> listener) {
        addListener(EventPriority.NORMAL, eventClass, listener);
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.RARE;
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }

    protected void damageStack(SlotContext slotContext, ItemStack stack) {
        damageStack(slotContext, stack, 1);
    }

    protected void damageStack(SlotContext slotContext, ItemStack stack, int damage) {
        stack.hurtAndBreak(damage, slotContext.entity(), entity ->
                CuriosApi.getCuriosHelper().onBrokenCurio(slotContext)
        );
    }

    protected void damageEquippedStacks(LivingEntity entity, int damage) {
        if (entity instanceof Player player && player.isCreative()) {
            return;
        }
        CuriosApi.getCuriosHelper().getCuriosHandler(entity).ifPresent(curiosHandler ->
                curiosHandler.getCurios().forEach((identifier, stacksHandler) -> {
                    IDynamicStackHandler stacks = stacksHandler.getStacks();
                    for (int slot = 0; slot < stacks.getSlots(); slot++) {
                        ItemStack stack = stacks.getStackInSlot(slot);
                        if (!stack.isEmpty() && stack.getItem() == this) {
                            SlotContext slotContext = new SlotContext(identifier, entity, slot, false, true);
                            damageStack(slotContext, stack, damage);
                        }
                    }
                })
        );
    }

    public void damageEquippedStacks(LivingEntity entity) {
        damageEquippedStacks(entity, 1);
    }
}
