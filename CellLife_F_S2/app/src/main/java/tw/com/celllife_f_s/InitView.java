package tw.com.celllife_f_s;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by FuFangzhou on 2017/6/3.
 */
public class InitView extends SurfaceView implements SurfaceHolder.Callback {
    CellProcess cellProcess;
    Paint paint;
    public static final int OFFWIDTH = 50;
    public static final int OFFHEIGHT = 200;
    public static final int SPAN = 50;

    public InitView(Context context, CellProcess cellprocess) {
        super(context);
        this.cellProcess = cellprocess;
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        getHolder().addCallback(this);
    }

    public void doDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        for (int i = 0; i < cellProcess.getWidth(); i++) {
            for (int j = 0; j < cellProcess.getHeight(); j++) {
                int x = OFFWIDTH + i * SPAN;
                int y = OFFHEIGHT + j * SPAN;
                if(!cellProcess.getStatus(i,j)) {
                    paint.setColor(Color.WHITE);
                }else{
                    paint.setColor(Color.RED);
                }
                canvas.drawRect(x, y, x + SPAN, y + SPAN, paint);
            }
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
        
        return true;
    }
}
