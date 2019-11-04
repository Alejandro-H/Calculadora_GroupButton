package android.radiobuttons;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
public class MainActivity extends AppCompatActivity {
    public EditText edtnumero1,edtnumero2,edtresultado;
    public RadioButton rbtsuma,rbtresta,rbtproducto,rbtdivision;
    public RadioGroup grupocal;
    public Button btnnuevo;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtnumero1=(EditText)findViewById(R.id.edtnumero1);
        edtnumero2=(EditText)findViewById(R.id.edtnumero2);
        edtresultado=(EditText)findViewById(R.id.edtresultado);
        rbtsuma=(RadioButton)findViewById(R.id.rbtsuma);
        rbtresta=(RadioButton)findViewById(R.id.rbtresta);
        rbtproducto=(RadioButton)findViewById(R.id.rbtproducto);
        rbtdivision=(RadioButton)findViewById(R.id.rbtdivision);
        btnnuevo=(Button)findViewById(R.id.btnnuevo);
        grupocal=(RadioGroup)findViewById(R.id.grupocal);
        grupocal.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String num1=edtnumero1.getText().toString();
                String num2=edtnumero2.getText().toString();

                Double n1= Double.parseDouble(num1);
                Double n2= Double.parseDouble(num2);
                Double res=0.0;
                if (checkedId==R.id.rbtsuma){
                    res=n1+n2;
                }else if (checkedId==R.id.rbtresta){

                    res=n1-n2;
                }else if (checkedId==R.id.rbtproducto){
                    res=n1*n2;
                }else if (checkedId==R.id.rbtdivision){
                    res=n1/n2;
                }
                edtresultado.setText(String.valueOf(res));
                edtresultado.setEnabled(false);
            }
        });
        btnnuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grupocal.clearCheck();
                edtnumero1.setText(" ");
                edtnumero2.setText("");
                edtresultado.setText("");
                edtnumero1.requestFocus();
            }
        });
    }
}
