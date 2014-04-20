package com.seventh.faavp.adapter;

import com.seventh.faavp.activity.MainActivity;
import com.seventh.faavp.fragment.Tab1Fragment;
import com.seventh.faavp.fragment.Tab2Fragment;
import com.seventh.faavp.fragment.Tab3Fragment;
import com.seventh.faavp.fragment.Tab4Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TestViewPagerAdapter extends FragmentPagerAdapter {

	public TestViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		switch (arg0) {
		case MainActivity.TAB_INDEX_1:
			return new Tab1Fragment();

		case MainActivity.TAB_INDEX_2:
			return new Tab2Fragment();

		case MainActivity.TAB_INDEX_3:
			return new Tab3Fragment();

		case MainActivity.TAB_INDEX_4:
			return new Tab4Fragment();
		}
		throw new IllegalStateException("No fragment at position " + arg0);
	}

	@Override
	public int getCount() {
		return MainActivity.TAB_COUNT;
	}
}
