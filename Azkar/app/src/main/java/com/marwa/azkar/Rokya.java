package com.marwa.azkar;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Rokya extends Fragment {

    MediaPlayer mplayer;
    private DrawerLayout drawer;
    Button play, pause, stop;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println(getContext().toString());
        view = inflater.inflate(R.layout.rokya, container, false);
        play = view.findViewById(R.id.play);
        pause = view.findViewById(R.id.pause);
        stop = view.findViewById(R.id.stop);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play(view);
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pause(view);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop(view);
            }
        });
        return view;
    }

    public void play(View v) {
        if (mplayer == null) {
            mplayer = MediaPlayer.create(getContext(), R.raw.rr);
            mplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlayer();
                }
            });

        }
        mplayer.start();
    }

    public void pause(View v) {
        if (mplayer != null) {
            mplayer.pause();
        }
    }

    public void stop(View v) {
        stopPlayer();
    }

    private void stopPlayer() {
        if (mplayer != null) {
            mplayer.release();
            mplayer = null;

        }
    }

    @Override
    public void onStop() {
        super.onStop();
        stopPlayer();
    }
}
