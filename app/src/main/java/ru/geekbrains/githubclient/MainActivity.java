package ru.geekbrains.githubclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ru.geekbrains.githubclient.mvp.presenter.Presenter;
import ru.geekbrains.githubclient.mvp.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    private Presenter presenter;

    private Button buttonCounter1;
    private Button buttonCounter2;
    private Button buttonCounter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this);

        buttonCounter1 = findViewById(R.id.btn_counter1);
        buttonCounter2 = findViewById(R.id.btn_counter2);
        buttonCounter3 = findViewById(R.id.btn_counter3);

        buttonCounter1.setOnClickListener(v -> presenter.counterClick(0));
        buttonCounter2.setOnClickListener(v -> presenter.counterClick(1));
        buttonCounter3.setOnClickListener(v -> presenter.counterClick(2));

    }

    @Override
    public void setButtonText(int index, String text) {
        switch (index) {
            case 0:
                buttonCounter1.setText(text);
                break;
            case 1:
                buttonCounter2.setText(text);
                break;
            case 2:
                buttonCounter3.setText(text);
                break;
        }
    }
}