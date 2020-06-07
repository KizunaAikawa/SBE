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
        ItemSlashBladeNamed.CurrentItemName.set(tag, blade.getName());
        ItemSlashBladeNamed.CustomMaxDamage.set(tag, blade.getMaxDamage());
        ItemSlashBlade.setBaseAttackModifier(tag, blade.getBaseAttackModifier());
        mods.flammpfeil.slashblade.item.ItemSlashBlade.TextureName.set(tag, blade.getTexture());
        mods.flammpfeil.slashblade.item.ItemSlashBlade.ModelName.set(tag, blade.getModel());
        mods.flammpfeil.slashblade.item.ItemSlashBlade.SpecialAttackType.set(tag, blade.getSpecialAttackType());
        mods.flammpfeil.slashblade.item.ItemSlashBlade.StandbyRenderType.set(tag, blade.getStandbyRenderType());
        for (EnchantmentEffect enchantment : blade.getEnchantmentEffects()) {
            customBlade.addEnchantment(enchantment.getEnchantmentType(), enchantment.getLevel());
        }
        SlashBlade.registerCustomItemStack(blade.getName(), customBlade);
        ItemSlashBladeNamed.NamedBlades.add(blade.getName());
    }
}
