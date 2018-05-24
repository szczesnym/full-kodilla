package com.kodilla.patterns.builder.bigmac;

import java.util.HashSet;
import java.util.Set;

public class BigMac {
    private BunEnum bun;
    private int burgers;
    private SauceEnum sauce;
    private Set<IngredientsEnum> ingredients;

    public BunEnum getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public SauceEnum getSauce() {
        return sauce;
    }

    public Set<IngredientsEnum> getIngredients() {
        return ingredients;
    }

    private BigMac(BunEnum bun, int burgers, SauceEnum sauce, Set<IngredientsEnum> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new HashSet<>();
        this.ingredients = ingredients;
    }

    public static class BigMacBuilder {
            private BunEnum bun;
            private int burgers;
            private SauceEnum sauce;
            private Set<IngredientsEnum> ingredients = new HashSet<>();

            public BigMacBuilder bun(BunEnum bun) {
                this.bun = bun;
                return this;
            }

            public BigMacBuilder burgers(int burgers) {
                this.burgers = burgers;
                return this;
            }

            public BigMacBuilder sauce(SauceEnum sauce) {
                this.sauce = sauce;
                return this;
            }

            public BigMacBuilder ingredients(IngredientsEnum ingredient) {
                this.ingredients.add(ingredient);
                return this;
            }

            public BigMac build() throws IllegalStateException {
                if(this.burgers <= 0) throw new IllegalStateException("Number of burgers must be >0");
                if(this.bun == null) throw new IllegalStateException("No bun given - cannot create BigMac");
                if(this.sauce == null) {
                    this.sauce = SauceEnum.Standart;
                }
                return new BigMac(this.bun, this.burgers, this.sauce, this.ingredients);
            }
    }
}
