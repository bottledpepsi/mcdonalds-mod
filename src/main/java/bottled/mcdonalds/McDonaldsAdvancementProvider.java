package bottled.mcdonalds;

import bottled.mcdonalds.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.triggers.ConsumeItemTrigger;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Generates the McDonalds advancement tab.
 * <p>
 * The generated JSON is committed under {@code src/main/generated} so that normal builds
 * ship the advancements without having to run {@code runDatagen} first. Re-run datagen
 * and commit the result whenever this class changes.
 * <p>
 * All titles/descriptions are translatable: {@code advancement.mcdonalds.<id>.title|description}.
 */
public class McDonaldsAdvancementProvider extends FabricAdvancementProvider {
    public McDonaldsAdvancementProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    private static Component text(String id, String part) {
        return Component.translatable("advancement." + McDonaldsMod.MOD_ID + "." + id + "." + part);
    }

    private static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(McDonaldsMod.MOD_ID, path);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider wrapperLookup, @NonNull Consumer<AdvancementHolder> consumer) {
        HolderLookup.RegistryLookup<net.minecraft.world.item.Item> itemLookup = wrapperLookup.lookupOrThrow(Registries.ITEM);

        // Root advancement - this defines the tab: title, icon, and background shown on the Advancements screen.
        AdvancementHolder root = Advancement.Builder.advancement()
                .display(
                        ModItems.BIG_MAC,
                        text("root", "title"),
                        text("root", "description"),
//                        Identifier.withDefaultNamespace("gui/advancements/backgrounds/adventure"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("has_big_mac", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BIG_MAC))
                .save(consumer, id("root"));

        Advancement.Builder.advancement()
                .parent(root)
                .display(
                        ModItems.MEDIUM_FRIES,
                        text("craft_potato_cutter", "title"),
                        text("craft_potato_cutter", "description"),
//                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("craft_potato_cutter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.POTATO_CUTTER))
                .save(consumer, id("craft_potato_cutter"));

        Advancement.Builder.advancement()
                .parent(root)
                .display(
                        ModItems.MCRIB,
                        text("eat_mcrib", "title"),
                        text("eat_mcrib", "description"),
//                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("ate_mcrib", ConsumeItemTrigger.TriggerInstance.usedItem(itemLookup, ModItems.MCRIB))
                .save(consumer, id("eat_mcrib"));

        Advancement.Builder.advancement()
                .parent(root)
                .display(
                        ModItems.MEDIUM_COKE,
                        text("drink_coke", "title"),
                        text("drink_coke", "description"),
//                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("drank_small_coke", ConsumeItemTrigger.TriggerInstance.usedItem(itemLookup, ModItems.SMALL_COKE))
                .addCriterion("drank_medium_coke", ConsumeItemTrigger.TriggerInstance.usedItem(itemLookup, ModItems.MEDIUM_COKE))
                .addCriterion("drank_large_coke", ConsumeItemTrigger.TriggerInstance.usedItem(itemLookup, ModItems.LARGE_COKE))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, id("drink_coke"));

        Advancement.Builder.advancement()
                .parent(root)
                .display(
                        ModItems.MCNUGGET,
                        text("eat_mcnugget", "title"),
                        text("eat_mcnugget", "description"),
//                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("ate_mcnugget", ConsumeItemTrigger.TriggerInstance.usedItem(itemLookup, ModItems.MCNUGGET))
                .save(consumer, id("eat_mcnugget"));

        // Mcium is found by mining, not by cooking, so this hangs off the root rather than the Potato Cutter.
        AdvancementHolder getMciumIngot = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        ModItems.MCIUM_INGOT,
                        text("get_mcium_ingot", "title"),
                        text("get_mcium_ingot", "description"),
//                        null,
                        AdvancementType.GOAL,
                        true,
                        true,
                        false
                )
                .addCriterion("has_mcium_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MCIUM_INGOT))
                .save(consumer, id("get_mcium_ingot"));

        Advancement.Builder.advancement()
                .parent(root)
                .display(
                        ModItems.APPLE_PIE,
                        text("eat_apple_pie", "title"),
                        text("eat_apple_pie", "description"),
//                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("ate_apple_pie", ConsumeItemTrigger.TriggerInstance.usedItem(itemLookup, ModItems.APPLE_PIE))
                .save(consumer, id("eat_apple_pie"));

        Advancement.Builder.advancement()
                .parent(getMciumIngot)
                .display(
                        ModItems.MCIUM_SWORD,
                        text("craft_mcium_sword", "title"),
                        text("craft_mcium_sword", "description"),
//                        null,
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        false
                )
                .addCriterion("has_mcium_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MCIUM_SWORD))
                .save(consumer, id("craft_mcium_sword"));
    }
}
