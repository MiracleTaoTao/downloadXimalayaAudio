package temt.download;

import temt.bean.AudioBean;
import temt.util.AudioDealUtil;

/**
 * @author temt
 * @time 2018年12月13日21:45:34
 * @time 2019年12月29日14:25:42 修改
 */
public class Main implements Runnable{

	private String albumId;//专辑ID
	
	public Main(){}
	
	public Main(String albumId){
		this.albumId = albumId;
	}
	
	@Override
	public void run() {
		try {
			downAudio(albumId);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void downAudio(String albumId) throws InterruptedException{
		
		//初始化音频列表，修改专辑ID便可下载该专辑的音频内容（非付费）
		AudioBean audioBean = AudioDealUtil.initBean(
				"https://www.ximalaya.com/revision/album",
				"albumId="+albumId); 
		
		//修改下载路径
		AudioDealUtil.initDownloadAudio("https://www.ximalaya.com/revision/album/v1/getTracksList",
				audioBean,
				"D://ximalaya03//");
	}
	
    public static void main(String[] args) throws InterruptedException{
    	Main thread01 = new Main("6661211");//《杉杉来吃》顾漫
    	Main thread02 = new Main("12040477");//人間失格
    	Main thread03 = new Main("31844110");//老舍名著《茶馆》地道北京话演绎
    	Main thread04 = new Main("10710983");//离婚 老舍先生的中篇小说
    	
    	Thread th01 = new Thread(thread01);
    	Thread th02 = new Thread(thread02);
    	Thread th03 = new Thread(thread03);
    	Thread th04 = new Thread(thread04);
    	
    	th01.start();
    	th02.start();
    	th03.start();
    	th04.start();

    }
}
