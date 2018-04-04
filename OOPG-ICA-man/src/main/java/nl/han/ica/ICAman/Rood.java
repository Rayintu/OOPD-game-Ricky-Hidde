package nl.han.ica.ICAman;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

import java.util.List;

public class Rood extends Student{


      Rood(ICAman world, String fileName, int frames, int studentenStartX, int studentenStartY){
          super(world, fileName, frames,  studentenStartX,  studentenStartY);
          spanwnTimer = 10;
      }


    public void tileCollisionOccurred(List<CollidedTile> collidedTiles)  {

    }

    public void Pathing(){
      }

      public void Death(){

      }
}