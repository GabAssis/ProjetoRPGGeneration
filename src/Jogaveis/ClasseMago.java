package Jogaveis;

import Cores.Cores;
import Inimigos.Inimigos;

public class ClasseMago extends AllChars implements Skills {

    //ATRIBUTOS
    Inimigos inimigo = new Inimigos();
    private double vidaRestante = vida();

    //CONSTRUCTOR
    public ClasseMago() {
    }

    public ClasseMago(String nome, float peso, int idade, String sexo, int vitality, int resistance, int strength, int dexterity, int intelligence, int level) {
        super(nome, peso, idade, sexo, vitality, resistance, strength, dexterity, intelligence, level);
    }


    //SCRIPT MAGO
    public void scriptMago() throws InterruptedException {
        System.out.println("\n\n\n         █▄██▄█                  █▄██▄█\n" +
                           "█▄█▄█▄█▄█▐█┼██▌█▄█▄█▄█▄██▄█▄█▄█▄█▐█┼██▌█▄█▄█▄█▄█\n" +
                           "███┼█████▐████▌█████┼██████┼█████▐████▌███┼█████\n" +
                           "█████████▐████▌██████████████████▐████▌█████████" +
                           "\nA aventura do mago " + this.getNome() + " começou de forma tranquila" +
                           " após aceitar um contrato para verificar um castelo abandonado!\n");
        caminhar();
        System.out.println("Após caminhar por um tempo pelos muros do castelo "+this.getNome()+" finalmente " +
                           "encontra uma brecha pelos portões do castelo\n");
        Thread.sleep(3000);
        System.out.println("          █▄█▄█▄█▄█           \n" +
                           "█▄█▄█▄█▄█▐████▌████▌█▄█▄█▄█▄█ \n" +
                           "███┼█████┼┼┼┼┼┼┼┼┼┼ █████┼███ \n" +
                           "█████████┼┼┼┼┼┼┼  ┼ █████████ \n" +
                           "█████████┼┼┼┼┼┼   ┼ █████████ \n");
        System.out.println("Após ser engolido pela escuridão que o ambiente proporcionava" +
                           " o "+senioridade()+" de "+this.getIdade()+" anos sente uma" +
                           " energia estranha e quando se vira......");
        Thread.sleep(6000);
    }

    //ENTRADA USUÁRIO
    public void inputMago() {
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

    //BATALHA MAGO
    public void batalhaMago() throws InterruptedException {
        // Obtém a vida do inimigo e seu poder de ataque
        double vidaInimigo = inimigo.vida();
        double ataqueInimigo = inimigo.atacar();
        boolean usouAPesado = false;
        boolean defendeu = false;
        // Loop que representa a batalha enquanto a vida do inimigo e a vida restante do jogador são maiores que zero
        while (vidaInimigo > 0 && vidaRestante > 0) {
            // Exibe as opções de luta
            opcoesLuta(getVidaRestante());
            System.out.println("DIGITE A OPÇÃO DESEJADA\n");
            switch (leia.nextInt()) {
                case 1:
                    // Caso o jogador escolha atacar
                    if (vidaRestante > 0) {
                        // Reduz a vida do inimigo com um ataque
                        vidaInimigo -= atacar();
                        System.out.printf("Você deu %.2f de dano e deixou o inimigo com %.2f de vida\n", atacar(), vidaInimigo);
                        System.out.println("o==[]:::::::::>");
                        // Verifica se o inimigo ainda está vivo
                        if (vidaInimigo > 0) {
                            System.out.println(" AGORA É O TURNO DO INIMIGO: \n");
                            // Reduz a vida do jogador com o ataque do inimigo
                            setVidaRestante(vidaRestante - ataqueInimigo);
                            // Verifica se o jogador morreu
                            if (!(vidaRestante > 0)) {
                                System.out.printf(" O inimigo te deu %.2f de dano e você morreu!", inimigo.atacar());
                                break;
                            }
                            // Aguarda um tempo (simulação de ação)
                            Thread.sleep(2000);
                            System.out.printf(" O inimigo te deu %.2f de dano e você está com %.2f de vida", inimigo.atacar(), getVidaRestante());
                        } else {
                            System.out.println(" Você matou o inimigo e ganhou o jogo!");
                        }
                    } else {
                        System.out.println(" Você morreu!");
                    }

                    break;
                case 2:
                    // Caso o jogador escolha defender
                    if (!defendeu) {
                        if (vidaRestante > 0) {
                            if (vidaInimigo > 0) {
                                // Aumenta a vida do jogador ao defender (simulação de defesa)
                                vidaRestante += defender() / 2;
                                System.out.printf(Cores.TEXT_GREEN_BOLD_BRIGHT+"Você  agora tem %.2f de vida\n"+Cores.TEXT_RESET, vidaRestante);
                                System.out.println("         \n" +
                                                   "  ▄▀▀█▀▀▄\n" +
                                                   " ▐▌     ▐▌\n" +
                                                   " ▐█▄   ▄█▌\n" +
                                                   "  ▀██▄██▀\n");
                                System.out.println(" AGORA É O TURNO DO INIMIGO: \n");
                                // Reduz a vida do jogador com o ataque do inimigo
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
                    // Caso o jogador escolha ataque raio
                    if (!usouAPesado) {
                        // Reduz a vida do inimigo com um ataque raio
                        vidaInimigo -= ataqueRaio();
                        System.out.printf("Você deu %.2f de dano e deixou o inimigo com %.2f de vida\n", ataqueRaio(), vidaInimigo);
                        System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "||RAIO||" + Cores.TEXT_RESET);
                        if(vidaRestante > 0) {
                            if (vidaInimigo > 0) {
                                System.out.println(" AGORA É O TURNO DO INIMIGO: \n");
                                setVidaRestante(vidaRestante - ataqueInimigo);
                                // Verifica se o jogador morreu
                                if(!(vidaRestante>0)){
                                    System.out.printf(Cores.TEXT_RED_BOLD+" O inimigo te deu %.2f de dano e você morreu!\n"+Cores.TEXT_RESET,inimigo.atacar());
                                    System.out.println("───────▄▄▄▄▄▄▄────────\n" +
                                                       "─────▄█████████▄──────\n" +
                                                       "─────██─▀███▀─██──────\n" +
                                                       "     ▀████▀████▀──────\n" +
                                                       "───────██▀█▀██────────\n");
                                    break;
                                }
                                // Aguarda um tempo (simulação de ação)
                                Thread.sleep(2000);
                                System.out.printf(" O inimigo te deu %.2f de dano e você está com %.2f de vida", inimigo.atacar(), getVidaRestante());
                            } else {
                                System.out.println(" Você matou o inimigo e ganhou o jogo!");
                            }
                        }else{
                            System.out.println(Cores.TEXT_RED_BOLD+" Você morreu!"+Cores.TEXT_RESET);
                        }
                        usouAPesado = true;
                    }else{
                        System.out.println("Você não pode mais usar o raio!");
                    }
                    break;
            }
        }

    }



    //SKILLS CLASSE
    public double ataqueRaio() {
        double damage = atacar() * getIntelligence() / 6;
        return damage;
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

    @Override
    public void opcoesLuta(double vida){
        System.out.printf("\n\n\n┌┌──────────────────┬───────────────┐┐\n" +
                          "││                  │      VIDA     ││\n" +
                          "││    1-ATAQUE      │     %.2f    ││\n" +
                          "││                  │               ││\n" +
                          "├│──────────────────┼───────────────│┤\n" +
                          "││                  │               ││\n" +
                          "││     2-DEFESA     │    3-RAIO     ││\n" +
                          "││                  │               ││\n" +
                          "└┘──────────────────┴───────────────┘┘\n", vida);
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

    public double getVidaRestante() {
        return vidaRestante;
    }

    public void setVidaRestante(double vidaRestante) {
        this.vidaRestante = vidaRestante;
    }
}
