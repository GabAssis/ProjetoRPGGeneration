package Jogaveis;

import Inimigos.Nivel;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static Scanner leia = new Scanner(System.in);

    static boolean musica = true;


    public static void main(String[] args) throws InterruptedException {



        //JOGAR OU JOGAR NOVAMENTE
        while (true) {
            boolean musica = true;
            classeMenu();
            playRpg();
            System.out.println("Deseja jogar novamente? (S/N)");
            String opcao = leia.nextLine();
            if (opcao.equalsIgnoreCase("s")) {
                if(audioGame.isAlive()){
                    audioGame.interrupt();
                }
            } else if (opcao.equalsIgnoreCase("n")) {
                System.out.println("Seu jogo foi encerrado!");
                System.exit(1);
                break;
            } else {
                System.out.println("DIGITE NOVAMENTE A OPÇÃO!");
                continue;
            }
        }
    }

    static Thread audioGame = new Thread(() -> {
        try {
            // Carrega o arquivo de áudio como um recurso da classe pai AllChars
            InputStream inputStream = Main.class.getResourceAsStream("/recursos/game.wav");

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

    //MÉTODO MENU
    public static void classeMenu() {
        System.out.println("┌──────────────────────────────────────┐");
        System.out.println("│  ESCOLHA A CLASSE QUE DESEJA JOGAR   │ ");
        System.out.println("│           1 • CAVALEIRO              │");
        System.out.println("│           2 • PIROMANTE              │");
        System.out.println("│           3 • LADRÃO                 │");
        System.out.println("│           4 • MAGO                   │");
        System.out.println("└──────────────────────────────────────┘");
    }

    public static void playRpg() throws InterruptedException {

        ClasseCavaleiro cavaleiro = new ClasseCavaleiro();
        ClassePiromante piromante1 = new ClassePiromante();
        ClasseLadrao ladrao1 = new ClasseLadrao();
        ClasseMago mago1 = new ClasseMago();
        Nivel nivel = new Nivel();




        int escolha;
        while (true) {
            try {
                System.out.println("DIGITE O NÚMERO DA CLASSE CORRESPONDENTE:");
                escolha = Integer.parseInt(leia.nextLine());
                break;
            } catch (NumberFormatException f) {
                System.out.println("\nOPÇÃO NÃO EXISTENTE!");
            } catch (IllegalStateException j) {
                System.out.println("\nNÚMERO DIGITADO INVÁLIDO! DIGITE NOVAMENTE.");
            }
        }
        switch (escolha) {
            case 1 -> {
                // Configuração do personagem Cavaleiro e início da batalha
                cavaleiro.inputCavaleiro();
                cavaleiro.scriptCavaleiro();
                audioGame.start();
                nivel.gerarListaInimigos();
                cavaleiro.batalhaCavaleiro();
                audioGame.stop();
            }
            case 2 -> {
                // Configuração do personagem Piromante e início da batalha
                piromante1.inputPiromante();
                piromante1.scriptPiromante();
                audioGame.start();
                nivel.gerarListaInimigos();
                piromante1.batalhaPiromante();
                audioGame.stop();
            }
            case 3 -> {
                // Configuração do personagem Ladrão e início da batalha
                ladrao1.inputLadrao();
                ladrao1.scriptLadrao();
                audioGame.start();
                nivel.gerarListaInimigos();
                ladrao1.batalhaLadrao();
                audioGame.stop();
            }
            case 4 -> {
                // Configuração do personagem Mago e início da batalha
                mago1.inputMago();
                mago1.scriptMago();
                audioGame.start();
                nivel.gerarListaInimigos();
                mago1.batalhaMago();
                audioGame.stop();
            }
            default -> {
                System.out.println("OPÇÃO NÃO EXISTENTE");

            }
        }
    }



}