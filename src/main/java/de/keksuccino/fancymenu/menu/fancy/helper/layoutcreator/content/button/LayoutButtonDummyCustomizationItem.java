package de.keksuccino.fancymenu.menu.fancy.helper.layoutcreator.content.button;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import com.mojang.blaze3d.systems.RenderSystem;

import de.keksuccino.fancymenu.menu.animation.AnimationHandler;
import de.keksuccino.fancymenu.menu.fancy.item.CustomizationItemBase;
import de.keksuccino.fancymenu.menu.fancy.menuhandler.MenuHandlerBase;
import de.keksuccino.konkrete.properties.PropertiesSection;
import de.keksuccino.konkrete.rendering.RenderUtils;
import de.keksuccino.konkrete.rendering.animation.IAnimationRenderer;
import de.keksuccino.konkrete.resources.ExternalTextureResourceLocation;
import de.keksuccino.konkrete.resources.TextureHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;

/**
 * Dummy item class to use its orientation handling for LayoutButtons
 */
public class LayoutButtonDummyCustomizationItem  extends CustomizationItemBase {

	protected MenuHandlerBase.ButtonCustomizationContainer button;

	public LayoutButtonDummyCustomizationItem(MenuHandlerBase.ButtonCustomizationContainer button, String label, int width, int height, int x, int y) {
		super(new PropertiesSection("customization"));
		this.value = label;
		this.action = "handlelayoutbutton";
		this.setWidth(width);
		this.setHeight(height);
		this.posX = x;
		this.posY = y;
		this.button = button;
	}

	@Override
	public void render(MatrixStack matrix, Screen menu) throws IOException {
		RenderSystem.enableBlend();

		IAnimationRenderer animation = null;
		Identifier texture = null;
		if (this.button.normalBackground != null) {
			if (this.button.normalBackground.startsWith("animation:")) {
				String aniName = this.button.normalBackground.split("[:]", 2)[1];
				if (AnimationHandler.animationExists(aniName)) {
					animation = AnimationHandler.getAnimation(aniName);
					if (!animation.isReady()) {
						animation.prepareAnimation();
					}
				}
			} else {
				File f = new File(this.button.normalBackground);
				if (f.isFile()) {
					if (f.getPath().toLowerCase().endsWith(".gif")) {
						animation = TextureHandler.getGifResource(f.getPath());
					} else if (f.getPath().toLowerCase().endsWith(".jpg") || f.getPath().toLowerCase().endsWith(".jpeg") || f.getPath().toLowerCase().endsWith(".png")) {
						ExternalTextureResourceLocation exTex = TextureHandler.getResource(f.getPath());
						if (exTex != null) {
							if (!exTex.isReady()) {
								exTex.loadTexture();
							}
							texture = exTex.getResourceLocation();
						}
					}
				}
			}
		}

		if (texture != null) {
			RenderUtils.bindTexture(texture);
			RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
			drawTexture(matrix, this.getPosX(menu), this.getPosY(menu), 0.0F, 0.0F, this.getWidth(), this.getHeight(), this.getWidth(), this.getHeight());
		} else if (animation != null) {
			int aniX = animation.getPosX();
			int aniY = animation.getPosY();
			int aniWidth = animation.getWidth();
			int aniHeight = animation.getHeight();
			boolean aniLoop = animation.isGettingLooped();

			animation.setPosX(this.getPosX(menu));
			animation.setPosY(this.getPosY(menu));
			animation.setWidth(this.getWidth());
			animation.setHeight(this.getHeight());
			animation.setLooped(this.button.loopAnimation);

			animation.render(matrix);

			animation.setPosX(aniX);
			animation.setPosY(aniY);
			animation.setWidth(aniWidth);
			animation.setHeight(aniHeight);
			animation.setLooped(aniLoop);
		} else {
			fill(matrix, this.getPosX(menu), this.getPosY(menu), this.getPosX(menu) + this.getWidth(), this.getPosY(menu) + this.getHeight(), new Color(138, 138, 138, 255).getRGB());
		}
		drawCenteredText(matrix, MinecraftClient.getInstance().textRenderer, new LiteralText(this.value), this.getPosX(menu) + this.getWidth() / 2, this.getPosY(menu) + (this.getHeight() - 8) / 2, -1);
		RenderSystem.disableBlend();
	}

}
