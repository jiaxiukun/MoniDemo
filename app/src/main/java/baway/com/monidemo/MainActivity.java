package baway.com.monidemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                Been been = (Been) msg.obj;
                mTop_stories = been.top_stories;
                HomeAdapter homeAdapter = new HomeAdapter(mTop_stories, MainActivity.this);
                recyclerView.setAdapter(homeAdapter);
                homeAdapter.setItemClickListener(new HomeAdapter.MyItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(MainActivity.this, mTop_stories.get(position).title, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }
    };

    private List<Been.TopStoriesBean> mTop_stories;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取资源id
        initview();
        //网络请求数据
        getrequest();
    }

    private void initview() {
        recyclerView = (RecyclerView) findViewById(R.id.recy);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getrequest() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient ok = new OkHttpClient();

                Request request = new Request.Builder().url("http://news-at.zhihu.com/api/4/news/latest").build();

                //同步
                try {
                    Response response = ok.newCall(request).execute();
                    final String s = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //gson解析
                            Gson gson = new Gson();
                            Been been = gson.fromJson(s, Been.class);
                            Message msg = new Message();
                            msg.what = 0;
                            msg.obj = been;
                            handler.sendMessage(msg);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
