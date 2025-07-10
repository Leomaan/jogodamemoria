package br.com.leoman.jogodamemoria.DesignPatterns.AbstractFactory;

import br.com.leoman.jogodamemoria.Telas.JogoScreen;
import br.com.leoman.jogodamemoria.Carta;
import br.com.leoman.jogodamemoria.Utils.Cronometro;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.util.ArrayList;

public interface NivelFactory {
    Cronometro criarCronometro(BitmapFont fonte);
    ArrayList<Carta> criarCartas(JogoScreen jogo);
}