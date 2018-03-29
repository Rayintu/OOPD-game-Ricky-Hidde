package nl.han.ica.ICAman;

import com.sun.prism.image.ViewPort;
import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.FilePersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.IPersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileMap;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileType;
import nl.han.ica.OOPDProcessingEngineHAN.View.EdgeFollowingViewport;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.waterworld.tiles.BoardsTile;
import processing.core.PApplet;

import static nl.han.ica.ICAman.IWriteReadTextFile.writeFile;

public class ICAman extends GameEngine {



    @Override
    public void setupGame(){
        //int worldWidth=1204;
        //int worldHeight=903;

        //createView(worldWidth, worldHeight);

        //testprint("yeet");

        //editScore();
    }

    /**
     * Implement this method to make constant updates in your game
     */
    @Override
    public void update() {

    }

    public void createView(int screenWidth,int screenHeight){
        View view = new View(screenWidth,screenHeight);
        view.setBackground(loadImage("src/main/java/nl/han/ica/ICAman/mecia/nadeshiko.png"));

        setView(view);
        size(screenWidth, screenHeight);
    }

    public void initializeSound(){

    }

    public void createObjects(){

    }

    public void testprint(String yeet){
        System.out.println(yeet);
    }

    public void editScore(){
        writeFile("Ricky",6000);
    }

}
