package tw.com.celllife_f_s;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.commit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int width = Integer.parseInt(((EditText)findViewById(R.id.editWidth)).getText().toString());
                int height = Integer.parseInt(((EditText)findViewById(R.id.editHeight)).getText().toString());
                Log.i(TAG, "onClick: width "+ width );
                Log.i(TAG, "onClick: height "+ height );
                Intent intent = new Intent(MainActivity.this,InitActivity.class);
                intent.putExtra("width",width);
                intent.putExtra("height",height);
                startActivity(intent);
            }
        });
    }
}
