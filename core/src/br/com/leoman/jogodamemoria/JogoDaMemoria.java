package br.com.leoman.jogodamemoria;

import br.com.leoman.jogodamemoria.Cronometro.Cronometro;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import java.util.ArrayList;
import java.util.Collections;

public class JogoDaMemoria extends Game {
	SpriteBatch batch;
	Stage stage;
	BitmapFont fonteTexto;
	ArrayList<Carta> cartasViradas;
	ArrayList<Carta> cartasIguais;
	ArrayList<Carta> cartasDiferentes;
	float tempoVirada = 0.5f;
	float contador = 0f;
	Cronometro cronometro;

	@Override
	public void create () {
		batch = new SpriteBatch();
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		fonteTexto = criarTexto(32, Color.RED);
		cronometro = new Cronometro(10f, fonteTexto);
		cartasViradas = new ArrayList<Carta>();
		cartasIguais = new ArrayList<Carta>();
		criarCartas();
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
	public void render () {
		ScreenUtils.clear(0.8f, 0.8f, 0.8f, 0.8f);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		delayCarta();
		removerCartasIguais();
		compararCartas(cartasViradas);
		cronometro.atualizar(Gdx.graphics.getDeltaTime());
		cronometro.desenhar(batch);
		batch.begin();
		batch.end();
	}

	private void reiniciarJogo() {
		stage.clear();
		cartasViradas.clear();
		cartasIguais.clear();
		cronometro.reiniciar();
		criarCartas();
	}


	@Override
	public void dispose () {
		batch.dispose();
		stage.dispose();
	}

	private void criarCartas() {
		ArrayList<Integer> numCartas = new ArrayList<Integer>();
		for (int i = 1; i <= 6; i++) {
			numCartas.add(i);
			numCartas.add(i);
		}
		Collections.shuffle(numCartas);
		for (int i = 0, x = 50; i < 6; i++, x += 210) {
			Carta carta = new Carta(numCartas.get(i), x, Gdx.graphics.getHeight() - 300,this);
			stage.addActor(carta);
		}
		for (int i = 6, x = 50; i < 12; i++, x += 210) {
			Carta carta = new Carta(numCartas.get(i), x, Gdx.graphics.getHeight() - 650,this);
			stage.addActor(carta);
		}
	}
	public void virarCartas(){
		for(Actor actor : stage.getActors()){
			if(actor instanceof Carta){
				((Carta) actor).virada = false;
			}
			cartasViradas.clear();
		}
	}
	private void removerCartasIguais(){
		if(contador <= 0){
			for(Carta carta : cartasIguais){
				stage.getActors().removeValue(carta, true);
			}
			cartasIguais.clear();
		}
	}
	private void compararCartas(ArrayList<Carta> cartasViradas) {
		if(cartasViradas.size() == 2){
			Carta carta1 = cartasViradas.get(0);
			Carta carta2 = cartasViradas.get(1);
			if(carta1.texturaFrente.toString().contentEquals(carta2.texturaFrente.toString()) && carta1 != carta2) {
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
}

