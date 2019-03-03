package com.example.dell.renderscriptdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import android.widget.ImageView;

/**
 * 创建日期：2019/1/24
 * 作者:baiyang
 * 參考https://blog.csdn.net/huachao1001/article/details/51524502
 */
public class HelloRenderScriptActivity extends BaseActivity {
    private ImageView iv_src;
    private ImageView iv_dst;
    private Bitmap mInBitmap;
    private Bitmap mOutBitmap;

    @NonNull
    @Override
    protected String getActionBarTitle() {
        return "hello";
    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_hello);
        iv_src = (ImageView) findViewById(R.id.iv_src);
        iv_dst = (ImageView) findViewById(R.id.iv_dst);
    }

    @Override
    protected void initVariables() {
        mInBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        mOutBitmap = Bitmap.createBitmap(mInBitmap.getWidth(), mInBitmap.getHeight(), mInBitmap.getConfig());
        iv_src.setImageBitmap(mInBitmap);

        RenderScript rs = RenderScript.create(this);
        ScriptC_hello scriptC_hello = new ScriptC_hello(rs);

        Allocation fromBitmapAllocation = Allocation.createFromBitmap(rs, mInBitmap);
        Allocation outBitmapAllocation = Allocation.createFromBitmap(rs,mOutBitmap);


        scriptC_hello.forEach_root(fromBitmapAllocation, outBitmapAllocation);
        outBitmapAllocation.copyTo(mOutBitmap);
        iv_dst.setImageBitmap(mOutBitmap);
        rs.destroy();

    }

    @Override
    protected void loadData() {

    }
}
