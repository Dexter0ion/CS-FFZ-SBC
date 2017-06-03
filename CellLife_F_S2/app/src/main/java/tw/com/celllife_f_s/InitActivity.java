package tw.com.celllife_f_s;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class InitActivity extends AppCompatActivity {

    private static final String TAG = "InitActivity";
    public static CellProcess cellprocess;
    int width;
    int height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        width = intent.getIntExtra("width",-1);
        height = intent.getIntExtra("height",-1);
        cellprocess = new CellProcess(width,height);
        setContentView(new InitView(this,cellprocess));
    }
}
