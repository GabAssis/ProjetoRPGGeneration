package Jogaveis;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class AudioDaBatalha implements Runnable {

    private InputStream inputStream;
    private AudioInputStream audioInputStream;
    private Clip clip;
    private String name = Thread.currentThread().getName();

    public void run() {

        try {
            carregarArquivo();
            if (inputStream != null) {
                extrairClip();
                clip.open(audioInputStream);
                abaixandoVolume();
                clip.start();
//                System.out.println(name + " INICIANDO AUDIO DA BATALHA");
            } else {
                System.out.println("Arquivo de áudio não encontrado.");
            }
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    public void stopMusic() {
        clip.stop();
        clip.close();
//        System.out.println(name + " PARANDO AUDIO DA BATALHA");
    }

    private void carregarArquivo(){
        this.inputStream = AudioDaBatalha.class.getResourceAsStream("/recursos/game.wav");
    }

    private void abaixandoVolume(){
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        float novoVolumeEmDecibeis = -24.0f; // Ajuste este valor conforme necessário
        gainControl.setValue(novoVolumeEmDecibeis);
    }
    private void extrairClip() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(inputStream);
        clip = AudioSystem.getClip();
    }


}
