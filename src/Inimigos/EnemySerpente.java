package Inimigos;


public class EnemySerpente extends Inimigos {

    public EnemySerpente() {
        super("Serpente");
    }

    public void drawSerpente(){
        System.out.println("\n\n\n\n\nUMA SERPENTE O ATACA!\n" +
                           "▄▄▀█▄───▄───────▄\n" +
                           "▀▀▀██──███─────███\n" +
                           "░▄██▀░█████░░░█████░░\n" +
                           "███▀▄███░███░███░███░▄\n" +
                           "▀█████▀░░░▀███▀░░░▀██▀\n");
    }



}