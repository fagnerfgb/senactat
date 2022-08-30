package main;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	public void play() {
		// carregar o arquivo de audio
		File file = new File("som/laser1.wav");
		// tratamento de excecoes
		try {
			// relacionado ao hardware de audio do sistema
			AudioInputStream audio = AudioSystem.getAudioInputStream(file);
			// controle do audio (reproducao, pausa, avanco, etc)
			Clip clip = AudioSystem.getClip();
			clip.open(audio);
			clip.start();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
