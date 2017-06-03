package tw.com.celllife_f_s;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final char[] MOKKEY = {
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,1,1,1,0,1,1,1,0,0,0,0,0,0,0,0,
            0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,
            0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,
            0,0,1,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,
            0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,
            0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,
            0,1,1,1,0,1,0,0,0,0,0,1,0,1,1,1,0,0,0,0,
            0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,
            0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,
            0,0,0,0,0,1,0,0,0,1,0,0,1,0,0,1,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,1,1,0,0,1,1,1,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,
            0,0,0,1,1,1,1,0,0,1,1,1,1,1,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0



    };
    public static final char[] CHINA = {
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,1,0,0,1,0,0,0,1,1,1,0,1,0,1,0,0,1,1,1,
            0,1,0,0,1,0,0,0,1,0,1,0,1,0,1,0,0,1,0,0,
            0,1,0,0,1,0,0,0,1,0,1,0,1,0,1,0,0,1,1,1,
            0,1,0,0,1,0,0,0,1,0,1,0,1,0,1,0,0,1,0,0,
            0,1,0,0,1,1,1,0,1,1,1,0,0,1,0,0,0,1,1,1,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            1,1,1,0,1,0,1,0,0,1,0,0,0,1,0,1,0,0,1,0,
            1,0,0,0,1,0,1,0,0,1,0,0,0,1,1,0,0,1,0,1,
            1,0,0,0,1,1,1,0,0,1,0,0,0,1,1,0,0,1,0,1,
            1,0,0,0,1,0,1,0,0,1,0,0,0,1,0,1,0,1,1,1,
            1,1,1,0,1,0,1,0,0,1,0,0,0,1,0,1,0,1,0,1,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.commit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int width = Integer.parseInt(((EditText)findViewById(R.id.editWidth)).getText().toString());
                int height = Integer.parseInt(((EditText)findViewById(R.id.editHeight)).getText().toString());
                Intent intent = new Intent(MainActivity.this,InitActivity.class);
                intent.putExtra("width",width);
                intent.putExtra("height",height);
                intent.putExtra("default",false);
                startActivity(intent);
            }
        });
        findViewById(R.id.monkey).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,InitActivity.class);
                intent.putExtra("width",20);
                intent.putExtra("height",20);
                intent.putExtra("default",true);
                intent.putExtra("data",MOKKEY);
                intent.putExtra("type",1);
                startActivity(intent);
            }
        });
        findViewById(R.id.china).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,InitActivity.class);
                intent.putExtra("width",20);
                intent.putExtra("height",20);
                intent.putExtra("default",true);
                intent.putExtra("data",CHINA);
                intent.putExtra("type",2);
                startActivity(intent);
            }
        });
    }
}
