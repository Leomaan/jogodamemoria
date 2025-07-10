package br.com.leoman.jogodamemoria.Telas;

import br.com.leoman.jogodamemoria.DesignPatterns.AbstractFactory.Nivel;
import br.com.leoman.jogodamemoria.JogoDaMemoria;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;



public class MenuScreen implements Screen {
    private final JogoDaMemoria game;
    private final Stage stage;

    public MenuScreen(JogoDaMemoria game) {
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        Texture texturaLetreiro = new Texture(Gdx.files.internal("assets/titulo.png"));
        Image imagemLetreiro = new Image(texturaLetreiro);

        table.add(imagemLetreiro).width(633).height(394).padBottom(100).row();

        TextButton buttonJogar = new TextButton("Jogar", skin);
        TextButton buttonSair = new TextButton("Sair", skin);

        table.add(buttonJogar).width(100).height(50).pad(10).row();
        buttonJogar.setColor(0.8588f, 0.8196f, 0.3215f, 1f);
        table.add(buttonSair).width(100).height(50).pad(10).row();
        buttonSair.setColor(0.8588f, 0.8196f, 0.3215f, 1f);

        buttonJogar.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new JogoScreen(game, Nivel.FACIL));
            }
        });

        buttonSair.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
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

    @Override
    public void resize(int i, int i1) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }
}