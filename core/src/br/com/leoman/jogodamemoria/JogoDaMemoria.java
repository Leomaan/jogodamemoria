package br.com.leoman.jogodamemoria;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;



public class JogoDaMemoria extends ApplicationAdapter {
	SpriteBatch batch;
	Stage stage;
	BitmapFont fimDeJogoTexto;

	@Override
	public void create () { //Objetos que precisamos interagir durante o jogo
		batch = new SpriteBatch();
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		fimDeJogoTexto = criarTexto(1, Color.RED);
	}

	private BitmapFont criarTexto(int tamanho, Color cor) {
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
	public void render () {  //Vendo e aplicando as mudanças
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.end();
	}

	@Override
	public void dispose () {  //Liberando memoria
		batch.dispose();
	}
}
