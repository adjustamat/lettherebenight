package github.adjustamat.lettherebenight;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.urbandroid.sleep.captcha.CaptchaSupport;
import com.urbandroid.sleep.captcha.CaptchaSupportFactory;

public class ActSettings extends Activity
{
   private static final String DBG = "ActSettings";
   private CaptchaSupport support;
   
   @Override
   protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.act_settings);
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
         if(!support.isConfigurationMode()){
            Log.e(DBG, "not configuration mode!");
            finish();
            return;
         }
         // ...
      }
   }
}