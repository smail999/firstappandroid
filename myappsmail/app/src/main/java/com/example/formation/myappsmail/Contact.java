package com.example.formation.myappsmail;

/**
 * Created by Formation on 15/06/2017.
 */

public class Contact {
    private int id;
    private String quantitiesCoffees;
    private String quantitiesChantillyCoffees;
    private String quantitiesChocolates;
    private String quantitiesChantillyChocolates;
    private String total;

    public Contact() {
    }

    public Contact(int id, String quantitiesCoffees, String quantitiesChantillyCoffees, String quantitiesChocolates, String quantitiesChantillyChocolates, String total) {
        this.id = id;
        this.quantitiesCoffees = quantitiesCoffees;
        this.quantitiesChantillyCoffees = quantitiesChantillyCoffees;
        this.quantitiesChocolates = quantitiesChocolates;
        this.quantitiesChantillyChocolates = quantitiesChantillyChocolates;
        this.total = total;
    }

    public Contact(String quantitiesCoffees, String quantitiesChantillyCoffees, String quantitiesChocolates, String quantitiesChantillyChocolates, String total) {
        this.quantitiesCoffees = quantitiesCoffees;
        this.quantitiesChantillyCoffees = quantitiesChantillyCoffees;
        this.quantitiesChocolates = quantitiesChocolates;
        this.quantitiesChantillyChocolates = quantitiesChantillyChocolates;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuantitiesCoffees() {
        return quantitiesCoffees;
    }

    public void setQuantitiesCoffees(String quantitiesCoffees) {
        this.quantitiesCoffees = quantitiesCoffees;
    }

    public String getQuantitiesChantillyCoffees() {
        return quantitiesChantillyCoffees;
    }

    public void setQuantitiesChantillyCoffees(String quantitiesChantillyCoffees) {
        this.quantitiesChantillyCoffees = quantitiesChantillyCoffees;
    }

    public String getQuantitiesChocolates() {
        return quantitiesChocolates;
    }

    public void setQuantitiesChocolates(String quantitiesChocolates) {
        this.quantitiesChocolates = quantitiesChocolates;
    }

    public String getQuantitiesChantillyChocolates() {
        return quantitiesChantillyChocolates;
    }

    public void setQuantitiesChantillyChocolates(String quantitiesChantillyChocolates) {
        this.quantitiesChantillyChocolates = quantitiesChantillyChocolates;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}