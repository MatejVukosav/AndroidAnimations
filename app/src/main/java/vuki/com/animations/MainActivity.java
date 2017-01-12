package vuki.com.animations;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import vuki.com.animations.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        binding = DataBindingUtil.setContentView( this, R.layout.activity_main );

        binding.btnAnim.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent intent = new Intent( MainActivity.this, AnimationsActivity.class );
                startActivity( intent );
            }
        } );

        binding.sharedLeTrAc.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent intent = new Intent( MainActivity.this, SharedElementTransitionActivity.class );
                Pair<View, String> s1 = Pair.create( (View) binding.slika1, "slika1" );
                Pair<View, String> t1 = Pair.create( (View) binding.tekstSource, "tekst1" );
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation( MainActivity.this, s1, t1 );
                Bundle bundle = new Bundle();
                bundle.putString( "tekst1", binding.tekstSource.getText().toString() );
                intent.putExtras( bundle );
                startActivity( intent, optionsCompat.toBundle() );
            }
        } );
    }
}
