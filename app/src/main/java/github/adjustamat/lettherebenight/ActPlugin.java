package github.adjustamat.lettherebenight;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class ActPlugin extends Activity implements OnTouchListener
{
   
   @Override
   protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.act_plugin);
   }
   
   @Override
   public boolean onTouch(View view, MotionEvent event){
      return false;
   }
   
   @Override
   public void onPointerCaptureChanged(boolean hasCapture){
      super.onPointerCaptureChanged(hasCapture);
   }
}