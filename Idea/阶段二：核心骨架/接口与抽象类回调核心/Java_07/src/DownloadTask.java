import interfaces.DownloadCallback;

class DownloadTask {
    public void startDownload(DownloadCallback callback) {
        // 模拟下载过程
        boolean success = Math.random() > 0.5;
        if (success) {
            callback.onSuccess("/sdcard/download/file.zip");
        } else {
            callback.onError("网络连接失败");
        }
    }
}
