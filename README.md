# BindingTestInclude
 ViewStup

- `build.gradle`
```gradle
buildFeatures{
    viewBinding = true
}
```

- `child.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    android:orientation="vertical"
    xmlns:android="http://schemas.android.com/apk/res/android" android:layout_width="match_parent"
    android:layout_height="match_parent">

    <Button
        android:id="@+id/btn"
        android:text="btn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
</LinearLayout>
```

- `activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <ViewStub
        android:id="@+id/layout_stub"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

</LinearLayout>
```

- `MainActivity.java`
```java
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
```

---

```
Copyright 2021 M. Fadli Zein
```