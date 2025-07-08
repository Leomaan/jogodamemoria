package br.com.leoman.jogodamemoria.Decorator;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface CartaDecorator {
    void executar();
    void draw(Batch batch, float delta);
}