package com.hifnawy.sampleandroidlibrarywithgithubpackages;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;

import com.hifnawy.math.MathOperations;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    MathOperations mathOperations;

    final int ANIMATION_DURATION = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    public void GenerateRandomMathOperation(View view) {
        textView.setText("Generating...");

        FadeView(textView, new DecelerateInterpolator(), 1f, 0f, new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
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

                FadeView(textView, new AccelerateInterpolator(), 0f, 1f, null);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void FadeView(View view, Interpolator interpolator, float fromAlpha, float toAlpha, Animation.AnimationListener listener) {
        Animation viewAnimation = new AlphaAnimation(fromAlpha, toAlpha);
        viewAnimation.setDuration(ANIMATION_DURATION);
        viewAnimation.setInterpolator(interpolator);
        viewAnimation.setAnimationListener(listener);
        view.setAnimation(viewAnimation);
        view.animate();
    }
}
