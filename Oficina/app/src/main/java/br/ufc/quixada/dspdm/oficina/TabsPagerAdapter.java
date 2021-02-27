package br.ufc.quixada.dspdm.oficina;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {
    private static final int NUM_TABS = 2;

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return oficinaTab.newInstance();
            default:
                return HistoricoTab.newInstance();
        }
    }

    @Override
    public int getCount() {
        return NUM_TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0){
            return "Oficinas";
        }

        return "Historico";
    }
}
