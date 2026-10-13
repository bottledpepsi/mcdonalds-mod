package bottled.mcdonalds.item;

import bottled.mcdonalds.McDonaldsMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
    public static final Item BIG_MAC = register("big_mac",
            p -> new Item(p.food(ModFoodComponents.BIG_MAC, ModFoodComponents.BIG_MAC_CONSUMABLE)));
    public static final Item SMALL_FRIES = register("small_fries",
            p -> new Item(p.food(ModFoodComponents.SMALL_FRIES)));
    public static final Item MEDIUM_FRIES = register("medium_fries",
            p -> new Item(p.food(ModFoodComponents.MEDIUM_FRIES)));
    public static final Item LARGE_FRIES = register("large_fries",
            p -> new Item(p.food(ModFoodComponents.LARGE_FRIES)));
    public static final Item MCNUGGET = register("mcnugget",
            p -> new Item(p.food(ModFoodComponents.MCNUGGET, ModFoodComponents.MCNUGGET_CONSUMABLE)));
    public static final Item HASHBROWN = register("hashbrown",
            p -> new Item(p.food(ModFoodComponents.HASHBROWN)));
    public static final Item SMALL_COKE = register("small_coke",
            p -> new Item(p.food(ModFoodComponents.SMALL_COKE, ModFoodComponents.SMALL_COKE_CONSUMABLE)));
    public static final Item MEDIUM_COKE = register("medium_coke",
            p -> new Item(p.food(ModFoodComponents.MEDIUM_COKE, ModFoodComponents.MEDIUM_COKE_CONSUMABLE)));
    public static final Item LARGE_COKE = register("large_coke",
            p -> new Item(p.food(ModFoodComponents.LARGE_COKE, ModFoodComponents.LARGE_COKE_CONSUMABLE)));
    public static final Item APPLE_PIE = register("apple_pie",
            p -> new Item(p.food(ModFoodComponents.APPLE_PIE)));
    public static final Item MCFLURRY = register("mcflurry",
            p -> new Item(p.food(ModFoodComponents.MCFLURRY, ModFoodComponents.MCFLURRY_CONSUMABLE)));
    public static final Item MCRIB = register("mcrib",
            p -> new Item(p.food(ModFoodComponents.MCRIB, ModFoodComponents.MCRIB_CONSUMABLE)));
    public static final Item FILET_O_FISH = register("filet_o_fish",
            p -> new Item(p.food(ModFoodComponents.FILET_O_FISH, ModFoodComponents.FILET_O_FISH_CONSUMABLE)));

    public static final Item RAW_MCIUM = register("raw_mcium", Item::new);
    public static final Item MCIUM_INGOT = register("mcium_ingot", Item::new);

    // ── Crafting intermediates ────────────────────────────────────────────────
    public static final Item POTATO_CUTTER = register("potato_cutter", Item::new);
    public static final Item RAW_FRIES = register("raw_fries", Item::new);
    public static final Item FRIED_POTATOES = register("fried_potatoes", Item::new);
    public static final Item RAW_NUGGET = register("raw_nugget", Item::new);
    public static final Item RAW_FILET = register("raw_filet", Item::new);
    public static final Item RAW_PIE = register("raw_pie", Item::new);

    public static final Item MCIUM_PICKAXE = register("mcium_pickaxe",
            p -> new Item(p.pickaxe(ModToolMaterial.MCIUM_PICKAXE, 1.0f, -2.8f)));
    public static final Item MCIUM_SWORD = register("mcium_sword",
            p -> new Item(p.sword(ModToolMaterial.MCIUM_SWORD, 4f, -2.4f)));
    // In 26.3 AxeItem/ShovelItem/HoeItem no longer exist. Stripping, scraping, waxing-off, flattening and
    // tilling are handled by the data-driven block transformers, and Item.Properties#axe/#shovel/#hoe attach
    // the matching vanilla DataComponents.BLOCK_TRANSFORMER component, so a plain Item is enough.
    public static final Item MCIUM_AXE = register("mcium_axe",
            p -> new Item(p.axe(ModToolMaterial.MCIUM_AXE, 6f, -3.0f)));
    public static final Item MCIUM_SHOVEL = register("mcium_shovel",
            p -> new Item(p.shovel(ModToolMaterial.MCIUM_SHOVEL, 1.5f, -3.0f)));
    public static final Item MCIUM_HOE = register("mcium_hoe",
            p -> new Item(p.hoe(ModToolMaterial.MCIUM_HOE, 0.5f, 0.0f)));


    // In 26.1, Item.Properties requires the ResourceKey to be set before construction
    private static Item register(String name, Function<Item.Properties, Item> factory) {
        Identifier id = Identifier.fromNamespaceAndPath(McDonaldsMod.MOD_ID, name);
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);
        Item item = factory.apply(new Item.Properties().setId(key));
        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void registerModItems() {
        McDonaldsMod.LOGGER.info("Registering items for " + McDonaldsMod.MOD_ID);
    }
}
