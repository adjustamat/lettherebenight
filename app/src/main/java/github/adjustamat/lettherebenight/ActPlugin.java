package github.adjustamat.lettherebenight;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.urbandroid.sleep.captcha.CaptchaSupport;
import com.urbandroid.sleep.captcha.CaptchaSupportFactory;

public class ActPlugin extends Activity implements OnTouchListener
{
   private static final String DBG = "ActPlugin";
   private CaptchaSupport support;
   
   @Override
   protected void onDestroy(){
      if(support != null)
         support.destroy();
      super.onDestroy();
   }
   
   @Override
   public void onBackPressed(){
      super.onBackPressed();
      if(support != null)
         support.unsolved(); // .unsolved() broadcasts an intent back to AlarmAlertFullScreen that captcha was not solved
   }
   
   @Override
   public void onUserInteraction(){
      super.onUserInteraction();
      if(support != null)
         support.alive(); // .alive() refreshes captcha timeout
      // - intended to be sent on user interaction primarily, but can be called anytime anywhere
   }
   
   @Override
   protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.act_plugin);
      // ...
      initialize(savedInstanceState, null);
   }
   
   protected void onNewIntent(Intent intent){
      super.onNewIntent(intent);
      initialize(null, intent);
   }
   
   private void initialize(Bundle savedInstanceState, Intent intent){
      try{
         support = CaptchaSupportFactory.create(this);
      }
      catch(RuntimeException exception){
         Log.e(DBG, "support is null because", exception);
         support = null;
      }
      if(support != null){
         if(support.isPreviewMode()){
            return;
         }
         else if(support.isOperationalMode()){
            //support.setRemainingTimeListener(remainingTimeListener);
         }
          /*
    When CaptchaSupport object is created you can
    get difficulty (1-5) : use CaptchaSupport.getDifficulty()
    call unsolved method when captcha was not solved but user left activity
    or use advanced features like CaptchaFinder for getting list of all available captchas on mobile and launch them via CaptchaLauncher
       */
      }
      
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