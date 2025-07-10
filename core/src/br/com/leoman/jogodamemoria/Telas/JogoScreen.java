package br.com.leoman.jogodamemoria.Telas;

import br.com.leoman.jogodamemoria.*;
import br.com.leoman.jogodamemoria.DesignPatterns.AbstractFactory.Factory;
import br.com.leoman.jogodamemoria.DesignPatterns.AbstractFactory.Nivel;
import br.com.leoman.jogodamemoria.DesignPatterns.AbstractFactory.NivelFactory;
import br.com.leoman.jogodamemoria.Utils.Cronometro;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import java.util.ArrayList;

public class JogoScreen implements Screen {
    private final JogoDaMemoria game;
    SpriteBatch batch;
    Stage stage;
    BitmapFont fonteTexto;
    public ArrayList<Carta> cartasViradas;
    ArrayList<Carta> cartasIguais;
    float tempoVirada = 0.5f;
    float contador = 0f;
    Cronometro cronometro;
    private Nivel nivel;
    private NivelFactory factory;

    public JogoScreen(JogoDaMemoria game, Nivel nivel) {
        this.game = game;
        this.nivel = nivel;
        this.factory = Factory.criarFactory(nivel);
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        fonteTexto = criarTexto(32, Color.RED);
        cronometro = factory.criarCronometro(fonteTexto);

        cartasViradas = new ArrayList<>();
        cartasIguais = new ArrayList<>();

        ArrayList<Carta> cartas = factory.criarCartas(this);
        for (Carta carta : cartas) {
            stage.addActor(carta);
        }
    }

    public BitmapFont criarTexto(int tamanho, Color cor) {
        BitmapFont fonte;
        FreeTypeFontGenerator gerador = new FreeTypeFontGenerator(Gdx.files.internal("ARIALBD.TTF"));
        FreeTypeFontGenerator.FreeTypeFontParameter parametros = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parametros.color = cor;
        parametros.size = tamanho;
        fonte = gerador.generateFont(parametros);
        gerador.dispose();
        return fonte;
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.8588f, 0.8196f, 0.3215f, 1f);

        stage.act(delta);
        stage.draw();
        delayCarta();
        removerCartasIguais();
        compararCartas(cartasViradas);
        cronometro.atualizar(delta);
        cronometro.desenhar(batch);

        batch.begin();
        batch.end();

        if (stage.getActors().size == 0 && !cronometro.isTempoEsgotado()) {
            Nivel proximo = getProximoNivel(nivel);
            if (proximo != null) {
                game.setScreen(new JogoScreen(game, proximo));
            } else {
                game.setScreen(new FimJogoScreen(game, true));
            }
        }
        if (cronometro.isTempoEsgotado()) {
            game.setScreen(new FimJogoScreen(game, false));
        }
    }

    public void virarCartas() {
        for (Actor actor : stage.getActors()) {
            if (actor instanceof Carta) {
                ((Carta) actor).virada = false;
            }
        }
        cartasViradas.clear();
    }

    private void removerCartasIguais() {
        if (contador <= 0) {
            for (Carta carta : cartasIguais) {
                stage.getActors().removeValue(carta, true);
            }
            cartasIguais.clear();
        }
    }

    private void compararCartas(ArrayList<Carta> cartasViradas) {
        if (cartasViradas.size() == 2) {
            Carta carta1 = cartasViradas.get(0);
            Carta carta2 = cartasViradas.get(1);
            if (carta1.texturaFrente.toString().contentEquals(carta2.texturaFrente.toString()) && carta1 != carta2) {
                cartasIguais.add(carta1);
                cartasIguais.add(carta2);
                contador = tempoVirada;
                cartasViradas.clear();
            }
        }
    }

    private void delayCarta() {
        if (contador > 0) {
            contador -= Gdx.graphics.getDeltaTime();
        }
    }

    private Nivel getProximoNivel(Nivel atual) {
        switch (atual) {
            case FACIL: return Nivel.MEDIO;
            case MEDIO: return Nivel.DIFICIL;
            case DIFICIL: return Nivel.ALEATORIO;
            default: return null;
        }
    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {
        batch.dispose();
        stage.dispose();
    }
}
