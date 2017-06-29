package tech.joei.vr;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import tech.joei.vr_mod_1.GLView;

public class MainActivity extends AppCompatActivity {

    GLView glView;
    ListView itemList;

    ImageButton backButton;
    ImageButton playButton;
    ImageButton nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // get views
        glView = (GLView) findViewById(R.id.glView);
        itemList = (ListView) findViewById(R.id.itemList);

        backButton = (ImageButton) findViewById(R.id.backButton);
        playButton = (ImageButton) findViewById(R.id.playButton);
        nextButton = (ImageButton) findViewById(R.id.nextButton);


        //Click listeners
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Back click", Toast.LENGTH_SHORT).show();
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Play click", Toast.LENGTH_SHORT).show();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Next click", Toast.LENGTH_SHORT).show();
            }
        });

        if(itemList != null) { // the itemList does not exists in landscape

            // populate list
            String[] data = new String[] {
                    "this",
                    "is",
                    "a",
                    "list",
                    "full",
                    "of",
                    "data"
            };
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.listview_item, R.id.itemLabel, data);
            itemList.setAdapter(dataAdapter);
        }


    }
}
