package com.edwardyi.bmi;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button calc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		calc = (Button)findViewById(R.id.cal_bmi);
//		當按鈕點擊時呼叫自己定義的calcBmi方法
//		calc.setOnClickListener(calcBmi);
//		由元件設定監聽事件來改寫監聽事件的方法
		Test listener = new Test();
		calc.setOnClickListener(listener);
	}
	
//	透過new物件來改寫onClick方法
	private OnClickListener calcBmi = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			EditText obj_weight = (EditText)findViewById(R.id.edit_weight);
			EditText obj_height = (EditText)findViewById(R.id.edit_height);
			double dbl_weight = Double.parseDouble(obj_weight.getText().toString());
			double dbl_height = Double.parseDouble(obj_height.getText().toString())/100;
			double dbl_Bmi = dbl_weight/(dbl_height*dbl_height);
			
			TextView obj_result = (TextView)findViewById(R.id.result);
//			型態轉換(從Double轉String)
			DecimalFormat df = new DecimalFormat("0.00");
			obj_result.setText("你的BMI為:"+df.format(dbl_Bmi));

			TextView obj_suggest = (TextView)findViewById(R.id.suggest);
			if(dbl_Bmi>25){
				obj_suggest.setText("Bmi值過高");
			}
			else if(dbl_Bmi<18){
				obj_suggest.setText("Bmi值過低");
			}
			else{
				obj_suggest.setText("Bmi剛剛好");
			}
		}
		
	};

	class Test implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			EditText obj_weight = (EditText)findViewById(R.id.edit_weight);
			EditText obj_height = (EditText)findViewById(R.id.edit_height);
			double dbl_weight = Double.parseDouble(obj_weight.getText().toString());
			double dbl_height = Double.parseDouble(obj_height.getText().toString())/100;
			double dbl_Bmi = dbl_weight/(dbl_height*dbl_height);
			
			TextView obj_result = (TextView)findViewById(R.id.result);
//						型態轉換(從Double轉String)
			DecimalFormat df = new DecimalFormat("0.00");
			obj_result.setText("你的BMI為:"+df.format(dbl_Bmi));

			TextView obj_suggest = (TextView)findViewById(R.id.suggest);
			if(dbl_Bmi>25){
				obj_suggest.setText("Bmi值過高");
			}
			else if(dbl_Bmi<18){
				obj_suggest.setText("Bmi值過低");
			}
			else{
				obj_suggest.setText("Bmi剛剛好");
			}
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
