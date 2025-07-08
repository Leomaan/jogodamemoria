package br.com.leoman.jogodamemoria.Cronometro;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

public class Cronometro {
    private float tempoMaximo;
    private float tempoRestante;
    private boolean ativo;
    private BitmapFont fonte;
    private String formatoTempo = "%.2f";
    private Timer.Task task;

    public Cronometro(float tempoMaximo, BitmapFont fonte) {
        this.tempoMaximo = tempoMaximo;
        this.tempoRestante = tempoMaximo;
        this.ativo = true;
        this.fonte = fonte;
    }

    public void atualizar(float deltaTime) {
        if(ativo){
            tempoRestante -= deltaTime;
            if(tempoRestante <= 0){
                tempoRestante = 0.0f;
                ativo = false;
            }
        }
    }

    public void desenhar(SpriteBatch batch) {
        String tempoFormatado = String.format(formatoTempo, tempoRestante);
        batch.begin();
        fonte.draw(batch,tempoFormatado, Gdx.graphics.getWidth() - 100, Gdx.graphics.getHeight() - 15);
        batch.end();
    }

    public boolean isTempoEsgotado() {
        return !ativo;
    }
}