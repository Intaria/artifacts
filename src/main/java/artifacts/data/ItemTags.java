package artifacts.data;

import artifacts.Artifacts;
import artifacts.common.init.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import top.theillusivec4.curios.api.CuriosApi;

import javax.annotation.Nullable;

public class ItemTags extends ItemTagsProvider {

    private static final TagKey<Item> ARTIFACTS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Artifacts.MODID, "artifacts"));

    private static final TagKey<Item> BELT = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(CuriosApi.MODID, "belt"));
    private static final TagKey<Item> CURIO = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(CuriosApi.MODID, "curio"));
    private static final TagKey<Item> FEET = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(CuriosApi.MODID, "feet"));
    private static final TagKey<Item> HANDS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(CuriosApi.MODID, "hands"));
    private static final TagKey<Item> HEAD = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(CuriosApi.MODID, "head"));
    private static final TagKey<Item> NECKLACE = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(CuriosApi.MODID, "necklace"));

    public ItemTags(DataGenerator generator, BlockTags blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, blockTags, Artifacts.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        // noinspection ConstantConditions
        tag(ARTIFACTS).add(ForgeRegistries.ITEMS.getValues().stream()
                .filter(item -> ForgeRegistries.ITEMS.getKey(item).getNamespace().equals(Artifacts.MODID))
                .filter(item -> item != ModItems.MIMIC_SPAWN_EGG.get()).toList().toArray(new Item[]{})
        );

        tag(net.minecraft.tags.ItemTags.PIGLIN_LOVED).add(ModItems.GOLDEN_HOOK.get());

        tag(BELT).add(
                ModItems.ANTIDOTE_VESSEL.get(),
                ModItems.CRYSTAL_HEART.get()
        );

        tag(FEET).add(
                ModItems.BUNNY_HOPPERS.get(),
                ModItems.FLIPPERS.get(),
                ModItems.KITTY_SLIPPERS.get(),
                ModItems.RUNNING_SHOES.get(),
                ModItems.STEADFAST_SPIKES.get(),
                ModItems.AQUA_DASHERS.get()
        );

        tag(HANDS).add(
                ModItems.DIGGING_CLAWS.get(),
                ModItems.FERAL_CLAWS.get(),
                ModItems.POCKET_PISTON.get(),
                ModItems.POWER_GLOVE.get(),
                ModItems.GOLDEN_HOOK.get()
        );

        tag(HEAD).add(
                ModItems.NIGHT_VISION_GOGGLES.get(),
                ModItems.PLASTIC_DRINKING_HAT.get(),
                ModItems.SUPERSTITIOUS_HAT.get(),
                ModItems.VILLAGER_HAT.get()
        );

        tag(NECKLACE).add(
                ModItems.CROSS_NECKLACE.get(),
                ModItems.FLAME_PENDANT.get(),
                ModItems.LUCKY_SCARF.get(),
                ModItems.PANIC_NECKLACE.get(),
                ModItems.SHOCK_PENDANT.get(),
                ModItems.THORN_PENDANT.get()
        );
    }
}
