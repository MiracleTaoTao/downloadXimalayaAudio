package temt.download;

import temt.bean.AudioBean;
import temt.util.AudioDealUtil;

/**
 * @author temt
 * @time 2018年12月13日21:45:34
 */public class main {

    public static void main(String[] args){

        //初始化音频列表，修改专辑ID便可下载该专辑的音频内容（非付费）
        AudioBean audioBean = AudioDealUtil.initBean(
                "https://www.ximalaya.com/revision/album",
                "albumId=3127907");

        //
        AudioDealUtil.initDownloadAudio("https://www.ximalaya.com/revision/play/album",
                audioBean,
                "D://download//");

    }
}
