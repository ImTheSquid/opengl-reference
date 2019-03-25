package org.Input;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

import java.util.HashSet;
import java.util.Set;

public class KeyInput implements KeyListener {
    private static Set<Short> key=new HashSet<Short>();
    public void keyPressed(KeyEvent keyEvent) {
        key.add(keyEvent.getKeyCode());
    }

    public void keyReleased(KeyEvent keyEvent) {
        if(!keyEvent.isAutoRepeat())key.remove(keyEvent.getKeyCode());
    }

    public static boolean getKey(short k){
        return key.contains(k);
    }
}
