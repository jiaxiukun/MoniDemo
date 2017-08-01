package baway.com.monidemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by 贾秀坤 on 2017/7/31.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    //数据源
    private List<Been.TopStoriesBean> mTop_stoires;
    //接口实例
    private MyItemClickListener mItemClickListener;
    private Context context;

    public HomeAdapter(List<Been.TopStoriesBean> mTop_stoires, Context context) {
        this.mTop_stoires = mTop_stoires;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        MyViewHolder me = new MyViewHolder(view, mItemClickListener);
        return me;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(mTop_stoires.get(position).title);
        Glide.with(context).load(mTop_stoires.get(position).image).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return mTop_stoires != null ? mTop_stoires.size() : 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private MyItemClickListener myListener;
        private  ImageView imageView;
        private TextView tv;

        public MyViewHolder(View view, MyItemClickListener myItemClickListener) {
            super(view);
            //将全局的监听赋值给接口
            this.myListener = myItemClickListener;
            itemView.setOnClickListener(this);
            tv = (TextView) view.findViewById(R.id.tv_title);
            imageView = (ImageView) view.findViewById(R.id.image_Top);
        }

        /**
         * 实现OnClickListener接口重写的方法
         *
         * @param view
         */

        @Override
        public void onClick(View view) {
            if (myListener != null) {
                myListener.onItemClick(view, getPosition());
            }
        }
    }

    /**
     * 创建一个回调接口
     */
    public interface MyItemClickListener {
        void onItemClick(View view, int position);
    }

    /**
     * 在activity中adapter就是调用这个方法，将点击事件监听传递过去，并赋值给全局的监听
     */
    public void setItemClickListener(MyItemClickListener myItemClickListener) {
        this.mItemClickListener = myItemClickListener;
    }

}
