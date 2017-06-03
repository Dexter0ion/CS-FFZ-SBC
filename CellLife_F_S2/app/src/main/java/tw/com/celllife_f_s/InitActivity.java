package tw.com.celllife_f_s;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Arrays;

public class InitActivity extends AppCompatActivity {

    private static final String TAG = "InitActivity";
    public static CellProcess cellprocess;
    public static int SCREENWIDTH;
    public static int SCREENHEIGHT;
    int width;
    int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SCREENWIDTH = getResources().getDisplayMetrics().widthPixels;
        SCREENHEIGHT = getResources().getDisplayMetrics().heightPixels;
        Intent intent = getIntent();
        width = intent.getIntExtra("width", -1);
        height = intent.getIntExtra("height", -1);
        char[] data = null;
        if (!intent.getBooleanExtra("default", false)) {
            data = new char[width * height];
            for (int i = 0; i < width * height; i++) {
                data[i] = 0;
            }
        } else {
            if (intent.getIntExtra("type", 0) == 1)
                data = Arrays.copyOf(MainActivity.MOKKEY, MainActivity.MOKKEY.length);
            else if (intent.getIntExtra("type", 0) == 2)
                data = Arrays.copyOf(MainActivity.CHINA, MainActivity.CHINA.length);
        }
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(SCREENWIDTH, SCREENWIDTH / 3);
        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(SCREENWIDTH, SCREENHEIGHT / 3 * 2);
        cellprocess = new CellProcess(data, width, height);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        InitView initView = new InitView(this, cellprocess);
        initView.setLayoutParams(lp2);
        linearLayout.addView(initView);
        Button button = new Button(this);
        button.setText("START");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InitActivity.this, DisplayActivity.class));
            }
        });
        button.setLayoutParams(lp);
        linearLayout.addView(button);
        setContentView(linearLayout);
    }
}
