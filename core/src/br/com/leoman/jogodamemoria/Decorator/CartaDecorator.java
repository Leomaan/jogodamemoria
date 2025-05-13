package br.com.leoman.jogodamemoria.Decorator;

import br.com.leoman.jogodamemoria.Carta;
import com.badlogic.gdx.graphics.g2d.Batch;

public class CartaDecorator {
    protected Carta carta;

    public CartaDecorator(Carta carta) {
        this.carta = carta;
    }
    public void draw(Batch batch, float delta) {
        carta.draw(batch, delta);
    }

    public void tocarSom() {

    }

    public void animar() {

    }
}
