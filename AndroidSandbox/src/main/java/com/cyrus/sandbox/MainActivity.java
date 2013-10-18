package com.cyrus.sandbox;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button triangleButton;
    private Button squareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        triangleButton = (Button)findViewById(R.id.triangleButton);
        triangleButton.setOnClickListener(trianglesOnClick);

        squareButton = (Button)findViewById(R.id.squareButton);
        squareButton.setOnClickListener(squareOnClick);
    }

    View.OnClickListener trianglesOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent myIntent1 = new Intent(MainActivity.this, TriangleActivity.class);
            MainActivity.this.startActivity(myIntent1);
        }
    };

    View.OnClickListener squareOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent myIntent1 = new Intent(MainActivity.this, SquareActivity.class);
            MainActivity.this.startActivity(myIntent1);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
