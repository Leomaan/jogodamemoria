package br.com.leoman.jogodamemoria;

import Telas.MenuScreen;
import com.badlogic.gdx.Game;

public class JogoDaMemoria extends Game {
	@Override
	public void create() {
		setScreen(new MenuScreen(this));
	}
}
