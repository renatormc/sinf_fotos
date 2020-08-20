package go.sptc.sinf.sinffotos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    //    private static final int REQUEST_QRSCAN = 2;
    private Button btnButton1;
    //    private Button btnButton2;
    private RecyclerView rvwPics;
    private RecyclerView.Adapter picsAdapter;
    private RecyclerView.LayoutManager picsLayoutManager;
    private ArrayList<Pic> pics;

    private void addPic(String name, Bitmap bitmap) {
        Pic pic = new Pic();
        pic.setName(name);
        pic.setBitmap(bitmap);
        pics.add(pic);
        picsAdapter.notifyDataSetChanged();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvwPics = (RecyclerView) findViewById(R.id.rvwPics);
        rvwPics.setHasFixedSize(true);
        picsLayoutManager = new LinearLayoutManager(this);
        rvwPics.setLayoutManager(picsLayoutManager);
        pics = new ArrayList<Pic>();
        picsAdapter = new PicsAdapter(pics);
        rvwPics.setAdapter(picsAdapter);



        btnButton1 = (Button) findViewById(R.id.btnButton1);
//        btnButton2 = (Button) findViewById(R.id.btnButton2);
////        imageView1 = (ImageView) findViewById(R.id.imageView1);
        btnButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
//
//        btnButton2.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//
//            }
//        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        InputStream stream = null;
        Bitmap bitmap;
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == MainActivity.RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            addPic("Legenda teste", imageBitmap);
        }
    }
}