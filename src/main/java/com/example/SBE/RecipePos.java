package com.example.SBE;

public class RecipePos {
    private int posX = 0;
    private int posY = 0;

    public RecipePos(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public RecipePos() {
    }

    public int getX() {
        return posX;
    }

    public void setX(int posX) {
        this.posX = posX;
    }

    public int getY() {
        return posY;
    }

    public void setY(int posY) {
        this.posY = posY;
    }
}
