package id.sch.smktelkom_mlg.learn.intent2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

public class InputActivity extends AppCompatActivity {

    public static final String NAMA = "Nama";
    public static final String TAHUN_LAHIR = "TahunLahir";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        findViewById(R.id.buttonFinish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etNama = (EditText) findViewById(R.id.editTextNama);
                EditText etThLhr = (EditText) findViewById(R.id.editTextThnLhr);
                String nama = etNama.getText().toString();
                String thnLhrStr = etThLhr.getText().toString();

                int thnLhr = thnLhrStr.isEmpty() ?
                        Calendar.getInstance().get(Calendar.YEAR) :
                        Integer.parseInt(thnLhrStr);

                Intent intent = new Intent();
                intent.putExtra(NAMA, nama);
                intent.putExtra(TAHUN_LAHIR, thnLhr);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
