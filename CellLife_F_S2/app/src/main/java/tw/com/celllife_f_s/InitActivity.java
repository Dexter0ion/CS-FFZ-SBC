package tw.com.celllife_f_s;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class InitActivity extends AppCompatActivity {

    private static final String TAG = "InitActivity";
    public static CellProcess cellprocess;
    int width;
    int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        width = intent.getIntExtra("width", -1);
        height = intent.getIntExtra("height", -1);
        char[] data = new char[width * height];
        for (int i = 0; i < width * height; i++) {
            data[i] = 0;
        }
        cellprocess = new CellProcess(data, width, height);
        setContentView(new InitView(this, cellprocess));
    }
}
