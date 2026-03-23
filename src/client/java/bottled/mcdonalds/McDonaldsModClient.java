package bottled.mcdonalds;

import bottled.mcdonalds.screen.FryerScreen;
import bottled.mcdonalds.screen.ModMenuTypes;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;

public class McDonaldsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MenuScreens.register(ModMenuTypes.FRYER, FryerScreen::new);
    }
}
