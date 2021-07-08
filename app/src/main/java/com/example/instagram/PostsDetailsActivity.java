package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.parse.Parse;
import com.parse.ParseObject;

import org.parceler.Parcels;

import java.util.Date;

public class PostsDetailsActivity extends AppCompatActivity {

    //the post to display
    Post post;

    //view objects
    TextView tvUsername;
    TextView tvDescription;
    ImageView ivImage;
    TextView tvCreatedAt;
    Button btnFeed;

    public PostsDetailsActivity() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_details);

        tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        ivImage = (ImageView) findViewById(R.id.ivImage);
        tvCreatedAt = (TextView) findViewById(R.id.tvCreatedAt);
        btnFeed = (Button) findViewById(R.id.btnFeed);

        post = (Post) Parcels.unwrap(getIntent().getParcelableExtra(Post.class.getSimpleName()));
        Log.i("PostsDetailsActivity", "Showing Post Details!");


        Date createdAt = post.getCreatedAt();
        String timeAgo = Post.calculateTimeAgo(createdAt);

        tvCreatedAt.setText(timeAgo);
        tvUsername.setText(post.getUser().getUsername());
        tvDescription.setText(post.getDescription());


        //upload the image
        Glide.with(this).load(post.getImage().getUrl()).into(ivImage);

        btnFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFeedButton(v);
            }
        });
    }

    private void onFeedButton(View v) {
        Intent i = new Intent(this, FeedActivity.class);
        //takes the user to the feed activity
        startActivity(i);
    }
}