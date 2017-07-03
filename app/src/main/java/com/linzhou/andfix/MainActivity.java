package com.linzhou.andfix;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public Button update;
    public TextView tv;

    private static final String APATCH_PATH = "/fix.apatch"; // 补丁文件名

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        update= (Button) findViewById(R.id.update);
        tv= (TextView) findViewById(R.id.tv);

        tv.setText("new");
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String patchFileStr = Environment.getExternalStorageDirectory().getAbsolutePath() + APATCH_PATH;
                try {
                    Myapp.mPatchManager.addPatch(patchFileStr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast();
            }
        });




    }

    //旧方法，1.apk

    private void toast() {
        Toast.makeText(this, "new", Toast.LENGTH_SHORT).show();
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
