package com.example.hafidz.myselfapp.MusicVideo;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hafidz.myselfapp.Adapter.DailyAdapter;
import com.example.hafidz.myselfapp.Adapter.MusicAdapter;
import com.example.hafidz.myselfapp.Item.DailyItem;
import com.example.hafidz.myselfapp.Item.MusicItem;
import com.example.hafidz.myselfapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MusicFragment extends Fragment {

    private View view;
    private List<MusicItem> MusicItem = null;
    private MediaPlayer mp;
    private Handler mHandler = new Handler();

    String title, artist, assets_title, clicked;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.bt_play)
    ImageButton bt_play;
    @BindView(R.id.song_progressbar)
    ProgressBar song_progressbar;
    @BindView(R.id.title)
    TextView txtTitle;
    @BindView(R.id.artist)
    TextView txtArtist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_music, container, false);
        ButterKnife.bind(this, view);

        Bundle args = getArguments();
        if (args == null) {
            title = "Separuh Aku";
            artist = "Noah";
            assets_title = "separuh_aku";
            clicked = "not clicked";
        } else {
            title = getArguments().getString("title");
            artist = getArguments().getString("artist");
            assets_title = getArguments().getString("assets_title");
            clicked = getArguments().getString("clicked");
        }

        loadDataMusic();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        MusicAdapter MusicDataAdapter = new MusicAdapter(getContext(), MusicItem);
        recyclerView.setAdapter(MusicDataAdapter);

        initplayer();

        txtTitle.setText(title);
        txtArtist.setText(artist);

        return view;
    }

    public void loadDataMusic() {
        MusicItem = new ArrayList<MusicItem>();
        MusicItem.add(new MusicItem("Separuh Aku", "Noah", "separuh_aku", R.drawable.img_noah));
        MusicItem.add(new MusicItem("Selow", "Wahyu", "selow", R.drawable.img_wahyu));
        MusicItem.add(new MusicItem("Cinta Luar Biasa", "Andmesh", "cinta_luar_biasa", R.drawable.img_andmesh));
        MusicItem.add(new MusicItem("Terbakar Cemburu", "Padi", "terbakar_cemburu", R.drawable.img_padi));
        MusicItem.add(new MusicItem("Kembalilah Kasih", "Gigi", "kembalilah_kasih", R.drawable.img_gigi));
    }

    public void initplayer() {
        // set Progress bar values
        song_progressbar.setProgress(0);
        song_progressbar.setMax(10000);

        // Media Player
        mp = new MediaPlayer();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // Changing button image to play button
                bt_play.setImageResource(R.drawable.ic_play);
            }
        });

            try {
                mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                AssetFileDescriptor afd = getActivity().getAssets().openFd(assets_title + ".mp3");
                mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                afd.close();
                mp.prepare();
            } catch (Exception e) {
                Toast.makeText(getActivity(), "cannot load music", Toast.LENGTH_SHORT).show();
            }

            buttonPlayerAction();
        }

    private void buttonPlayerAction() {
        bt_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // check for already playing
                if (mp.isPlaying()) {
                    mp.pause();
                    // Changing button image to play button
                    bt_play.setImageResource(R.drawable.ic_play);
                } else {
                    // Resume song
                    mp.start();
                    // Changing button image to pause button
                    bt_play.setImageResource(R.drawable.ic_pause);
                    mHandler.post(mUpdateTimeTask);
                }

            }
        });
    }

    private Runnable mUpdateTimeTask = new Runnable() {
        public void run() {
            updateTimerAndSeekbar();
            // Running this thread after 10 milliseconds
            if (mp.isPlaying()) {
                mHandler.postDelayed(this, 100);
            }
        }
    };

    private void updateTimerAndSeekbar() {
        long totalDuration = mp.getDuration();
        long currentDuration = mp.getCurrentPosition();

        // Updating progress bar
        int progress = (int) (getProgressSeekBar(currentDuration, totalDuration));
        song_progressbar.setProgress(progress);
    }

    // stop player when destroy
    @Override
    public void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(mUpdateTimeTask);
        mp.stop();
    }

    public int getProgressSeekBar(long currentDuration, long totalDuration) {
        Double progress = (double) 0;
        // calculating percentage
        progress = (((double) currentDuration) / totalDuration) * 10000;

        // return percentage
        return progress.intValue();
    }

}
