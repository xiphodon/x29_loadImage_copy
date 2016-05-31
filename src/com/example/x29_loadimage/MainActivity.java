package com.example.x29_loadimage;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.BitmapFactory.Options;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //加载缩放图片
    public void click(View v){
    	//解析图片需要的参数都封装在这个对象里
    	Options opt = new Options();
    	//设置为仅获取图片宽高
    	opt.inJustDecodeBounds = true;
    	BitmapFactory.decodeFile("sdcard/wolf.bmp", opt);
    	//拿到图片宽高
    	int imageWidth = opt.outWidth;
    	int imageHeight = opt.outHeight;
    	
    	//拿到手机屏幕宽高
    	Display dp = getWindowManager().getDefaultDisplay();
    	int screenWidth = dp.getWidth();
    	int screenHeight = dp.getHeight();
    	
    	//计算缩放比例
    	int scale = 1;
    	int scaleWidth = imageWidth / screenWidth;
    	int scaleHeight = imageHeight / screenHeight;
    	if(scaleWidth >= scaleHeight && scaleWidth > 1){
    		scale = scaleWidth;
    	}else if(scaleHeight > scaleWidth && scaleHeight > 1){
    		scale = scaleHeight;
    	}
    	
    	//设置缩放比例
    	opt.inSampleSize = scale;
    	opt.inJustDecodeBounds = false;
    	Bitmap bm = BitmapFactory.decodeFile("sdcard/wolf.bmp", opt);
    	
    	ImageView iv = (ImageView) findViewById(R.id.iv);
    	iv.setImageBitmap(bm);
    }
    
    
    //加载缩放图片副本
    public void click2(View v){
    	
    	//解析图片需要的参数都封装在这个对象里
    	Options opt = new Options();
    	//设置为仅获取图片宽高
    	opt.inJustDecodeBounds = true;
    	BitmapFactory.decodeFile("sdcard/wolf.bmp", opt);
    	//拿到图片宽高
    	int imageWidth = opt.outWidth;
    	int imageHeight = opt.outHeight;
    	
    	//拿到手机屏幕宽高
    	Display dp = getWindowManager().getDefaultDisplay();
    	int screenWidth = dp.getWidth();
    	int screenHeight = dp.getHeight();
    	
    	//计算缩放比例
    	int scale = 1;
    	int scaleWidth = imageWidth / screenWidth;
    	int scaleHeight = imageHeight / screenHeight;
    	if(scaleWidth >= scaleHeight && scaleWidth > 1){
    		scale = scaleWidth;
    	}else if(scaleHeight > scaleWidth && scaleHeight > 1){
    		scale = scaleHeight;
    	}
    	
    	//设置缩放比例
    	opt.inSampleSize = scale;
    	opt.inJustDecodeBounds = false;
    	//此对象是只读对象
    	Bitmap bm = BitmapFactory.decodeFile("sdcard/wolf.bmp", opt);
    	
//    	*******************************************************
    	//开始复制副本
    	
    	//1.在内存中创建一个和原图一样大小的Bitmap对象（创建白纸）____此对象可读可写
    	Bitmap bmCopy = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), bm.getConfig());
    	
    	//2.创建画笔对象
    	Paint paint = new Paint();
    	
    	//3.创建画板对象，把白纸放在画板上
    	Canvas canvas = new Canvas(bmCopy);
    	
    	//矩阵
    	Matrix mt = new Matrix();
    	
    	
//    	---------------------
    	
    	//平移
//    	mt.setTranslate(20, 30);
    	//缩放                  （ 横轴缩放比例，纵轴缩放比例，缩放的中心坐标横标，缩放的中心坐标纵标）
//    	mt.setScale(0.5f, 0.5f);
//    	mt.setScale(0.5f, 0.5f, bmCopy.getWidth() / 2, bmCopy.getHeight() / 2);
    	//旋转              （顺时针旋转角度，旋转中心横标，旋转中心纵标）
//    	mt.setRotate(45, bmCopy.getWidth() / 2, bmCopy.getHeight() / 2);
    	//镜面              先水平翻转，后向右平移                 连续设置，后面的要用post
//    	mt.setScale(-1, 1);
//    	mt.postTranslate(bmCopy.getWidth(), 0);
    	//倒影            先竖直翻转，后向下平移                  连续设置，后面的要用post
//    	mt.setScale(1, -1);
//    	mt.postTranslate(0, bmCopy.getHeight());
    	
//    	---------------------
    	
    	//4.开始绘画，把原图内容画在画板上           参数：(原画，矩阵，画笔)
    	canvas.drawBitmap(bm, mt, paint);
    	
    	
    	ImageView iv_copy = (ImageView) findViewById(R.id.iv_copy);
    	iv_copy.setImageBitmap(bmCopy);
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
