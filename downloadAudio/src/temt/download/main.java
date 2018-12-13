package temt.download;

import temt.bean.AudioBean;
import temt.util.AudioDealUtil;

/**
 * @author temt
 * @time 2018年12月13日21:45:34
 */
public class main {

    public static void main(String[] args){

        //初始化音频列表
        AudioBean audioBean = AudioDealUtil.initBean(
                "https://www.ximalaya.com/revision/album",
                "albumId=7623782");

        AudioDealUtil.initDownloadAudio("https://www.ximalaya.com/revision/play/album",audioBean);

    }
}
