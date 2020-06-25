package com.example.home.buttoncounter;

//import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText; //imported from android widget package
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userInput; //reference to EditText widget
    //private Button button; //reference to Button widget
    private TextView textView; //reference to TextView widget
    //private int numTimesClicked = 0;
    private static final String TAG = "MainActivity";
    private final String TEXT_CONTENTS = "TextContents";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: into the onCreate method");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //sets the main display

        userInput = findViewById(R.id.myEditText); //the myEditText is the ID from the activity_main.xml file
        userInput.setText(""); //setting the text box as empty
        Button button = findViewById(R.id.myButton);
        textView = findViewById(R.id.myTextView);
        textView.setText("");//removes the word "TextView" from the app and sets the value
        textView.setMovementMethod(new ScrollingMovementMethod());//needed to make the textView scroll

        View.OnClickListener ourOnClickListener = new View.OnClickListener() { //interface OnClickListener is defined in the View class
            @Override
            public void onClick(View v) {
//                String result;
//                numTimesClicked++;
//                if (numTimesClicked == 1) {
//                    result = "The button was pressed " + numTimesClicked + " time\n";
//                } else {
//                    result = "The button was pressed " + numTimesClicked + " times\n";
//                }
//                textView.append(result);

                String result = userInput.getText().toString(); //this needs to be java.lang.String, NOT android.text.Editable. Add toString()
                result = result + "\n";
                textView.append(result);

                userInput.setText(""); //makes the box blank after pressing the button
                //this function reminds me of adding items to a list, since when you click the button
                //it appears on the bottom, and the text box becomes empty


            }
        };

        button.setOnClickListener(ourOnClickListener);
        Log.d(TAG, "onCreate: out of the onCreate method");
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: in onStart method");
        super.onStart();
        Log.d(TAG, "onStart: out onStart method");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) { //this does not save permanently
        Log.d(TAG, "onRestoreInstanceState: in onRestoreInstanceState method");
        super.onRestoreInstanceState(savedInstanceState);
//        String savedString = savedInstanceState.getString(TEXT_CONTENTS); //retrieved the text contents and assigned it to the savedString
        textView.setText(savedInstanceState.getString(TEXT_CONTENTS)); //<-- shorter way than the command above
        Log.d(TAG, "onRestoreInstanceState: out onRestoreInstanceState method");
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: in onRestart method");
        super.onRestart();
        Log.d(TAG, "onRestart: out onRestart method");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: in onSaveInstanceState method");
        outState.putString(TEXT_CONTENTS, textView.getText().toString()); //saving the contents entered in the text value, <-- KEY, VALUE PAIR
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: out onSaveInstanceState method");
    }

    @Override
    protected void onPause() { //good for if you want to save data that you want to save permanently
        Log.d(TAG, "onPause: in onPause method");
        super.onPause();
        Log.d(TAG, "onPause: out onPause method");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: in onResume method");
        super.onResume();
        Log.d(TAG, "onResume: out onResume method");
    }

    @Override
    protected void onStop() { //could be used to cancel some sort of transfer
        Log.d(TAG, "onStop: in onStop method");
        super.onStop();
        Log.d(TAG, "onStop: out onStop method");
    }
}
