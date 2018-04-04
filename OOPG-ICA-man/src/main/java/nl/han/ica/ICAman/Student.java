package nl.han.ica.ICAman;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import processing.core.PVector;

import java.util.List;

public abstract class Student extends AnimatedSpriteObject implements ICollidableWithTiles, IAlarmListener, IPathing {


    protected final int size = 25;
    protected final ICAman world;
    protected int spanwnTimer, studentenStartX, studentenStartY;

    /**
     * Constructor
     *
     * @param world Referentie naar de wereld
     */
    public Student(ICAman world, String fileName, int frames, int studentenStartX, int studentenStartY) {
        super(new Sprite(fileName), frames);
        this.world = world;
        this.studentenStartX = studentenStartX;
        this.studentenStartY = studentenStartY;
        startAlarm();
    }

    private void startAlarm() {
        Alarm alarm = new Alarm("spawnTimer", spanwnTimer);
        alarm.addTarget(this);
        alarm.start();
    }

    @Override
    public void triggerAlarm(String alarmName){
        spawn();
    }

    public void spawn(){
        setX(0);
        setY(0);
    }

    public void death(){
        //   editScore();
        startAlarm();
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

}
