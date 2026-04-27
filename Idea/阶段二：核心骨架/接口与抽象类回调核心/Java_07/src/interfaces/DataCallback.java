package interfaces;

@FunctionalInterface
public interface DataCallback {
    int onDataReceived(String data);
}
