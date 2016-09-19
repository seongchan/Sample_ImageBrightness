package com.clipandbooks.sample.imagebrightness;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

    ImageView mAfter ;
    Bitmap bitmap_Source;
    int brightnessValue = 204;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mAfter = (ImageView)findViewById(R.id.after);
        //bitmap_Source = BitmapFactory.decodeResource(getResources(), R.drawable.sample_img);
        //mAfter.setImageBitmap(processingBitmap_Brightness(bitmap_Source));
    }



    private Bitmap processingBitmap_Brightness(Bitmap src){
        Bitmap dest = Bitmap.createBitmap(
                src.getWidth(), src.getHeight(), src.getConfig());

        for(int x = 0; x < src.getWidth(); x++){
            for(int y = 0; y < src.getHeight(); y++){
                int pixelColor = src.getPixel(x, y);
                int pixelAlpha = Color.alpha(pixelColor);

                int pixelRed = Color.red(pixelColor) + brightnessValue;
                int pixelGreen = Color.green(pixelColor) + brightnessValue;
                int pixelBlue = Color.blue(pixelColor) + brightnessValue;

                if(pixelRed > 255){
                    pixelRed = 255;
                }else if(pixelRed < 0){
                    pixelRed = 0;
                }

                if(pixelGreen > 255){
                    pixelGreen = 255;
                }else if(pixelGreen < 0){
                    pixelGreen = 0;
                }

                if(pixelBlue > 255){
                    pixelBlue = 255;
                }else if(pixelBlue < 0){
                    pixelBlue = 0;
                }

                int newPixel = Color.argb(
                        pixelAlpha, pixelRed, pixelGreen, pixelBlue);

                dest.setPixel(x, y, newPixel);

            }
        }
        return dest;
    }
}
