import java.util.ArrayList;
import java.util.List;

public class Fieldbase implements Observer, Subject {

    private List<Observer>spies = new ArrayList<>();
    Message m = new Message();

    EncryptandDecrypt encryption = new EncryptandDecryptA();
    
    @Override
    public void Add(Observer x) {
        spies.add(x);
        System.out.println("Spy added");
    }

    @Override
    public void Remove(Observer x) {
        spies.remove(x);
        System.out.println("Spy removed"); 
    }

    @Override
    public void sendMessageTo(Observer o, Message m) {
        if(spies.contains(o)){
            o.receiveMessage(encryption.Encrypt(m));
        }  
    }

    @Override
    public void Update() {
        for(Observer x : spies){
            x.Update();
        }
        System.out.println(spies);
    }

    @Override
    public void sendMessageTo(Subject s, Message m) {
        if(s.getObservers().contains(this)){
            s.receiveMessage(encryption.Encrypt(m));
        }
    }

    @Override
    public void receiveMessage( Message m) {
        this.m = encryption.Decrypt(m);
    }

    @Override
    public List<Observer> getObservers() {
        return spies;
    }
}
