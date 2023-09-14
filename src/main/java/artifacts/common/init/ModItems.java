package artifacts.common.init;

import artifacts.Artifacts;
import artifacts.common.item.EverlastingFoodItem;
import artifacts.common.item.curio.CurioItem;
import artifacts.common.item.curio.belt.*;
import artifacts.common.item.curio.feet.*;
import artifacts.common.item.curio.hands.*;
import artifacts.common.item.curio.head.DrinkingHatItem;
import artifacts.common.item.curio.head.NightVisionGogglesItem;
import artifacts.common.item.curio.head.SuperstitiousHatItem;
import artifacts.common.item.curio.necklace.*;
import net.minecraft.core.Registry;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registry.ITEM_REGISTRY, Artifacts.MODID);

    public static final CreativeModeTab CREATIVE_TAB = new CreativeModeTab(Artifacts.MODID) {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(BUNNY_HOPPERS.get());
        }
    };

    public static final RegistryObject<Item> MIMIC_SPAWN_EGG = ITEMS.register("mimic_spawn_egg", () -> new ForgeSpawnEggItem(ModEntityTypes.MIMIC, 0x805113, 0x212121, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
 
    // head
    public static final RegistryObject<CurioItem> PLASTIC_DRINKING_HAT = ITEMS.register("plastic_drinking_hat", DrinkingHatItem::new);
    public static final RegistryObject<CurioItem> NIGHT_VISION_GOGGLES = ITEMS.register("night_vision_goggles", NightVisionGogglesItem::new);
    public static final RegistryObject<CurioItem> VILLAGER_HAT = ITEMS.register("villager_hat", CurioItem::new);
    public static final RegistryObject<CurioItem> SUPERSTITIOUS_HAT = ITEMS.register("superstitious_hat", SuperstitiousHatItem::new);

    // necklace
    public static final RegistryObject<CurioItem> LUCKY_SCARF = ITEMS.register("lucky_scarf", LuckyScarfItem::new);
    public static final RegistryObject<CurioItem> CROSS_NECKLACE = ITEMS.register("cross_necklace", CrossNecklaceItem::new);
    public static final RegistryObject<CurioItem> PANIC_NECKLACE = ITEMS.register("panic_necklace", PanicNecklaceItem::new);
    public static final RegistryObject<CurioItem> SHOCK_PENDANT = ITEMS.register("shock_pendant", ShockPendantItem::new);
    public static final RegistryObject<CurioItem> FLAME_PENDANT = ITEMS.register("flame_pendant", FlamePendantItem::new);
    public static final RegistryObject<CurioItem> THORN_PENDANT = ITEMS.register("thorn_pendant", ThornPendantItem::new);

    // belt
    public static final RegistryObject<CurioItem> ANTIDOTE_VESSEL = ITEMS.register("antidote_vessel", AntidoteVesselItem::new);
    public static final RegistryObject<CurioItem> CRYSTAL_HEART = ITEMS.register("crystal_heart", CrystalHeartItem::new);

    // hands
    public static final RegistryObject<CurioItem> DIGGING_CLAWS = ITEMS.register("digging_claws", DiggingClawsItem::new);
    public static final RegistryObject<CurioItem> FERAL_CLAWS = ITEMS.register("feral_claws", FeralClawsItem::new);
    public static final RegistryObject<CurioItem> POWER_GLOVE = ITEMS.register("power_glove", PowerGloveItem::new);
    public static final RegistryObject<CurioItem> POCKET_PISTON = ITEMS.register("pocket_piston", PocketPistonItem::new);
    public static final RegistryObject<CurioItem> GOLDEN_HOOK = ITEMS.register("golden_hook", GoldenHookItem::new);

    // feet
    public static final RegistryObject<AquaDashersItem> AQUA_DASHERS = ITEMS.register("aqua_dashers", AquaDashersItem::new);
    public static final RegistryObject<CurioItem> BUNNY_HOPPERS = ITEMS.register("bunny_hoppers", BunnyHoppersItem::new);
    public static final RegistryObject<CurioItem> KITTY_SLIPPERS = ITEMS.register("kitty_slippers", KittySlippersItem::new);
    public static final RegistryObject<CurioItem> RUNNING_SHOES = ITEMS.register("running_shoes", RunningShoesItem::new);
    public static final RegistryObject<CurioItem> STEADFAST_SPIKES = ITEMS.register("steadfast_spikes", SteadfastSpikesItem::new);
    public static final RegistryObject<CurioItem> FLIPPERS = ITEMS.register("flippers", FlippersItem::new);
}
