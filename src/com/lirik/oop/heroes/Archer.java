package com.lirik.oop.heroes;

import com.lirik.generic.oop.weapon.RangeWeapon;
import com.lirik.oop.Enemy;

/**
 * T extends RangeWeapon означает, что в качестве параметра наш лучник получит только то оружие, которое реализует интерфейс RangeWeapon
 */
public class Archer<T extends RangeWeapon> extends Hero<T> {

    private Wolf wolf;

    public Archer(String name, Integer damage) {
        super(name, damage);
        this.wolf = new Wolf("Wolf", 7);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println(getName() + " attacks enemy " + enemy.getName() + " with bow");
        wolf.attackEnemy(enemy);
    }

    /**
     * Внутренние классы. Внутренние и вложенные классы могут быть как public, так и default и даже private!!!
     * Даже если доступ будет public создать объект Wolf можно только через объект класса Archer: archer.new Wolf();
     *
     * Вложенный класс создается с модификатором static, но тогда теряется связь с верхним классом и запись Archer.this.getName()
     * становится невозможной, а объект будет создаваться через класс, а не его объект:
     * Archer.Wolf wolf = new Archer.Wolf ();
     */

    private class Wolf {

        private String name;
        private int damage;

        public Wolf(String name, int damage) {
            this.name = name;
            this.damage = damage;
        }

        public void attackEnemy(Enemy enemy) {
            System.out.println(name + " and " + Archer.this.getName() + " make common attack");
            enemy.takeDamage(damage + Archer.this.getDamage());
        }
    }
}
