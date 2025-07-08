package br.com.leoman.jogodamemoria.AbstractFactory;

import br.com.leoman.jogodamemoria.Telas.JogoScreen;
import br.com.leoman.jogodamemoria.Carta;
import br.com.leoman.jogodamemoria.Cronometro.Cronometro;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.util.ArrayList;
import java.util.Collections;

public class DificilFactory implements NivelFactory {

    private String caminhoVerso = "assets/versoDificil.png";

    public Cronometro criarCronometro(BitmapFont fonte) {
        return new Cronometro(60f, fonte);
    }

    public ArrayList<Carta> criarCartas(JogoScreen jogo) {
        return criarCartasBase(jogo);
    }

    private ArrayList<Carta> criarCartasBase(JogoScreen jogo) {
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 11; i <= 18; i++) {
            numeros.add(i);
            numeros.add(i);
        }

        Collections.shuffle(numeros);

        ArrayList<Carta> cartas = new ArrayList<>();

        int totalCartas = numeros.size();
        int colunas = 8;
        int linhas = 2;

        float larguraTela = Gdx.graphics.getWidth();
        float alturaTela = Gdx.graphics.getHeight();

        float larguraCarta = 170;
        float alturaCarta = 230;

        float espacamentoX = (larguraTela - (colunas * larguraCarta)) / (colunas + 1);
        float espacamentoY = (alturaTela - (linhas * alturaCarta)) / (linhas + 1);

        for (int i = 0; i < totalCartas; i++) {
            int coluna = i % colunas;
            int linha = i / colunas;

            float x = espacamentoX + coluna * (larguraCarta + espacamentoX);
            float y = alturaTela - ((linha + 1) * (alturaCarta + espacamentoY));

            Carta carta = new Carta(numeros.get(i), caminhoVerso, x, y, jogo);
            carta.setSize(larguraCarta, alturaCarta);
            cartas.add(carta);
        }

        return cartas;
    }
}