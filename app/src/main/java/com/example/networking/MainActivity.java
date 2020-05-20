package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private String[] mountainNames={"Matterhorn","Mont Blanc","Denali"};
    private String[] mountainLocations={"Alps","Alps","Alaska"};
    private int[] mountainHeights={4478,4808,6190};
    private ArrayList<String> listData= new ArrayList<>(Arrays.asList(mountainNames));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,R.layout.list_item_textview,R.id.list_item_textview_xml,listData);

        ListView my_listview=(ListView) findViewById(R.id.listview);

        my_listview.setAdapter(adapter);

        my_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyAsyncTask extends AsyncTask {
                    public void doInBackground(){
        // your network code
                    }
                    public void onPostExecute(String s){
        // your code, parse the returned JSON in s
                    }
                }
            }
        });
    }
}
@SuppressLint("StaticFieldLeak")
private class JsonTask extends AsyncTask<String, String, String> {

    private HttpURLConnection connection = null;
    private BufferedReader reader = null;

    protected String doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && !isCancelled()) {
                builder.append(line).append("\n");
            }
            return builder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String json) {
        Log.d("TAG", json);
    }
}

