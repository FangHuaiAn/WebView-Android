package tw.com.thinkpower.webviewinteraction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private int selectedIndex = 0;

    private static final String[] features = new String[] {
        "Load HTML from Web", "Load HTML from Local", "JavaScript Interaction"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //
        ListView featureListView = (ListView) findViewById(R.id.featureListView);

        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, features);
        featureListView.setAdapter(listAdapter);

        featureListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //
                selectedIndex = position;

                Snackbar.make(view, "" + features[selectedIndex], Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        //my events
                        Intent intent = new Intent();
                        switch (selectedIndex) {
                            case 0: {
                                intent.setClass(MainActivity.this, LoadFromWebActivity.class);
                            }
                            break;
                            case 1: {
                                intent.setClass(MainActivity.this, LoadLocalHtmlActivity.class);
                            }
                            break;
                            case 2: {
                                intent.setClass(MainActivity.this, JavaScriptInteractionActivity.class);
                            }
                            break;
                        }

                        startActivity(intent);

                    }
                }, 1500); //time in millis

            }


        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
