package com.example.ch2;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 创建并显示自定义对话框
        showLoginDialog();
    }

    private void showLoginDialog() {
        // 使用 LayoutInflater 加载自定义布局
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.dialog_login, null);

        // 创建 AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);

        // 获取布局中的组件
        EditText usernameEditText = dialogView.findViewById(R.id.username);
        EditText passwordEditText = dialogView.findViewById(R.id.password);
        Button btnCancel = dialogView.findViewById(R.id.btn_cancel);
        Button btnSignIn = dialogView.findViewById(R.id.btn_sign_in);

        // 创建并显示对话框
        AlertDialog dialog = builder.create();

        // 设置按钮点击事件
        btnCancel.setOnClickListener(v -> dialog.dismiss());
        btnSignIn.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            Toast.makeText(this, "Username: " + username + ", Password: " + password, Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        dialog.show();
    }
}
