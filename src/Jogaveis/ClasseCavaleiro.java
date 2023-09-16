package Jogaveis;


import Inimigos.Inimigos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClasseCavaleiro extends AllChars implements Skills {

    Inimigos inimigo = new Inimigos();
    private double vidaRestante = vida();

    public ClasseCavaleiro(String nome, float peso, int idade, String sexo, int vitality, int resistance, int strength, int dexterity, int intelligence, int level) {
        super(nome, peso, idade, sexo, vitality, resistance, strength, dexterity, intelligence, level);
    }

    public ClasseCavaleiro() {
    }

    public void scriptCavaleiro() throws InterruptedException {
        System.out.println("\n\n\n         █▄██▄█                  █▄██▄█\n" +
                           "█▄█▄█▄█▄█▐█┼██▌█▄█▄█▄█▄██▄█▄█▄█▄█▐█┼██▌█▄█▄█▄█▄█\n" +
                           "███┼█████▐████▌█████┼██████┼█████▐████▌███┼█████\n" +
                           "█████████▐████▌██████████████████▐████▌█████████" +
                           "\nA aventura do cavaleiro " + this.getNome() + " começou de forma tranquila" +
                           " após aceitar um contrato para verificar um castelo abandonado!\n");
        caminhar();
        System.out.println("Após caminhar por um tempo pelos muros do castelo " + this.getNome() + " finalmente " +
                           "encontra uma brecha pelos portões do castelo\n");
        Thread.sleep(3000);
        System.out.println("          █▄█▄█▄█▄█           \n" +
                           "█▄█▄█▄█▄█▐████▌████▌█▄█▄█▄█▄█ \n" +
                           "███┼█████┼┼┼┼┼┼┼┼┼┼ █████┼███ \n" +
                           "█████████┼┼┼┼┼┼┼  ┼ █████████ \n" +
                           "█████████┼┼┼┼┼┼   ┼ █████████ \n");
        System.out.println("Após ser engolido pela escuridão que o ambiente proporcionava" +
                           " o " + senioridade() + " de " + this.getIdade() + " anos sente uma" +
                           " energia estranha e quando se vira......");
        Thread.sleep(6000);

    }

    //TRATAMENTO DE EXCEPTIONS
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
            if (sexoPersonagem.startsWith("m") || sexoPersonagem.startsWith("f") || sexoPersonagem.startsWith("n")) {
                setSexo(sexoPersonagem);
            } else {
                System.out.println("String inválida");
                continue;
            }
            break;
        }
    }

    public void batalhaCavaleiro() throws InterruptedException {
        double vidaInimigo = inimigo.vida();
        double ataqueInimigo = inimigo.atacar();
        boolean usouAPesado = false;
        boolean defendeu = false;
        while (vidaInimigo > 0 && vidaRestante > 0) {
            opcoesLuta(getVidaRestante());
            System.out.println("DIGITE A OPÇÃO DESEJADA\n");
            switch (leia.nextInt()) {
                case 1:
                    if(vidaRestante >  0) {
                        vidaInimigo -= atacar();
                        System.out.printf("Você deu %.2f de dano e deixou o inimigo com %.2f de vida\n", atacar(), vidaInimigo);
                        System.out.println("o==[]:::::::::>");
                        if (vidaInimigo > 0) {
                            System.out.println(" AGORA É O TURNO DO INIMIGO: \n");
                            setVidaRestante(vidaRestante - ataqueInimigo);
                            if(!(vidaRestante>0)){
                                System.out.printf(" O inimigo te deu %.2f de dano e você morreu!\n",inimigo.atacar());
                                System.out.println("───────▄▄▄▄▄▄▄────────\n" +
                                                   "─────▄█████████▄──────\n" +
                                                   "─────██─▀███▀─██──────\n" +
                                                   "     ▀████▀████▀──────\n" +
                                                   "───────██▀█▀██────────\n");
                                break;
                            }
                            Thread.sleep(2000);
                            System.out.printf(" O inimigo te deu %.2f de dano e você está com %.2f de vida", inimigo.atacar(), getVidaRestante());
                        } else {
                            System.out.println(" Você matou o inimigo e ganhou o jogo!");
                        }
                    }else {
                        System.out.println(" Você morreu!");
                    }
                    break;
                case 2:

                    if (!defendeu) {
                        if (vidaRestante > 0) {
                            if (vidaInimigo > 0) {
                                vidaRestante += defender() / 2;
                                System.out.printf("Você  agora tem %.2f de vida\n", vidaRestante);
                                System.out.println("         \n" +
                                                   "  ▄▀▀█▀▀▄\n" +
                                                   " ▐▌     ▐▌\n" +
                                                   " ▐█▄   ▄█▌\n" +
                                                   "  ▀██▄██▀\n");
                                System.out.println(" AGORA É O TURNO DO INIMIGO: \n");
                                setVidaRestante(vidaRestante - ataqueInimigo);
                                Thread.sleep(2000);
                                System.out.printf(" O inimigo te deu %.2f de dano e você está com %.2f de vida", inimigo.atacar(), getVidaRestante());
                            } else {
                                System.out.println("O inimigo ja esta morto");
                            }
                        } else {
                            System.out.println("Você morreu!");
                        }
                        defendeu = true;
                    }else{
                        System.out.println("Você ja se defendeu nesta batalha!");
                    }
                    break;
                case 3:
                    if (!usouAPesado) {
                        vidaInimigo -= ataquePesado();
                        System.out.printf("Você deu %.2f de dano e deixou o inimigo com %.2f de vida\n", ataquePesado(), vidaInimigo);
                        System.out.println("▬▬═══════>");
                        if(vidaRestante > 0) {
                            if (vidaInimigo > 0) {
                                System.out.println(" AGORA É O TURNO DO INIMIGO: \n");
                                setVidaRestante(vidaRestante - ataqueInimigo);
                                Thread.sleep(2000);
                                System.out.printf(" O inimigo te deu %.2f de dano e você está com %.2f de vida", inimigo.atacar(), getVidaRestante());
                            } else {
                                System.out.println(" Você matou o inimigo e ganhou o jogo!");
                            }
                        }else{
                            System.out.println(" Você morreu!");
                        }
                        usouAPesado = true;
                    }else{
                        System.out.println("Você não pode mais usar mais ataque pesado!");
                    }
                    break;
            }
        }

    }

    //SKILLS
    public double ataquePesado() {
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

    @Override
    public void opcoesLuta(double vida) {
        System.out.printf("\n\n\n┌┌──────────────────┬───────────────┐┐\n" +
                          "││                  │      VIDA     ││\n" +
                          "││    1-ATAQUE      │     %.2f    ││\n" +
                          "││                  │               ││\n" +
                          "├│──────────────────┼───────────────│┤\n" +
                          "││                  │               ││\n" +
                          "││     2-DEFESA     │  3-ATK.PESADO ││\n" +
                          "││                  │               ││\n" +
                          "└┘──────────────────┴───────────────┘┘\n", vida);
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
