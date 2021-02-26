package de.keksuccino.fancymenu.keybinding;

import de.keksuccino.fancymenu.FancyMenu;
import de.keksuccino.fancymenu.menu.fancy.helper.CustomizationHelper;
import de.keksuccino.konkrete.config.exceptions.InvalidValueException;
import de.keksuccino.konkrete.input.KeyboardHandler;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;

public class Keybinding {

	public static KeyBinding KeyReloadMenu;
	public static KeyBinding KeyToggleHelper;
	
	private static boolean isCtrlDown = false;
	
	public static void init() {
		KeyReloadMenu = new KeyBinding("Reload Menu | CTRL + ", 82, "FancyMenu");
		KeyBindingHelper.registerKeyBinding(KeyReloadMenu);

		KeyToggleHelper = new KeyBinding("Toggle Customization Overlay | CTRL + ", 67, "FancyMenu");
		KeyBindingHelper.registerKeyBinding(KeyToggleHelper);
		
		initGuiClickActions();
	}
	
	private static void initGuiClickActions() {
		KeyboardHandler.addKeyReleasedListener((c) -> {
			if (c.keycode == 341) {
				isCtrlDown = false;
			}
		});
		KeyboardHandler.addKeyPressedListener((c) -> {
			if (c.keycode == 341) {
				isCtrlDown = true;
			}
		});
		
		//It's not possible in GUIs to check for keypresses via Keybinding.isPressed(), so I'm doing it on my own
		KeyboardHandler.addKeyPressedListener((c) -> {
			if ((KeyBindingHelper.getBoundKeyOf(KeyReloadMenu).getCode() == c.keycode) && isCtrlDown) {
				CustomizationHelper.getInstance().onReloadButtonPress();
			}

			if ((KeyBindingHelper.getBoundKeyOf(KeyToggleHelper).getCode() == c.keycode) && isCtrlDown) {
				try {
					if (FancyMenu.config.getOrDefault("showcustomizationbuttons", true)) {
						FancyMenu.config.setValue("showcustomizationbuttons", false);
					} else {
						FancyMenu.config.setValue("showcustomizationbuttons", true);
					}
					FancyMenu.config.syncConfig();
					CustomizationHelper.getInstance().updateCustomizationButtons();
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
			}
		});
	}
}