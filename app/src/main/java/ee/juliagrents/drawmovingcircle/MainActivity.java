package ee.juliagrents.drawmovingcircle;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {
    private int start_x=50;
    private int start_y=50;
    DrawScene scene ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getPreferences(0);

        int x=preferences.getInt("x",start_x);
        int y=preferences.getInt("y",start_y);

       scene =  new DrawScene(this, x, y);
        setContentView(scene);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences preferences = getPreferences(0);
        SharedPreferences.Editor storedDataEditor  = preferences.edit();
        storedDataEditor.putInt("x", scene.getCurrentX());

        storedDataEditor.putInt("y", scene.getCurrentY());
        storedDataEditor.commit();
    }
}
