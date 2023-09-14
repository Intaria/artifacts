package artifacts.data;

import artifacts.Artifacts;
import artifacts.common.init.ModItems;
import artifacts.common.loot.ConfigurableRandomChance;
import artifacts.common.loot.RollLootTableModifier;
import net.minecraft.advancements.critereon.EntityFlagsPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LootModifiers extends GlobalLootModifierProvider {

    protected List<Builder> lootBuilders = new ArrayList<>();

    public LootModifiers(DataGenerator generator) {
        super(generator, Artifacts.MODID);
    }

    private void addLoot() {
        for (String biome : Arrays.asList("desert", "plains", "savanna", "snowy", "taiga")) {
            builder(String.format("chests/village/village_%s_house", biome), 0.02F)
                    .item(ModItems.VILLAGER_HAT.get());
        }
        builder("chests/village/village_armorer", 0.1F)
                .item(ModItems.STEADFAST_SPIKES.get())
                .item(ModItems.SUPERSTITIOUS_HAT.get())
                .item(ModItems.RUNNING_SHOES.get());
        builder("chests/village/village_tannery", 0.2F)
                .item(ModItems.KITTY_SLIPPERS.get())
                .item(ModItems.BUNNY_HOPPERS.get());
        builder("chests/village/village_temple", 0.2F)
                .item(ModItems.CROSS_NECKLACE.get())
                .item(ModItems.ANTIDOTE_VESSEL.get());
        builder("chests/village/village_toolsmith", 0.15F)
                .item(ModItems.DIGGING_CLAWS.get())
                .item(ModItems.POCKET_PISTON.get());
        builder("chests/village/village_weaponsmith", 0.1F)
                .item(ModItems.FERAL_CLAWS.get());
        builder("chests/abandoned_mineshaft", 0.3F)
                .item(ModItems.NIGHT_VISION_GOGGLES.get())
                .item(ModItems.PANIC_NECKLACE.get())
                .item(ModItems.SUPERSTITIOUS_HAT.get())
                .item(ModItems.DIGGING_CLAWS.get())
                .item(ModItems.AQUA_DASHERS.get())
                .drinkingHat(1);
        builder("chests/bastion_hoglin_stable", 0.2F)
                .artifact(5)
                .item(ModItems.BUNNY_HOPPERS.get(), 3)
                .item(ModItems.FLAME_PENDANT.get(), 3);
        builder("chests/bastion_treasure", 0.65F)
                .artifact(6)
                .item(ModItems.GOLDEN_HOOK.get(), 3)
                .item(ModItems.CROSS_NECKLACE.get(), 3)
                .item(ModItems.STEADFAST_SPIKES.get())
                .item(ModItems.PANIC_NECKLACE.get())
                .item(ModItems.CRYSTAL_HEART.get())
                .item(ModItems.ANTIDOTE_VESSEL.get());
        builder("chests/buried_treasure", 0.25F)
                .item(ModItems.FLIPPERS.get(), 5)
                .item(ModItems.GOLDEN_HOOK.get(), 5)
                .item(ModItems.FERAL_CLAWS.get(), 3)
                .item(ModItems.DIGGING_CLAWS.get(), 3)
                .item(ModItems.KITTY_SLIPPERS.get(), 3)
                .item(ModItems.BUNNY_HOPPERS.get(), 3)
                .item(ModItems.LUCKY_SCARF.get(), 3)
                .item(ModItems.AQUA_DASHERS.get(), 3)
                .drinkingHat(3);
        builder("chests/desert_pyramid", 0.2F)
                .item(ModItems.FLAME_PENDANT.get(), 2)
                .item(ModItems.THORN_PENDANT.get(), 2)
                .item(ModItems.SHOCK_PENDANT.get());
        builder("chests/end_city_treasure", 0.3F)
                .artifact(3)
                .item(ModItems.CRYSTAL_HEART.get());
        builder("chests/jungle_temple", 0.3F)
                .item(ModItems.KITTY_SLIPPERS.get(), 2)
                .item(ModItems.BUNNY_HOPPERS.get());
        builder("chests/nether_bridge", 0.15F)
                .item(ModItems.CROSS_NECKLACE.get())
                .item(ModItems.NIGHT_VISION_GOGGLES.get())
                .item(ModItems.POCKET_PISTON.get())
                .item(ModItems.RUNNING_SHOES.get())
                .drinkingHat(1);
        builder("chests/pillager_outpost", 0.25F)
                .item(ModItems.PANIC_NECKLACE.get())
                .item(ModItems.POCKET_PISTON.get())
                .item(ModItems.STEADFAST_SPIKES.get())
                .item(ModItems.POWER_GLOVE.get())
                .item(ModItems.CROSS_NECKLACE.get())
                .item(ModItems.CRYSTAL_HEART.get())
                .item(ModItems.SUPERSTITIOUS_HAT.get());
        builder("chests/ruined_portal", 0.15F)
                .item(ModItems.NIGHT_VISION_GOGGLES.get())
                .item(ModItems.THORN_PENDANT.get())
                .item(ModItems.POWER_GLOVE.get())
                .item(ModItems.LUCKY_SCARF.get());
        builder("chests/shipwreck_treasure", 0.15F)
                .item(ModItems.GOLDEN_HOOK.get(), 3)
                .item(ModItems.FLIPPERS.get())
                .item(ModItems.STEADFAST_SPIKES.get())
                .item(ModItems.FERAL_CLAWS.get())
                .item(ModItems.NIGHT_VISION_GOGGLES.get())
                .item(ModItems.RUNNING_SHOES.get());
        builder("chests/stronghold_corridor", 0.3F)
                .artifact(3)
                .item(ModItems.POWER_GLOVE.get())
                .item(ModItems.ANTIDOTE_VESSEL.get())
                .item(ModItems.SUPERSTITIOUS_HAT.get())
                .item(ModItems.LUCKY_SCARF.get())
                .item(ModItems.AQUA_DASHERS.get());
        builder("chests/underwater_ruin_big", 0.45F)
                .item(ModItems.FLIPPERS.get(), 3)
                .item(ModItems.SUPERSTITIOUS_HAT.get())
                .item(ModItems.LUCKY_SCARF.get())
                .item(ModItems.CROSS_NECKLACE.get())
                .item(ModItems.POWER_GLOVE.get());
        builder("chests/woodland_mansion", 0.25F)
                .artifact(1);
    }

    protected Builder builder(String lootTable, float baseChance) {
        Builder builder = new Builder(lootTable);
        builder.lootPoolCondition(ConfigurableRandomChance.configurableRandomChance(baseChance));
        builder.lootModifierCondition(LootTableIdCondition.builder(new ResourceLocation(lootTable)));
        lootBuilders.add(builder);
        return builder;
    }

    @Override
    protected void start() {
        addLoot();

        for (Builder lootBuilder : lootBuilders) {
            add("inject/" + lootBuilder.lootTable, lootBuilder.build());
        }
    }

    @SuppressWarnings({"UnusedReturnValue", "SameParameterValue"})
    protected static class Builder {

        private final String lootTable;
        private final LootPool.Builder lootPool = LootPool.lootPool();
        private final List<LootItemCondition> conditions;

        private LootContextParamSet paramSet = LootContextParamSets.CHEST;

        private Builder(String lootTable) {
            this.lootTable = lootTable;
            this.conditions = new ArrayList<>();
        }

        private RollLootTableModifier build() {
            return new RollLootTableModifier(conditions.toArray(new LootItemCondition[]{}), new ResourceLocation(Artifacts.MODID, "inject/" + lootTable));
        }

        protected LootTable.Builder createLootTable() {
            return new LootTable.Builder().withPool(lootPool);
        }

        public LootContextParamSet getParameterSet() {
            return paramSet;
        }

        protected String getName() {
            return lootTable;
        }

        private Builder parameterSet(LootContextParamSet paramSet) {
            this.paramSet = paramSet;
            return this;
        }

        private Builder lootPoolCondition(LootItemCondition.Builder condition) {
            lootPool.when(condition);
            return this;
        }

        private Builder lootModifierCondition(LootItemCondition.Builder condition) {
            conditions.add(condition.build());
            return this;
        }

        private Builder item(Item item, int weight) {
            lootPool.add(LootTables.item(item, weight));
            return this;
        }

        private Builder item(Item item) {
            return item(item, 1);
        }

        private Builder artifact(int weight) {
            lootPool.add(LootTables.artifact(weight));
            return this;
        }

        private Builder drinkingHat(int weight) {
            lootPool.add(LootTables.drinkingHat(weight));
            return this;
        }
    }
}
