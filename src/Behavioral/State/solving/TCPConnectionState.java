package Behavioral.State.solving;

public interface TCPConnectionState {
    void open();
    void close();
    void acknowledge() throws Exception;
}
