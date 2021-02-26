package de.keksuccino.fancymenu.menu.fancy.gameintro;

import de.keksuccino.fancymenu.menu.animation.AnimationHandler;
import de.keksuccino.konkrete.events.SubscribeEvent;
import de.keksuccino.konkrete.events.client.GuiScreenEvent;
import de.keksuccino.konkrete.rendering.animation.IAnimationRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;

public class GameIntroEvents {
	
	@SubscribeEvent
	public void onScreenInitPre(GuiScreenEvent.InitGuiEvent.Pre e) {
		if ((e.getGui() instanceof TitleScreen) && AnimationHandler.isReady() && !GameIntroHandler.introDisplayed) {
			IAnimationRenderer intro = GameIntroHandler.getGameIntroAnimation();
			if (intro != null) {
				MinecraftClient.getInstance().openScreen(new GameIntroScreen(intro, (TitleScreen) e.getGui()));
			} else {
				GameIntroHandler.introDisplayed = true;
			}
		}
	}

}