package accountsguy.net.webistewidget;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O) // For getting Packing Information of the WebView.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        WebView webView = findViewById(R.id.website);
        String url = "https://acadgild.com/";

        Intent BrowserIntent = new Intent(Intent.ACTION_VIEW);
        BrowserIntent.setData(Uri.parse(url));
//        startActivity(BrowserIntent);

        // Always use string resources for UI text. This says something like "Share this photo with"
        String title = "Choose the Browser";
        // Create and start the chooser
        Intent chooser = Intent.createChooser(BrowserIntent, title);
        startActivity(chooser);
        finish();
    }
}
