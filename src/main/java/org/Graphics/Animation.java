package org.Graphics;

import org.Resource.ImageResource;

public class Animation {

    //Animation frames
    public ImageResource[] frames;

    private int currentFrame=0;

    public int fps=1;
    private long lastFrameTime=0;

    private boolean loop=true;

    public void play(){
        long currentTime=System.nanoTime();
        if(currentTime>lastFrameTime+1000000000/fps) {
            currentFrame++;
            if (currentFrame >= frames.length) {
                if (loop) {
                    currentFrame = 0;
                } else {
                    currentFrame--;
                }

            }
            lastFrameTime = currentTime;
        }
    }

    public ImageResource getImage(){
        return frames[currentFrame];
    }

}
