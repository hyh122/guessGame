package guessTest;

import com.example.sharepreferencedemo.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
/**
 * 
 * @author hyh
 *
 */
public class GameActivity extends Activity implements OnClickListener{
	private TextView tv_level,tv_timer;
	private Button btn_guoguan,btn_false;
	SharedPreferences sp;
	private CountDownTimer cdt;
	Editor editor;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		init();
		
		int level = sp.getInt("level", 1);
		tv_level.setText(String.valueOf(level));
		startTimer();
		
		
	}
	private void init(){
		btn_guoguan=(Button) findViewById(R.id.btn_guoguan);
		btn_guoguan.setOnClickListener(this);
		btn_false=(Button) findViewById(R.id.btn_false);
		btn_false.setOnClickListener(this);
		tv_level=(TextView) findViewById(R.id.tv_level);
		tv_timer=(TextView) findViewById(R.id.tv_timer);
		// 获取实例
		sp = GameActivity.this.getSharedPreferences(
							"flag", Context.MODE_PRIVATE);
		editor = sp.edit();
	}
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		// 获取实例
		
				sp = GameActivity.this.getSharedPreferences(
									"flag", Context.MODE_PRIVATE);
				editor = sp.edit();
				int level = sp.getInt("level", 1);
				tv_level.setText(String.valueOf(level));
				
				startTimer();
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_guoguan:
			cdt.cancel();
			Intent intent;
			intent=new Intent(GameActivity.this,GameGuoguanActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_false:
			Intent intent1;
			intent1=new Intent(GameActivity.this,GameOverActivity.class);
			
			startActivity(intent1);
			break;
		}
	}
	
	public void startTimer(){
		/************************* 计时器开始计时 ********************/
		cdt = new CountDownTimer(20000, 100) {

			@Override
			public void onTick(long millisUntilFinished) {

				tv_timer.setText(String.valueOf(millisUntilFinished / 1000));
			}

			@Override
			public void onFinish() {
				cdt.cancel();
				Intent intent;
				intent=new Intent(GameActivity.this,GameOverActivity.class);
				
				startActivity(intent);
			}

		}.start();
		
		
	}
}
