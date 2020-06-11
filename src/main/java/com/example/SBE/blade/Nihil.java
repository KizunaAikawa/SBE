package com.example.SBE.blade;

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
        this.setDefaultBewitched(true);
        this.setBaseAttackModifier(10.0F);
        this.setTexture("nihil/nihil");
        this.setModel("nihil/nihil");
        this.setSpecialAttackType(2);
        this.setStandbyRenderType(1);
        List<EnchantmentEffect> enchantmentEffects = new ArrayList<>();
        enchantmentEffects.add(new EnchantmentEffect(Enchantments.UNBREAKING, 10));
        enchantmentEffects.add(new EnchantmentEffect(Enchantments.SHARPNESS, 10));
        this.setEnchantmentEffects(enchantmentEffects);
        this.setDefaultBewitched(true);
        this.setRecipe(new NihilRecipe());
    }
}
