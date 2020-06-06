package com.example.examplemod.util;

import mods.flammpfeil.slashblade.ItemSlashBlade;
import mods.flammpfeil.slashblade.ItemSlashBladeNamed;
import mods.flammpfeil.slashblade.SlashBlade;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class BladeCustomizer {
    public static void createBlade(Blade blade) {
        ItemStack customBlade = new ItemStack(SlashBlade.bladeNamed, 1, 0);
        NBTTagCompound tag = new NBTTagCompound();
        ItemSlashBladeNamed.CurrentItemName.set(tag,blade.getName());
        ItemSlashBladeNamed.CustomMaxDamage.set(tag,blade.getMaxDamage());
        ItemSlashBlade.setBaseAttackModifier(tag,blade.getBaseAttackModifier());
        SlashBlade.registerCustomItemStack(blade.getName(),customBlade);
        ItemSlashBladeNamed.NamedBlades.add(blade.getName());
    }
}
