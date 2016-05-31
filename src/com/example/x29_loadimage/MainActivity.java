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

    //��������ͼƬ
    public void click(View v){
    	//����ͼƬ��Ҫ�Ĳ�������װ�����������
    	Options opt = new Options();
    	//����Ϊ����ȡͼƬ���
    	opt.inJustDecodeBounds = true;
    	BitmapFactory.decodeFile("sdcard/wolf.bmp", opt);
    	//�õ�ͼƬ���
    	int imageWidth = opt.outWidth;
    	int imageHeight = opt.outHeight;
    	
    	//�õ��ֻ���Ļ���
    	Display dp = getWindowManager().getDefaultDisplay();
    	int screenWidth = dp.getWidth();
    	int screenHeight = dp.getHeight();
    	
    	//�������ű���
    	int scale = 1;
    	int scaleWidth = imageWidth / screenWidth;
    	int scaleHeight = imageHeight / screenHeight;
    	if(scaleWidth >= scaleHeight && scaleWidth > 1){
    		scale = scaleWidth;
    	}else if(scaleHeight > scaleWidth && scaleHeight > 1){
    		scale = scaleHeight;
    	}
    	
    	//�������ű���
    	opt.inSampleSize = scale;
    	opt.inJustDecodeBounds = false;
    	Bitmap bm = BitmapFactory.decodeFile("sdcard/wolf.bmp", opt);
    	
    	ImageView iv = (ImageView) findViewById(R.id.iv);
    	iv.setImageBitmap(bm);
    }
    
    
    //��������ͼƬ����
    public void click2(View v){
    	
    	//����ͼƬ��Ҫ�Ĳ�������װ�����������
    	Options opt = new Options();
    	//����Ϊ����ȡͼƬ���
    	opt.inJustDecodeBounds = true;
    	BitmapFactory.decodeFile("sdcard/wolf.bmp", opt);
    	//�õ�ͼƬ���
    	int imageWidth = opt.outWidth;
    	int imageHeight = opt.outHeight;
    	
    	//�õ��ֻ���Ļ���
    	Display dp = getWindowManager().getDefaultDisplay();
    	int screenWidth = dp.getWidth();
    	int screenHeight = dp.getHeight();
    	
    	//�������ű���
    	int scale = 1;
    	int scaleWidth = imageWidth / screenWidth;
    	int scaleHeight = imageHeight / screenHeight;
    	if(scaleWidth >= scaleHeight && scaleWidth > 1){
    		scale = scaleWidth;
    	}else if(scaleHeight > scaleWidth && scaleHeight > 1){
    		scale = scaleHeight;
    	}
    	
    	//�������ű���
    	opt.inSampleSize = scale;
    	opt.inJustDecodeBounds = false;
    	//�˶�����ֻ������
    	Bitmap bm = BitmapFactory.decodeFile("sdcard/wolf.bmp", opt);
    	
//    	*******************************************************
    	//��ʼ���Ƹ���
    	
    	//1.���ڴ��д���һ����ԭͼһ����С��Bitmap���󣨴�����ֽ��____�˶���ɶ���д
    	Bitmap bmCopy = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), bm.getConfig());
    	
    	//2.�������ʶ���
    	Paint paint = new Paint();
    	
    	//3.����������󣬰Ѱ�ֽ���ڻ�����
    	Canvas canvas = new Canvas(bmCopy);
    	
    	//����
    	Matrix mt = new Matrix();
    	
    	
//    	---------------------
    	
    	//ƽ��
//    	mt.setTranslate(20, 30);
    	//����                  �� �������ű������������ű��������ŵ����������꣬���ŵ����������ݱ꣩
//    	mt.setScale(0.5f, 0.5f);
//    	mt.setScale(0.5f, 0.5f, bmCopy.getWidth() / 2, bmCopy.getHeight() / 2);
    	//��ת              ��˳ʱ����ת�Ƕȣ���ת���ĺ�꣬��ת�����ݱ꣩
//    	mt.setRotate(45, bmCopy.getWidth() / 2, bmCopy.getHeight() / 2);
    	//����              ��ˮƽ��ת��������ƽ��                 �������ã������Ҫ��post
//    	mt.setScale(-1, 1);
//    	mt.postTranslate(bmCopy.getWidth(), 0);
    	//��Ӱ            ����ֱ��ת��������ƽ��                  �������ã������Ҫ��post
//    	mt.setScale(1, -1);
//    	mt.postTranslate(0, bmCopy.getHeight());
    	
//    	---------------------
    	
    	//4.��ʼ�滭����ԭͼ���ݻ��ڻ�����           ������(ԭ�������󣬻���)
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
