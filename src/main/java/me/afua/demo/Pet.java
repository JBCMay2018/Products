package me.afua.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pet {
//    This class acts as the 'orders' or 'transaction' class
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int petName;

    @ManyToOne()
    private Person owners;

    public Pet() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPetName() {
        return petName;
    }

    public void setPetName(int petName) {
        this.petName = petName;
    }

    public Person getOwners() {
        return owners;
    }

    public void setOwners(Person owners) {
        this.owners = owners;
    }
}
