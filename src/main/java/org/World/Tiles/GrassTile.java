package org.World.Tiles;

import org.Graphics.Animation;
import org.Resource.ImageResource;
import org.World.Tile;

public class GrassTile extends Tile {
    public GrassTile(){
        animations = new Animation[1];
        animations[0]=new Animation();
        animations[0].frames=new ImageResource[1];
        animations[0].frames[0]=new ImageResource("/Images/grass.png");
    }
}
