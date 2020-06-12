package com.example.SBE.recipe;

import com.example.SBE.Recipe;
import mods.flammpfeil.slashblade.SlashBlade;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class AkaSakuraRecipe extends Recipe {
    public AkaSakuraRecipe() {
        super();
        ItemStack diamondBlock = new ItemStack(Blocks.DIAMOND_BLOCK);
        ItemStack redFlower = new ItemStack(Blocks.RED_FLOWER);
        ItemStack redstoneBlock = new ItemStack(Blocks.REDSTONE_BLOCK);
        this.newBlade = SlashBlade.getCustomBlade("flammpfeil.slashblade.named.akasakura");
        this.previousBlade = new ItemStack(SlashBlade.weapon);
        this.itemMap.put('D', diamondBlock);
        this.itemMap.put('F', redFlower);
        this.itemMap.put('R', redstoneBlock);
        this.itemMap.put('B', previousBlade);
        this.setShare(new String[]{"DBD", "DRD", "DFD"});
    }
}
