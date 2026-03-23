package bottled.mcdonalds.screen;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class FryerScreen extends AbstractContainerScreen<FryerMenu> {

    private static final Identifier TEXTURE =
            Identifier.withDefaultNamespace("textures/gui/container/furnace.png");

    public FryerScreen(FryerMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        int x = this.leftPos;
        int y = this.topPos;

        // Background
        graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x, y, 0, 0, imageWidth, imageHeight, 256, 256);

        // Fuel flame — shrinks as fuel burns down
        if (menu.isBurning()) {
            int fuelHeight = menu.getFuelTotalTime() > 0
                    ? menu.getFuelTime() * 13 / menu.getFuelTotalTime()
                    : 0;
            graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE,
                    x + 53, y + 36 + 12 - fuelHeight,
                    176, 12 - fuelHeight, 14, fuelHeight + 1, 256, 256);
        }

        // Progress arrow — grows as item cooks
        int progressWidth = menu.getCookingTotalTime() > 0
                ? menu.getCookingProgress() * 24 / menu.getCookingTotalTime()
                : 0;
        graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE,
                x + 79, y + 34, 176, 14, progressWidth + 1, 16, 256, 256);

        // Render slots, labels, tooltip on top
        super.extractRenderState(graphics, mouseX, mouseY, a);
    }

    @Override
    protected void extractLabels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
        graphics.text(this.font, this.title,                this.titleLabelX,     this.titleLabelY,     -12566464, false);
        graphics.text(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, -12566464, false);
    }
}