package com.edwardyi.checkboxprj;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;



public class MainActivity extends ActionBarActivity {
	private CheckBox cb1;
	private CheckBox cb2;
	private CheckBox cb3;
	private CheckBox cb4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb1 = (CheckBox)findViewById(R.id.cb1);
        cb2 = (CheckBox)findViewById(R.id.cb2);
        cb3 = (CheckBox)findViewById(R.id.cb3);
        cb4 = (CheckBox)findViewById(R.id.cb4);
//        OnButtonClickListener listener = new OnButtonClickListener();
//        cb1.setOnClickListener(listener);
        Abc abc = new Abc();
        cb4.setOnCheckedChangeListener(abc);
        
        
        
        
    }
    class Abc implements OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			// TODO Auto-generated method stub
			if(buttonView.getId()==R.id.cb4 && isChecked){
				cb1.setChecked(true);
				cb2.setChecked(true);
				cb3.setChecked(true);
			}
			if(buttonView.getId()==R.id.cb4 && !isChecked){
				cb1.setChecked(false);
				cb2.setChecked(false);
				cb3.setChecked(false);
			}
			
		}
    	
    }
//    class OnButtonClickListener implements OnClickListener{
//
//		@Override
//		public void onClick(View v) {
//			
//			v.getId();
//			System.out.print("Checked!");
//		}
//    	
//    }
    
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
