package project.cs442arafaliy.com.project;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class ListDetail extends ActionBarActivity {

    String selected_locations="Select Location from Map";
    TextView selected_location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);
        selected_location= (TextView) findViewById(R.id.textView);
        selected_location.setText(selected_locations);


    }
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

               Log.d("Request_code", String.valueOf(requestCode));
               String s=data.getStringExtra("address_of_location");
        Log.d("-------->Address:",s);
               selected_location.setText(s);
           }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setloc(View view) {

              Intent intent = new Intent(this,MapView.class);
              startActivityForResult(intent,0);
    }

    public void Save(View view) {

       String s= (String) selected_location.getText();

    }
}
