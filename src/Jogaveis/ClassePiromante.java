package Jogaveis;

import Cores.Cores;
import Inimigos.Inimigos;

public class ClassePiromante extends AllChars implements Skills{

    //ATRIBUTOS
    Inimigos inimigo = new Inimigos();
    private double vidaRestante = vida();


    //CONSTRUCTOR
    public ClassePiromante() {
        super.setAtaqueEspecial("FOGO");
        super.setClasse("Piromante");
    }

    //ENTRADA USUÁRIO
    public void inputPiromante(){
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


    //SKILLS CLASSE
    public double usarAtaqueEspecial(){
        double damage = atacar()*getIntelligence()/5;
        return damage;
    }


    //SKILLS BASE
    @Override
    public double atacar() {
        double damage = getStrength()+getStrength()+getIntelligence()*(getStrength()-7)+(getLevel()*10);
        return damage;
    }

    @Override
    public double defender() {
        double defense = getVitality()+getResistance()*5;
        return defense;
    }

    @Override
    public double vida() {
        double life = 500+(getLevel()/0.04)+getVitality()*10;
        return life;
    }




    //GET AND SET
    public int getVitality() {
        int vitality = 10;
        return vitality;
    }

    public int getResistance() {
        int resistance = 12;
        return resistance;
    }

    public int getStrength() {
        int strength = 12;
        return strength;
    }

    public int getDexterity() {
        int dexterity = 9;
        return dexterity;
    }

    public int getIntelligence() {
        int intelligence = 10;
        return intelligence;
    }

    public int getLevel() {
        int level = 1;
        return level;
    }


}
