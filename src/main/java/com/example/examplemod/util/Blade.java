package com.example.examplemod.util;

import java.util.List;

public class Blade {
    private String name;
    private Integer maxDamage;
    private Float baseAttackModifier;
    private String texture;
    private String model;
    private Integer specialAttackType;
    private Integer standbyRenderType;
    private List<EnchantmentEffect> enchantmentEffects;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(Integer maxDamage) {
        this.maxDamage = maxDamage;
    }

    public Float getBaseAttackModifier() {
        return baseAttackModifier;
    }

    public void setBaseAttackModifier(Float baseAttackModifier) {
        this.baseAttackModifier = baseAttackModifier;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSpecialAttackType() {
        return specialAttackType;
    }

    public void setSpecialAttackType(Integer specialAttackType) {
        this.specialAttackType = specialAttackType;
    }

    public Integer getStandbyRenderType() {
        return standbyRenderType;
    }

    public void setStandbyRenderType(Integer standbyRenderType) {
        this.standbyRenderType = standbyRenderType;
    }

    public List<EnchantmentEffect> getEnchantmentEffects() {
        return enchantmentEffects;
    }

    public void setEnchantmentEffects(List<EnchantmentEffect> enchantmentEffects) {
        this.enchantmentEffects = enchantmentEffects;
    }
}
