package br.com.leoman.jogodamemoria;

import Telas.JogoScreen;
import br.com.leoman.jogodamemoria.Decorator.CartaAnimacao;
import br.com.leoman.jogodamemoria.Decorator.CartaDecorator;
import br.com.leoman.jogodamemoria.Decorator.CartaSom;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import java.util.ArrayList;

public class Carta extends Actor {
   public Texture texturaFrente;
   Texture texturaVerso;
   public boolean virada = false;
   float x;
   float y;
   float largura = 190;
   float altura = 255;
   Carta cartaAtual;

   public Carta (int numCarta, float x , float y, JogoScreen jogo){
       texturaFrente = new Texture(Gdx.files.internal("carta"+numCarta+".png"));
       texturaVerso = new Texture(Gdx.files.internal("verso.png"));
      this.x = x;
      this.y = y;
      cartaAtual = this;
      setBounds(x, y, largura, altura);

      addListener(new InputListener(){
         public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
            virada = !virada;
            ArrayList<Carta> cartasViradas = jogo.cartasViradas;
            if(cartasViradas.size() <2){
               virada = true;
               jogo.cartasViradas.add(cartaAtual);
               CartaDecorator som = new CartaSom(cartaAtual);
               som.executar();
               CartaDecorator animacao = new CartaAnimacao(cartaAtual);
               animacao.executar();

            }else if(cartasViradas.size() >=2){
                   jogo.virarCartas();
                   virada = true;
                   jogo.cartasViradas.add(cartaAtual);
                  CartaDecorator som = new CartaSom(cartaAtual);
                  som.executar();
                  CartaDecorator animacao = new CartaAnimacao(cartaAtual);
                  animacao.executar();
            }
            return super.touchDown(event, x, y, pointer, button);
         }
      });
   }

      public void draw(Batch batch, float parentAlpha) {
          Texture textura = virada ? texturaFrente : texturaVerso;
          batch.draw(textura, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation(), 0, 0, (int) largura, (int) altura, false, false
          );
      }
}