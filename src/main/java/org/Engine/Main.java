package org.Engine;

import org.Graphics.Renderer;
import org.Player.Player;
import org.World.Tiles.GrassTile;
import org.World.World;

public class Main {
    public static void main(String[] args) {
        new Renderer();
        GameLoop.start();

        //TEST CODE
        for(int x=0;x<30;x++){
            for(int y=0;y<40;y++){
                GrassTile tile=new GrassTile();
                tile.x=tile.width*x;
                tile.y=tile.height*y;
                World.addTile(tile);
            }
        }
        World.addObject(new Player());
    }
}
