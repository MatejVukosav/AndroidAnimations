package vuki.com.animations;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.databinding.DataBindingUtil;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import vuki.com.animations.databinding.ActivityAnimationsBinding;

public class AnimationsActivity extends AppCompatActivity {
    ActivityAnimationsBinding binding;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        binding = DataBindingUtil.setContentView( this, R.layout.activity_animations );
    }

    /**
     * Used in xml as OnClick method for buttons
     *
     * @param view
     */
    public void startAnimation( View view ) {
        float dest = 0;
        ImageView animationImageView = (ImageView) findViewById( R.id.imageView1 );
        switch( view.getId() ) {

            case R.id.Button01:
                dest = 360;
                if( animationImageView.getRotation() == 360 ) {
                    dest = 0;
                }
                ObjectAnimator animation1 = ObjectAnimator.ofFloat( animationImageView, "rotation", dest );
                animation1.setDuration( 2000 );
                animation1.start();
                // Show how to load an animation from XML
                // Animation animation1 = AnimationUtils.loadAnimation(this,
                // R.anim.myanimation);
                // animation1.setAnimationListener(this);
                // animatedView1.startAnimation(animation1);
                break;

            case R.id.Button02:
                // shows how to define a animation via code
                // also use an Interpolator (BounceInterpolator)
                Paint paint = new Paint();
                TextView animationTextView = (TextView) findViewById( R.id.textView1 );
                float measureTextCenter = paint.measureText( animationTextView.getText().toString() );
                dest = 0 - measureTextCenter;
                if( animationTextView.getX() < 0 ) {
                    dest = 0;
                }
                ObjectAnimator animation2 = ObjectAnimator.ofFloat( animationTextView,
                        "x", dest );
                animation2.setDuration( 2000 );
                animation2.start();
                break;

            case R.id.Button03:
                // demonstrate fading and adding an AnimationListener

                dest = 1;
                if( animationImageView.getAlpha() > 0 ) {
                    dest = 0;
                }
                ObjectAnimator animation3 = ObjectAnimator.ofFloat( animationImageView,
                        "alpha", dest );
                animation3.setDuration( 2000 );
                animation3.start();
                break;

            case R.id.Button04:

                ObjectAnimator fadeOut = ObjectAnimator.ofFloat( animationImageView, "alpha", 0f );
                fadeOut.setDuration( 2000 );
                ObjectAnimator mover = ObjectAnimator.ofFloat( animationImageView, "translationX", -500f, 0f );
                mover.setDuration( 2000 );
                ObjectAnimator fadeIn = ObjectAnimator.ofFloat( animationImageView, "alpha", 0f, 1f );
                fadeIn.setDuration( 2000 );
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play( mover ).with( fadeIn ).after( fadeOut );
                animatorSet.start();
                break;

            default:
                break;
        }

    }

}
