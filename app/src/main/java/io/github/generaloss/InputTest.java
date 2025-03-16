package io.github.generaloss;

import android.util.Log;
import jpize.context.Jpize;
import jpize.context.JpizeApplication;
import jpize.context.input.Key;
import jpize.context.input.MouseBtn;

public class InputTest extends JpizeApplication {

    public void init() {
        Jpize.callbacks.addKey((key, scancode, action, mods) -> {
            Log.i("JPIZE", "key: " + key.getName() + " " + scancode + " " + action + " " + mods);
        });
        Jpize.callbacks.addCursorPos((cursorIndex, x, y) -> {
            Log.i("JPIZE", "cursorpos: " + cursorIndex + " " + x + " " + y);
        });
        Jpize.callbacks.addMouseButton((mouseIndex, button, action, mods) -> {
            Log.i("JPIZE", "mousebutton: " + mouseIndex + " " + button + " " + action + " " + mods);
        });
    }

    public void update() {
        if(MouseBtn.LEFT.down()) Log.i("JPIZE", "LEFT is down");
        if(MouseBtn.LEFT.pressed()) Log.i("JPIZE", "LEFT is pressed");
        if(MouseBtn.LEFT.up()) Log.i("JPIZE", "LEFT is up");

    }

}