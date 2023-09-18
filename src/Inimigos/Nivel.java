package Inimigos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

// CLASSE AUXILIAR
public class Nivel {

    //LISTA INIMIGOS
    private ArrayList<Inimigos> inimigos = new ArrayList<>();

    //MÉTODOS GERAÇÃO DE INIMIGOS
    public void gerarListaInimigos() {
        EnemySerpente serpente1 = new EnemySerpente();
        EnemyEsquilo esquilo1 = new EnemyEsquilo();
        EnemyAranha aranha1 = new EnemyAranha();
        EnemyElefante elefante1 = new EnemyElefante();
        inimigos.addAll(Arrays.asList(serpente1, esquilo1, aranha1,elefante1));
        if (escolhaInimigo().equals(serpente1.getName())) {
            serpente1.drawSerpente();
        } else if (escolhaInimigo().equals(esquilo1.getName())) {
            esquilo1.drawEsquilo();
        } else if (escolhaInimigo().equals(elefante1.getName())) {
            elefante1.drawElefante();
        } else {
            aranha1.drawAranha();
        }

    }

    private String escolhaInimigo() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(inimigos.size());
        Inimigos inimigoAleatorio = inimigos.get(numeroAleatorio);
        return inimigoAleatorio.getName();
    }

}








