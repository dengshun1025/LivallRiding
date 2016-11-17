package com.example.dengshun.test.Demo.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dengshun.test.Demo.Bean.Top5Bean;
import com.example.dengshun.test.Demo.Bean.TopicsBean;
import com.example.dengshun.test.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2016/7/5.
 */
public class CommunityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private RecyclerView mRecyclerView;
    //置顶数据
    private List<Top5Bean> toplist;
    //普通数据
    private List<TopicsBean> commonlist;


    public CommunityAdapter(Context context) {
        this.context = context;
        toplist = new ArrayList<>();
        commonlist = new ArrayList<>();
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.laiba_item_tv);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_community_list_common, parent, false);
        return new ViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return commonlist.size() + (toplist.size() == 0 ? 5 : toplist.size() + 1);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView=recyclerView;
    }

    /**
     * 初始话icon类型标记
     */
    private static ArrayList<String> listtype = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
    /**
     * 初始化icon图标
     */
    private static int[] resId = new int[]{R.drawable.community_ding, R.drawable.community_jing, R.drawable.community_lu, R.drawable.community_tu, R.drawable.community_you};

    private static int iconH;
    private static int iconW;

    public static Bitmap getIcon(Context context, List<String> l) {
        if (iconH == 0) {//获取标签bitmap宽高
            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.community_ding);
            iconH = bitmap.getHeight();
            iconW = bitmap.getWidth();
        }
        if (l.size() > 0) {
            //创建一个标签bitmap,添加右边距10
            Bitmap bitmap = Bitmap.createBitmap((int) (1.1f * iconW * l.size() + 9 * l.size()), iconH, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            for (int i = 0; i < l.size(); i++) {
                canvas.drawBitmap(BitmapFactory.decodeResource(context.getResources(), resId[listtype.indexOf(l.get(i))]), (int) (1.1f * i * iconW + i * 9), 0, paint);
            }
            return bitmap;
        }
        return null;
    }

}
