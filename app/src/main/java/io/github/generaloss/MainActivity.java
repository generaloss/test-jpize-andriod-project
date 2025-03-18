package io.github.generaloss;

import android.app.Activity;
import android.os.Bundle;

import android.util.Log;
import android.view.KeyEvent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import jpize.android.context.input.AndroidKey;
import jpize.context.input.Key;

public class MainActivity extends Activity {

    private final Map<Key, Long> pressedKeys = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keycode = event.getKeyCode();
        int action = event.getAction();

        final Key key = AndroidKey.byAndroidKeycode(keycode);
        if(key == null)
            return false;

        if(action == KeyEvent.ACTION_DOWN) {
            if(pressedKeys.containsKey(key)) {
                return false;
            }

            Log.i("JPIZE", "down " + key);
            pressedKeys.put(key, System.currentTimeMillis());
            return true;
        }

        if(action == KeyEvent.ACTION_UP) {
            final Long timestamp = pressedKeys.get(key);
            if(timestamp == null)
                return false;
            final long elapsedTime = (System.currentTimeMillis() - timestamp);
            if(elapsedTime < 10)
                return false;
            Log.i("JPIZE", "up " + key);
            pressedKeys.remove(key);
            return true;
        }

        return super.dispatchKeyEvent(event);
    }

}
