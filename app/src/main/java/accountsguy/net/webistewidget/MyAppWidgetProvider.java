package accountsguy.net.webistewidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Button;
import android.widget.RemoteViews;

import java.util.Random;

/**
 * Created by advic on 24/03/2018.
 */

public class MyAppWidgetProvider extends AppWidgetProvider {


    private static final String ACTION_CLICK = "ACTION_CLICK";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {

        // Get all ids
        ComponentName thisWidget = new ComponentName(context,
                MyAppWidgetProvider.class);
        int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
        for (int widgetId : allWidgetIds) {
            // create some random data
            int number = (new Random().nextInt(100));

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                    R.layout.appwidget_provider_layout);

            Log.w("WidgetExample", String.valueOf(number));
            // Set the text
//            remoteViews.setTextViewText(R.id.update, String.valueOf(number));

            // Register an onClickListener
            Intent intent = new Intent(context, MyAppWidgetProvider.class);

            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
                    0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setOnClickPendingIntent(R.id.update, pendingIntent);
            appWidgetManager.updateAppWidget(widgetId, remoteViews);


            Intent configIntent = new Intent(context, MainActivity.class);
            PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);
            remoteViews.setOnClickPendingIntent(R.id.update, configPendingIntent);
            appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
        }
    }


//    @Override
//    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
//        super.onUpdate(context, appWidgetManager, appWidgetIds);
//
//        final int N = appWidgetIds.length;
//        // Perform this loop procedure for each App Widget that belongs to this provider
//        for (int i=0; i<N; i++) {
//            int appWidgetId = appWidgetIds[i];
//
//            // Create an Intent to launch Activity
//            Intent intent = new Intent(context, MainActivity.class);
//            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
//
//            // Get the layout for the App Widget and attach an on-click listener
//            // to the button
//            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout
//                    .appwidget_provider_layout);
//            views.setOnClickPendingIntent(R.id.widget_button, pendingIntent);
//
//            // Tell the AppWidgetManager to perform an update on the current app widget
//            appWidgetManager.updateAppWidget(appWidgetId, views);
//        }
//    }
}
