package com.lirik.oop.heroes;

import com.lirik.generic.oop.weapon.MagicWeapon;
import com.lirik.oop.Enemy;
import com.lirik.oop.heroes.Hero;

/**
 * T extends MagicWeapon означает, что в качестве параметра наш маг получит только то оружие, которое реализует интерфейс MagicWeapon
 */
public class Mage<T extends MagicWeapon> extends Hero<T> {

    public Mage(String name, Integer damage) {
        super(name, damage);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println(getName() + " attacks enemy " +enemy.getName() + " with magic");
        enemy.takeDamage(getDamage());
    }
}
