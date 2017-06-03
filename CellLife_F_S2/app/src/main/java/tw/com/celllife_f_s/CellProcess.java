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
}
