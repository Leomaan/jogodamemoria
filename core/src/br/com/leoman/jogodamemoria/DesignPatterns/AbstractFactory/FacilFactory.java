package br.com.leoman.jogodamemoria.DesignPatterns.AbstractFactory;

import br.com.leoman.jogodamemoria.Telas.JogoScreen;
import br.com.leoman.jogodamemoria.Carta;
import br.com.leoman.jogodamemoria.Utils.Cronometro;
import br.com.leoman.jogodamemoria.Utils.GeradorCartas;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.util.ArrayList;

public class FacilFactory implements NivelFactory {

    private final String caminhoVerso = "assets/versoFacil.png";

    public Cronometro criarCronometro(BitmapFont fonte) {
        return new Cronometro(60f, fonte);
    }

    public ArrayList<Carta> criarCartas(JogoScreen jogo) {
        return criarCartasBase(jogo);
    }

    private ArrayList<Carta> criarCartasBase(JogoScreen jogo) {
        return GeradorCartas.criarCartas(1, 4, 4, 190, 255, caminhoVerso, jogo);
    }
}