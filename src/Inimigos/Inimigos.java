package Inimigos;

import java.util.ArrayList;
import java.util.Random;

public  class Inimigos {




    private String name;

    public float atacar() {
        Random rand = new Random();
        float damage = rand.nextFloat(100, 250);
        return damage;
    }

    public float vida(){
        Random rand = new Random();
        float life = rand.nextFloat(400, 650);
        return life;
    }


    public Inimigos(){

    }

    public Inimigos(String name) {
            this.name = name;
        }

        public String getName () {
            return name;
        }
    }

