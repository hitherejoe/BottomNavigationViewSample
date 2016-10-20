package bottomnav.hitherejoe.com.bottomnavigationsample;

public enum ViewPagerEnum {

    FAVORITES(R.string.text_favorites, R.layout.view_favorites),
    SCHEDULES(R.string.text_schedules, R.layout.view_schedules),
    MUSIC(R.string.text_music, R.layout.view_music);

    private int mTitleResId;
    private int mLayoutResId;

    ViewPagerEnum(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}