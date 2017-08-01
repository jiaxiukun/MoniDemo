package baway.com.monidemo;

import java.util.List;

/**
 * Created by 贾秀坤 on 2017/7/31.
 */

public class Been {


    /**
     * date : 20170731
     * stories : [{"images":["https://pic1.zhimg.com/v2-e3bce8121d341f110ba10c168fe46fbc.jpg"],"type":0,"id":9546371,"ga_prefix":"073109","title":"想想看，好的主机游戏似乎只出在欧美日本，这是为什么？"},{"title":"本季《权力的游戏》的前两集，你可能错过了这几处细节","ga_prefix":"073108","images":["https://pic3.zhimg.com/v2-a741b965b1833553387a7353921f5f96.jpg"],"multipic":true,"type":0,"id":9549427},{"images":["https://pic3.zhimg.com/v2-63306d292bcb35dd06f95482a952e6e2.jpg"],"type":0,"id":9549436,"ga_prefix":"073107","title":"孙悟空是石头里来的，那石头是怎么来的？"},{"images":["https://pic1.zhimg.com/v2-ed3230fd62ff7f0aeaa6ee787ebdfc44.jpg"],"type":0,"id":9549326,"ga_prefix":"073107","title":"咖啡店老板想聘请一位店长，怎么防止他中饱私囊？"},{"images":["https://pic4.zhimg.com/v2-488af4a7a5765cb42569b46288b34bdb.jpg"],"type":0,"id":9549393,"ga_prefix":"073107","title":"机场、火车站修得那么高，嗯\u2026\u2026我怎么觉得有点浪费"},{"images":["https://pic4.zhimg.com/v2-80a522d413422e4d6ead0b48172ff4df.jpg"],"type":0,"id":9546040,"ga_prefix":"073106","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic2.zhimg.com/v2-419b3c943eb31712bc16277a9082c8d1.jpg","type":0,"id":9549427,"ga_prefix":"073108","title":"本季《权力的游戏》的前两集，你可能错过了这几处细节"},{"image":"https://pic3.zhimg.com/v2-e617519e63118ebf5192fc3547d1424e.jpg","type":0,"id":9549326,"ga_prefix":"073107","title":"咖啡店老板想聘请一位店长，怎么防止他中饱私囊？"},{"image":"https://pic4.zhimg.com/v2-46e20b43d76182de1c4b6b32909dbb2f.jpg","type":0,"id":9548975,"ga_prefix":"073017","title":"要员工加班，公司该多给多少钱才行？"},{"image":"https://pic4.zhimg.com/v2-86bd65e3118e2e410d8d0294107610ff.jpg","type":0,"id":9546480,"ga_prefix":"073013","title":"出现这么大的失误还能翻盘，我服服服服服"},{"image":"https://pic3.zhimg.com/v2-99ce918e1c6a7c7e1ea2918914323a46.jpg","type":0,"id":9548221,"ga_prefix":"073007","title":"重庆是座什么样的城市？"}]
     */

    public String date;
    public List<StoriesBean> stories;
    public List<TopStoriesBean> top_stories;

    public static Been objectFromData(String str) {

        return new com.google.gson.Gson().fromJson(str, Been.class);
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic1.zhimg.com/v2-e3bce8121d341f110ba10c168fe46fbc.jpg"]
         * type : 0
         * id : 9546371
         * ga_prefix : 073109
         * title : 想想看，好的主机游戏似乎只出在欧美日本，这是为什么？
         * multipic : true
         */

        public int type;
        public int id;
        public String ga_prefix;
        public String title;
        public boolean multipic;
        public List<String> images;

        public static StoriesBean objectFromData(String str) {

            return new com.google.gson.Gson().fromJson(str, StoriesBean.class);
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic2.zhimg.com/v2-419b3c943eb31712bc16277a9082c8d1.jpg
         * type : 0
         * id : 9549427
         * ga_prefix : 073108
         * title : 本季《权力的游戏》的前两集，你可能错过了这几处细节
         */

        public String image;
        public int type;
        public int id;
        public String ga_prefix;
        public String title;

        public static TopStoriesBean objectFromData(String str) {

            return new com.google.gson.Gson().fromJson(str, TopStoriesBean.class);
        }
    }
}
