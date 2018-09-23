package com.example.sachinkmr.di;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import javax.inject.Inject;

/* Here, MainActivity is the dependent which requires dependency of SharedPreferences, Context
and Resources or in simple term we are injecting the objects.
So, in the code below injecting the dependency for the same. */
public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Inject
    SharedPreferences pref;

    @Inject
    Context context;

    @Inject
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.text);

        // Injecting the reference of MainActivity.
        ((MyApplication)getApplication()).getAppComponent().inject(this);

        //using pref reference via DI..
        pref.edit().putInt("Num",1).apply();

        Log.e("PrefVal:",String.valueOf(pref.getInt("Num",0)));

        //using context reference via DI..
        mTextView.setBackgroundColor(context.getResources().getColor(android.R.color.holo_purple));

        //using resource reference via DI..
        Log.e("PrefVal1:",String.valueOf(resources.getColor(android.R.color.holo_purple)));

    }
}

