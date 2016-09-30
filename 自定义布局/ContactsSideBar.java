package org.pingchuan.dingwork.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.HashMap;

/**
 * 通訊錄侧边栏导航 需要提供首字母地图，即该字母对应的列表位置
 *
 */
public class ContactsSideBar extends View {

    OnTouchingLetterChangedListener onTouchingLetterChangedListener;
    String[] b = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#", " "};
    int choose = -1;
    Paint paint = new Paint();
    boolean showBkg = true;
    private HashMap<String, Integer> hashMap;

    public ContactsSideBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ContactsSideBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ContactsSideBar(Context context) {
        super(context);
    }

    public void setHashMap(HashMap<String, Integer> hashMap) {
        this.hashMap = hashMap;
        this.invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        int singleHeight = height / b.length;
        if (showBkg) {
            for (int i = 0; i < b.length; i++) {

                if (i == choose) {
//                    paint.setColor(Color.parseColor("#b61e08"));
                    //画背景色
//				BitmapFactory.Options options = new BitmapFactory.Options();
//				options.inSampleSize = 2;
//				Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg_normal,options);
                    //canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.letter_frame), null, paint);
//				canvas.drawBitmap(imageBitmap, 0, singleHeight * i + singleHeight / 2 - imageBitmap.getHeight() / 4 , paint);
                    //getRoundedCornerBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.letter_frame), 5f);
                    //canvas.drawBitmap(Bitmap, left, top, paint)
                }

                paint.setColor(Color.argb(0xff, 0xa0, 0xa0, 0xa0));
//                paint.setTypeface(Typeface.DEFAULT_BOLD);
                paint.setAntiAlias(true);
                paint.setTextSize(40);

                if (null != hashMap && hashMap.get(b[i]) != null) {
                    paint.setColor(Color.parseColor("#818181"));
                    //paint.setFakeBoldText(true);
                    if (i == choose) {

                        paint.setColor(Color.parseColor("#b61e08"));
                    }
                }
                float xPos = width / 2 - paint.measureText(b[i]) / 2;
                float yPos = singleHeight * i + singleHeight;
                canvas.drawText(b[i], xPos, yPos, paint);
                //paint.reset();

            }
        }

    }

    public void drawLineExt(Canvas canvas, float[] pts, Paint paint) {

        for (int i = 0; i < pts.length; i += 2) {
            int stopXIndex = i + 2;
            int stopYIndex = i + 3;
            if (stopXIndex > pts.length - 1)
                stopXIndex = 0;
            if (stopYIndex > pts.length - 1)
                stopYIndex = 1;
            canvas.drawLine(pts[i], pts[i + 1], pts[stopXIndex],
                    pts[stopYIndex], paint);
        }

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        final int action = event.getAction();
        final float y = event.getY();
        final int oldChoose = choose;
        final OnTouchingLetterChangedListener listener = onTouchingLetterChangedListener;
        final int c = (int) (y / getHeight() * b.length);

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                //showBkg = true;
                if (oldChoose != c && listener != null) {
                    if (c > 0 && c < b.length) {
                        listener.onTouchingLetterChanged(b[c]);
                        choose = c;
                        invalidate();
                    }
                }

                break;
            case MotionEvent.ACTION_MOVE:
                if (oldChoose != c && listener != null) {
                    if (c > 0 && c < b.length) {
                        listener.onTouchingLetterChanged(b[c]);
                        choose = c;
                        invalidate();
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                choose = -1;
                //invalidate();
                break;
        }
        return true;
    }


    public Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx) {

        Bitmap output = Bitmap.createBitmap(
                //bitmap.getWidth(), bitmap.getHeight(),
                getWidth(), getHeight() / b.length, Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xffb61e08;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, getWidth(), getHeight() / b.length);
        //bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

//        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN)); 
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }

    //设置监听位置
    public void setOnTouchingLetterChangedListener(OnTouchingLetterChangedListener onTouchingLetterChangedListener) {
        this.onTouchingLetterChangedListener = onTouchingLetterChangedListener;
    }

    public interface OnTouchingLetterChangedListener {
        //设置点击返回的字母
        void onTouchingLetterChanged(String s);
    }

}  