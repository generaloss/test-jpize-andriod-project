package io.github.generaloss;

import android.util.Log;
import jpize.context.Jpize;
import jpize.context.JpizeApplication;
import jpize.context.input.Key;
import jpize.context.input.MouseBtn;
import jpize.util.math.vector.Vec2f;

public class InputTest extends JpizeApplication {

    public void init() {
        // Jpize.callbacks.addKey((key, scancode, action, mods) -> {
        //     Log.i("JPIZE", "key: " + key.getName() + " " + scancode + " " + action + " " + mods);
        // });
        // Jpize.callbacks.addCursorPos((cursorIndex, x, y) -> {
        //     Log.i("JPIZE", "cursorpos: " + cursorIndex + " " + x + " " + y);
        // });
        // Jpize.callbacks.addMouseButton((mouseIndex, button, action, mods) -> {
        //     Log.i("JPIZE", "mousebutton: " + mouseIndex + " " + button + " " + action + " " + mods);
        // });
        Jpize.callbacks.addScroll((x, y) -> {
            Log.i("JPIZE", "scroll: " + x + " " + y);
        });
    }

    public void update() {
        if(MouseBtn.LEFT.down()) Log.i("JPIZE", "LEFT is down " + Jpize.input.getCursorPos(new Vec2f()));
        if(MouseBtn.LEFT.pressed()) Log.i("JPIZE", "LEFT is pressed " + Jpize.input.getCursorPos(new Vec2f()));
        if(MouseBtn.LEFT.up()) Log.i("JPIZE", "LEFT is up " + Jpize.input.getCursorPos(new Vec2f()));

        if(Key.A.down()) Log.i("JPIZE", "A is down");
        if(Key.A.pressed()) Log.i("JPIZE", "A is pressed");
        if(Key.A.up()) Log.i("JPIZE", "A is up");

        if(Jpize.getScroll() != 0)
            Log.i("JPIZE", "Scroll " + Jpize.getScroll());
    }

}