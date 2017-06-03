package tw.com.celllife_f_s;

import android.util.Log;

import java.util.Arrays;

/**
 * Created by FuFangzhou on 2017/6/3.
 */
public class CellProcess {
    public static final String TAG = "CellProcess";
    private char[] data;
    private int width;
    private int height;
    private int[] markData;

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
        viewAllCell();
        //DEBUG
        Log.i(TAG, "next: " + toString());
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
        if (data[x + y * width] == 1)
            data[x + y * width] = 0;
        else
            data[x + y * width] = 1;
    }

    private void viewAllCell() {
        markData = new int[width * height];
        for (int i = 0; i < markData.length; i++) {
            markData[i] = 0;
        }

        for (int i = 0; i < data.length; i++) {
            changeMarkdata(markData, i);
        }
    }

    private void changeMarkdata(int[] markData, int p) {
        int result = 0;
        int x = p % width;
        int y = p / width;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i == x && j == y) continue;
                if (checkStatus(i, j)) result += 1;
            }
        }
        markData[p] = result;
    }

    private boolean checkStatus(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) return false;
        else if (data[x + y * width] == 0) return false;
        else return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                sb.append(markData[i + j * width]);
                sb.append(' ');
            }
            sb.append('\n');
            System.out.println(sb);
        }
        return sb.toString();
    }
}
