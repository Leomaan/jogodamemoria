package br.com.leoman.jogodamemoria.Telas;

import br.com.leoman.jogodamemoria.JogoDaMemoria;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
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

        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        Texture texturaVenceu = new Texture(Gdx.files.internal("assets/tituloVenceu.png"));
        Image imagemVenceu = new Image(texturaVenceu);

        Texture texturaPerdeu = new Texture(Gdx.files.internal("assets/tituloPerdeu.png"));
        Image imagemPerdeu = new Image(texturaPerdeu);




        if (venceu) {
            table.add(imagemVenceu).width(633).height(394).padBottom(100).row();
        } else {
            table.add(imagemPerdeu).width(633).height(394).padBottom(100).row();
        }

        TextButton botaoReiniciar = new TextButton("Voltar ao Menu", skin);

        table.add(botaoReiniciar).width(150).height(80).pad(20).row();
        botaoReiniciar.setColor(0.8588f, 0.8196f, 0.3215f, 1f);

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
        Gdx.gl.glClearColor(0.8588f, 0.8196f, 0.3215f, 1f);
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