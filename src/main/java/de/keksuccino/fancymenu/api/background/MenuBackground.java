package de.keksuccino.fancymenu.api.background;

import de.keksuccino.fancymenu.api.Nonnull;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;

public abstract class MenuBackground {

    private final String backgroundIdentifier;
    private final MenuBackgroundType type;

    /**
     * A menu background.<br><br>
     *
     * Needs to be loaded into a {@link MenuBackgroundType} instance.<br><br>
     *
     * @param uniqueBackgroundIdentifier The <b>unique</b> identifier of the background.
     * @param type The {@link MenuBackgroundType} this background is part of.
     */
    public MenuBackground(@Nonnull String uniqueBackgroundIdentifier, @Nonnull MenuBackgroundType type) {
        this.backgroundIdentifier = uniqueBackgroundIdentifier;
        this.type = type;
    }

    /**
     * Called whenever a new GUI is getting opened containing this background.<br><br>
     *
     * So for example, if you want to reset stuff when a new menu is getting opened, do it here.
     */
    public abstract void onOpenMenu();

    /**
     * Called to render the background in the menu.<br><br>
     *
     * Backgrounds should get rendered at X0 Y0 and in the size of the screen,<br>
     * to cover the full menu background.<br><br>
     *
     * @param matrix The matrix/pose stack used to render the screen.
     * @param screen The screen this background is getting rendered in.
     * @param keepAspectRatio If the background should keep its aspect ratio or if it should get stretched to the screen size.
     */
    public abstract void render(MatrixStack matrix, Screen screen, boolean keepAspectRatio);

    /**
     * The background identifier of this menu background.
     */
    public String getIdentifier() {
        return this.backgroundIdentifier;
    }

    /**
     * The {@link MenuBackgroundType} this background is part of.
     */
    public MenuBackgroundType getType() {
        return this.type;
    }

}