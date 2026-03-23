package bottled.mcdonalds.screen;

import bottled.mcdonalds.McDonaldsMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

public class ModMenuTypes {

    public static MenuType<FryerMenu> FRYER;

    public static void register() {
        FRYER = Registry.register(
                BuiltInRegistries.MENU,
                Identifier.fromNamespaceAndPath(McDonaldsMod.MOD_ID, "fryer"),
                new MenuType<>(FryerMenu::new, FeatureFlags.DEFAULT_FLAGS)
        );
        McDonaldsMod.LOGGER.info("Registering menu types for " + McDonaldsMod.MOD_ID);
    }
}
