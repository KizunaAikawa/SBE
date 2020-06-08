package com.example.SBE;

import net.minecraft.enchantment.Enchantment;

public class EnchantmentEffect {
    private Enchantment enchantmentType;
    private int level = 1;

    public EnchantmentEffect(Enchantment enchantmentType, int level) {
        this.enchantmentType = enchantmentType;
        this.level = level;
    }

    public EnchantmentEffect(Enchantment enchantmentType) {
        this.enchantmentType = enchantmentType;
    }

    public EnchantmentEffect() {
    }

    public Enchantment getEnchantmentType() {
        return enchantmentType;
    }

    public void setEnchantmentType(Enchantment enchantmentType) {
        this.enchantmentType = enchantmentType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
