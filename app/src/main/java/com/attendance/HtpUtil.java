package com.attendance;

import android.os.AsyncTask;
import android.widget.Toast;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by naver on 2017. 5. 30..
 */

public class HtpUtil extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
        try {
            //String url = "http://example.com/test.jsp";
            URL obj = new URL("http://localhost:52273/list");
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");


            byte[] outputInBytes = params[0].getBytes("UTF-8");
            OutputStream os = conn.getOutputStream();
            os.write( outputInBytes );
            os.close();

            String response = conn.getResponseMessage();
//
//                int retCode = conn.getResponseCode();
//
//                InputStream is = conn.getInputStream();
//                BufferedReader br = new BufferedReader(new InputStreamReader(is));
//                String line;
//                StringBuffer response = new StringBuffer();
//                while((line = br.readLine()) != null) {
//                    response.append(line);
//                    response.append('\r');
//                }
//                br.close();
//
//                String res = response.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
