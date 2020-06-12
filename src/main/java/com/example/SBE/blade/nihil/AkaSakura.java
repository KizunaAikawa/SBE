package com.example.SBE.blade.nihil;

import com.example.SBE.Blade;
import net.minecraft.init.Enchantments;

public class AkaSakura extends Blade {
    public AkaSakura() {
        super();
        this.setName("akasakura");
        this.setMaxDamage(65);
        this.setBaseAttackModifier(11.0F);
        this.setTexture("nihil/akasakura");
        this.setModel("nihil/nihil");
        this.setSpecialAttackType(7);
        this.setStandbyRenderType(1);
        this.addEnchantment(Enchantments.UNBREAKING, 5);
        this.addEnchantment(Enchantments.SHARPNESS, 5);
        this.addEnchantment(Enchantments.SMITE, 5);
        this.setDefaultBewitched(true);
    }
}
