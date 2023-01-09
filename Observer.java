public interface Observer {
    
    public void Update();

    public void sendMessageTo(Subject s, Message m);

    public void receiveMessage(Message m);

}
