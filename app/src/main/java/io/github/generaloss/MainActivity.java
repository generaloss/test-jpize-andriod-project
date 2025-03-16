package io.github.generaloss;

import android.os.Bundle;

import jpize.android.context.JpizeAndroidActivity;
import jpize.context.Jpize;

public class MainActivity extends JpizeAndroidActivity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Jpize.context.setApp(new InputTest());
    }

}
