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
    }


    //SCRIPT CAVALEIRO
    public void scriptCavaleiro() throws InterruptedException {

        String nomeMaisculo = this.getNome().toUpperCase();

        System.out.println("...");
        Thread.sleep(1500);
        System.out.println("...");
        Thread.sleep(1500);
        System.out.print(Cores.ANSI_BLACK_BACKGROUND+"─────█─▄▀█──█▀▄─█─────\n"+Cores.TEXT_RESET);
        Thread.sleep(600);
        System.out.print(Cores.ANSI_BLACK_BACKGROUND+"────▐▌──────────▐▌────\n"+Cores.TEXT_RESET);
        Thread.sleep(600);
        System.out.print(Cores.ANSI_BLACK_BACKGROUND+"────█▌▀▄──▄▄──▄▀▐█────\n"+Cores.TEXT_RESET);
        Thread.sleep(600);
        System.out.print(Cores.ANSI_BLACK_BACKGROUND+"───▐██──▀▀──▀▀──██▌───\n"+Cores.TEXT_RESET);
        Thread.sleep(600);
        System.out.print(Cores.ANSI_BLACK_BACKGROUND+"──▄████▄──▐▌──▄████▄──\n\n\n"+Cores.TEXT_RESET);
        Thread.sleep(600);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_YELLOW_BOLD+"OLÁ "+nomeMaisculo+" O QUE FAZ SÓ, PELAS RUAS DE LOTHRIC?");
        Thread.sleep(4000);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_GREEN_BOLD+nomeMaisculo+" :QUEM É VOCÊ E COMO SABE O MEU NOME ???!!!!");
        Thread.sleep(4000);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_YELLOW_BOLD+"Isso não importa HAHAHAHA! Sou apenas um desconhecido com uma missão para pessoas corajosas!");
        Thread.sleep(5000);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_GREEN_BOLD+nomeMaisculo+" :HMMM...Acredito ser a pessoa certa! O que devo fazer e o que ganharei com isso?");
        Thread.sleep(5000);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_YELLOW_BOLD+"Uma pessoa verdadeiramente corajosa se provará apenas pela honra e não por dinheiro");
        Thread.sleep(2500);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_YELLOW_BOLD+"Deverá investigar o castelo abandonado de ANOR LONDO e torcer para sair vivo! HAHAHA\n\n");
        Thread.sleep(3000);
        System.out.print(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_RED_BOLD+"─────█─▄▀█──█▀▄─█─────\n");
        Thread.sleep(500);
        System.out.print("────▐▌──────────▐▌────\n");
        Thread.sleep(500);
        System.out.print("────█▌───▄▀▀▄───▐█────\n");
        Thread.sleep(500);
        System.out.print("───▐██──▀────▀──██▌───\n");
        Thread.sleep(500);
        System.out.print("──▄████▄──▐▌──▄████▄──\n ...............ACEITE!\n"+Cores.TEXT_RESET);
        Thread.sleep(6000);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_GREEN_BOLD+this.getNome().toUpperCase()+" :OK! OK! CALMA! Eu aceito senhor desconhecido. Irei provar o meu valor!!!"+Cores.TEXT_RESET);
        Thread.sleep(4000);

        System.out.println("\n\n\n         █▄██▄█                  █▄██▄█\n" +
                           "█▄█▄█▄█▄█▐█┼██▌█▄█▄█▄█▄██▄█▄█▄█▄█▐█┼██▌█▄█▄█▄█▄█\n" +
                           "███┼█████▐████▌█████┼██████┼█████▐████▌███┼█████\n" +
                           "█████████▐████▌██████████████████▐████▌█████████" +
                           "\nA aventura do cavaleiro " + this.getNome() + " começou de forma tranquila" +
                           " após aceitar o contrato do desconhecido!\n");
        caminhar();
        Thread.sleep(5000);
        System.out.println("Após caminhar por um tempo pelos muros do castelo "+this.getNome()+" finalmente " +
                           "encontra uma brecha pelos portões do castelo\n");

        System.out.println("          █▄█▄█▄█▄█           \n" +
                           "█▄█▄█▄█▄█▐████▌████▌█▄█▄█▄█▄█ \n" +
                           "███┼█████┼┼┼┼┼┼┼┼┼┼ █████┼███ \n" +
                           "█████████┼┼┼┼┼┼┼  ┼ █████████ \n" +
                           "█████████┼┼┼┼┼┼   ┼ █████████ \n");
        Thread.sleep(4000);
        System.out.println("Após ser engolido pela escuridão que o ambiente proporcionava" +
                           " o "+senioridade()+" de "+this.getIdade()+" anos sente uma" +
                           " energia estranha e quando se vira......");
        Thread.sleep(6000);

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



    //FIM SKILLS BASE



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
