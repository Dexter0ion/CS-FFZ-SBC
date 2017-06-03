package tw.com.celllife_f_s;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

/**
 * Created by FuFangzhou on 2017/6/3.
 */
public class CellThread extends Thread {
    public static final int SLEEP = 1000;
    public boolean flag = true;
    private CellProcess cellProcess;
    private SurfaceHolder surfaceHolder;
    private DisplayView displayView;
    public static final String TAG = "CellThread";

    public CellThread(CellProcess cellProcess, DisplayView displayView) {
        this.cellProcess = cellProcess;
        this.displayView = displayView;
        this.surfaceHolder = displayView.getHolder();
    }

    @Override
    public void run() {
        while (flag) {
            try {
                Thread.sleep(SLEEP);
                cellProcess.next();
                for (int i = 0; i < CellProcess.MAXVAR; i++) {
                    cellProcess.addVar();
                    Canvas canvas = surfaceHolder.lockCanvas();
                    if (canvas != null) {
                        displayView.doDraw(canvas);
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                    Thread.sleep(SLEEP/cellProcess.MAXVAR);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
