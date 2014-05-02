package com.devrakesh.chit_chat;

import com.scringo.Scringo;
import com.scringo.features.profile.ScringoSignUpListener;
import com.scringo.features.profile.ScringoUserAdapter;
import com.scringo.utils.ScringoUserRepository;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private Scringo scringo;
	
	private Button signUpButton;
	private EditText email;
	private EditText password;
	private EditText userName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		Scringo.setAppId("0tUSefQKJ8KeV7SYtrhWaFELfvRUoe5O");
		scringo=new Scringo(LoginActivity.this);
		
		scringo.init();
		
		initVars();
		
	}
	
	
	private void initVars()
	{
		signUpButton=(Button)findViewById(R.id.sign_up_button);
		signUpButton.setOnClickListener(new SignUpButtonListener());
		
		email=(EditText)findViewById(R.id.email_text);
		
		password=(EditText)findViewById(R.id.password_text);
		
		userName=(EditText)findViewById(R.id.user_name_text);
	}
	
	
	private void signUpUser()
	{
		Scringo.signUpWithEmail(email.getText().toString(), password.getText().toString(), userName.getText().toString(), 
								new signUpResultListener());
	}
	
	
	private class signUpResultListener implements ScringoSignUpListener
	{

		@Override
		public void onError(String arg0) {
			System.out.println("no no");
		}

		@Override
		public void onSuccess(String arg0) {
			System.out.println("okok");
			Scringo.loginWithEmail(email.getText().toString(), password.getText().toString(), new ScringoLogInListener());
		}
		
	}
	
	
	private class ScringoLogInListener implements ScringoSignUpListener
	{

		@Override
		public void onError(String arg0) {
			System.out.println("no no");
		}

		@Override
		public void onSuccess(String arg0) {
			System.out.println("okok");
		}
		
	}
	
	
	private class SignUpButtonListener implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			signUpUser();
			
		}
		
	}
	
	
	@Override
	protected void onStart() {
		super.onStart();
		scringo.onStart();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		scringo.onStop();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
