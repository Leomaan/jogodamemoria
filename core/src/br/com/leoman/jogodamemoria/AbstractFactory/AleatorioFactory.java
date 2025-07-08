package br.com.leoman.jogodamemoria.AbstractFactory;

import br.com.leoman.jogodamemoria.Carta;
import br.com.leoman.jogodamemoria.Cronometro.Cronometro;
import br.com.leoman.jogodamemoria.Telas.JogoScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.util.ArrayList;
import java.util.Collections;

public class AleatorioFactory implements NivelFactory {

    private String caminhoVerso = "assets/versoFinal.png";

    @Override
    public Cronometro criarCronometro(BitmapFont fonte) {
        return new Cronometro(90f, fonte);
    }

    @Override
    public ArrayList<Carta> criarCartas(JogoScreen jogo) {
        return criarCartasBase(jogo);
    }

    private ArrayList<Carta> criarCartasBase(JogoScreen jogo) {
        ArrayList<Integer> numerosSelecionados = new ArrayList<>();

        ArrayList<Integer> tema1 = new ArrayList<>();
        for (int i = 1; i <= 4; i++) tema1.add(i);

        Collections.shuffle(tema1);

        for (int i = 0; i < 2; i++) {
            numerosSelecionados.add(tema1.get(i));
        }

        ArrayList<Integer> tema2 = new ArrayList<>();
        for (int i = 5; i <= 10; i++) tema2.add(i);

        Collections.shuffle(tema2);

        for (int i = 0; i < 4; i++) {
            numerosSelecionados.add(tema2.get(i));
        }

        ArrayList<Integer> tema3 = new ArrayList<>();
        for (int i = 11; i <= 18; i++) tema3.add(i);

        Collections.shuffle(tema3);

        for (int i = 0; i < 6; i++) {
            numerosSelecionados.add(tema3.get(i));
        }

        ArrayList<Integer> numeros = new ArrayList<>();
        for (Integer num : numerosSelecionados) {
            numeros.add(num);
            numeros.add(num);
        }

        Collections.shuffle(numeros);

        ArrayList<Carta> cartas = new ArrayList<>();

        int totalCartas = numeros.size();
        int colunas = 6;
        int linhas = 4;

        float larguraCarta = 140f;
        float alturaCarta = 200f;

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