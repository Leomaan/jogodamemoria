package br.com.leoman.jogodamemoria.AbstractFactory;

import br.com.leoman.jogodamemoria.Telas.JogoScreen;
import br.com.leoman.jogodamemoria.Carta;
import br.com.leoman.jogodamemoria.Cronometro.Cronometro;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.util.ArrayList;
import java.util.Collections;

public class MedioFactory implements NivelFactory {
    private String caminhoVerso = "assets/versoMedio.png";

    public Cronometro criarCronometro(BitmapFont fonte) {
        return new Cronometro(25f, fonte);
    }

    public ArrayList<Carta> criarCartas(JogoScreen jogo) {
        return criarCartasBase(jogo);
    }

    private ArrayList<Carta> criarCartasBase(JogoScreen jogo) {
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 5; i <= 6; i++) {
            numeros.add(i);
            numeros.add(i);
        }
        Collections.shuffle(numeros);

        ArrayList<Carta> cartas = new ArrayList<>();

        int totalCartas = numeros.size();
        int colunas = Math.min(6, totalCartas);
        int linhas = (int) Math.ceil((float) totalCartas / colunas);

        float larguraCarta = 190;
        float alturaCarta = 255;

        float larguraTela = Gdx.graphics.getWidth();
        float alturaTela = Gdx.graphics.getHeight();

        float espacamentoX = (larguraTela - colunas * larguraCarta) / (colunas + 1);
        float espacamentoY = (alturaTela - linhas * alturaCarta) / (linhas + 1);

        for (int i = 0; i < totalCartas; i++) {
            int coluna = i % colunas;
            int linha = i / colunas;
            float x = espacamentoX + coluna * (larguraCarta + espacamentoX);
            float y = alturaTela - ((linha + 1) * (alturaCarta + espacamentoY));
            cartas.add(new Carta(numeros.get(i),caminhoVerso, x, y, jogo));
        }

        return cartas;
    }
}