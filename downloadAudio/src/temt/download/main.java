package temt.download;

import temt.bean.AudioBean;
import temt.util.AudioDealUtil;

/**
 * @author temt
 * @time 2018年12月13日21:45:34
 * @time 2019年12月29日14:25:42 修改
 */public class main {

    public static void main(String[] args) throws InterruptedException{

        //初始化音频列表，修改专辑ID便可下载该专辑的音频内容（非付费）
        AudioBean audioBean = AudioDealUtil.initBean(
                "https://www.ximalaya.com/revision/album",
                "albumId=29527659");

        //修改下载路径
        AudioDealUtil.initDownloadAudio("https://www.ximalaya.com/revision/album/v1/getTracksList",
                audioBean,
                "D://ximalaya//");

    }
}
