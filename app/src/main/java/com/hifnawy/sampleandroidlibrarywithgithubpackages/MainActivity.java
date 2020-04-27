package com.hifnawy.sampleandroidlibrarywithgithubpackages;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.hifnawy.math.MathOperations;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    MathOperations mathOperations;

    final int ANIMATION_DURATION = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);

        ObjectAnimator textViewScaleXAnimation = new ObjectAnimator().ofFloat(textView, "scaleX", 5f, 1f);
        ObjectAnimator textViewScaleYAnimation = new ObjectAnimator().ofFloat(textView, "scaleY", 5f, 1f);
        ObjectAnimator textViewScaleAlphaAnimation = new ObjectAnimator().ofFloat(textView, "alpha", 0f, 1f);
        textViewScaleXAnimation.setDuration(ANIMATION_DURATION * 2);
        textViewScaleYAnimation.setDuration(ANIMATION_DURATION * 2);
        textViewScaleAlphaAnimation.setDuration(ANIMATION_DURATION * 2);
        textViewScaleXAnimation.start();
        textViewScaleYAnimation.start();
        textViewScaleAlphaAnimation.start();

        ObjectAnimator imageViewAlphaAnimation = new ObjectAnimator().ofFloat(imageView, "alpha", 0f, 1f);
        imageViewAlphaAnimation.setDuration(ANIMATION_DURATION * 2);
        imageViewAlphaAnimation.start();
    }

    public void GenerateRandomMathOperation(View view) {
        ObjectAnimator imageViewAlphaAnimation = new ObjectAnimator().ofFloat(imageView, "alpha", 1f, 0f);
        imageViewAlphaAnimation.setDuration(ANIMATION_DURATION);
        imageViewAlphaAnimation.start();

        textView.setText(textView.getText());
        FadeView(textView, ANIMATION_DURATION, new DecelerateInterpolator(), 1f, 0f, new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                int R = new Random().nextInt(255);
                int G = new Random().nextInt(255);
                int B = new Random().nextInt(255);
                imageView.setBackgroundColor(Color.rgb(R, G, B));
                ObjectAnimator imageViewAlphaAnimation = new ObjectAnimator().ofFloat(imageView, "alpha", 0f, 1f);
                imageViewAlphaAnimation.setDuration(ANIMATION_DURATION);
                imageViewAlphaAnimation.start();

                mathOperations = new MathOperations(new Random().nextInt(100) + 1, new Random().nextInt(100) + 1);

                int operation = new Random().nextInt(3);

                switch (operation) {
                    case 0:
                        textView.setText("F + S = R");
                        textView.append(String.format("\n%d + %d = %d", mathOperations.getFirstNumber(), mathOperations.getSecondNumber(), mathOperations.add()));
                        textView.append("\nClick Me");
                        break;
                    case 1:
                        textView.setText("F - S = R");
                        textView.append(String.format("\n%d - %d = %d", mathOperations.getFirstNumber(), mathOperations.getSecondNumber(), mathOperations.subFS()));
                        textView.append("\nClick Me");
                        break;
                    case 2:
                        textView.setText("S - F = R");
                        textView.append(String.format("\n%d - %d = %d", mathOperations.getSecondNumber(), mathOperations.getFirstNumber(), mathOperations.subSF()));
                        textView.append("\nClick Me");
                        break;
                }

                FadeView(textView, ANIMATION_DURATION, new AccelerateInterpolator(), 0f, 1f, null);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void FadeView(View view, int duration, Interpolator interpolator, float fromAlpha, float toAlpha, Animation.AnimationListener listener) {
        Animation viewAnimation = new AlphaAnimation(fromAlpha, toAlpha);
        viewAnimation.setDuration(duration);
        viewAnimation.setInterpolator(interpolator);
        viewAnimation.setAnimationListener(listener);
        view.setAnimation(viewAnimation);
        view.animate();
    }
}
