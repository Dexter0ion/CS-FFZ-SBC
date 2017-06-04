package tw.com.celllife_f_s;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by FuFangzhou on 2017/6/3.
 */
public class InitView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = "InitView";
    CellProcess cellProcess;
    Paint paint;
    public static final int OFFWIDTH = 50;
    public static final int OFFHEIGHT = 200;
    public static int SPAN = 50;
    private int bufX;               //用来记录偏移量的x
    private int bufY;               //用来记录偏移量的y
    private int bufX2;
    private int bufY2;


    public InitView(Context context, CellProcess cellprocess) {
        super(context);
        this.cellProcess = cellprocess;
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        getHolder().addCallback(this);
        SPAN = 50;
    }

    public void doDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        for (int i = 0; i < cellProcess.getWidth(); i++) {
            for (int j = 0; j < cellProcess.getHeight(); j++) {
                int x = OFFWIDTH + i * SPAN + cellProcess.getOffsetX();
                int y = OFFHEIGHT + j * SPAN + cellProcess.getOffsetY();
                if (!cellProcess.getStatus(i, j)) {
                    paint.setColor(Color.rgb(20, 50, 50));
                } else {
                    paint.setColor(Color.rgb(220, 50, 50));
                }
                canvas.drawRect(x, y, x + SPAN, y + SPAN, paint);
            }
        }
        for (int i = 0; i < cellProcess.getWidth(); i++) {
            int bx = OFFWIDTH + cellProcess.getOffsetX() + i * SPAN;
            int by = OFFHEIGHT + cellProcess.getOffsetY();
            paint.setColor(Color.BLACK);
            canvas.drawLine(bx, by, bx, by + cellProcess.getHeight() * SPAN, paint);
        }//绘制
        for (int i = 0; i < cellProcess.getHeight(); i++) {
            int bx = OFFWIDTH + cellProcess.getOffsetX();
            int by = OFFHEIGHT + cellProcess.getOffsetY() + i * SPAN;
            paint.setColor(Color.BLACK);
            canvas.drawLine(bx, by, bx + cellProcess.getWidth() * SPAN, by, paint);
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Canvas canvas = getHolder().lockCanvas();
        doDraw(canvas);
        getHolder().unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (event.getPointerCount() == 2) {
            if (action == MotionEvent.ACTION_DOWN) {
                bufX2 = (int) Math.abs(event.getX(0) - event.getX(1));
            }

            if (action == MotionEvent.ACTION_MOVE) {
                int buf = (int) Math.abs(event.getX(0) - event.getX(1));
                int value = buf - bufX2;
                if (value > 20)
                    value = 20;
                else if (value < -20)
                    value = -20;
                else
                    value /= 2;
                SPAN = SPAN + value;
                bufX2 = buf;
            }
        } else {
            if (action == MotionEvent.ACTION_DOWN) {
                bufX = (int) event.getX();
                bufY = (int) event.getY();
                int x = cellProcess.getX(event.getX());
                int y = cellProcess.getY(event.getY());
                if (x == -1 || y == -1)
                    return true;
                cellProcess.changeStatus(x, y);
            } else if (action == MotionEvent.ACTION_MOVE) {
                Log.i(TAG, "onTouchEvent: ");
                cellProcess.addOffsetX((event.getX() - bufX) / 2);
                cellProcess.addOffsetY((event.getY() - bufY) / 2);
                Log.i(TAG, "onTouchEvent: " + cellProcess.getOffsetX());
                bufX = (int) event.getX();
                bufY = (int) event.getY();
            }
            Canvas canvas = getHolder().lockCanvas();
            doDraw(canvas);
            getHolder().unlockCanvasAndPost(canvas);
        }
        return true;
    }


}
