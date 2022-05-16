package com.lirik.generic.oop;

import com.lirik.generic.oop.weapon.Axe;
import com.lirik.generic.oop.weapon.Bow;
import com.lirik.generic.oop.weapon.Sword;
import com.lirik.generic.oop.weapon.Wand;
import com.lirik.generic.oop.weapon.Weapon;
import com.lirik.oop.heroes.Archer;
import com.lirik.oop.heroes.Hero;
import com.lirik.oop.heroes.Mage;
import com.lirik.oop.heroes.Warrior;

public class WeaponRunner {

    public static void main(String[] args) {

        Archer<Bow> archer = new Archer<>("Legolas", 30);
        archer.setWeapon(new Bow());   // Создать оружие другого типа мы ему не можем, т. к. параметризовали оружие лучника классом Bow

        Warrior<Sword> warrior = new Warrior<>("Aragon", 50);
        warrior.setWeapon(new Sword());  // Создать оружие другого типа мы ему не можем, т. к. параметризо вали оружие война классом Sword

        Mage<Wand> mage = new Mage<>("Gendolf", 40);
        mage.setWeapon(new Wand());   // Создать оружие другого типа мы ему не можем, т. к. параметризовали оружие мага классом Wand

        Warrior<Axe> warrior1 = new Warrior<>("Gimly", 45);
        warrior1.setWeapon(new Axe()); // Создать оружие другого типа мы ему не можем, т. к. параметризовали оружие война классом Axe

        printWeaponDamage(warrior);
        printWeaponDamage(mage);
        printWeaponDamage(archer);
        printWeaponDamage(warrior1);

        printWeaponDamageWithWildCard(warrior);
        printWeaponDamageWithWildCard(warrior1);
        printWeaponDamageWithWildCard(archer);
        printWeaponDamageWithWildCard(mage);

    }

    public static <T extends Weapon> void printWeaponDamage(Hero<T> hero) {
        System.out.println(hero.getWeapon().getDamage());
    }

    /**
     * Конструкция с Wildcard для обозначения типа данных нашего Hero
     */
    public static void printWeaponDamageWithWildCard(Hero<? extends Weapon> hero) {
        System.out.println(hero.getWeapon().getDamage());
    }
}
