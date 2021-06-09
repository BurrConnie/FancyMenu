//TODO übernehmen
//package de.keksuccino.fancymenu.menu.fancy.helper;
//
//import java.awt.Color;
//import java.io.File;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//import com.mojang.blaze3d.systems.RenderSystem;
//
//import de.keksuccino.konkrete.localization.Locals;
//import de.keksuccino.fancymenu.menu.animation.AdvancedAnimation;
//import de.keksuccino.fancymenu.menu.animation.AnimationHandler;
//import de.keksuccino.fancymenu.menu.fancy.MenuCustomization;
//import de.keksuccino.fancymenu.menu.fancy.helper.layoutcreator.LayoutEditorScreen;
//import de.keksuccino.fancymenu.menu.fancy.helper.layoutcreator.PreloadedLayoutEditorScreen;
//import de.keksuccino.fancymenu.menu.fancy.helper.ui.popup.FMPopup;
//import de.keksuccino.konkrete.gui.content.AdvancedButton;
//import de.keksuccino.konkrete.gui.content.HorizontalSwitcher;
//import de.keksuccino.konkrete.properties.PropertiesSection;
//import de.keksuccino.konkrete.properties.PropertiesSet;
//import de.keksuccino.konkrete.rendering.animation.IAnimationRenderer;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.gui.AbstractGui;
//import net.minecraft.client.gui.screen.Screen;
//import net.minecraft.util.text.StringTextComponent;
//
////TODO übernehmen (FM popup)
//public class EditLayoutPopup extends FMPopup {
//
//	protected Map<String, List<Object>> props = new HashMap<String, List<Object>>();
//	protected List<PropertiesSet> fullprops = new ArrayList<PropertiesSet>();
//	
//	private List<String> msg = new ArrayList<String>();
//
//	protected AdvancedButton loadAllButton;
//	protected AdvancedButton loadLayoutButton;
//	protected AdvancedButton cancelButton;
//	
//	protected HorizontalSwitcher fileSwitcher;
//	
//	public EditLayoutPopup(List<PropertiesSet> properties) {
//		super(240);
//		
//		this.fullprops = properties;
//
//		this.setNotificationText(Locals.localize("helper.creator.editlayout.popup.msg"));
//		
//		for (PropertiesSet s : properties) {
//			List<PropertiesSection> secs = s.getPropertiesOfType("customization-meta");
//			if (secs.isEmpty()) {
//				secs = s.getPropertiesOfType("type-meta");
//			}
//			if (secs.isEmpty()) {
//				continue;
//			}
//			PropertiesSection meta = secs.get(0);
//			String path = meta.getEntryValue("path");
//			if (path != null) {
//				List<Object> l = new ArrayList<Object>();
//				l.add(s);
//				l.add(s.getPropertiesOfType("customization").size());
//				props.put(new File(path).getName(), l);
//			}
//		}
//		
//		this.fileSwitcher = new HorizontalSwitcher(120, true, props.keySet().toArray(new String[0]));
//		this.fileSwitcher.setButtonColor(new Color(102, 102, 153), new Color(133, 133, 173), new Color(163, 163, 194), new Color(163, 163, 194), 1);
//		this.fileSwitcher.setValueBackgroundColor(new Color(102, 102, 153));
//
//		this.loadAllButton = new AdvancedButton(0, 0, 120, 20, Locals.localize("helper.creator.editlayout.popup.loadall"), true, (press) -> {
//			this.setDisplayed(false);
//			
//			//TODO übernehmen
////			boolean b = false;
////			for (PropertiesSet s : this.fullprops) {
////				if (MenuCustomization.containsCalculations(s)) {
////					b = true;
////					break;
////				}
////			}
//			
//			//TODO übernehmen
////			if (!b) {
//				//TODO übernehmen
//				LayoutEditorScreen.isActive = true;
//				//TODO übernehmen (currentScreen)
//				Minecraft.getInstance().displayGuiScreen(new PreloadedLayoutEditorScreen(Minecraft.getInstance().currentScreen, this.fullprops));
//				//TODO übernehmen
////				LayoutCreatorScreen.isActive = true;
//				MenuCustomization.stopSounds();
//				MenuCustomization.resetSounds();
//				for (IAnimationRenderer r : AnimationHandler.getAnimations()) {
//					if (r instanceof AdvancedAnimation) {
//						((AdvancedAnimation)r).stopAudio();
//						if (((AdvancedAnimation)r).replayIntro()) {
//							((AdvancedAnimation)r).resetAnimation();
//						}
//					}
//				}
////			} else {
////				PopupHandler.displayPopup(new NotificationPopup(300, new Color(0, 0, 0, 0), 240, null, Locals.localize("helper.creator.editlayout.unsupportedvalues")));
////			}
//		});
//		this.addButton(loadAllButton);
//		
//		this.loadLayoutButton = new AdvancedButton(0, 0, 120, 20, Locals.localize("helper.creator.editlayout.popup.loadselected"), true, (press) -> {
//			String s = this.fileSwitcher.getSelectedValue();
//			if ((s != null) && !s.equals("")) {
//				this.setDisplayed(false);
//				
//				List<PropertiesSet> l = new ArrayList<PropertiesSet>();
//				l.add((PropertiesSet) this.props.get(s).get(0));
//				
//				//TODO übernehmen
////				if (!MenuCustomization.containsCalculations(l.get(0))) {
//					//TODO übernehmen
//					LayoutEditorScreen.isActive = true;
//					//TODO übernehmen (currentScreen)
//					Minecraft.getInstance().displayGuiScreen(new PreloadedLayoutEditorScreen(Minecraft.getInstance().currentScreen, l));
//					//TODO übernehmen
////					LayoutCreatorScreen.isActive = true;
//					MenuCustomization.stopSounds();
//					MenuCustomization.resetSounds();
//					for (IAnimationRenderer r : AnimationHandler.getAnimations()) {
//						if (r instanceof AdvancedAnimation) {
//							((AdvancedAnimation)r).stopAudio();
//							if (((AdvancedAnimation)r).replayIntro()) {
//								((AdvancedAnimation)r).resetAnimation();
//							}
//						}
//					}
////				} else {
////					PopupHandler.displayPopup(new NotificationPopup(300, new Color(0, 0, 0, 0), 240, null, Locals.localize("helper.creator.editlayout.unsupportedvalues")));
////				}
//			}
//		});
//		this.addButton(loadLayoutButton);
//		
//		this.cancelButton = new AdvancedButton(0, 0, 120, 20, Locals.localize("helper.creator.editlayout.popup.cancel"), true, (press) -> {
//			this.setDisplayed(false);
//		});
//		this.addButton(cancelButton);
//	}
//
//	@Override
//	public void render(int mouseX, int mouseY, Screen renderIn) {
//		RenderSystem.enableBlend();
//		super.render(mouseX, mouseY, renderIn);
//		
//		if (this.isDisplayed()) {
//
//			AbstractGui.drawCenteredString(Minecraft.getInstance().fontRenderer, new StringTextComponent("§l" + Locals.localize("helper.creator.editlayout")),
//					renderIn.width / 2, (renderIn.height / 2) - 110, Color.WHITE.getRGB());
//			
//			int i = 0;
//			for (String s : this.msg) {
//				AbstractGui.drawCenteredString(Minecraft.getInstance().fontRenderer, new StringTextComponent(s),
//						renderIn.width / 2, (renderIn.height / 2) - 90 + i, Color.WHITE.getRGB());
//				i += 10;
//			}
//			
//			int startY = (renderIn.height / 2) - 70 + i;
//			
//			this.loadAllButton.setX((renderIn.width / 2) - (this.loadAllButton.getWidth() / 2));
//			this.loadAllButton.setY(startY);
//			
//			
//			AbstractGui.drawCenteredString(Minecraft.getInstance().fontRenderer, new StringTextComponent(Locals.localize("helper.creator.editlayout.popup.layouts")),
//					renderIn.width / 2, startY + 37, Color.WHITE.getRGB());
//			
//			this.fileSwitcher.render((renderIn.width / 2) - (this.fileSwitcher.getTotalWidth() / 2), startY + 50);
//			
//			String s = this.fileSwitcher.getSelectedValue();
//			int count = 0;
//			if ((s != null) && !props.isEmpty()) {
//				List<Object> ol = this.props.get(s);
//				if (ol.size() >= 2) {
//					count = (int) this.props.get(s).get(1);
//				}
//			}
//			
//			AbstractGui.drawCenteredString(Minecraft.getInstance().fontRenderer,
//					new StringTextComponent("(" + Locals.localize("helper.creator.editlayout.popup.actionscount", "" + count) + ")"),
//					renderIn.width / 2, startY + 75, Color.WHITE.getRGB());
//
//			
//			this.loadLayoutButton.setX((renderIn.width / 2) - this.loadLayoutButton.getWidth() - 5);
//			this.loadLayoutButton.setY(startY + 95);
//			
//			this.cancelButton.setX((renderIn.width / 2) + 5);
//			this.cancelButton.setY(startY + 95);
//			
//			this.renderButtons(mouseX, mouseY);
//		}
//	}
//	
//	private void setNotificationText(String... text) {
//		if (text != null) {
//			List<String> l = new ArrayList<String>();
//			for (String s : text) {
//				if (s.contains("%n%")) {
//					for (String s2 : s.split("%n%")) {
//						l.add(s2);
//					}
//				} else {
//					l.add(s);
//				}
//			}
//			this.msg = l;
//		}
//	}
//
//}
//