public class Runner {
    
    public static void main(String[] args){
		HomeBase h = HomeBase.getInstance();
        HomeBase g = HomeBase.getInstance();
        Fieldbase f1 = new Fieldbase();
        Fieldbase f2 = new Fieldbase();
        Message m = new Message();

        h.Add(f1);
        g.sendMessageTo(f1, m);
        h.Remove(f1);
        

        
	}

}
