package com.example.SBE;

import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class Recipe {
    protected Map<Character, ItemStack> itemMap = new HashMap<>();
    protected String[] share = {};
    protected ItemStack newBlade = ItemStack.EMPTY;
    protected ItemStack previousBlade = ItemStack.EMPTY;

    public Recipe() {
    }

    public Recipe(Map<Character, ItemStack> itemMap, String[] share, ItemStack previousBlade) {
        this.itemMap = itemMap;
        this.share = share;
        this.previousBlade = previousBlade;
    }

    // getters and setters
    public Map<Character, ItemStack> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<Character, ItemStack> itemMap) {
        this.itemMap = itemMap;
    }

    public String[] getShare() {
        return share;
    }

    public void setShare(String[] share) {
        this.share = share;
    }

    public ItemStack getNewBlade() {
        return newBlade;
    }

    public void setNewBlade(ItemStack newBlade) {
        this.newBlade = newBlade;
    }

    public ItemStack getPreviousBlade() {
        return previousBlade;
    }

    public void setPreviousBlade(ItemStack previousBlade) {
        this.previousBlade = previousBlade;
    }
}
