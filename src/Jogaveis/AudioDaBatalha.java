package Jogaveis;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class AudioDaBatalha extends Thread {

    private InputStream inputStream;
    private AudioInputStream audioInputStream;
    private Clip clip;
    public boolean isRunningGame = true;

    public void run() {
        try {
            carregarArquivo();
            if (inputStream != null) {
                extrairClip();
                clip.open(audioInputStream);
                abaixandoVolume();
                clip.start();
                while (true) {
                    if(!isRunningGame) {
                        clip.stop();
                        clip.close();
                     return;
                    }
                }
            } else {
                System.out.println("Arquivo de áudio não encontrado.");
            }
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }


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
