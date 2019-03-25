package org.Input;


import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import org.Graphics.Renderer;

public class MouseInput implements MouseListener {

    private static int x=0,y=0;

    public static float getWorldX(){
        return Renderer.unitsWide/Renderer.getWindow().getWidth()*x-Renderer.unitsWide/2 - Renderer.cameraX;
    }

    public static float getWorldY(){
        float unitsTall=Renderer.unitsWide*((float)Renderer.getWindow().getHeight()/Renderer.getWindow().getWidth());
        return -(unitsTall/ Renderer.getWindow().getHeight()*y-unitsTall/2)+Renderer.cameraY;
    }

    public void mouseClicked(MouseEvent mouseEvent) {

    }

    public void mouseEntered(MouseEvent mouseEvent) {

    }

    public void mouseExited(MouseEvent mouseEvent) {

    }

    public void mousePressed(MouseEvent mouseEvent) {

    }

    public void mouseReleased(MouseEvent mouseEvent) {

    }

    public void mouseMoved(MouseEvent mouseEvent) {
        x=mouseEvent.getX();
        y=mouseEvent.getY();
    }

    public void mouseDragged(MouseEvent mouseEvent) {

    }

    public void mouseWheelMoved(MouseEvent mouseEvent) {

    }
}
