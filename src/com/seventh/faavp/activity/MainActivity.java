package com.seventh.faavp.activity;

import java.lang.reflect.Field;

import com.seventh.faavp.adapter.TestViewPagerAdapter;
import com.seventh.faavp.R;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

	public final static int TAB_INDEX_1 = 0;
	public final static int TAB_INDEX_2 = 1;
	public final static int TAB_INDEX_3 = 2;
	public final static int TAB_INDEX_4 = 3;
	public final static int TAB_COUNT = 4;

	private ViewPager mViewPager;
	private ScrollView mscrollview;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initListener();
		getOverflowMenu();
	}
	private void initView(){
		mscrollview=(ScrollView) findViewById(R.id.mlist);
		
		ActionBar actionbar=getActionBar();
		actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionbar.setDisplayHomeAsUpEnabled(true);
		
		// 创建Tab
		setupTest1();
		setupTest2();
		setupTest3();
		setupTest4();
		
		// 创建 view pager
		mViewPager = (ViewPager)findViewById(R.id.pager);
		getFragmentManager();

		mViewPager.setAdapter(new TestViewPagerAdapter(getSupportFragmentManager()));
		mViewPager.setCurrentItem(TAB_INDEX_1);
	}
	private void initListener(){
		mViewPager.setOnPageChangeListener(new TestPagerListener());
	}
	
	private void setupTest1(){
		Tab tab = this.getActionBar().newTab();
		tab.setContentDescription("Tab 1");
		tab.setText("Tab 1");
		tab.setTabListener(mTabListener);
		getActionBar().addTab(tab);
	}

	private void setupTest2(){
		Tab tab = this.getActionBar().newTab();
		tab.setContentDescription("Tab 2");
		tab.setText("Tab 2");
		tab.setTabListener(mTabListener);
		getActionBar().addTab(tab);
	}

	private void setupTest3(){
		Tab tab = this.getActionBar().newTab();
		tab.setContentDescription("Tab 3");
		tab.setText("Tab 3");
		tab.setTabListener(mTabListener);
		getActionBar().addTab(tab);
	}

	private void setupTest4(){
		Tab tab = this.getActionBar().newTab();
		tab.setContentDescription("Tab 4");
		tab.setText("Tab 4");
		tab.setTabListener(mTabListener);
		getActionBar().addTab(tab);
	}

	private final TabListener mTabListener = new TabListener() {
		private final static String TAG = "TabListener";
		@Override
		public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {
			// Tab被选中后用户再次选中该Tab所执行的代码，通常不做任何事情
			Log.d(TAG, "onTabReselected");
		}

		@Override
		public void onTabSelected(Tab tab, android.app.FragmentTransaction ft) {
			// Tab选中时要执行的代码
			Log.d(TAG, "onTabSelected()");
			if (mViewPager != null)
				mViewPager.setCurrentItem(tab.getPosition());
		}

		@Override
		public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {
			// Tab离开选中状态时执行的代码
			Log.d(TAG, "onTabUnselected()");
		}
	};

	class TestPagerListener implements OnPageChangeListener{
		@Override
		public void onPageScrollStateChanged(int arg0) {
			mscrollview.setVisibility(View.INVISIBLE);
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		
		}

		@Override
		public void onPageSelected(int arg0) {
			getActionBar().selectTab(getActionBar().getTabAt(arg0));
		}
	}
	
	/**
	 * 三点菜单
	 */
	private void getOverflowMenu() {
	     try {
	        ViewConfiguration config = ViewConfiguration.get(this);
	        Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
	        if(menuKeyField != null) {
	            menuKeyField.setAccessible(true);
	            menuKeyField.setBoolean(config, false);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast.makeText(getApplicationContext(), item.getTitle()+"", Toast.LENGTH_SHORT).show();
		if (item.getTitle().toString().trim().equals("Search")) {
		}
		else if (item.getTitle().toString().trim().equals("Settings")) {
			
		} 
		else if (item.getTitle().toString().trim().equals("About")) {
			
		}
		else if (item.getTitle().toString().trim().equals("Exit")) {
		}
		else if (item.getTitle().toString().trim().equals("test")){
			if(mscrollview.getVisibility()==View.INVISIBLE)
				mscrollview.setVisibility(View.VISIBLE);
			else 
				mscrollview.setVisibility(View.INVISIBLE);
		}
		return super.onOptionsItemSelected(item);
	}
}
