package guessTest;

import com.example.sharepreferencedemo.R;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GameGuoguanActivity extends Activity implements OnClickListener{
	private Button btn_next;
	SharedPreferences sp;
	Editor editor;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gameguoguan);
		init();
	}
	private void init(){
		btn_next=(Button) findViewById(R.id.btn_next);
		btn_next.setOnClickListener(this);
		
		// »ñÈ¡ÊµÀý
		sp = GameGuoguanActivity.this.getSharedPreferences(
							"flag", Context.MODE_PRIVATE);
		editor = sp.edit();
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_next:
			
		int level=sp.getInt("level",1);
		
			editor.putInt("level", level+1);
			editor.commit();
			finish();
			break;
		}
	}
}
