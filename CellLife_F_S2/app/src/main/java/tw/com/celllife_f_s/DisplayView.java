package tw.com.celllife_f_s;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by FuFangzhou on 2017/6/3.
 */
public class DisplayView extends SurfaceView implements SurfaceHolder.Callback {
    public static final String TAG = "DisplayView";
    CellProcess cellProcess;
    Paint paint;
    int bufX;
    int bufY;
    private CellThread cellThread;

    public DisplayView(Context context, final CellProcess cellProcess) {
        super(context);
        getHolder().addCallback(this);
        paint = new Paint();
        this.cellProcess = cellProcess;
    }

    public void doDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        for (int i = 0; i < cellProcess.getWidth(); i++) {
            for (int j = 0; j < cellProcess.getHeight(); j++) {
                int x = InitView.OFFWIDTH + i * InitView.SPAN + cellProcess.getOffsetX();
                int y = InitView.OFFHEIGHT + j * InitView.SPAN + cellProcess.getOffsetY();
                if (cellProcess.check(i,j)) {
                    if (!cellProcess.getStatus(i, j)) {
                        paint.setColor(Color.GRAY);
                    } else {
                        paint.setColor(Color.RED);
                    }
                }else{
                    paint.setColor(cellProcess.getVarColor());
                }
                canvas.drawRect(x, y, x + InitView.SPAN, y + InitView.SPAN, paint);
            }
        }
        for (int i = 0; i < cellProcess.getWidth(); i++) {
            int bx = InitView.OFFWIDTH + cellProcess.getOffsetX() + i * InitView.SPAN;
            int by = InitView.OFFHEIGHT + cellProcess.getOffsetY();
            paint.setColor(Color.BLACK);
            canvas.drawLine(bx, by, bx, by + cellProcess.getHeight() * InitView.SPAN, paint);
        }//绘制
        for (int i = 0; i < cellProcess.getHeight(); i++) {
            int bx = InitView.OFFWIDTH + cellProcess.getOffsetX();
            int by = InitView.OFFHEIGHT + cellProcess.getOffsetY() + i * InitView.SPAN;
            paint.setColor(Color.BLACK);
            canvas.drawLine(bx, by, bx + cellProcess.getWidth() * InitView.SPAN, by, paint);
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Canvas canvas = getHolder().lockCanvas();
        doDraw(canvas);
        getHolder().unlockCanvasAndPost(canvas);
        cellThread = new CellThread(cellProcess, this);
        cellThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        cellThread.flag = false;
        cellThread = null;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN){
            bufX = (int) event.getX();
            bufY = (int) event.getY();
        }
        if (action == MotionEvent.ACTION_MOVE) {
            cellProcess.addOffsetX((event.getX() - bufX) / 2);
            cellProcess.addOffsetY((event.getY() - bufY) / 2);
            bufX = (int) event.getX();
            bufY = (int) event.getY();
        }
        Canvas canvas = getHolder().lockCanvas();
        doDraw(canvas);
        getHolder().unlockCanvasAndPost(canvas);
        return true;
    }
}
