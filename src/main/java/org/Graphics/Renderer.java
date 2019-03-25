package org.Graphics;

import com.jogamp.nativewindow.WindowClosingProtocol;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.newt.opengl.GLWindow.*;
import com.jogamp.opengl.*;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;
import org.Engine.GameLoop;
import org.Input.KeyInput;
import org.Input.MouseInput;
import org.Resource.ImageResource;
import org.World.World;

public class Renderer implements GLEventListener {
    private static GLWindow window;
    //private FPSAnimator animator;
    private static GLProfile profile;
    public static GL2 gl=null;
    public static int screenWidth=640, screenHeight=360;
    public static float unitsWide=10, unitsTall;

    public static float cameraX=0,cameraY=0;

    public Renderer(){
        profile=GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities=new GLCapabilities(profile);
        window=GLWindow.create(capabilities);
        window.addGLEventListener(this);
        window.setSize(screenWidth,screenHeight);
        window.setResizable(false);
        window.setFullscreen(false);
        window.setDefaultCloseOperation(WindowClosingProtocol.WindowClosingMode.DISPOSE_ON_CLOSE);
        window.addMouseListener(new MouseInput());
        window.addKeyListener(new KeyInput());
        window.setTitle("OpenGL Testing");
        window.setVisible(true);
    }

    public static void render(){
        if (window == null) {
            return;
        }
        window.display();
    }

    public static GLProfile getProfile() {
        return profile;
    }

    public static GLWindow getWindow() {
        return window;
    }

    public void init(GLAutoDrawable glAutoDrawable) {
        GL2 gl=glAutoDrawable.getGL().getGL2();
        gl.glClearColor(0.25f,0.25f,0.25f,1);
        gl.glEnable(GL2.GL_BLEND);//Enable alpha values
        gl.glEnable(GL2.GL_TEXTURE_2D);

        gl.glBlendFunc(GL2.GL_SRC_ALPHA,GL2.GL_ONE_MINUS_SRC_ALPHA);//Set blend mode
    }

    public void dispose(GLAutoDrawable glAutoDrawable) {
        //animator.stop();
        GameLoop.setRunning(false);
        //window.destroy();
    }
    public void display(GLAutoDrawable glAutoDrawable) {
        gl=glAutoDrawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glTranslatef(-cameraX,-cameraY,0);
        World.render();
        gl.glTranslatef(cameraX,cameraY,0);
    }

    public void reshape(GLAutoDrawable glAutoDrawable, int x, int y, int width, int height) {
        //set projection matrix
        GL2 gl = glAutoDrawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        unitsTall=window.getHeight()/(window.getWidth()/unitsWide);
        gl.glOrtho(-unitsWide/2,unitsWide/2,-unitsTall/2,unitsTall/2,-1,1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }
}
