package Jogaveis;

import Cores.Cores;
import Inimigos.Inimigos;

import java.util.InputMismatchException;


public class ClasseMago extends AllChars implements Skills  {

    //ATRIBUTOS
    Inimigos inimigo = new Inimigos();
    private double vidaRestante = vida();

    //CONSTRUCTOR
    public ClasseMago() {
        super.setAtaqueEspecial("Raio");
        super.setClasse("Mago");
    }


    //ENTRADA USUÁRIO
    public void inputMago() {
        while (true) {
            System.out.println("\nDigite o nome do seu personagem: ");
            String nome = leia.nextLine();
            if (!(nome.isEmpty())) {
                setNome(nome);
                break;
            } else {
                System.out.println("O nome não pode ser vazio!");
            }
        }
        while (true) {
            try {
                System.out.println("Digite a idade do seu personagem:");
                int idade = Integer.parseInt(leia.nextLine());
                setIdade(idade);
                break;
            } catch (NumberFormatException f) {
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


    //SKILLS CLASSE
    @Override
    protected double usarAtaqueEspecial() {
        return atacar() * getIntelligence() / 6;
    }


    //SKILLS BASE
    @Override
    public double atacar() {
        double damage = getStrength() + getIntelligence() * (getIntelligence() - 10) + (getLevel() * 10);
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



    //FIM SKILLS BASE


    //GET AND SET
    public int getVitality() {
        int vitality = 8;
        return vitality;
    }

    public int getResistance() {
        int resistance = 8;
        return resistance;
    }

    public int getStrength() {
        int strength = 9;
        return strength;
    }

    public int getDexterity() {
        int dexterity = 11;
        return dexterity;
    }

    public int getIntelligence() {
        int intelligence = 15;
        return intelligence;
    }

    public int getLevel() {
        int level = 3;
        return level;
    }

}
