package org.example.hibernate;

import jakarta.persistence.*;

@Entity
@Table(name = "magic")
public class Magic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "название")
    private String name;

    @Column(name = "повреждение")
    private int damage;

    @Column(name = "атака")
    private int attBonus;

    @Column(name = "броня")
    private int armor;


    Magic() {

    }

    public Magic(String name, int damage, int attBonus, int armor) {
        this.name = name;
        this.damage = damage;
        this.attBonus = attBonus;
        this.armor = armor;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getAttBonus() {
        return attBonus;
    }

    public int getArmor() {
        return armor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setAttBonus(int attBonus) {
        this.attBonus = attBonus;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public String toString() {
        return "Magic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", damage=" + damage +
                ", attBonus=" + attBonus +
                ", armor=" + armor +
                '}';
    }
}
