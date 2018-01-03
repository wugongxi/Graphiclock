package com.example.wu.graphiclock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class LoginActivity extends Activity
{
	private LocusPassWordView lpwv;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity);
		setTitle("手势解锁");
		lpwv = (LocusPassWordView) this.findViewById(R.id.mLocusPassWordView);
		lpwv.setOnCompleteListener(new LocusPassWordView.OnCompleteListener()
		{
			@Override
			public void onComplete(String mPassword)
			{
				if (lpwv.verifyPassword(mPassword))
				{
					Toast.makeText(LoginActivity.this, "解锁成功", Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(LoginActivity.this, MainActivity.class);
					startActivity(intent);
					LoginActivity.this.finish();
				}
				else
				{
					Toast.makeText(LoginActivity.this, "解锁失败，请重新尝试", Toast.LENGTH_SHORT).show();
					lpwv.clearPassword();
				}
			}
		});

	}

	@Override
	protected void onStart()
	{
		super.onStart();
		View noSetPassword = (View) this.findViewById(R.id.tvNoSetPassword);
		if (lpwv.isPasswordEmpty())
		{
			noSetPassword.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					Intent intent = new Intent(LoginActivity.this, SetPasswordActivity.class);
					startActivity(intent);
				}

			});
			noSetPassword.setVisibility(View.VISIBLE);
		}
		else
		{
			noSetPassword.setVisibility(View.GONE);
		}
	}

	@Override
	protected void onStop()
	{
		super.onStop();
	}

}
