package hello.sdeeney.com;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HelloAndroidActivity extends Activity {
	private SharedPreferences myPrefs; 
	private CharSequence text;
	private TextView tv;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        
        Button button = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.tv);
        final EditText textBox = (EditText) findViewById(R.id.editText);
        myPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        text = myPrefs.getString("text", null);
        ChangeText();
        
        textBox.setOnKeyListener(new OnKeyListener(){
        	
        	public boolean onKey(View v, int keyCode, KeyEvent event)
        	{
        		if(event.getAction()==KeyEvent.ACTION_DOWN && keyCode==KeyEvent.KEYCODE_ENTER)
        		{
        			text = textBox.getText();
        			ChangeText();
        			return true;
        		}
        		return false;
        	}
        });
        button.setOnClickListener(new OnClickListener(){
        	public void onClick(View view)
        	{
        		text = textBox.getText();
    			ChangeText();
        	}
        });
    }
    
    @Override
    public void onStart()
    {
    	super.onStart();
    	Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onResume()
    {
    	super.onResume();
    	Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onRestart()
    {
    	super.onRestart();
    	Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onPause()
    {
    	Editor editor= myPrefs.edit();
    	editor.putString("text", text.toString());
    	editor.commit();
    	Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    	
    	super.onPause();
    }
    @Override
    public void onStop()
    {
    	Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    	super.onStop();
    }
    @Override
    public void onDestroy()
    {
    	Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    	super.onDestroy();
    }
    
    private void ChangeText()
    {
    	tv.setText(text);
    	Toast.makeText(this, "Changed Text : " + text, Toast.LENGTH_SHORT).show();
    }
    private void saveState()
    {
    	
    }
    private void restoreState()
    {
    	
    }
    
    
}