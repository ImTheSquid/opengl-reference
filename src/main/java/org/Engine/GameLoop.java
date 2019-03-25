package org.Engine;

import org.Graphics.Renderer;
import org.World.World;

public class GameLoop {
    private static boolean running=false;

    private static int updates =0;
    private static final int MAX_UPDATES=5;

    private static long lastUpdateTime=0;

    private static int targetFPS=60;
    private static int targetTime=1000000000/targetFPS;

    public static void start(){
        Thread thread=new Thread(){
            public void run(){
                running=true;
                lastUpdateTime=System.nanoTime();
                int fps=0;
                long lastFpsCheck=System.nanoTime();
                while (running) {
                    long currentTime=System.nanoTime();
                    //Lag protection
                    updates=0;
                    while(currentTime-lastUpdateTime>=targetTime){//If diff between now and last time updated is greater than time to wait between updates, update again
                        World.update();
                        lastUpdateTime+=targetTime;
                        updates++;
                        if(updates>MAX_UPDATES)break;
                    }

                    long startTime=System.nanoTime();

                    //Render game (draw everything)
                    Renderer.render();
                    fps++;
                    if (System.nanoTime() >= lastFpsCheck + 1000000000) {
                        System.out.println(fps);
                        fps=0;
                        lastFpsCheck=System.nanoTime();
                    }

                    long timeTaken=System.nanoTime()-startTime;
                    if(timeTaken<targetTime){//Sleeps for extra time between frames
                        try {
                            Thread.sleep((targetTime-timeTaken)/1000000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        thread.setName("GameLoop");
        thread.start();
    }

    public static void setRunning(boolean running) {
        GameLoop.running = running;
    }

    public static float updateDelta(){
        return 1.0f/1000000000*targetTime;
    }
}
