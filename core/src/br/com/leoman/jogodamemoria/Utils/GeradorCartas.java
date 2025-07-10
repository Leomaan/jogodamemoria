package br.com.leoman.jogodamemoria.Utils;

import br.com.leoman.jogodamemoria.Carta;
import br.com.leoman.jogodamemoria.Telas.JogoScreen;
import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.Collections;

public class GeradorCartas {

    public static ArrayList<Carta> criarCartas(int inicioNumero, int fimNumero, int maxColunas, float larguraCarta, float alturaCarta, String caminhoVerso, JogoScreen jogo) {
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = inicioNumero; i <= fimNumero; i++) {
            numeros.add(i);
            numeros.add(i);
        }
        Collections.shuffle(numeros);

        ArrayList<Carta> cartas = new ArrayList<>();

        int totalCartas = numeros.size();
        int colunas = Math.min(maxColunas, totalCartas);
        int linhas = (int) Math.ceil((float) totalCartas / colunas);

        float larguraTela = Gdx.graphics.getWidth();
        float alturaTela = Gdx.graphics.getHeight();

        float espacamentoX = (larguraTela - colunas * larguraCarta) / (colunas + 1);
        float espacamentoY = (alturaTela - linhas * alturaCarta) / (linhas + 1);

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

