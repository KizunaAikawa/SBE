package com.example.SBE.blade.nihil;

import com.example.SBE.Blade;
import com.example.SBE.EnchantmentEffect;
import com.example.SBE.recipe.NihilRecipe;
import net.minecraft.init.Enchantments;

import java.util.ArrayList;
import java.util.List;

public class Nihil extends Blade {
    public Nihil() {
        super();
        this.setName("nihil");
        this.setMaxDamage(45);
        this.setBaseAttackModifier(10.0F);
        this.setTexture("nihil/nihil");
        this.setModel("nihil/nihil");
        this.setSpecialAttackType(2);
        this.setStandbyRenderType(1);
        this.addEnchantment(Enchantments.UNBREAKING, 3);
        this.addEnchantment(Enchantments.SHARPNESS, 3);
        this.setDefaultBewitched(true);
    }
}
