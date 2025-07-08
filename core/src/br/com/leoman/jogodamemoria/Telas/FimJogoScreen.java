package br.com.leoman.jogodamemoria.Telas;

import br.com.leoman.jogodamemoria.JogoDaMemoria;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class FimJogoScreen implements Screen {
    private final JogoDaMemoria game;
    private final boolean venceu;
    private final Stage stage;

    public FimJogoScreen(JogoDaMemoria game, boolean venceu) {
        this.game = game;
        this.venceu = venceu;
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Skin skin = new Skin(Gdx.files.internal("uiskin.json")); // certifique-se que está no assets/

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        String mensagem = venceu ? "Você venceu!" : "Você perdeu!";
        Label labelResultado = new Label(mensagem, skin, "default");
        TextButton botaoReiniciar = new TextButton("Voltar ao Menu", skin);

        table.add(labelResultado).pad(20).row();
        table.add(botaoReiniciar).pad(20).row();

        botaoReiniciar.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MenuScreen(game));
            }
        });
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.9f, 0.9f, 0.9f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {
        stage.dispose();
    }
}