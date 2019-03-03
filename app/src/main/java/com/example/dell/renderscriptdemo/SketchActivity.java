package com.example.dell.renderscriptdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.example.dell.renderscriptdemo.util.SketchUtil;

/**
 * 创建日期：2019/3/1
 * 作者:baiyang
 */
public class SketchActivity extends BaseActivity {
    private ImageView iv_src;
    private ImageView iv_dst;
    @NonNull
    @Override
    protected String getActionBarTitle() {
        return "Sketch素描效果";
    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_sketch);
        iv_src = (ImageView) findViewById(R.id.iv_src);
        iv_dst = (ImageView) findViewById(R.id.iv_dst);
    }

    @Override
    protected void initVariables() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        iv_src.setImageBitmap(bitmap);
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        Bitmap sketchBitmap = SketchUtil.sketchBitmap(bitmap1, mContext);
        iv_dst.setImageBitmap(sketchBitmap);
    }

    @Override
    protected void loadData() {

    }
}
