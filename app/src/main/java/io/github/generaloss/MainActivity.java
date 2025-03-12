package io.github.generaloss;

import android.app.Activity;
import android.os.Bundle;

import jpize.android.context.AndroidContextBuilder;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AndroidContextBuilder.create(this)
            .build()
            .setApp(new App());
    }

}
