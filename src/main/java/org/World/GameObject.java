package org.World;

import org.Graphics.Animation;
import org.Graphics.Graphics;

public class GameObject {
    //Object pos
    public float x = 0,y=0;
    //Size
    public float width=0.5f,height=0.5f;
    //Rotation
    public float rotation=0;

    //Animations
    public Animation[] animations;
    public int currentAnimation=0;

    public void update(){
        //Implement in subclass
    }

    public void render(){
        animations[currentAnimation].play();
        Graphics.setRotation(rotation);
        Graphics.drawImage(animations[currentAnimation].getImage(),x,y,width,height);
        Graphics.setRotation(0);
    }

}
