package Inimigos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Nivel {

    //Lista
    private ArrayList<Inimigos> inimigos = new ArrayList<>();

    public void gerarListaInimigos(){
            EnemySerpente serpente1 = new EnemySerpente();
            EnemyMacaco macaco1 = new EnemyMacaco();
            EnemyAranha aranha1 = new EnemyAranha();
            inimigos.addAll(Arrays.asList(serpente1,macaco1,aranha1));
            if(escolhaInimigo().equals(serpente1.getName())){
                serpente1.drawSerpente();
            }else if(escolhaInimigo().equals(macaco1.getName())){
                macaco1.drawMacaco();
            }else {
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








