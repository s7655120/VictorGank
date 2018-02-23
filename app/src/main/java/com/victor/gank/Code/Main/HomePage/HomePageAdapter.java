package com.victor.gank.Code.Main.HomePage;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.victor.gank.Data.Main.HomePage.GankData;
import com.victor.gank.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by Victor on 2017/8/2.
 */
public class HomePageAdapter extends BaseQuickAdapter<GankData, BaseViewHolder> {

    public HomePageAdapter(){
        super(R.layout.item_home_page);
    }
    ImageView imgView;
    @Override
    protected void convert(BaseViewHolder helper, GankData item) {
        helper.setText(R.id.tv, item.getTitle());
        String str = item.getContent();
        // JSoup 解析

        Document document = Jsoup.parse(str);
        Elements pngs = document.select("img");
        String src = pngs.attr("src");
        Log.e("test","src = " + src);
        imgView = helper.getView(R.id.iv);
        imgView.setColorFilter(0x5e000000);
        Glide.with(mContext).load(src).into(imgView);

        imgView.setOnTouchListener(new touchListener(helper));
    }

    private class touchListener implements View.OnTouchListener{

        private BaseViewHolder mHelper;
        private ImageView mIV;

        public touchListener(BaseViewHolder helper) {
            this.mHelper = helper;
            this.mIV = mHelper.getView(R.id.iv);
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                mIV.clearColorFilter();
                View parent = (View) mHelper.itemView.getParent();
                if(parent != null){
                    parent.setOnTouchListener(this);
                }
            } else if(event.getAction() == MotionEvent.ACTION_UP){
                mIV.setColorFilter(0x5e000000);
            }
            return false;
        }
    }


}
