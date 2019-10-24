package com.example.wowebackand.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.wowebackand.R;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ThirdFragment extends Fragment {

    ImageView imageView;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.third_fragment, container, false);
        imageView=view.findViewById(R.id.img);
        Resources resources=getResources();
//        resources.getDrawable()
//        Bitmap bitmap= BitmapFactory.decodeResource(resources,R.drawable.abasuderezi);
//
//        if (bitmap!=null){
//            Log.e("bitmap","is not null");
//        int nh = (int) ( bitmap.getHeight() * (800.0 / bitmap.getWidth()) );
//        Bitmap bitmapScaled= Bitmap.createScaledBitmap(bitmap,600,nh,true);
//        imageView.setImageBitmap(bitmapScaled);//nothing is disiplaying
//             }
//        else{
////        imageView.setImageBitmap(bitmap);
//        Drawable drawable=getResources().getDrawable(R.drawable.abasuderezi);
//        if (drawable==null)
//            Log.e("drawable"," null");
//        else
//        imageView.setImageDrawable(drawable);
//        }
        Picasso.with(getContext()).load(R.drawable.header).into(imageView);
        return view;
    }
}

