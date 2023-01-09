import java.util.ArrayList;
import java.util.List;

public class HomeBase implements Subject {

    private List<Observer>fbases = new ArrayList<>();
    EncryptandDecrypt encryption = new EncryptandDecryptA();
    Message m = new Message();
    static HomeBase homeBase;

    private HomeBase(){

    }

    public static HomeBase getInstance(){
        if(homeBase == null){
            homeBase = new HomeBase();
        }
        return homeBase;
    }

    @Override
    public void Add(Observer o) {
        fbases.add(o);
        System.out.println("Fieldbase added");
        
    }

    @Override
    public void Remove(Observer o) {
        fbases.remove(o);
        System.out.println("Fieldbase removed");
        
    }

    @Override
    public void Update() {
        for(Observer o : fbases){
            o.Update();
        }
        
    }

    @Override
    public void sendMessageTo(Observer o, Message m) {
        if(fbases.contains(o)){
            o.receiveMessage(encryption.Encrypt(m));
        }
        
    }

    @Override
    public void receiveMessage(Message m) {
        this.m = encryption.Decrypt(m);
        
    }

    public List<Observer> getObservers(){
        return fbases;
    }
    
    
    

}
