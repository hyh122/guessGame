package com.example.sharepreferencedemo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	// 姓名
	private EditText nameText;
	// 年龄
	private EditText ageText;
	// 显示结果
	private TextView resultText;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 获取文本框
		nameText = (EditText) this.findViewById(R.id.name);
		ageText = (EditText) this.findViewById(R.id.age);
		// 获取文本
		resultText = (TextView) this.findViewById(R.id.result);
		// 获取按钮
		Button save = (Button) this.findViewById(R.id.save);
		Button out = (Button) this.findViewById(R.id.out);
		save.setOnClickListener(listener);
		out.setOnClickListener(listener);
	}

	// 创建事件监听
	private View.OnClickListener listener = new View.OnClickListener() {
		public void onClick(View v) {
			Button button = (Button) v;
			// 获取实例
			SharedPreferences sp = MainActivity.this.getSharedPreferences(
					"soft", Context.MODE_PRIVATE);
			switch (button.getId()) {
			case R.id.save:
				// 获取值
				String name = nameText.getText().toString();
				String age = ageText.getText().toString();
				Editor editor = sp.edit();
				editor.putString("name", name);
				editor.putInt("age", new Integer(age));
				editor.commit();
				Toast.makeText(MainActivity.this, "保存成功！", 2).show();
				break;
			case R.id.out:
				String namet = sp.getString("name", "");
				int aget = sp.getInt("age", 1);
				resultText.setText("姓名：" + namet + "  年龄:" + aget);
				break;
			}
		}
	};
}
