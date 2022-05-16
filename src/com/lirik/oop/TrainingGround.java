package com.lirik.oop;

import com.lirik.generic.oop.weapon.RangeWeapon;
import com.lirik.oop.heroes.Archer;
import com.lirik.oop.heroes.Hero;
import com.lirik.oop.heroes.Mage;
import com.lirik.oop.heroes.Warrior;

public class TrainingGround {

    public static void main(String[] args) {

        Hero warrior = new Warrior("Aragon", 50);

        Hero archer = new Archer("Legolas", 30);

        Hero mage = new Mage("Gendolf", 40);

        Enemy enemy = new Enemy("Ork", 150);

        attackEnemy(enemy, warrior, archer, mage);
    }

    private static void attackEnemy(Enemy enemy, Hero... heroes) {
        while (enemy.isAlive()) {
            for (Hero hero : heroes) {
                if (enemy.isAlive()) {
                    hero.attackEnemy(enemy);
                }
            }
        }


    }
}
