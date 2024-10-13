package g324.klokov.lab02unitconvert;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView, textView1, result;
    private EditText from_1;
    private Spinner unit_1, unit_2;
    private Button convert;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        from_1 = findViewById(R.id.from_1);
        unit_1 = findViewById(R.id.unit_1);
        unit_2 = findViewById(R.id.unit_2);
        convert= findViewById(R.id.convert);

        ArrayAdapter <String> adp = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);

        adp.add("mm");
        adp.add("cm");
        adp.add("m");
        adp.add("km");

        unit_1.setAdapter(adp);
        unit_2.setAdapter(adp);
        }

        public void on_convert(View v)
        {
            try {
                double from = Double.parseDouble(from_1.getText().toString());
                String unit_01 = (String) unit_1.getSelectedItem();
                String unit_02 = (String) unit_2.getSelectedItem();

                double m = 1., to = 1.;

                if (unit_01.equals("mm")) m = from / 1000.;
                if (unit_01.equals("cm")) m = from / 100.;
                if (unit_01.equals("m")) m = from / 1.;
                if (unit_01.equals("km")) m = from * 1000.;

                if (unit_02.equals("mm")) to = m * 1000.;
                if (unit_02.equals("cm")) to = m * 100.;
                if (unit_02.equals("m")) to = m * 1.;
                if (unit_02.equals("km")) to = m / 1000.;

                result.setText(String.valueOf(to));
            }
            catch (Exception e)
            {
                result.setText(String.valueOf("Enter a number!"));
            }


        }
    }