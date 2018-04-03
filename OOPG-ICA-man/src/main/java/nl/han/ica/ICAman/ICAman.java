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
import nl.han.ica.waterworld.Player;
import nl.han.ica.waterworld.tiles.BoardsTile;
import processing.core.PApplet;

import static nl.han.ica.ICAman.IWriteReadTextFile.writeFile;

public class ICAman extends GameEngine {

    /**
     * variabelen
     */

    private Docent docent;

    public static void main(String[] args) {
        PApplet.main("nl.han.ica.ICAman.ICAman");
    }

    @Override
    public void setupGame(){
        int worldWidth=1200;
        int worldHeight=800;

        createView(worldWidth, worldHeight);
        createMaze();
        createObjects();


    }

    /**
     * Implement this method to make constant updates in your game
     */
    @Override
    public void update() {

    }

    public void createView(int screenWidth,int screenHeight){
        View view = new View(screenWidth,screenHeight);
        view.setBackground(loadImage("src/main/java/nl/han/ica/ICAman/media/mapbackgroundblack.png"));

        setView(view);
        size(screenWidth, screenHeight);
    }

    public void initializeSound(){

    }

    public void createMaze(){
        Sprite wallSprite = new Sprite("src/main/java/nl/han/ica/ICAman/media/wall.png");
        Sprite gateSprite = new Sprite( "src/main/java/nl/han/ica/ICAman/media/gate.png");
        Sprite warpSprite = new Sprite("src/main/java/nl/han/ica/ICAman/media/inviswall.png" );
        //Sprite koffieSprite = new Sprite( "src/main/java/nl/han/ica/ICAman/media/koffie_sprite.png");
        //Sprite boardsSprite = new Sprite("src/main/java/nl/han/ica/ICAman/media/inviswall.png");
        TileType<BoardsTile> wallTileType = new TileType<>(BoardsTile.class, wallSprite);
        TileType<BoardsTile> gateTileType = new TileType<>(BoardsTile.class, gateSprite);
        TileType<BoardsTile> warpTileType = new TileType<>(BoardsTile.class, warpSprite);
        //TileType<BoardsTile> koffieTileType = new TileType<>(BoardsTile.class, koffieSprite);

        //tilesize 32px map is 23x25
        TileType[] tileTypes = { wallTileType, gateTileType, warpTileType };


        int tileSize=32;
        int tilesMap[][]={
                {0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1,-1},
                {0 ,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0,-1,-1},
                {0 ,-1, 0, 0, 0,-1, 0, 0, 0, 0,-1, 0,-1, 0, 0, 0, 0,-1, 0, 0, 0,-1, 0,-1,-1},
                {0 ,-1, 0, 0, 0,-1, 0, 0, 0, 0,-1, 0,-1, 0, 0, 0, 0,-1, 0, 0, 0,-1, 0,-1,-1},
                {0 ,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0,-1,-1},
                {0 ,-1, 0, 0, 0,-1, 0,-1, 0, 0, 0, 0, 0, 0, 0,-1, 0,-1, 0, 0, 0,-1, 0,-1,-1},
                {0 ,-1, 0, 0, 0,-1, 0,-1, 0, 0, 0, 0, 0, 0, 0,-1, 0,-1, 0, 0, 0,-1, 0,-1,-1},
                {0 ,-1,-1,-1,-1,-1, 0,-1,-1,-1,-1, 0,-1,-1,-1,-1, 0,-1,-1,-1,-1,-1, 0,-1,-1},
                {0 , 0, 0, 0, 0,-1, 0, 0, 0, 0,-1, 0,-1, 0, 0, 0, 0,-1, 0, 0, 0, 0, 0,-1,-1},
                {-1,-1,-1,-1, 0,-1, 0,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0,-1, 0,-1,-1,-1,-1,-1,-1},
                {0 , 0, 0, 0, 0,-1, 0,-1, 0, 0, 0, 1, 0, 0, 0,-1, 0,-1, 0, 0, 0, 0, 0,-1,-1},
                { 2,-1,-1,-1,-1,-1,-1,-1, 0,-1,-1,-1,-1,-1, 0,-1,-1,-1,-1,-1,-1,-1,-1,-1, 2},
                { 2,-1,-1,-1,-1,-1,-1,-1, 0,-1,-1,-1,-1,-1, 0,-1,-1,-1,-1,-1,-1,-1,-1,-1, 2},
                {0 , 0, 0, 0, 0,-1, 0,-1, 0, 0, 0, 0, 0, 0, 0,-1, 0,-1, 0, 0, 0, 0, 0,-1,-1},
                {-1,-1,-1,-1, 0,-1, 0,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0,-1, 0,-1,-1,-1,-1,-1,-1},
                {0 , 0, 0, 0, 0,-1, 0,-1, 0, 0, 0, 0, 0, 0, 0,-1, 0,-1, 0, 0, 0, 0, 0,-1,-1},
                {0 ,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0,-1,-1},
                {0 ,-1, 0, 0, 0,-1, 0, 0, 0, 0,-1, 0,-1, 0, 0, 0, 0,-1, 0, 0, 0,-1, 0,-1,-1},
                {0 ,-1, 0, 0, 0,-1, 0, 0, 0, 0,-1, 0,-1, 0, 0, 0, 0,-1, 0, 0, 0,-1, 0,-1,-1},
                {0 ,-1,-1,-1, 0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0,-1,-1,-1, 0,-1,-1},
                {0 , 0, 0,-1, 0,-1, 0,-1, 0, 0, 0, 0, 0, 0, 0,-1, 0,-1, 0,-1, 0, 0, 0,-1,-1},
                {0 ,-1,-1,-1,-1,-1, 0,-1,-1,-1,-1, 0,-1,-1,-1,-1, 0,-1,-1,-1,-1,-1, 0,-1,-1},
                {0 ,-1, 0, 0, 0, 0, 0, 0, 0, 0,-1, 0,-1, 0, 0, 0, 0, 0, 0, 0, 0,-1, 0,-1,-1},
                {0 ,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0,-1,-1},
                {0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1,-1}
                };
        tileMap = new TileMap(tileSize, tileTypes, tilesMap);
    }





    public void createObjects(){
        int docentStartX = 355;
        int docentStartY = 730;

        docent = new Docent(this);
        addGameObject(docent, docentStartX, docentStartY);
    }

    public void testprint(String yeet){
        System.out.println(yeet);
    }

    public void editScore(){
        writeFile("Ricky",6000);
    }

}
