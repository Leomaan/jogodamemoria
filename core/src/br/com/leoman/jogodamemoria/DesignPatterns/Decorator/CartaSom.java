package br.com.leoman.jogodamemoria.DesignPatterns.Decorator;

import br.com.leoman.jogodamemoria.Carta;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class CartaSom implements CartaDecorator{

    private Sound som;
    private Carta carta;

    public CartaSom(Carta carta) {
        this.carta = carta;
    }

    @Override
    public void executar() {
        som = Gdx.audio.newSound(Gdx.files.internal("flip.wav"));
        som.play();
    }
}