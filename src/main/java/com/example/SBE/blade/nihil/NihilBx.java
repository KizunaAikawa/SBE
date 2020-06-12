package com.example.SBE.blade.nihil;

import com.example.SBE.Blade;
import com.example.SBE.recipe.NihilBxRecipe;
import net.minecraft.init.Enchantments;

public class NihilBx extends Blade {
    public NihilBx() {
        super();
        this.setName("nihilbx");
        this.setMaxDamage(240);
        this.setBaseAttackModifier(13.0F);
        this.setTexture("nihil/nihil_bx");
        this.setModel("nihil/nihil");
        this.setSpecialAttackType(7);
        this.setStandbyRenderType(1);
        this.addEnchantment(Enchantments.UNBREAKING, 10);
        this.addEnchantment(Enchantments.SHARPNESS, 10);
        this.addEnchantment(Enchantments.SMITE, 5);
        this.addEnchantment(Enchantments.FIRE_ASPECT, 5);
        this.setDefaultBewitched(true);
    }
}
