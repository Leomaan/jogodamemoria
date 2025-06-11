package br.com.leoman.jogodamemoria.Decorator;

import br.com.leoman.jogodamemoria.Carta;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class CartaAnimacao implements CartaDecorator{

    private Carta carta;

    public CartaAnimacao(Carta carta) {
        this.carta = carta;
    }

    @Override
    public void executar() {
        carta.addAction(Actions.sequence(Actions.rotateBy(20f, 0.1f), Actions.rotateBy(-20f, 0.1f)));
    }

    @Override
    public void draw(Batch batch, float delta) {
        carta.draw(batch, delta);

    }
}
