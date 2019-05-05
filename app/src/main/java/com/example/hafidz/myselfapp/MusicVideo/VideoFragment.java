package com.example.hafidz.myselfapp.MusicVideo;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.hafidz.myselfapp.Adapter.MusicAdapter;
import com.example.hafidz.myselfapp.Adapter.VideoAdapter;
import com.example.hafidz.myselfapp.Item.MusicItem;
import com.example.hafidz.myselfapp.Item.VideoItem;
import com.example.hafidz.myselfapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class VideoFragment extends Fragment {

    @BindView(R.id.video)
    VideoView simpleVideoView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;
    private View view;
    private List<VideoItem> VideoItem = null;
    MediaController mediaControls;

    String assets_title;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_video, container, false);
        unbinder = ButterKnife.bind(this, view);

        Bundle args = getArguments();
        if (args == null) {
            assets_title = "separuh_aku";
        }
        else {
            assets_title = getArguments().getString("assets_title");

        }

        simpleVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        /*
                         *  add media controller
                         */
                        mediaControls = new MediaController(getContext());;
                        simpleVideoView.setMediaController(mediaControls);
                        /*
                         * and set its position on screen
                         */
                        mediaControls.setAnchorView(simpleVideoView);
                    }
                });
            }
        });

        loadDataVideo();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        VideoAdapter VideoDataAdapter = new VideoAdapter(getContext(), VideoItem);
        recyclerView.setAdapter(VideoDataAdapter);
        // set the uri for the video view
        simpleVideoView.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + "raw/"+ assets_title));
        // start a video
        simpleVideoView.start();
        // implement on completion listener on video view
        simpleVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(getContext(), "Thank You...!!!", Toast.LENGTH_LONG).show(); // display a toast when an video is completed
            }
        });
        simpleVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(getContext(), "Oops An Error Occur While Playing Video...!!!", Toast.LENGTH_LONG).show(); // display a toast when an error is occured while playing an video
                return false;
            }
        });


        return view;
    }

    public void loadDataVideo() {
        VideoItem = new ArrayList<VideoItem>();
        VideoItem.add(new VideoItem("Separuh Aku", "Noah", "separuh_aku", R.drawable.img_noah));
        VideoItem.add(new VideoItem("Selow", "Wahyu", "selow", R.drawable.img_wahyu));
        VideoItem.add(new VideoItem("Cinta Luar Biasa", "Andmesh", "cinta_luar_biasa", R.drawable.img_andmesh));
        VideoItem.add(new VideoItem("Terbakar Cemburu", "Padi", "terbakar_cemburu", R.drawable.img_padi));
        VideoItem.add(new VideoItem("Kembalilah Kasih", "Gigi", "kembalilah_kasih", R.drawable.img_gigi));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
