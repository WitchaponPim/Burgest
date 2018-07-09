package com.example.ptwitchapon.burgest;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.ptwitchapon.burgest.API.APIService2;
import com.example.ptwitchapon.burgest.API.ConnectTopup;
import com.example.ptwitchapon.burgest.Model.AddTopupModel;
import com.example.ptwitchapon.burgest.Tool.Gallery;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.picasso.Picasso;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopupActivity extends AppCompatActivity {
    Gallery gallery;
    ImageView slip;
    Button picker,upload;
    EditText amount;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);
        slip =(ImageView) findViewById(R.id.slip);
        picker = (Button) findViewById(R.id.picker);
        amount =(EditText) findViewById(R.id.amount);
        upload = (Button) findViewById(R.id.upload);




        if (Build.VERSION.SDK_INT > 22) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = amount.getText().toString();
                upload(a);
            }
        });
        picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               pick();
            }
        });

    }


    public void pick() {
        // Create intent to Open Image applications like Gallery, Google Photos
        gallery = new Gallery.Builder()
                .setpickPhotoRequestCode(123)
                .resetToCorrectOrientation(true)
                .setDirectory("DCIM/Camera/")
                .setName(Utils.user.getChecklogin().getId_member() + "_" + System.currentTimeMillis())
                .setImageFormat(Gallery.IMAGE_JPG)
                .setCompression(75)
                .setImageHeight(1000)
                .build(this);
        try {
            gallery.pickPicture();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Gallery.REQUEST_PICK_PHOTO && resultCode == RESULT_OK && data != null) {
            Log.d("pickGallery", "onActivityResult: ");
            String respath= gallery.getCameraBitmapPath();
            Uri pickedImage = data.getData();

            String[] filePath = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(pickedImage, filePath, null, null, null);
            cursor.moveToFirst();
            String imagePath = cursor.getString(cursor.getColumnIndex(filePath[0]));

            Bitmap bitmap = Utils.decodeFile(new File(imagePath),1000);
            bitmap = Utils.rotateBitmap(bitmap, Utils.getImageRotation(imagePath));
            Utils.saveBitmap( bitmap,respath,"jpg",75);
            Log.d("pickGallery", "onActivityResult: "+respath);

            file = new File(respath);
            Picasso.with(getApplicationContext()).load(file).into(slip);

            cursor.close();

        }
    }

    public void upload(String amount){
        if(file!=null&&!this.amount.getText().equals("")){
            final String TAG ="Upload";
            Log.d(TAG, "upload: ");
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpeg"), file);

            MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("image", file.getName(), requestBody );

            RequestBody idmember = RequestBody.create(MediaType.parse("text/plain"), Utils.user.getChecklogin().getId_member());
            RequestBody amountt = RequestBody.create(MediaType.parse("text/plain"), amount);
            RequestBody filename = RequestBody.create(MediaType.parse("text/plain"), file.getName());

            APIService2 getResponse = ConnectTopup.getClient().create(APIService2.class);
            Call<AddTopupModel> call = getResponse.uploadFile(idmember,amountt,fileToUpload, filename);
            call.enqueue(new Callback<AddTopupModel>() {
                @Override
                public void onResponse(Call<AddTopupModel> call, Response<AddTopupModel> response) {
                    Utils.toast(getApplicationContext(),response.body().getInsert().getDescription());
                    Log.d(TAG, "onResponse: "+response.body().getInsert().getDescription());
                    onBackPressed();
                }
                @Override
                public void onFailure(Call<AddTopupModel> call, Throwable t) {
                    Utils.toast(getApplicationContext(),t.toString());
                    Log.d(TAG, "onFailure: "+t.toString());
                }
            });
        }else {
            Utils.toast(getApplicationContext(),"ใส่จำนวนเงินกับอัพสลิปด้วยจ๊ะ");
        }


    }
}
