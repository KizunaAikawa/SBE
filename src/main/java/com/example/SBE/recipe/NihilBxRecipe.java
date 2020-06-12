package com.example.SBE.recipe;

import com.example.SBE.Recipe;
import mods.flammpfeil.slashblade.SlashBlade;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class NihilBxRecipe extends Recipe {
    public NihilBxRecipe() {
        super();
        ItemStack diamondBlock = new ItemStack(Blocks.DIAMOND_BLOCK);
        this.newBlade = SlashBlade.getCustomBlade("flammpfeil.slashblade.named.nihilbx");
        this.previousBlade = SlashBlade.getCustomBlade("flammpfeil.slashblade.named.nihil");
        this.itemMap.put('D', diamondBlock);
        this.itemMap.put('B', previousBlade);
        this.setShare(new String[]{"DDD", "DBD", "DDD"});
    }
}
