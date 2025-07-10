package br.com.leoman.jogodamemoria.DesignPatterns.AbstractFactory;

import br.com.leoman.jogodamemoria.Telas.JogoScreen;
import br.com.leoman.jogodamemoria.Carta;
import br.com.leoman.jogodamemoria.Utils.Cronometro;
import br.com.leoman.jogodamemoria.Utils.GeradorCartas;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.util.ArrayList;

public class MedioFactory implements NivelFactory {

    private final String caminhoVerso = "assets/versoMedio.png";

    public Cronometro criarCronometro(BitmapFont fonte) {
        return new Cronometro(45f, fonte);
    }

    public ArrayList<Carta> criarCartas(JogoScreen jogo) {
        return criarCartasBase(jogo);
    }

    private ArrayList<Carta> criarCartasBase(JogoScreen jogo) {
        return GeradorCartas.criarCartas(5, 10, 6, 190, 255, caminhoVerso, jogo);
    }
}