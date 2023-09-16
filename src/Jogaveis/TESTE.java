package Jogaveis;


import Inimigos.Nivel;


import java.util.Scanner;

public class TESTE {

    public static Scanner leia = new Scanner(System.in);


    public static void main(String[] args) throws InterruptedException {



        ClasseCavaleiro cavaleiro = new ClasseCavaleiro();
        ClassePiromante piromante1 = new ClassePiromante();
        ClasseLadrao ladrao1 = new ClasseLadrao();
        ClasseMago mago1 = new ClasseMago();

        Nivel nivel = new Nivel();

        System.out.println("Digite qual classe deseja escolher:");
        System.out.println("1 - Cavaleiro");
        System.out.println("2 - Piromante");
        System.out.println("3 - Ladrão");
        System.out.println("4 - Mago");
        int escolha = leia.nextInt();
        switch (escolha) {
            case 1 -> {
                cavaleiro.inputCavaleiro();
                cavaleiro.scriptCavaleiro();
                nivel.gerarListaInimigos();
                cavaleiro.batalhaCavaleiro();

            }
            case 2 -> {
                piromante1.inputPiromante();
                piromante1.scriptPiromante();
                nivel.gerarListaInimigos();
                piromante1.batalhaPiromante();
            }
            case 3 -> {
                ladrao1.inputLadrao();
                ladrao1.scriptLadrao();
                nivel.gerarListaInimigos();
                ladrao1.batalhaLadrao();
            }
            case 4 -> {
                mago1.inputMago();
                mago1.scriptMago();
                nivel.gerarListaInimigos();
                mago1.batalhaMago();
            }
            default -> throw new IllegalStateException("Valor não esperado: " + leia.nextInt());
        }

    }

}