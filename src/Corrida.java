import javax.sound.midi.SysexMessage;
import java.util.concurrent.CyclicBarrier;

public class Corrida {

    static final private int NUM_CORREDORES = 5;
    static final private int DIST = 50;
    private int lugar = 0;

    public Corrida(){

    }

    public int cheguei(){
        lugar++;
        return lugar;
    }



    public static void main(String[] args) {

        Corredor[] tds =  new Corredor[NUM_CORREDORES];
        Corrida c = new Corrida();
        CyclicBarrier barreira = new CyclicBarrier(NUM_CORREDORES, new Runnable() {
            @Override
            public void run() {
            }
        });

        for(int i = 0; i < NUM_CORREDORES; i++) {
            tds[i] = new Corredor(DIST, c, barreira);
            tds[i].start();
        }
    }
}