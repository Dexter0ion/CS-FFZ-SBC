package tw.com.celllife_f_s;

/**
 * Created by FuFangzhou on 2017/6/3.
 */
public class CellProcess {
    private char[] data;
    private int width;
    private int height;

    public CellProcess(char[] data, int width, int height) {
        this.data = data;
        this.width = width;
        this.height = height;
    }

    public char[] getData() {
        return data;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void init(char[] data) {
        this.data = data;
    }

    public char[] display() {
        return null;
    }

    public void next() {

    }

    public boolean getStatus(int x, int y) {
        if (data[x + y * width] == 1)
            return true;
        else
            return false;
    }

    public int getX(float x) {
        //boardCheck
        if (x < InitView.OFFWIDTH || x > InitView.OFFWIDTH + InitView.SPAN * this.width)
            return -1;
        int xresult;
        xresult = ((int) x - InitView.OFFWIDTH) / InitView.SPAN;
        return xresult;
    }

    public int getY(float y) {
        if (y < InitView.OFFHEIGHT || y > InitView.OFFHEIGHT + InitView.SPAN * this.height)
            return -1;
        int yresult = ((int) y - InitView.OFFHEIGHT) / InitView.SPAN;
        return yresult;
    }

    public void changeStatus(int x, int y) {
        if(data[x+y*width]==1)
            data[x+y*width]=0;
        else
            data[x+y*width]=1;
    }
}
