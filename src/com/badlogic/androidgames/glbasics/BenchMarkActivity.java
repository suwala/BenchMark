package com.badlogic.androidgames.glbasics;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.widget.EditText;

public class BenchMarkActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		final EditText et = new EditText(this);
		et.setInputType(InputType.TYPE_CLASS_NUMBER);
		new AlertDialog.Builder(this).setMessage("表示するオブジェクトの数を入力して下さい")
			.setView(et).setPositiveButton("OK", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					
					Intent intent = new Intent(BenchMarkActivity.this,OptimizationReimuTest.class);
					if(et.getText().toString().equals(""))
						et.setText("100");
					intent.putExtra("et", Integer.valueOf(et.getText().toString()));
					startActivity(intent);
				}
			}).
			setOnKeyListener(new OnKeyListener() {
				
				@Override
				public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
					
					if(event.getKeyCode() == KeyEvent.KEYCODE_BACK)
						finish();
					return false;
				}
			}).show();
	}
}
