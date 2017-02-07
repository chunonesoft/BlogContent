package com.chunsoft.blogcontent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.chunsoft.blogcontent.bean.User;
import com.chunsoft.blogcontent.presenter.impl.LoginPresenterImpl;
import com.chunsoft.blogcontent.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView{

    private EditText et_mobile,et_password;
    private ProgressBar pb;
    private Button btn_login;

    private LoginPresenterImpl mLoginPresenter = new LoginPresenterImpl(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_mobile = (EditText) findViewById(R.id.et_mobile);
        et_password = (EditText) findViewById(R.id.et_password);
        pb = (ProgressBar) findViewById(R.id.pb);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.login();
            }
        });
    }

    @Override
    public String getUserName() {
        return et_mobile.getText().toString();
    }

    @Override
    public String getPassword() {
        return et_password.getText().toString();
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb.setVisibility(View.INVISIBLE);
    }

    @Override
    public void toMainActvity(User user) {
        Toast.makeText(this,user.getUsername() + "登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
