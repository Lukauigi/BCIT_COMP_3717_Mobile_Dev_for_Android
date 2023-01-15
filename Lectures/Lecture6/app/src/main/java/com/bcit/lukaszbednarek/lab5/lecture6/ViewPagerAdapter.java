package com.bcit.lukaszbednarek.lab5.lecture6;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * A simple pager adapter that represents 5 ExampleFragment objects, in
 * sequence.
 */
class ViewPagerAdapter extends FragmentStateAdapter {

    Cartoon[] cartoons;

    public ViewPagerAdapter(FragmentActivity fa, Cartoon[] cartoons) {
        super(fa);
        this.cartoons = cartoons;
    }

    @Override
    public Fragment createFragment(int position) {
        return CartoonFragment.newInstance(cartoons[position]);
    }

    @Override
    public int getItemCount() {
        return cartoons.length;
    }
}
