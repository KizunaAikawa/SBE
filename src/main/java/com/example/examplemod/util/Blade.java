package com.example.examplemod.util;

import java.util.List;

public class Blade {
    private String name;
    private Integer maxDamage;
    private Float baseAttackModifier;
    private String textureName;
    private String modelName;
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

    public String getTextureName() {
        return textureName;
    }

    public void setTextureName(String textureName) {
        this.textureName = textureName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
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
}
