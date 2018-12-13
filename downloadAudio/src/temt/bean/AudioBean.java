package temt.bean;

/**
 * 音频文件Bean
 */
public class AudioBean {

    /**
     * 专辑ID
     */
    private String albumId;

    /**
     * 总条数
     */
    private int trackTotalCount;

    /**
     * 当前页数
     */
    private int pageNum;

    /**
     * 每页条数
     */
    private int pageSize;

    /**
     * 总页数
     */
    private int totalPage;

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public int getTrackTotalCount() {
        return trackTotalCount;
    }

    public void setTrackTotalCount(int trackTotalCount) {
        this.trackTotalCount = trackTotalCount;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "AudioBean{" +
                "albumId='" + albumId + '\'' +
                ", trackTotalCount=" + trackTotalCount +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                '}';
    }
}
