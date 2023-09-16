package Inimigos;

public class EnemyAranha extends Inimigos {


    public EnemyAranha() {
        super("Aranha");
    }


    public void drawAranha() {
        System.out.println("\n\n\n\n\nUMA ARANHA O ATACA\n" +
                           "──▄──▄────▄▀\n" +
                           "───▀▄─█─▄▀▄▄▄\n" +
                           "▄██▄████▄██▄▀█▄\n" +
                           "─▀▀─█▀█▀▄▀███▀\n" +
                           "──▄▄▀─█──▀▄▄\n");
    }

}