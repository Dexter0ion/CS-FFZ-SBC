package tw.com.celllife_f_s;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by FuFangzhou on 2017/6/3.
 */
public class LifeView extends SurfaceView implements SurfaceHolder.Callback {
    CellProcess cellProcess;
    public LifeView(Context context) {
        super(context);
        cellProcess = new CellProcess();
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
