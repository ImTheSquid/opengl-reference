package org.Graphics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;
import org.Resource.ImageResource;

public class Graphics {

    //Color vals
    private static float red=1,green=1,blue=1,alpha=1;

    //Rotation
    private static float rotation=0;

    public static void fillRect(float x, float y, float width, float height){
        GL2 gl= Renderer.gl;

        gl.glTranslatef(x,y,0);
        gl.glRotatef(-rotation,0,0,1);

        gl.glColor4f(red,green,blue,alpha);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(-width/2,-height/2);
        gl.glVertex2f(width/2,-height/2);
        gl.glVertex2f(width/2,height/2);
        gl.glVertex2f(-width/2,height/2);
        gl.glEnd();
        gl.glFlush();
        gl.glRotatef(rotation,0,0,1);//Set rot to 0
        gl.glTranslatef(-x,-y,0);//Do negative to put back
    }

    public static void drawImage(ImageResource image, float x, float y, float width, float height){
        GL2 gl= Renderer.gl;

        Texture tex=image.getTexture();

        //Check if visible
        if(x-width/2-Renderer.cameraX>Renderer.unitsWide/2||
            x+width/2-Renderer.cameraX<-Renderer.unitsWide/2||
            y-height/2-Renderer.cameraY>Renderer.unitsTall/2||
            y+height/2-Renderer.cameraY<-Renderer.unitsTall/2){
            return;
        }

        //Bind the texture
        if (tex != null) {
            gl.glBindTexture(GL2.GL_TEXTURE_2D,tex.getTextureObject());
        }

        gl.glTranslatef(x,y,0);
        gl.glRotatef(-rotation,0,0,1);

        gl.glColor4f(red,green,blue,alpha);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0,1);
        gl.glVertex2f(-width/2,-height/2);
        gl.glTexCoord2f(1,1);
        gl.glVertex2f(width/2,-height/2);
        gl.glTexCoord2f(1,0);
        gl.glVertex2f(width/2,height/2);
        gl.glTexCoord2f(0,0);
        gl.glVertex2f(-width/2,height/2);
        gl.glEnd();
        gl.glFlush();

        gl.glBindTexture(GL2.GL_TEXTURE_2D,0);//Unbind texture

        gl.glRotatef(rotation,0,0,1);//Set rot to 0
        gl.glTranslatef(-x,-y,0);//Do negative to put back
    }



    public static void setColor(float r, float g, float b, float a){
        red=Math.max(0,Math.min(1,r));
        green=Math.max(0,Math.min(1,g));
        blue=Math.max(0,Math.min(1,b));
        alpha=Math.max(0,Math.min(1,a));
    }

    public static void setRotation(float r){
        rotation=r;
    }



}
