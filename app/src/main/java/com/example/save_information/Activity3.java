package com.example.save_information;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.save_information.databinding.CoolmarketBinding;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CoolmarketBinding binding = CoolmarketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + binding.phone.getText().toString()));
                startActivity(intent);
            }
        });

        binding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"my@yandex.ru"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Доставка продуктов");

                StringBuilder text = new StringBuilder("Мой заказ: ");
                for (int j = 0; j < 2; j++) {
                    LinearLayout ll = (LinearLayout) binding.products.getChildAt(j);
                    for (int i = 0; i < ll.getChildCount(); i++) {
                        CheckBox box = (CheckBox) ll.getChildAt(i);
                        if (box.isChecked()) text.append(box.getText().toString() + ", ");
                    }
                }

                RadioGroup rr = binding.group;
                for (int i = 0; i < rr.getChildCount(); i++) {
                    RadioButton but = (RadioButton) rr.getChildAt(i);
                    if (but.isChecked())
                        text.append("\nСпособ доставки: " + but.getText().toString());
                }

                text.append("\nКомментарий: " + binding.message.getText().toString());

                //binding.TV.setText(text);

                intent.putExtra(Intent.EXTRA_TEXT, text.toString());
                startActivity(intent);
            }
        });
    }
}
