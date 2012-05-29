package net.uguryildiz.android.kredihesaplama;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class KrediHesaplamaActivity extends Activity {
    private EditText oranText;
    private EditText vadeText;
    private EditText tutarText;
    private TextView taksitText;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
        taksitText = (TextView) findViewById(R.id.krediTaksit);
        oranText = (EditText) findViewById(R.id.krediOran);
        vadeText = (EditText) findViewById(R.id.krediVade);
        tutarText = (EditText) findViewById(R.id.krediTutar);
    }
    
    public void krediHesaplaClickHandler(View v) {
    	float oranValue = Float.parseFloat(oranText.getText().toString());
    	int vadeValue = Integer.parseInt(vadeText.getText().toString());
    	int tutarValue = Integer.parseInt(tutarText.getText().toString());    	
    	
    	int taksit = (int) ((tutarValue * (oranValue/100))/ (1 - (1 / Math.pow(( 1 + (oranValue/100)),vadeValue))));

    	taksitText.setText("Aylõk Taksit: " + Integer.toString(taksit) + " TL");
    	
    }
}