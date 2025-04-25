   package br.com.leoman.jogodamemoria;


   import com.badlogic.gdx.graphics.Texture;
   import com.badlogic.gdx.graphics.g2d.Batch;
   import com.badlogic.gdx.scenes.scene2d.Actor;

   public class Carta extends Actor {
      Texture textureFrente;
      Texture textureVerso;
      boolean virada = false;
      float x;
      float y;
      float altura = 255;
      float largura = 190;

      public Carta(int numCarta, float x, float y){
         textureFrente = new Texture("carta"+numCarta+".png");
         textureVerso = new Texture("verso.png");

         this.x = x;
         this.y = y;
         setBounds(x,y,largura,altura);
      }
      public void draw(Batch batch, float delta){
         batch.draw(!virada ? textureVerso : textureFrente,x,y,largura,altura);
      }
   }