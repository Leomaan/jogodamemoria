package br.com.leoman.jogodamemoria.Decorator;

import br.com.leoman.jogodamemoria.Carta;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class CartaSom extends CartaDecorator {
    private Sound som;

    public CartaSom(Carta carta) {
        super(carta);
        som = Gdx.audio.newSound(Gdx.files.internal("flip.wav"));
    }
    @Override
    public void tocarSom() {
        som.play();
    }
}
