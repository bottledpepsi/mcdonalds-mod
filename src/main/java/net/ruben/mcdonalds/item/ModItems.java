package net.ruben.mcdonalds.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.ruben.mcdonalds.McdonaldsMod;

public class ModItems {
    public static final Item BIG_MAC = registerItem("big_mac", new Item(new FabricItemSettings().food(ModFoodComponents.BIG_MAC)));
    public static final Item SMALL_FRIES = registerItem("small_fries", new Item(new FabricItemSettings().food(ModFoodComponents.SMALL_FRIES)));
    public static final Item MCNUGGET = registerItem("mcnugget", new Item(new FabricItemSettings().food(ModFoodComponents.MCNUGGET)));
    public static final Item CASH_REGISTER = registerItem("cash_register", new Item(new FabricItemSettings().food(ModFoodComponents.CASH_REGISTER)));
    public static final Item HASHBROWN = registerItem("hashbrown", new Item(new FabricItemSettings().food(ModFoodComponents.HASHBROWN)));
    public static final Item LARGE_COKE = registerItem("large_coke", new LargeCokeItem(new FabricItemSettings().food(ModFoodComponents.LARGE_COKE)));
    public static final Item APPLE_PIE = registerItem("apple_pie", new Item(new FabricItemSettings().food(ModFoodComponents.APPLE_PIE)));

    public static void registerModItems() {
        McdonaldsMod.LOGGER.info("Registering Mod Items for " + McdonaldsMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((entries) -> {
            entries.add(BIG_MAC);
            entries.add(SMALL_FRIES);
            entries.add(MCNUGGET);
            entries.add(CASH_REGISTER);
            entries.add(HASHBROWN);
            entries.add(LARGE_COKE);
            entries.add(APPLE_PIE);
        });
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(McdonaldsMod.MOD_ID, name), item);
    }
}
