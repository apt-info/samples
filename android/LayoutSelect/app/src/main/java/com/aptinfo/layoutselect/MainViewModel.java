package com.aptinfo.layoutselect;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class MainViewModel {
    private Context context;
    public final String text = "TextView";

    public MainViewModel(Context context) {
        this.context = context;
    }

    public void onClick() {
        Log.i("MainViewModel", "onClick");
        Toast.makeText(context, "TextView 클릭", Toast.LENGTH_SHORT).show();
    }

}
