package com.example.examplemod.util;

import net.minecraft.init.Enchantments;

public class EnchantmentEffect {
    private Enchantments enchantmentType;
    private int level = 1;

    public EnchantmentEffect(Enchantments enchantmentType, int level) {
        this.enchantmentType = enchantmentType;
        this.level = level;
    }

    public EnchantmentEffect(Enchantments enchantmentType) {
        this.enchantmentType = enchantmentType;
    }

    public EnchantmentEffect() {
    }

    public Enchantments getEnchantmentType() {
        return enchantmentType;
    }

    public void setEnchantmentType(Enchantments enchantmentType) {
        this.enchantmentType = enchantmentType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
