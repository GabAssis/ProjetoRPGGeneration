package Inimigos;

import java.util.Random;

public class Inimigos {

    //ATRIBUTOS GERAIS
    private String name;

    //CONSTRUCTOR
    public Inimigos() {

    }

    //MÉTODOS GERAIS
    public float atacar() {
        Random rand = new Random();
        float damage = rand.nextFloat(100, 250);
        return damage;
    }

    public float vida() {
        Random rand = new Random();
        float life = rand.nextFloat(400, 650);
        return life;
    }


    //GET AND SET
    public Inimigos(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

