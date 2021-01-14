package Behavioral.State.solving;

public class TCPConnection {

    private TCPConnectionState state = new ClosedTCPConnectionState(this);

    public void open(){
        state.open();
    }

    public void close(){
        state.close();
    }

    public void acknowledge() throws Exception{
        state.acknowledge();
    }

    public void setState(TCPConnectionState state) {
        this.state = state;
    }
}
