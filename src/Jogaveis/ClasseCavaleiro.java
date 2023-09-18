package Jogaveis;

import Cores.Cores;
import Inimigos.Inimigos;

public class ClasseCavaleiro extends AllChars implements Skills {

    //ATRIBUTOS
    Inimigos inimigo = new Inimigos();
    private double vidaRestante = vida();


    //CONSTRUCTOR

    public ClasseCavaleiro() {
        super.setAtaqueEspecial("ATK.PESADO");
        super.setClasse("Cavaleiro");
    }


    //INPUT CAVALEIRO
    public void inputCavaleiro() {
        while(true) {
            System.out.println("\nDigite o nome do seu personagem: ");
            String nome = leia.nextLine();
            if(!(nome.isEmpty())) {
                setNome(nome);
                break;
            }else{
                System.out.println("O nome não pode ser vazio!");
            }
        }
        while(true) {
            try {
                System.out.println("Digite a idade do seu personagem:");
                int idade = Integer.parseInt(leia.nextLine());
                setIdade(idade);
                break;
            }catch (NumberFormatException f){
                System.out.println("\nDigite a idade novamente");
            }
        }
        while (true) {
            System.out.println("Digite o sexo do seu personagem: (M ou F ou N)");
            String sexoPersonagem = leia.nextLine();
            if (sexoPersonagem.equalsIgnoreCase("m") || sexoPersonagem.equalsIgnoreCase("f") || sexoPersonagem.equalsIgnoreCase("n")) {
                setSexo(sexoPersonagem);
            } else {
                System.out.println("String inválida");
                continue;
            }
            break;
        }
    }

    //MÉTODO BATALHA


    //SKILLS CLASSE
    public double usarAtaqueEspecial() {
        double damage = atacar() * getStrength() / 6;
        return damage;
    }


    //SKILLS BASE
    @Override
    public double atacar() {
        double damage = getStrength() + getVitality() * (getVitality() - 10) + (getLevel() * 10);
        return damage;
    }

    @Override
    public double defender() {
        double defense = getVitality() + getResistance() * 5;
        return defense;
    }

    @Override
    public double vida() {
        double life = 500 + (getLevel() / 0.04) + getVitality() * 10;
        return life;
    }


    //GET AND SET
    public int getVitality() {
        int vitality = 14;
        return vitality;
    }

    public int getResistance() {
        int resistance = 10;
        return resistance;
    }

    public int getStrength() {
        int strength = 11;
        return strength;
    }

    public int getDexterity() {
        int dexterity = 11;
        return dexterity;
    }

    public int getIntelligence() {
        int intelligence = 9;
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
