package vuki.com.animations;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import vuki.com.animations.databinding.ActivitySharedElementTransitionBinding;

public class SharedElementTransitionActivity extends AppCompatActivity {
    ActivitySharedElementTransitionBinding binding;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        binding = DataBindingUtil.setContentView( this, R.layout.activity_shared_element_transition );

        Bundle b = getIntent().getExtras();
        if( b != null ) {
            String txt1 = (String) b.get( "tekst1" );
            binding.tekstTarget.setText( txt1 );
        }
        binding.slika1.setImageDrawable( ContextCompat.getDrawable( this, R.drawable.gorila ) );
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        supportFinishAfterTransition();
    }
}
