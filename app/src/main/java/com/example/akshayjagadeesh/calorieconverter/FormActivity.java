package com.example.akshayjagadeesh.calorieconverter;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class FormActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    private GoogleApiClient client;

    Button mButton;
    RadioButton rButtonReps;
    RadioButton rButtonMins;
    Spinner dropdown;
    EditText mEdit;
    TextView mText;
    TextView dText;
    boolean isRep;
    String units;
    String exercise;
    float calories;
    String other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dropdown = (Spinner)findViewById(R.id.spinner1);
        String[] items = new String[]{"Pushup", "Situp", "Jumping Jacks", "Jogging"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        mButton = (Button) findViewById(R.id.button1);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String a;
                String b;
                String c;
                mEdit   = (EditText)findViewById(R.id.editText);
                int numEx = Integer.parseInt(mEdit.getText().toString());

                rButtonReps = (RadioButton)findViewById(R.id.radioButton1);
                if (rButtonReps.isChecked()){
                    isRep = true;
                    units = "reps";
                }
                else{
                    isRep = false;
                    units = "mins";
                }
                exercise = dropdown.getSelectedItem().toString();

                switch(exercise){
                    case "Pushup":
                        calories = (float) 100*numEx/350;
                        a = Float.toString((float) 200*numEx / 350);
                        b = Float.toString((float) 10*numEx / 350);
                        c = Float.toString((float) 12*numEx / 350);
                        other = a + " reps of situps, " + b + " minutes of jumping jacks, or " + c + " minutes of jogging.";
                        break;
                    case "Situp":
                        calories = (float) 100*numEx/200;
                        a = Float.toString((float) 350*numEx / 200);
                        b = Float.toString((float) 10*numEx / 200);
                        c = Float.toString((float) 12*numEx / 200);
                        other = a + " reps of pushups, " + b + " minutes of jumping jacks, or " + c + " minutes of jogging.";
                        break;
                    case "Jumping Jacks":
                        calories = (float) 100*numEx/10;
                        a = Float.toString((float) 350*numEx / 10);
                        b = Float.toString((float) 200*numEx / 10);
                        c = Float.toString((float) 12*numEx / 10);
                        other = a + " reps of pushups, " + b + " reps of situps, or " + c + " minutes of jogging.";
                        break;
                    case "Jogging":
                        calories = (float) 100*numEx/12;
                        a = Float.toString((float) 350*numEx / 12);
                        b = Float.toString((float) 200*numEx / 12);
                        c = Float.toString((float) 10*numEx / 12);
                        other = a + "reps of pushups, " + b + " reps of situps, or " + c + " minutes of jogging.";
                        break;
                }
                dText = (TextView)findViewById(R.id.textView4);
                mText = (TextView)findViewById(R.id.textView1);
                mText.setText("Congratulations on completing " + mEdit.getText().toString() + " " + units + " of " + exercise + "!");
                dText.setText("You have burned " + calories + " calories, which is equivalent to " + other);

            }
        });



        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form, menu);
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

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Form Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.akshayjagadeesh.calorieconverter/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Form Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.akshayjagadeesh.calorieconverter/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
