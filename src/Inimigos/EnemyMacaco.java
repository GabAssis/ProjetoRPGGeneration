package Inimigos;


public class EnemyMacaco extends Inimigos {

    //CONSTRUCTOR
    public EnemyMacaco() {
        super("Macaco");
    }

    public void drawMacaco(){
        System.out.println("\n\n\n\n\nUM MACACO O ATACA!\n" +
                           "───▄██▄─────────────▄▄\n" +
                           "──█████▄▄▄▄───────▄▀\n" +
                           "────▀██▀▀████▄───▄▀\n" +
                           "───▄█▀▄██▄████▄─▄█\n" +
                           "▄▄█▀▄▄█─▀████▀██▀\n");

    }

}
