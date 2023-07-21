package vn.fpt.ph26439.mongodbcompass_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private Button btnSend,btnEdit,btnDelete;
    private RequestQueue requestQueue ;
    private EditText edIdUser,edIdTruyen,edNameTruyen,edDate,edNoidung;
//    public static final String API_POST = "http://127.0.0.1:3000/binhluan/addbinhluan";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSend = findViewById(R.id.btnSend);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);
        edIdUser = findViewById(R.id.edIdUser);
        edIdTruyen = findViewById(R.id.edIdTruyen);
        edNameTruyen = findViewById(R.id.edNameTruyen);
        edDate = findViewById(R.id.edDate);
        edNoidung = findViewById(R.id.edNoidung);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    JSONObject object = new JSONObject();
                    object.put("idUser",edIdUser.getText().toString());
                    object.put("idTruyen",edIdTruyen.getText().toString());
                    object.put("nameTruyen",edNameTruyen.getText().toString());
                    object.put("date",edDate.getText().toString());
                    object.put("noidung",edNoidung.getText().toString());
                    JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST,
                            ApiClass.API_POST, object
                            ,new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    requestQueue.add(objectRequest);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    JSONObject object = new JSONObject();
                    object.put("idUser",edIdUser.getText().toString());
                    object.put("idTruyen",edIdTruyen.getText().toString());
                    object.put("nameTruyen",edNameTruyen.getText().toString());
                    object.put("date",edDate.getText().toString());
                    object.put("noidung",edNoidung.getText().toString());
                    JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.PUT,
                            ApiClass.API_UPDATE, object
                            ,new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    requestQueue.add(objectRequest);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.DELETE,
                        ApiClass.API_DELETE, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                requestQueue.add(objectRequest);
            }
        });
    }
}