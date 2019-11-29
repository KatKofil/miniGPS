package com.example.parisfilms;

import android.app.Activity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private Activity context;

    public CustomInfoWindowAdapter(Activity context){
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View v = context.getLayoutInflater().inflate(R.layout.info_window, null);

        ImageView movieImg = v.findViewById(R.id.movie_img);
        TextView movieTitle = v.findViewById(R.id.movie_title);
        TextView movieInfos = v.findViewById(R.id.movie_infos);
        TextView movieLink = v.findViewById(R.id.movie_link);

        String link = marker.getSnippet().substring(20);
        SpannableString ss = new SpannableString(link);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(context, "test", Toast.LENGTH_SHORT).show();
            }
        };

        ss.setSpan(clickableSpan, 0, link.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        movieImg.setImageResource(R.drawable.parisjetaime);
        movieTitle.setText(marker.getTitle());
        movieInfos.setText(marker.getSnippet());
        movieLink.setText(ss);
        movieLink.setMovementMethod(LinkMovementMethod.getInstance());

        return v;
    }
}
