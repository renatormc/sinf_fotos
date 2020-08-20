package go.sptc.sinf.sinffotos;

import android.graphics.Bitmap;

public class Pic {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    private String name;
    private Bitmap bitmap;

}
