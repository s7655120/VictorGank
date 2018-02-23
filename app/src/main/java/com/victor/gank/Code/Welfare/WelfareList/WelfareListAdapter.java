package com.victor.gank.Code.Welfare.WelfareList;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.victor.gank.Data.Welfare.Welfare;
import com.victor.gank.R;

/**
 * Created by Victor on 2017/8/2.
 */
public class WelfareListAdapter extends BaseQuickAdapter<Welfare, BaseViewHolder> {

    public WelfareListAdapter() {
        super(R.layout.item_welfare_list);
    }

    @Override
    protected void convert(BaseViewHolder helper, Welfare item) {
        Glide.with(mContext).load(item.getUrl()).into((ImageView) helper.getView(R.id.iv_welfare));

    }
}
