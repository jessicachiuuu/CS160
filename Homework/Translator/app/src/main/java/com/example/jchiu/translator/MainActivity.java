package com.example.jchiu.translator;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnItemSelectedListener, View.OnClickListener {

    // Declare Spinner variables so they are accessible throughout class
    Spinner fromLanguageSpinner, phraseChoiceSpinner, toLanguageSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // From language spinner setup
        fromLanguageSpinner = (Spinner) findViewById(R.id.from_language);
        ArrayAdapter<CharSequence> fromLanguageAdapter = ArrayAdapter.createFromResource(this,
                R.array.from_language, android.R.layout.simple_spinner_item);
        fromLanguageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromLanguageSpinner.setAdapter(fromLanguageAdapter);
        fromLanguageSpinner.setOnItemSelectedListener(this);

        // toLanguage Spinner setup
        toLanguageSpinner = (Spinner) findViewById(R.id.to_language);
        ArrayAdapter<CharSequence> toLanguageAdapter = ArrayAdapter.createFromResource(this,
                R.array.to_language, android.R.layout.simple_spinner_item);
        toLanguageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toLanguageSpinner.setAdapter(toLanguageAdapter);

        // Phrase choice spinner setup
        phraseChoiceSpinner = (Spinner) findViewById(R.id.phrase_choice);

        // Translate button setup
        Button translateButton = (Button) findViewById(R.id.translate_button);
        translateButton.setOnClickListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3) {

        // Sets which phrase choice spinner to display depending on which language
        // user is translating from
        if (pos == 0) {
            ArrayAdapter<CharSequence> EnglishAdapter = ArrayAdapter.createFromResource(this,
                    R.array.English, android.R.layout.simple_spinner_item);
            phraseChoiceSpinner.setAdapter(EnglishAdapter);
        } else if (pos == 1) {
            ArrayAdapter<CharSequence> SpanishAdapter = ArrayAdapter.createFromResource(this,
                    R.array.Spanish, android.R.layout.simple_spinner_item);
            phraseChoiceSpinner.setAdapter(SpanishAdapter);
        } else if (pos == 2) {
            ArrayAdapter<CharSequence> MandarinAdapter = ArrayAdapter.createFromResource(this,
                    R.array.Mandarin, android.R.layout.simple_spinner_item);
            phraseChoiceSpinner.setAdapter(MandarinAdapter);
        }

    }

    public void onClick(View v) {

        // Store which language app needs to translate to
        TextView view = (TextView) findViewById(R.id.answer);
        int toPosition = toLanguageSpinner.getSelectedItemPosition();
        int choicePosition = phraseChoiceSpinner.getSelectedItemPosition();

        // Hold array of all the various phrases for output to answer text field
        String[] EnglishArray = getResources().getStringArray(R.array.English);
        String[] SpanishArray = getResources().getStringArray(R.array.Spanish);
        String[] MandarinArray = getResources().getStringArray(R.array.Mandarin);

        // Determine what answer text field should display
        if (toPosition == 0) {
            view.setText(EnglishArray[choicePosition]);
        } else if (toPosition == 1) {
            view.setText(SpanishArray[choicePosition]);
        } else if (toPosition == 2) {
            view.setText(MandarinArray[choicePosition]);
        }

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

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }

}
