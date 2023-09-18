package Jogaveis;

import Cores.Cores;
import Inimigos.Inimigos;

public class ClasseLadrao extends AllChars implements Skills {

    //ATRIBUTOS
    Inimigos inimigo = new Inimigos();
    public double vidaRestante = vida();

    //CONSTRUCTOR
    public ClasseLadrao() {
        super.setAtaqueEspecial("CRÍTICO");
        super.setClasse("Ladrão");
    }


    //SKILLS CLASSE
    protected double usarAtaqueEspecial(){
        double damage = atacar()*1.6;
        return damage;
    }



    //ENTRADA DO USUÁRIO


    //BATALHA LADRÃO





    //SKILLS BASE
    @Override
    public double atacar() {
        double damage = getStrength()+getDexterity()*(getDexterity()-11)+(getLevel()*10);
        return damage;
    }

    @Override
    public double defender() {
        double defense = getVitality()+getResistance()*4;
        return defense;
    }

    @Override
    public double vida() {
        double life = 500+(getLevel()/0.04)+getVitality()*10;
        return life;
    }



    //FIM SKILLS BASE

    //GET AND SET
    public int getVitality() {
        int vitality = 9;
        return vitality;
    }

    public int getResistance() {
        int resistance = 10;
        return resistance;
    }

    public int getStrength() {
        int strength = 9;
        return strength;
    }

    public int getDexterity() {
        int dexterity = 15;
        return dexterity;
    }

    public int getIntelligence() {
        int intelligence = 12;
        return intelligence;
    }

    public int getLevel() {
        int level = 5;
        return level;
    }

    public double getVidaRestante() {
        return vidaRestante;
    }

    public void setVidaRestante(double vidaRestante) {
        this.vidaRestante = vidaRestante;
    }
}
