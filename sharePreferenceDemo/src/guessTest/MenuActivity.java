package guessTest;

import com.example.sharepreferencedemo.MainActivity;
import com.example.sharepreferencedemo.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuActivity extends Activity implements OnClickListener{
	private Button btn_one,btn_two,btn_three,btn_four;
	
	SharedPreferences sp;
	Editor editor;
	Intent intent;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		init();
}
private void init(){
	btn_one=(Button) findViewById(R.id.btn_one);
	btn_one.setOnClickListener(this);
	
	btn_two=(Button) findViewById(R.id.btn_two);
	btn_two.setOnClickListener(this);
	
	btn_three=(Button) findViewById(R.id.btn_three);
	btn_three.setOnClickListener(this);
	
	btn_four=(Button) findViewById(R.id.btn_four);
	btn_four.setOnClickListener(this);
	
	// »ñÈ¡ÊµÀý
	sp = MenuActivity.this.getSharedPreferences(
						"flag", Context.MODE_PRIVATE);
	editor = sp.edit();
	
	intent=new Intent(MenuActivity.this,GameActivity.class);
}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_one:
			
		
			editor.putInt("level", 1);
			editor.commit();
			startActivity(intent);
			break;
		case R.id.btn_two:
			editor.putInt("level", 2);
			editor.commit();
			startActivity(intent);
			break;
		case R.id.btn_three:
			editor.putInt("level", 3);
			editor.commit();
			startActivity(intent);
			break;
		case R.id.btn_four:
			editor.putInt("level", 4);
			editor.commit();
			startActivity(intent);
			break;
		
		}
		
	}
}