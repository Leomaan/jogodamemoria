package br.com.leoman.jogodamemoria;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Jogo da Memoria");
		config.setWindowedMode(1600, 900);
		config.setResizable(false);
		new Lwjgl3Application(new JogoDaMemoria(), config);

	}
}