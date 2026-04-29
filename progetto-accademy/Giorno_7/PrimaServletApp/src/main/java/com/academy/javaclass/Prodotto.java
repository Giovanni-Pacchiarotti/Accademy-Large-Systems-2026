package com.academy.javaclass;

public class Prodotto 
{

    private String nome;
    private double prezzo;
    private boolean disponibile;

    // COSTRUTTORE VUOTO (obbligatorio per JavaBean)
    public Prodotto() {}

    // GETTER E SETTER
    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public double getPrezzo() 
    {
        return prezzo;
    }

    public void setPrezzo(double prezzo) 
    {
        this.prezzo = prezzo;
    }

    // per boolean si usa "is"
    public boolean isDisponibile() 
    {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) 
    {
        this.disponibile = disponibile;
    }
}
