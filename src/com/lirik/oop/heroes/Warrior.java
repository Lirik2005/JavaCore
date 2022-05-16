package com.lirik.oop.heroes;

import com.lirik.generic.oop.weapon.MeleeWeapon;
import com.lirik.oop.Enemy;
import com.lirik.oop.heroes.Hero;

/**
 * T extends MeleeWeapon означает, чт в качестве параметра наш воин может получит только то оружие, которое реализует интерфейс MeleeWeapon
 */
public class Warrior<T extends MeleeWeapon> extends Hero<T> {

    public Warrior(String name, Integer damage) {
        super(name, damage);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println(getName() + " attacks enemy " + enemy.getName() + " with sword");
        enemy.takeDamage(getDamage());
    }
}
