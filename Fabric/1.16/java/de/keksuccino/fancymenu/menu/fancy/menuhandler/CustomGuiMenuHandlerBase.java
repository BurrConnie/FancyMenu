package de.keksuccino.fancymenu.menu.fancy.menuhandler;

import de.keksuccino.fancymenu.menu.button.ButtonCachedEvent;
import de.keksuccino.fancymenu.menu.fancy.guicreator.CustomGuiBase;
import de.keksuccino.fancymenu.menu.fancy.helper.MenuReloadedEvent;
import de.keksuccino.konkrete.events.SubscribeEvent;
import de.keksuccino.konkrete.events.client.GuiScreenEvent.BackgroundDrawnEvent;
import de.keksuccino.konkrete.events.client.GuiScreenEvent.DrawScreenEvent.Post;
import de.keksuccino.konkrete.events.client.GuiScreenEvent.InitGuiEvent.Pre;
import net.minecraft.client.gui.screen.Screen;

public class CustomGuiMenuHandlerBase  extends MenuHandlerBase {

	public CustomGuiMenuHandlerBase(String identifier) {
		super(identifier);
	}

	@SubscribeEvent
	@Override
	public void onMenuReloaded(MenuReloadedEvent e) {
		super.onMenuReloaded(e);
	}
	
	@SubscribeEvent
	@Override
	public void onInitPre(Pre e) {
		super.onInitPre(e);
	}
	
	@SubscribeEvent
	@Override
	public void onButtonsCached(ButtonCachedEvent e) {
		super.onButtonsCached(e);
	}
	
	@SubscribeEvent
	@Override
	public void onRenderPost(Post e) {
		super.onRenderPost(e);
	}
	
	@SubscribeEvent
	@Override
	public void drawToBackground(BackgroundDrawnEvent e) {
		super.drawToBackground(e);
	}
	
	@Override
	protected boolean shouldCustomize(Screen menu) {
		if (menu instanceof CustomGuiBase) {
			if (((CustomGuiBase) menu).getIdentifier().equals(this.getMenuIdentifier())) {
				return true;
			}
		}
		return false;
	}

}