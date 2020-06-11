package com.example.SBE.recipe;

import com.example.SBE.Recipe;
import mods.flammpfeil.slashblade.SlashBlade;
import net.minecraft.item.ItemStack;

public class NihilRecipe extends Recipe {
    public NihilRecipe() {
        super();
        ItemStack sphere = SlashBlade.findItemStack("flammpfeil.slashblade", "sphere_bladesoul", 1);
        ItemStack ingot = SlashBlade.findItemStack("flammpfeil.slashblade", "ingot_bladesoul", 1);
        this.previousBlade = new ItemStack(SlashBlade.weapon);
        this.itemMap.put('S', sphere);
        this.itemMap.put('I', ingot);
        this.itemMap.put('B', previousBlade);
        this.setShare(new String[]{"SIS", "IBI", "SIS"});
    }
}
