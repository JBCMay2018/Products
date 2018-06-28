package me.afua.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {
//    This entity act as the 'product' class
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String myName;

    private double price;

    @OneToMany(mappedBy = "owners")
    private Set<Pet> pets;

    public Person() {
        pets = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
