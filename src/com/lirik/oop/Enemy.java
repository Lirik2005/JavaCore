package com.lirik.oop;

public class Enemy implements Mortal {

    private String name;

    private Integer health;

    public Enemy(String name, Integer health) {
        this.name = name;
        this.health = health;
    }

    public void takeDamage(int damage) {
        if (isAlive() && health <= damage) {
            health = 0;
            System.out.println(name + " was killed");
        } else {
            this.health -= health > damage ? damage : health;
            System.out.println(name + " gets damage " + damage + ". HP left " + health);
        }
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }
}
