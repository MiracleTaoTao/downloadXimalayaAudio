package temt.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import temt.bean.AudioBean;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * @author temt
 * 音频处理工具类
 */
public class AudioDealUtil {

    /**
     * 初始化音频列表
     * @param url
     * @param param
     * @return
     */
    public static AudioBean initBean(String url,String param){
        AudioBean audioBean = new AudioBean();

        //获取数据
        String result = HttpUtil.sendGet(url,param);
        JSONObject resultJson = JSONObject.fromObject(result);
        JSONObject dataJson = resultJson.getJSONObject("data");
        String albumId = dataJson.getString("albumId");

        //获取专辑信息
        JSONObject tracksInfoJson = dataJson.getJSONObject("tracksInfo");
        int pageNum = tracksInfoJson.getInt("pageNum");
        int pageSize = tracksInfoJson.getInt("pageSize");
        int trackTotalCount = tracksInfoJson.getInt("trackTotalCount");

        //总共页码
        int totalPage = trackTotalCount/pageSize + 1;

        //封装对象
        audioBean.setTrackTotalCount(trackTotalCount);
        audioBean.setAlbumId(albumId);
        audioBean.setPageNum(pageNum);
        audioBean.setTotalPage(totalPage);
        audioBean.setPageSize(pageSize);

        return audioBean;
    }

    /**
     * 初始化音频下载列表数据
     * @param url
     * @param audioBean
     */
    public static void initDownloadAudio(String url,AudioBean audioBean){
        ////https://www.ximalaya.com/revision/play/album?
        int pageNum = audioBean.getPageNum();
        for(int j = 0 ; j < audioBean.getTotalPage() ; j++){
            String param = "albumId="+audioBean.getAlbumId()+"&pageNum="+(j+1)+"&sort=-1&pageSize="+audioBean.getPageSize();
            String result = HttpUtil.sendGet(url,param);

            JSONObject resultJson = JSONObject.fromObject(result);
            JSONObject dataJson = resultJson.getJSONObject("data");

            JSONArray tracksAudioPlayJSONArray = dataJson.getJSONArray("tracksAudioPlay");
            for(int i = 0 ; i < tracksAudioPlayJSONArray.size() ; i++){
                JSONObject object = tracksAudioPlayJSONArray.getJSONObject(i);
                String trackName = object.getString("trackName");
                String downloadUrl = object.getString("src");
                downloadAudio(downloadUrl,"D://download//",trackName);
            }
        }

    }

    /**
     * 下载音频
     * @param downloadUrl
     * @param targetUrl
     * @param fileName
     */
    public static void downloadAudio(String downloadUrl,String targetUrl,String fileName){

        try {
            // 创建连接、输入流
            InputStream in = new URL(downloadUrl).openConnection().getInputStream();
            String str = targetUrl+fileName+".mp3";
            FileOutputStream f = new FileOutputStream(str);
            byte[] bufferByte = new byte[1024]; // 接收缓存
            int len;
            while ((len = in.read(bufferByte)) > 0) {
                f.write(bufferByte, 0, len);
            }
            f.close();
            in.close();
            System.out.println(str + "****** success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
