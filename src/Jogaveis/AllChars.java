package Jogaveis;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import Cores.Cores;
import Inimigos.Inimigos;

public abstract class AllChars implements Skills{

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

    //CONSTRUCTOR
    public AllChars(){}

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
        }else if (getIdade() < 18 && getIdade() > 0){
            return "pequeno";
        }
        return null;
    }


    public void batalhar() throws InterruptedException {
        // Obtém a vida do inimigo e seu poder de ataque
        var inimigo = new Inimigos();
        double vidaInimigo = inimigo.vida();
        double ataqueInimigo = inimigo.atacar();
        boolean usouAPesado = false;
        boolean defendeu = false;
        var audioBatalha = new AudioDaBatalha();
        audioBatalha.start();
        // Loop que representa a batalha enquanto a vida do inimigo e a vida restante do jogador são maiores que zero
        while (vidaInimigo > 0 && vidaRestante > 0) {
            // Exibe as opções de luta
            opcoesLuta(vidaRestante);
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
                            vidaRestante -= ataqueInimigo;
                            // Verifica se o jogador morreu
                            if (!(vidaRestante > 0)) {
                                System.out.printf(" O inimigo te deu %.2f de dano e você morreu!", ataqueInimigo);
                                break;
                            }
                            // Aguarda um tempo (simulação de ação)
                            Thread.sleep(2000);
                            System.out.printf(" O inimigo te deu %.2f de dano e você está com %.2f de vida",ataqueInimigo , vidaRestante);
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
                                vidaRestante -= ataqueInimigo;
                                Thread.sleep(2000);
                                System.out.printf(" O inimigo te deu %.2f de dano e você está com %.2f de vida", ataqueInimigo, vidaRestante);
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
                    // Caso o jogador escolha ataque pesado
                    if (!usouAPesado) {
                        // Reduz a vida do inimigo com um ataque pesado
                        vidaInimigo -= usarAtaqueEspecial();
                        System.out.printf("Você deu %.2f de dano pesado e deixou o inimigo com %.2f de vida\n", usarAtaqueEspecial(), vidaInimigo);
                        System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + ataqueEspecial +  Cores.TEXT_RESET);
                        if(vidaRestante > 0) {
                            if (vidaInimigo > 0) {
                                System.out.println(" AGORA É O TURNO DO INIMIGO: \n");
                                vidaRestante -= ataqueInimigo;
                                // Verifica se o jogador morreu
                                if(!(vidaRestante>0)){
                                    System.out.printf(Cores.TEXT_RED_BOLD+" O inimigo te deu %.2f de dano e você morreu!\n"+Cores.TEXT_RESET,ataqueInimigo);
                                    System.out.println("───────▄▄▄▄▄▄▄────────\n" +
                                                       "─────▄█████████▄──────\n" +
                                                       "─────██─▀███▀─██──────\n" +
                                                       "     ▀████▀████▀──────\n" +
                                                       "───────██▀█▀██────────\n");
                                    break;
                                }
                                // Aguarda um tempo (simulação de ação)
                                Thread.sleep(2000);
                                System.out.printf(" O inimigo te deu %.2f de dano e você está com %.2f de vida", ataqueInimigo, vidaRestante);
                            } else {
                                System.out.println(" Você matou o inimigo e ganhou o jogo!");
                            }
                        }else{
                            System.out.println(Cores.TEXT_RED_BOLD+" Você morreu!"+Cores.TEXT_RESET);
                        }
                        usouAPesado = true;
                    }else{
                        System.out.println("Você não pode mais usar o ataque pesado!");
                    }
                    break;
            }
        }
        audioBatalha.isRunningGame = false;
    }

    protected abstract double usarAtaqueEspecial();


    //SONS
    Thread musicaNpc = new Thread(() -> {
        try {
            // Carrega o arquivo de áudio como um recurso da classe pai AllChars
            InputStream inputStream = AllChars.class.getResourceAsStream("/recursos/spooktune.wav");

            if (inputStream != null) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);

                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

                // Define o novo valor de ganho (volume) em decibéis (dB)
                float novoVolumeEmDecibeis = -20.0f; // Ajuste este valor conforme necessário

                gainControl.setValue(novoVolumeEmDecibeis);

                clip.start();

                Thread.sleep(35000);

                clip.stop();
                clip.close();
            } else {
                System.out.println("Arquivo de áudio não encontrado.");
            }
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    });

    Thread falando = new Thread(() -> {
        try {
            File arquivoDeAudio = new File("C:\\Users\\Administrator\\Documents\\Projeto RPG\\RPG\\src\\recursos\\fala.wav"); // Substitua pelo caminho da sua música de fundo
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(arquivoDeAudio);
            Clip clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.start();

            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            // Define o novo valor de ganho (volume) em decibéis (dB)
            float novoVolumeEmDecibeis = -15.0f; // Ajuste este valor conforme necessário

            gainControl.setValue(novoVolumeEmDecibeis);

            // Você pode adicionar um atraso para controlar a duração do alerta sonoro
            Thread.sleep(35000); //

            clip.close();

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    });


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

    //GET AND SET


    public void setAtaqueEspecial(String ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
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
