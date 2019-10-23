package uk.ac.brunel.cs.level2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

    public void on_button_click(View View) {

        TextView tv = this.findViewById(R.id.numberTextView);
        TextView en = this.findViewById(R.id.EnterNumber);
        TextView sid = this.findViewById(R.id.ScoreId);


        Random p = new Random();
        int number = p.nextInt(10);

        tv.setText(Integer.toString(number));


        try {
            int Number = Integer.valueOf(tv.getText().toString());
            int UserNumber = Integer.valueOf(en.getText().toString());

            if (UserNumber == Number) {
                int Score = Integer.valueOf(sid.getText().toString());
                int ScoreChecker = Score + 1;

                sid.setText(Integer.toString(ScoreChecker));

                Toast.makeText(getApplicationContext(), "Congrats!", Toast.LENGTH_SHORT).show();
            } else if (UserNumber < 1 || Number > 10) {
                Toast.makeText(getApplicationContext(), "Try Again!", Toast.LENGTH_SHORT).show();
            } else {
                tv.setText(Integer.toString(number));
            }
        }catch (Exception ex){

        }
    }
}

