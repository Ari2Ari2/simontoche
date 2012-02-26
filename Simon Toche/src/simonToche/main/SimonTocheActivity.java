package simonToche.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class SimonTocheActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        LinearLayout ll = (LinearLayout)findViewById(R.id.time_menu);
        ll.setVisibility(View.INVISIBLE);
    }
    
    
}