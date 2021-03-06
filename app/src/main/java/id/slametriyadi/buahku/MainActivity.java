package id.slametriyadi.buahku;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn_customgrid)
    Button btnCustomgrid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_customgrid})
    public void onViewClicked(View view) {
        Intent i = new Intent(this, BuahActivity.class);
        switch (view.getId()) {
            case R.id.btn_customgrid:
                i.putExtra("requestCode", 2);
                startActivity(i);
                break;
        }
    }
}
