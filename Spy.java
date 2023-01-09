public class Spy implements Observer {

    EncryptandDecrypt encryption = new EncryptandDecryptA();
    Message m = new Message();

    @Override 
    public void Update() {
        // updates spy
    }

    @Override
    public void sendMessageTo(Subject s, Message m) {
        if(s.getObservers().contains(this)){
            s.receiveMessage(encryption.Encrypt(m));
        }
        
    }

    @Override
    public void receiveMessage(Message m) {
        this.m = encryption.Decrypt(m);
        
    }

    
    
}
