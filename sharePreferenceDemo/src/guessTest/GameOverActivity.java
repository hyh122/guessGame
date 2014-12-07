package guessTest;

import com.example.sharepreferencedemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GameOverActivity extends Activity implements OnClickListener{
	private Button btn_tryAgain;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gameover);
		init();
	}
	private void init(){
		
		btn_tryAgain=(Button) findViewById(R.id.btn_tryagain);
		btn_tryAgain.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
				switch (v.getId()) {
				case R.id.btn_tryagain:
					
				
				finish();
					break;
				}
		
	}
}
