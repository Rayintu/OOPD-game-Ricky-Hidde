package nl.han.ica.ICAman;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;

import java.util.List;

<<<<<<< HEAD
public class Docent extends AnimatedSpriteObject implements ICollidableWithTiles {

    final int size = 25;
    private final ICAman world;

    /**
     * Constructor
     *
     * @param world Referentie naar de wereld
     */
    public Docent(ICAman world) {
        super(new Sprite("nl/han/ica/ICAman/media/original_pacman.png"), 1);
        this.world = world;
        setCurrentFrameIndex(0);
        setWidth(size);
        setHeight(size);
    }

    @Override
    public void update() {
        if (getX()<=0) {
            setxSpeed(0);
            setX(0);
        }
        if (getY()<=0) {
            setySpeed(0);
            setY(0);
        }
        if (getX()>=world.getWidth()-size) {
            setxSpeed(0);
            setX(world.getWidth() - size);
        }
        if (getY()>=world.getHeight()-size) {
            setySpeed(0);
            setY(world.getHeight() - size);
        }

    }

    @Override
    public void keyPressed(int keyCode, char key) {
        final int speed = 5;
        if (keyCode == world.LEFT) {
            setDirectionSpeed(270, speed);
            setCurrentFrameIndex(0);
        }
        if (keyCode == world.UP) {
            setDirectionSpeed(0, speed);
        }
        if (keyCode == world.RIGHT) {
            setDirectionSpeed(90, speed);
            setCurrentFrameIndex(0);
        }
        if (keyCode == world.DOWN) {
            setDirectionSpeed(180, speed);
        }
    }


    @Override
    public void tileCollisionOccurred(List<CollidedTile> collidedTiles)  {

<<<<<<< HEAD
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
=======
public class Docent implements ICollidableWithGameObjects {
    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {

>>>>>>> parent of 0bf02f0... code dinges :b:oi
=======

>>>>>>> parent of d88693a... docent update
    }
}
