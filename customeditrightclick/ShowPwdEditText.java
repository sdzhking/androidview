package org.pingchuan.dingwork.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.EditText;

public class ShowPwdEditText extends EditText {

    private Drawable dRight;
    private Rect rBounds;
    private Context mContext;

    public ShowPwdEditText(Context context) {
        super(context);
        mContext = context;
    }

    public ShowPwdEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
    }

    public ShowPwdEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    @Override
    public void setCompoundDrawables(Drawable left, Drawable top,
                                     Drawable right, Drawable bottom) {
        if (right != null) {
            dRight = right;
        }
        super.setCompoundDrawables(left, top, right, bottom);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP && dRight != null) {
            rBounds = dRight.getBounds();
            final int x = (int) event.getX();
            final int y = (int) event.getY();
            System.out.println("x:/y: " + x + "/" + y);
            System.out.println("bounds: " + rBounds.left + "/" + rBounds.right + "/" + rBounds.top
                    + "/" + rBounds.bottom + "/" + rBounds.width() + "/" + this.getRight()
                    + "/" + this.getPaddingTop() + "/" + this.getTop() + "/" + this.getPaddingRight()
            );
            //check to make sure the touch event was within the bounds of the drawable
            if (x >= (this.getWidth() - rBounds.width() - this.getPaddingRight() - this.getPaddingRight()) && x <= (this.getWidth())
                    && y >= 0 && y <= this.getHeight()) {
//                if (this.getId() == R.id.login_pwd) {

                    Log.d("edittext", " ACTION_UP right draw click" + this.isSelected());
                    if (this.isSelected()) {
                        /* 设定EditText的内容为隐藏的 */
                        this.setTransformationMethod(PasswordTransformationMethod
                                .getInstance());
                    } else {
                		/* 设定EditText的内容为可见的 */
                        this.setTransformationMethod(HideReturnsTransformationMethod
                                .getInstance());
                    }
                    this.setSelected(!this.isSelected());
//                }
                event.setAction(MotionEvent.ACTION_CANCEL);//use this to prevent the keyboard from coming up
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void finalize() throws Throwable {
        dRight = null;
        rBounds = null;
        super.finalize();
    }
}
