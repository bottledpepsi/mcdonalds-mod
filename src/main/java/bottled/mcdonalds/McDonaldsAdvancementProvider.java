package bottled.mcdonalds;

import bottled.mcdonalds.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.advancement.FabricAdvancementBuilder;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
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
        AdvancementHolder craftPotatoCutter = Advancement.Builder.advancement()
                .display(
                        ModItems.MEDIUM_FRIES,
                        Component.literal("Would You Like Fries With That?"),
                        Component.literal("Craft the Potato Cutter"),
                        Identifier.withDefaultNamespace("gui/advancements/backgrounds/adventure"),
                        AdvancementType.TASK,
                        true,
                        true,
                        true
                )
                .addCriterion("craft_potato_cutter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.POTATO_CUTTER))

                .save(consumer, Identifier.fromNamespaceAndPath(McDonaldsMod.MOD_ID, "craft_potato_cutter"));
    }
}
