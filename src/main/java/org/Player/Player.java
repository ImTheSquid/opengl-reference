package org.Player;

import com.jogamp.newt.event.KeyEvent;
import org.Engine.GameLoop;
import org.Graphics.Animation;
import org.Graphics.Graphics;
import org.Graphics.Renderer;
import org.Input.KeyInput;
import org.Input.MouseInput;
import org.Resource.ImageResource;
import org.World.GameObject;

public class Player extends GameObject {
    public Player(){
        animations=new Animation[1];
        animations[0]=new Animation();
        animations[0].frames=new ImageResource[1];
        animations[0].frames[0]=new ImageResource("/Images/java.png");
        //animations[0].frames[1]=new ImageResource("/Images/java2.png");
    }
    public void update(){
        float xInput=0;
        float yInput=0;
        if(KeyInput.getKey(KeyEvent.VK_A)){
            xInput--;
        }
        if(KeyInput.getKey(KeyEvent.VK_D)){
            xInput++;
        }
        if (KeyInput.getKey(KeyEvent.VK_W)) {
            yInput++;
        }
        if (KeyInput.getKey(KeyEvent.VK_S)) {
            yInput--;
        }

        x+=xInput* GameLoop.updateDelta();
        y+=yInput*GameLoop.updateDelta();

        //System.out.println(MouseInput.getWorldX()+" / "+MouseInput.getWorldY());
        rotation = (float)Math.toDegrees(Math.atan2(MouseInput.getWorldX()-x,MouseInput.getWorldY()-y));

        Renderer.cameraX=x;
        Renderer.cameraY=y;
    }

    @Override
    public void render() {
        super.render();
        //Graphics.fillRect(x,y,width,height);
    }
}
