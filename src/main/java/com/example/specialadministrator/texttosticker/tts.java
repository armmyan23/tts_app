package com.example.specialadministrator.texttosticker;

        import android.annotation.SuppressLint;
        import android.content.Context;
        import android.content.Intent;
        import android.graphics.Bitmap;
        import android.graphics.Typeface;
        import android.net.Uri;
        import android.support.v4.content.FileProvider;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.CardView;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.TextView;

        import java.io.File;
        import java.io.FileOutputStream;
        import java.io.IOException;

public class tts extends AppCompatActivity {

    Context context;

    CardView v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tts);
        final Spinner spinner = findViewById(R.id.spinn);
        final TextView input = findViewById(R.id.etext);
        final TextView textView = findViewById(R.id.view1);
        v1 = findViewById(R.id.view);
        final String[] items = {"IndieFlower", "ShadowsIntoLight", "DancingScript-Regular", "GloriaHallelujah", "Megrim", "Lobster-Regular", "Plaster-Regular", "Pacifico-Regular", "PoiretOne-Regular", "Righteous-Regular"};

        SpinnerAdapter adapter = new SpinnerAdapter(this, items);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/" + items[i] + ".ttf"));
                textView.setText(input.getText());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

}

    private void sharefunc1() {

        createBmp(bmap(),this);

        File imagePath = new File(context.getCacheDir(), "images");
        imagePath.mkdirs();
        File newFile = new File(imagePath, "image.png");
        Uri contentUri = FileProvider.getUriForFile(context, "com.example.specialadministrator.texttosticker", newFile);

        if(contentUri != null) {
            Intent intentM = new Intent();
            intentM.setAction(Intent.ACTION_SEND);
            intentM.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intentM.setDataAndType(contentUri, getContentResolver().getType(contentUri));
            intentM.putExtra(Intent.EXTRA_STREAM, contentUri);
            intentM.setPackage("com.messenger.orca");
            intentM.setType("*/*");
            startActivity(intentM);
        }
    }

    private void sharefunc2() {

        createBmp(bmap(),this);

        File imagePath = new File(context.getCacheDir(), "images");
        imagePath.mkdirs();
        File newFile = new File(imagePath, "image.png");
        Uri contentUri = FileProvider.getUriForFile(context, "com.example.specialadministrator.texttosticker", newFile);

        if(contentUri != null) {
            Intent intentV = new Intent();
            intentV.setAction(Intent.ACTION_SEND);
            intentV.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intentV.setDataAndType(contentUri, getContentResolver().getType(contentUri));
            intentV.putExtra(Intent.EXTRA_STREAM, contentUri);
            intentV.setPackage("com.viber.voip");
            intentV.setType("*/*");
            startActivity(intentV);
        }
    }

    private void sharefunc3() {

        createBmp(bmap(),this);

        File imagePath = new File(context.getCacheDir(), "images");
        imagePath.mkdirs();
        File newFile = new File(imagePath, "image.png");
        Uri contentUri = FileProvider.getUriForFile(context, "com.example.specialadministrator.texttosticker", newFile);

        if(contentUri != null) {
            Intent intentW = new Intent();
            intentW.setAction(Intent.ACTION_SEND);
            intentW.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intentW.setDataAndType(contentUri, getContentResolver().getType(contentUri));
            intentW.putExtra(Intent.EXTRA_STREAM, contentUri);
            intentW.setPackage("com.whatsapp");
            intentW.setType("*/*");
            startActivity(intentW);
        }
    }

    private void sharefunc4() {

        createBmp(bmap(),this);

        File imagePath = new File(context.getCacheDir(), "images");
        imagePath.mkdirs();
        File newFile = new File(imagePath, "image.png");
        Uri contentUri = FileProvider.getUriForFile(context, "com.example.specialadministrator.texttosticker", newFile);

        if(contentUri != null) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(contentUri, getContentResolver().getType(contentUri));
            intent.putExtra(Intent.EXTRA_STREAM, contentUri);
            intent.setType("*/*");
            startActivity(Intent.createChooser(intent, "Choose an app"));
        }
    }

    public Bitmap bmap() {

        v1.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
        v1.setDrawingCacheEnabled(false);
        return bitmap;
    }

    public void createBmp(Bitmap bitmap, Context context) {
        try {

            File cachePath = new File(context.getCacheDir(), "images");
            cachePath.mkdir();
            FileOutputStream stream = new FileOutputStream(cachePath + "/image.png");
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            stream.flush();
            stream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib1:
                sharefunc1();
                break;

            case R.id.ib2:
                sharefunc2();
                break;

            case R.id.ib3:
                sharefunc3();
                break;

            case R.id.ib4:
                sharefunc4();
                break;

            default:
                break;
        }

    }
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}