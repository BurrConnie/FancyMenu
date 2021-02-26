package de.keksuccino.fancymenu.menu.fancy.helper.layoutcreator.content.button;

import java.awt.Color;
import java.io.IOException;

import com.mojang.blaze3d.systems.RenderSystem;

import de.keksuccino.fancymenu.menu.fancy.item.CustomizationItemBase;
import de.keksuccino.konkrete.properties.PropertiesSection;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

/**
 * Dummy item class to use its orientation handling for LayoutButtons
 */
public class LayoutButtonDummyCustomizationItem  extends CustomizationItemBase {

	private Identifier texture = null;
	
	public LayoutButtonDummyCustomizationItem(String label, int width, int height, int x, int y) {
		super(new PropertiesSection("customization"));
		this.value = label;
		this.action = "handlelayoutbutton";
		this.width = width;
		this.height = height;
		this.posX = x;
		this.posY = y;
	}

	@Override
	public void render(MatrixStack matrix, Screen menu) throws IOException {
		RenderSystem.enableBlend();
        if (this.texture == null) {
        	Screen.fill(matrix, this.getPosX(menu), this.getPosY(menu), this.getPosX(menu) + this.width, this.getPosY(menu) + this.height, new Color(138, 138, 138, 255).getRGB());
        } else {
        	MinecraftClient.getInstance().getTextureManager().bindTexture(this.texture);
        	RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        	drawTexture(matrix, this.getPosX(menu), this.getPosY(menu), 0.0F, 0.0F, this.width, this.height, this.width, this.height);
        }
        drawCenteredString(matrix, MinecraftClient.getInstance().textRenderer, this.value, this.getPosX(menu) + this.width / 2, this.getPosY(menu) + (this.height - 8) / 2, new Color(255, 255, 255, 255).getRGB());
        RenderSystem.disableBlend();
	}
	
	public void setTexture(Identifier texture) {
		this.texture = texture;
	}

}