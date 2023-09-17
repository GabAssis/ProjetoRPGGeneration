package Jogaveis;

import Inimigos.Nivel;

import java.util.Scanner;

public class Main {

    public static Scanner leia = new Scanner(System.in);


    public static void main(String[] args) throws InterruptedException {


        //JOGAR OU JOGAR NOVAMENTE
        while (true) {
            classeMenu();
            playRpg();
            System.out.println("Deseja jogar novamente? (S/N)");
            String opcao = leia.nextLine();
            if (opcao.equalsIgnoreCase("s")) {
                continue;
            } else if (opcao.equalsIgnoreCase("n")) {
                System.out.println("Seu jogo foi encerrado!");
                break;
            } else {
                System.out.println("DIGITE NOVAMENTE A OPÇÃO!");
                continue;
            }
        }
    }

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
                nivel.gerarListaInimigos();
                cavaleiro.batalhaCavaleiro();

            }
            case 2 -> {
                // Configuração do personagem Piromante e início da batalha
                piromante1.inputPiromante();
                piromante1.scriptPiromante();
                nivel.gerarListaInimigos();
                piromante1.batalhaPiromante();
            }
            case 3 -> {
                // Configuração do personagem Ladrão e início da batalha
                ladrao1.inputLadrao();
                ladrao1.scriptLadrao();
                nivel.gerarListaInimigos();
                ladrao1.batalhaLadrao();
            }
            case 4 -> {
                // Configuração do personagem Mago e início da batalha
                mago1.inputMago();
                mago1.scriptMago();
                nivel.gerarListaInimigos();
                mago1.batalhaMago();
            }
            default -> {
                System.out.println("OPÇÃO NÃO EXISTENTE");

            }
        }
    }

}