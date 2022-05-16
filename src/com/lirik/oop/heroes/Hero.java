package com.lirik.oop.heroes;

import com.lirik.generic.oop.weapon.Weapon;
import com.lirik.oop.Enemy;

public abstract class Hero <T extends Weapon> {

    private String name;

    private Integer damage;

    private T weapon;

    public Hero(String name, Integer damage) {
        this.name = name;
        this.damage = damage;
    }

    public abstract void attackEnemy(Enemy enemy);

    public String getName() {
        return name;
    }

    public Integer getDamage() {
        return damage;
    }

    public T getWeapon() {
        return weapon;
    }

    public void setWeapon(T weapon) {
        this.weapon = weapon;
    }
}
