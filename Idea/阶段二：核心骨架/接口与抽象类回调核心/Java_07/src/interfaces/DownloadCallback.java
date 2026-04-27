package interfaces;

//========================================
// 回调接口示例 1：下载回调
//========================================
public interface DownloadCallback {
    void onSuccess(String filePath);

    void onError(String errorMsg);
}
