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

	// ����
	private EditText nameText;
	// ����
	private EditText ageText;
	// ��ʾ���
	private TextView resultText;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// ��ȡ�ı���
		nameText = (EditText) this.findViewById(R.id.name);
		ageText = (EditText) this.findViewById(R.id.age);
		// ��ȡ�ı�
		resultText = (TextView) this.findViewById(R.id.result);
		// ��ȡ��ť
		Button save = (Button) this.findViewById(R.id.save);
		Button out = (Button) this.findViewById(R.id.out);
		save.setOnClickListener(listener);
		out.setOnClickListener(listener);
	}

	// �����¼�����
	private View.OnClickListener listener = new View.OnClickListener() {
		public void onClick(View v) {
			Button button = (Button) v;
			// ��ȡʵ��
			SharedPreferences sp = MainActivity.this.getSharedPreferences(
					"soft", Context.MODE_PRIVATE);
			switch (button.getId()) {
			case R.id.save:
				// ��ȡֵ
				String name = nameText.getText().toString();
				String age = ageText.getText().toString();
				Editor editor = sp.edit();
				editor.putString("name", name);
				editor.putInt("age", new Integer(age));
				editor.commit();
				Toast.makeText(MainActivity.this, "����ɹ���", 2).show();
				break;
			case R.id.out:
				String namet = sp.getString("name", "");
				int aget = sp.getInt("age", 1);
				resultText.setText("������" + namet + "  ����:" + aget);
				break;
			}
		}
	};
}
