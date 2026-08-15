package bottled.mcdonalds;

import bottled.mcdonalds.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.advancement.FabricAdvancementBuilder;
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


import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class McDonaldsAdvancementProvider extends FabricAdvancementProvider {
    public McDonaldsAdvancementProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider wrapperLookup, Consumer<AdvancementHolder> consumer) {
        HolderLookup.RegistryLookup<net.minecraft.world.item.Item> itemLookup = wrapperLookup.lookupOrThrow(Registries.ITEM);

        // Root advancement - this defines the tab: title, icon, and background shown on the Advancements screen.
        AdvancementHolder root = Advancement.Builder.advancement()
                .display(
                        ModItems.BIG_MAC,
                        Component.literal("McDonalds"),
                        Component.literal("I'm Lovin' It"),
                        Identifier.withDefaultNamespace("gui/advancements/backgrounds/adventure"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("has_big_mac", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BIG_MAC))
                .save(consumer, Identifier.fromNamespaceAndPath(McDonaldsMod.MOD_ID, "root"));

        AdvancementHolder craftPotatoCutter = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        ModItems.MEDIUM_FRIES,
                        Component.literal("Would You Like Fries With That?"),
                        Component.literal("Craft the Potato Cutter"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("craft_potato_cutter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.POTATO_CUTTER))
                .save(consumer, Identifier.fromNamespaceAndPath(McDonaldsMod.MOD_ID, "craft_potato_cutter"));

        AdvancementHolder eatBigMac = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        ModItems.MCRIB,
                        Component.literal("I love the McRib"),
                        Component.literal("It's just so good"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("ate_mcrib", ConsumeItemTrigger.TriggerInstance.usedItem(itemLookup, ModItems.MCRIB))
                .save(consumer, Identifier.fromNamespaceAndPath(McDonaldsMod.MOD_ID, "eat_mcrib"));

        AdvancementHolder drinkCoke = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        ModItems.MEDIUM_COKE,
                        Component.literal("Thirsty?"),
                        Component.literal("Drink a Coke"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("drank_small_coke", ConsumeItemTrigger.TriggerInstance.usedItem(itemLookup, ModItems.SMALL_COKE))
                .addCriterion("drank_medium_coke", ConsumeItemTrigger.TriggerInstance.usedItem(itemLookup, ModItems.MEDIUM_COKE))
                .addCriterion("drank_large_coke", ConsumeItemTrigger.TriggerInstance.usedItem(itemLookup, ModItems.LARGE_COKE))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, Identifier.fromNamespaceAndPath(McDonaldsMod.MOD_ID, "drink_coke"));

        AdvancementHolder eatNugget = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        ModItems.MCNUGGET,
                        Component.literal("Chicken McNugget"),
                        Component.literal("Eat a McNugget"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("ate_mcnugget", ConsumeItemTrigger.TriggerInstance.usedItem(itemLookup, ModItems.MCNUGGET))
                .save(consumer, Identifier.fromNamespaceAndPath(McDonaldsMod.MOD_ID, "eat_mcnugget"));

        AdvancementHolder getMciumIngot = Advancement.Builder.advancement()
                .parent(craftPotatoCutter)
                .display(
                        ModItems.MCIUM_INGOT,
                        Component.literal("A New Metal?"),
                        Component.literal("Obtain a Mcium Ingot"),
                        null,
                        AdvancementType.GOAL,
                        true,
                        true,
                        false
                )
                .addCriterion("has_mcium_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MCIUM_INGOT))
                .save(consumer, Identifier.fromNamespaceAndPath(McDonaldsMod.MOD_ID, "get_mcium_ingot"));

        AdvancementHolder eatApplePie = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        ModItems.APPLE_PIE,
                        Component.literal("As American As..."),
                        Component.literal("Eat an Apple Pie"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("ate_apple_pie", ConsumeItemTrigger.TriggerInstance.usedItem(itemLookup, ModItems.APPLE_PIE))
                .save(consumer, Identifier.fromNamespaceAndPath(McDonaldsMod.MOD_ID, "eat_apple_pie"));

        AdvancementHolder craftMciumSword = Advancement.Builder.advancement()
                .parent(getMciumIngot)
                .display(
                        ModItems.MCIUM_SWORD,
                        Component.literal("Drive-Thru Defender"),
                        Component.literal("Craft a Mcium Sword"),
                        null,
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        false
                )
                .addCriterion("has_mcium_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MCIUM_SWORD))
                .save(consumer, Identifier.fromNamespaceAndPath(McDonaldsMod.MOD_ID, "craft_mcium_sword"));
    }
}
