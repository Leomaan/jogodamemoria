package br.com.leoman.jogodamemoria;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;


public class JogoDaMemoria extends ApplicationAdapter {
	SpriteBatch batch;
	Stage stage;
	BitmapFont fimDeJogoTexto;

	@Override
	public void create () { //Objetos que precisamos interagir durante o jogo
		batch = new SpriteBatch();
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		criarCarta();
		//fimDeJogoTexto = criarTexto(20, Color.RED);
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
		stage.draw();
	}

	@Override
	public void dispose () {  //Liberando memoria
		batch.dispose();
	}

	private void criarCarta() {
		ArrayList<Integer>numeroCartas = new ArrayList<Integer>();
		for(int i = 1;i<=6;i++){
			numeroCartas.add(i);
			numeroCartas.add(i);
		}

		for(int i = 1, x = 50; i<=6; i++, x+=210){
			Carta carta = new Carta(i, x, Gdx.graphics.getHeight()-300);
			stage.addActor(carta);
		}
		for(int i = 1, x = 50; i<=6; i++, x+=210){
			Carta carta = new Carta(i, x, Gdx.graphics.getHeight()-650);
			stage.addActor(carta);
		}

	}
}
