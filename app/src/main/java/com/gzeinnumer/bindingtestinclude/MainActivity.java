package com.gzeinnumer.bindingtestinclude;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Toast;

import com.gzeinnumer.bindingtestinclude.databinding.ActivityMainBinding;
import com.gzeinnumer.bindingtestinclude.databinding.ChildBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewStub stub = findViewById(R.id.layout_stub);
        stub.setLayoutResource(R.layout.child);
        View inflated = stub.inflate();
        ChildBinding b = ChildBinding.bind(inflated);

        b.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "text", Toast.LENGTH_SHORT).show();
            }
        });
    }
}