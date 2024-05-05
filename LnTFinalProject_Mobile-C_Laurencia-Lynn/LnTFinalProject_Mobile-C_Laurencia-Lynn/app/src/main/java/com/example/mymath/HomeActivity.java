package com.example.mymath;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    PagerAdapter pagerAdapter;
    Button plus, less, reset;
    TextView counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager2 = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tablayout);
        setViewPager2(viewPager2);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> tab.setText(pagerAdapter.getPageTitle(position))).attach();
        plus = findViewById(R.id.bt_plusplus);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.listmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int menu = item.getItemId();
        switch(menu) {
            case R.id.logout:
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setViewPager2 (ViewPager2 viewPager2) {
        if (pagerAdapter == null) {
            pagerAdapter = new PagerAdapter(this);
            pagerAdapter.addFragment(new Fragment1(), "Counter");
            pagerAdapter.addFragment(new Fragment2(), "Area");
            pagerAdapter.addFragment(new Fragment3(), "Volume");
            viewPager2.setAdapter(pagerAdapter);
        }
    }
}