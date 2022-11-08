package de.keksuccino.fancymenu.menu.fancy.item.items;

import de.keksuccino.fancymenu.api.item.CustomizationItemRegistry;
import de.keksuccino.fancymenu.menu.fancy.item.items.inputfield.InputFieldCustomizationItemContainer;
import de.keksuccino.fancymenu.menu.fancy.item.items.slider.SliderCustomizationItemContainer;
import de.keksuccino.fancymenu.menu.fancy.item.items.text.TextCustomizationItemContainer;

public class CustomizationItems {

    public static void registerAll() {

        CustomizationItemRegistry.registerItem(new InputFieldCustomizationItemContainer());
        CustomizationItemRegistry.registerItem(new SliderCustomizationItemContainer());
        
        CustomizationItemRegistry.registerItem(new TextCustomizationItemContainer());

    }

}
