package Jogaveis;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


public abstract class AllChars {

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
            Thread.sleep(35000); // Espera 2 segundos

            clip.close();

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    });

    static Thread audioGame = new Thread(() -> {
        try {
            // Carrega o arquivo de áudio como um recurso da classe pai AllChars
            InputStream inputStream = AllChars.class.getResourceAsStream("/recursos/game.wav");

            if (inputStream != null) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);

                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

                // Define o novo valor de ganho (volume) em decibéis (dB)
                float novoVolumeEmDecibeis = -24.0f; // Ajuste este valor conforme necessário

                gainControl.setValue(novoVolumeEmDecibeis);

                clip.start();

                Thread.sleep(1000000000);

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
