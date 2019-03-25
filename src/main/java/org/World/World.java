package org.World;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class World {

    private static ConcurrentLinkedQueue<Tile> tiles=new ConcurrentLinkedQueue<Tile>();
    private static ConcurrentLinkedQueue<GameObject> gameObjects=new ConcurrentLinkedQueue<GameObject>();

    //private static ArrayList<Tile> tiles=new ArrayList<Tile>();
    //private static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    public static void update(){
        //Loop through game objects and update
        for(GameObject gameObject:gameObjects){
            gameObject.update();
        }
    }

    public static void render(){
        //Render tiles
        for(Tile t:tiles){
            t.render();
        }
        //Loop through game objects and render
        for(GameObject gameObject:gameObjects){
            gameObject.render();
        }
    }

    public static void addObject(GameObject go){
        gameObjects.offer(go);
    }

    public static void addTile(Tile t){tiles.offer(t);}
}
