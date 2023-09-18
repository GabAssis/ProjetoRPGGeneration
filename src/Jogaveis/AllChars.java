package Jogaveis;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.List;

import Cores.Cores;
import Inimigos.Inimigos;
import Sons.AudioDaBatalha;
import Sons.AudioDamage;
import Sons.AudioFala;
import Sons.AudioGameOver;

public abstract class AllChars implements Skills {

    //ATRIBUTOS CLASSE PAI
    static Scanner leia = new Scanner(System.in);
    private String nome;
    private int idade;
    private String sexo;
    private int vitality;
    private int resistance;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int level;
    private double vidaRestante = vida();
    private String ataqueEspecial;
    private String classe;

    //CONSTRUCTOR
    public AllChars() {
    }

    public AllChars(String nome, float peso, int idade,
                    String sexo, int vitality, int resistance,
                    int strength, int dexterity, int intelligence, int level) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.vitality = vitality;
        this.resistance = resistance;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.level = level;
    }


    //METODOS
    public void caminhar() throws InterruptedException {
        System.out.println("     ██     \n" +
                "  ▄▀█▄▄▄     \n" +
                "▄▀  █▄▄     \n" +
                " ▄▄▄▀  ▀▄   \n" +
                " ▀       ▀▀");
        Thread.sleep(2000);
        System.out.println("               ██     \n" +
                "            ▄▀█▄▄▄     \n" +
                "          ▄▀  █▄▄     \n" +
                "           ▄▄▄▀  ▀▄   \n" +
                "           ▀       ▀▀");
        Thread.sleep(2000);
        System.out.println("                          ██     \n" +
                "                       ▄▀█▄▄▄     \n" +
                "                     ▄▀  █▄▄     \n" +
                "                      ▄▄▄▀  ▀▄   \n" +
                "                      ▀       ▀▀");
        Thread.sleep(3000);
        System.out.println("                                     ██     \n" +
                "                                  ▄▀█▄▄▄     \n" +
                "                                ▄▀  █▄▄     \n" +
                "                                 ▄▄▄▀  ▀▄   \n" +
                "                                 ▀       ▀▀");

    }

    public String senioridade() {
        if (getIdade() >= 18 && getIdade() < 50) {
            return "jovem";
        } else if (getIdade() > 50) {
            return "senhor";
        } else if (getIdade() < 18 && getIdade() > 0) {
            return "pequeno";
        }
        return null;
    }

    //SIMULAÇÃO BATALHA
    public void batalhar() throws InterruptedException {
        // Obtém a vida do inimigo e seu poder de ataque
        var inimigo = new Inimigos();
        double vidaInimigo = inimigo.vida();
        var audioDamage = new AudioDamage();
        var audioGameOver = new AudioGameOver();
        var audioGanhou = new AudioGameOver();
        boolean usouAPesado = false;
        boolean defendeu = false;
        var audioDaBatalha = new AudioDaBatalha();
        Executors.newSingleThreadExecutor().execute(audioDaBatalha);
        // Loop que representa a batalha enquanto a vida do inimigo e a vida restante do jogador são maiores que zero
        while (vidaInimigo > 0 && vidaRestante > 0) {
            double ataqueInimigo = inimigo.atacar();
            // Exibe as opções de luta
            opcoesLuta(vidaRestante);
            System.out.println("DIGITE A OPÇÃO DESEJADA\n");
            switch (leia.nextInt()) {
                case 1:
                    // Caso o jogador escolha atacar
                    if (vidaRestante > 0) {
                        // Reduz a vida do inimigo com um ataque
                        vidaInimigo -= atacar();
                        System.out.printf("Você deu "+Cores.TEXT_RED_BOLD +"%.2f "+Cores.TEXT_RESET+" de dano e deixou o inimigo com "+Cores.TEXT_RED_BOLD +"%.2f "+Cores.TEXT_RESET+" de vida\n", atacar(), vidaInimigo);
                        Executors.newSingleThreadExecutor().execute(audioDamage);
                        System.out.println("o==[]:::::::::>");
                        // Verifica se o inimigo ainda está vivo
                        if (vidaInimigo > 0) {
                            System.out.println(" AGORA É O TURNO DO INIMIGO: \n");
                            // Reduz a vida do jogador com o ataque do inimigo
                            vidaRestante -= ataqueInimigo;
                            // Verifica se o jogador morreu
                            if (!(vidaRestante > 0)) {
                                System.out.printf(" O inimigo te deu "+Cores.TEXT_RED_BOLD +"%.2f "+Cores.TEXT_RESET+"de dano e você morreu!\n", ataqueInimigo);
                                Executors.newSingleThreadExecutor().execute(audioGameOver);
                                System.out.println("───────▄▄▄▄▄▄▄────────\n" +
                                                   "─────▄█████████▄──────\n" +
                                                   "─────██─▀███▀─██──────\n" +
                                                   "     ▀████▀████▀──────\n" +
                                                   "───────██▀█▀██────────\n");

                                break;
                            }
                            // Aguarda um tempo (simulação de ação)
                            Thread.sleep(2000);
                            audioDamage.stopMusic();
                            System.out.printf(" O inimigo te deu"+Cores.TEXT_RED_BOLD +" %.2f"+Cores.TEXT_RESET+" de dano e você está com" +Cores.TEXT_RED_BOLD +" %.2f"+Cores.TEXT_RESET+" de vida"+Cores.TEXT_RESET, ataqueInimigo, vidaRestante);
                            audioDamage.run();
                        } else {
                            System.out.println(" Você matou o inimigo e ganhou o jogo!");
                            Executors.newSingleThreadExecutor().execute(audioGanhou);
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
                                System.out.printf(Cores.TEXT_GREEN_BOLD_BRIGHT + "Você  agora tem %.2f de vida\n" + Cores.TEXT_RESET, vidaRestante);
                                System.out.println("         \n" +
                                        "  ▄▀▀█▀▀▄\n" +
                                        " ▐▌     ▐▌\n" +
                                        " ▐█▄   ▄█▌\n" +
                                        "  ▀██▄██▀\n");
                                System.out.println(" AGORA É O TURNO DO INIMIGO: \n");
                                // Reduz a vida do jogador com o ataque do inimigo
                                vidaRestante -= ataqueInimigo;
                                audioDamage.stopMusic();
                                Thread.sleep(2000);
                                System.out.printf(" O inimigo te deu %.2f de dano e você está com %.2f de vida", ataqueInimigo, vidaRestante);
                                audioDamage.run();
                            } else {
                                System.out.println("O inimigo ja esta morto");
                            }
                        } else {
                            System.out.println("Você morreu!");
                        }
                        defendeu = true;
                    } else {
                        System.out.println("Você ja se defendeu nesta batalha!");
                    }
                    break;
                case 3:
                    // Caso o jogador escolha ataque pesado
                    if (!usouAPesado) {
                        // Reduz a vida do inimigo com um ataque pesado
                        audioDamage.stopMusic();
                        vidaInimigo -= usarAtaqueEspecial();
                        System.out.printf("Você deu "+Cores.TEXT_RED_BOLD +"%.2f "+Cores.TEXT_RESET+" de dano e deixou o inimigo com "+Cores.TEXT_RED_BOLD +"%.2f "+Cores.TEXT_RESET+" de vida\n", usarAtaqueEspecial(), vidaInimigo);
                        System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + ataqueEspecial + Cores.TEXT_RESET);
                        audioDamage.run();
                        if (vidaRestante > 0) {
                            if (vidaInimigo > 0) {
                                System.out.println(" AGORA É O TURNO DO INIMIGO: \n");
                                vidaRestante -= ataqueInimigo;
                                // Verifica se o jogador morreu
                                if (!(vidaRestante > 0)) {
                                    audioGameOver.stopMusic();
                                    audioGameOver.run();
                                    System.out.printf(" O inimigo te deu "+Cores.TEXT_RED_BOLD +"%.2f "+Cores.TEXT_RESET+"de dano e você morreu!\n", ataqueInimigo);
                                    System.out.println("───────▄▄▄▄▄▄▄────────\n" +
                                                       "─────▄█████████▄──────\n" +
                                                       "─────██─▀███▀─██──────\n" +
                                                       "     ▀████▀████▀──────\n" +
                                                       "───────██▀█▀██────────\n");
                                    break;
                                }
                                // Aguarda um tempo (simulação de ação)
                                audioDamage.stopMusic();
                                Thread.sleep(2000);
                                System.out.printf(" O inimigo te deu"+Cores.TEXT_RED_BOLD +" %.2f"+Cores.TEXT_RESET+" de dano e você está com" +Cores.TEXT_GREEN_BOLD +" %.2f"+Cores.TEXT_RESET+" de vida"+Cores.TEXT_RESET, ataqueInimigo, vidaRestante);
                                audioDamage.run();
                            } else {
                                audioGanhou.stopMusic();
                                audioGanhou.run();
                                System.out.println(" Você matou o inimigo e ganhou o jogo!");
                            }
                        } else {
                            System.out.println(Cores.TEXT_RED_BOLD + " Você morreu!" + Cores.TEXT_RESET);
                        }
                        usouAPesado = true;
                    } else {
                        System.out.println("Você não pode mais usar o "+ataqueEspecial);
                    }
                    break;
            }
        }

        audioDaBatalha.stopMusic();
    }

    //ATAQUE ESPECIAL DAS CLASSES
    protected abstract double usarAtaqueEspecial();


    //MENU DURANTE A LUTA
    public void opcoesLuta(double vida) {
        System.out.printf("\n\n\n┌┌──────────────────┬───────────────┐┐\n" +
                "││                  │      VIDA     ││\n" +
                "││    1-ATAQUE      │     %.2f    ││\n" +
                "││                  │               ││\n" +
                "├│──────────────────┼───────────────│┤\n" +
                "││                  │               ││\n" +
                "││     2-DEFESA     │    3-%s     ││\n" +
                "││                  │               ││\n" +
                "└┘──────────────────┴───────────────┘┘\n", vida, ataqueEspecial);
    }

    //HISTÓRIA RPG
    public void scriptPersonagens() throws InterruptedException {

        contagemBatalha();
        String nomeMaisculo = this.getNome().toUpperCase();
        var audioFala = new AudioFala();

        Thread.sleep(1500);
        musicaNpc.start();
        System.out.print(Cores.ANSI_BLACK_BACKGROUND + "     █ ▄▀█  █▀▄ █     \n" + Cores.TEXT_RESET);
        Thread.sleep(500);
        System.out.print(Cores.ANSI_BLACK_BACKGROUND + "    ▐▌          ▐▌    \n" + Cores.TEXT_RESET);
        Thread.sleep(500);
        System.out.print(Cores.ANSI_BLACK_BACKGROUND + "    █▌▀▄  ▄▄  ▄▀▐█    \n" + Cores.TEXT_RESET);
        Thread.sleep(500);
        System.out.print(Cores.ANSI_BLACK_BACKGROUND + "   ▐██  ▀▀  ▀▀  ██▌   \n" + Cores.TEXT_RESET);
        Thread.sleep(500);
        System.out.print(Cores.ANSI_BLACK_BACKGROUND + "  ▄████▄  ▐▌  ▄████▄  \n\n\n" + Cores.TEXT_RESET);
        Thread.sleep(500);
        Executors.newSingleThreadExecutor().execute(audioFala);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW_BOLD + "OLÁ " + nomeMaisculo + " O QUE FAZ SÓ, PELAS RUAS DE LOTHRIC?");
        Thread.sleep(4000);
        audioFala.stopMusic();
        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_GREEN_BOLD + nomeMaisculo + " :QUEM É VOCÊ E COMO SABE O MEU NOME ???!!!!");
        Thread.sleep(4000);
        audioFala.run();
        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW_BOLD + "Isso não importa HAHAHAHA! Sou apenas um desconhecido, com uma missão para pessoas corajosas!!");
        Thread.sleep(6000);
        audioFala.stopMusic();
        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_GREEN_BOLD + nomeMaisculo + " :HMMM...Acredito ser a pessoa certa! O que devo fazer e o que ganharei com isso?");
        Thread.sleep(6000);
        audioFala.run();
        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW_BOLD + "Uma pessoa verdadeiramente corajosa se provará apenas pela honra e não por dinheiro!");
        Thread.sleep(3000);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW_BOLD + "Deverá investigar o castelo abandonado de ANOR LONDO e torcer para sair vivo! HAHAHA\n\n");
        Thread.sleep(3000);
        audioFala.stopMusic();
        System.out.print(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_RED_BOLD + "     █ ▄▀█  █▀▄ █      \n");
        Thread.sleep(500);
        audioFala.run();
        System.out.print("    ▐▌          ▐▌    \n");
        Thread.sleep(500);
        System.out.print("    █▌   ▄▀▀▄   ▐█    \n");
        Thread.sleep(500);
        System.out.print("   ▐██  ▀    ▀  ██▌   \n");
        Thread.sleep(500);
        System.out.print("  ▄████▄  ▐▌  ▄████▄  \n ...............ACEITE!\n" + Cores.TEXT_RESET);
        Thread.sleep(6000);
        audioFala.stopMusic();
        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_GREEN_BOLD + this.getNome().toUpperCase() + " :OK! OK! CALMA! Eu aceito senhor desconhecido. Irei provar o meu valor!!!" + Cores.TEXT_RESET);
        Thread.sleep(4000);


        System.out.println("\n\n\n         █▄██▄█                  █▄██▄█\n" +
                           "█▄█▄█▄█▄█▐█┼██▌█▄█▄█▄█▄██▄█▄█▄█▄█▐█┼██▌█▄█▄█▄█▄█\n" +
                           "███┼█████▐████▌█████┼██████┼█████▐████▌███┼█████\n" +
                           "█████████▐████▌██████████████████▐████▌█████████" +
                           "\nA aventura do "+classe +" "+ this.getNome() + " começou de forma tranquila" +
                           " após aceitar o contrato do desconhecido!\n");
        caminhar();
        Thread.sleep(5000);
        System.out.println("Após caminhar por um tempo pelos muros do castelo " + this.getNome() + " finalmente " +
                           "encontra uma brecha pelos portões do castelo\n");

        System.out.println("          █▄█▄█▄█▄█           \n" +
                           "█▄█▄█▄█▄█▐████▌████▌█▄█▄█▄█▄█ \n" +
                           "███┼█████┼┼┼┼┼┼┼┼┼┼ █████┼███ \n" +
                           "█████████┼┼┼┼┼┼┼  ┼ █████████ \n" +
                           "█████████┼┼┼┼┼┼   ┼ █████████ \n");
        Thread.sleep(4000);
        System.out.println("Após ser engolido pela escuridão que o ambiente proporcionava," +
                           " o " + senioridade() + " de " + this.getIdade() + " anos sente uma" +
                           " energia estranha, quando se vira......");
        Thread.sleep(6000);

    }

    //ENTRADA USUÁRIO
    public void inputPersonagens(){
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

    public void contagemBatalha(){
        List<String> numContagem = Arrays.asList("um...","dois...","três...");

        List<String> contagem = numContagem.stream()
                .map(String::toUpperCase)
                .toList();
        contagem.forEach(System.out::println);

    }

    //SONS
    Thread musicaNpc = new Thread(() -> {
        try {
            // Carrega o arquivo de áudio como um recurso da classe pai AllChars
            InputStream inputStream = AllChars.class.getResourceAsStream("/recursos/fallenDown.wav");

            if (inputStream != null) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);

                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

                // Define o novo valor de ganho (volume) em decibéis (dB)
                float novoVolumeEmDecibeis = -20.0f; // Ajuste este valor conforme necessário

                gainControl.setValue(novoVolumeEmDecibeis);

                clip.start();

                Thread.sleep(57000);

                clip.stop();
                clip.close();
            } else {
                System.out.println("Arquivo de áudio não encontrado.");
            }
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    });


    //GET AND SET
    public void setAtaqueEspecial(String ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
