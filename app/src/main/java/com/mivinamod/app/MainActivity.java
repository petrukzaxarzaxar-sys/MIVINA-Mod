
package com.mivinamod.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private int dp(float value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER_HORIZONTAL);
        root.setPadding(dp(24), dp(40), dp(24), dp(24));
        root.setBackgroundColor(Color.rgb(18, 18, 24));

        TextView title = new TextView(this);
        title.setText("Mivina_Mod");
        title.setTextSize(30);
        title.setTextColor(Color.WHITE);
        title.setGravity(Gravity.CENTER);
        root.addView(title, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, dp(70)));

        TextView subtitle = new TextView(this);
        subtitle.setText("Панель приложения");
        subtitle.setTextSize(16);
        subtitle.setTextColor(Color.LTGRAY);
        subtitle.setGravity(Gravity.CENTER);
        root.addView(subtitle);

        EditText keyInput = new EditText(this);
        keyInput.setHint("Введите ключ доступа");
        keyInput.setSingleLine(true);
        keyInput.setTextColor(Color.WHITE);
        keyInput.setHintTextColor(Color.GRAY);
        root.addView(keyInput, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, dp(60)));

        Button login = new Button(this);
        login.setText("Войти");
        root.addView(login, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, dp(56)));

        login.setOnClickListener(v -> {
            if (keyInput.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "Введите ключ", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,
                        "Проверка ключа ещё не подключена к серверу",
                        Toast.LENGTH_LONG).show();
            }
        });

        TextView modules = new TextView(this);
        modules.setText("\nМОДУЛИ\n\n• Авторизация\n• Срок действия ключа\n• Настройки");
        modules.setTextSize(17);
        modules.setTextColor(Color.WHITE);
        root.addView(modules);

        setContentView(root);
    }
}
