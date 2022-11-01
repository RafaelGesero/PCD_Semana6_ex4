import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Corredor extends Thread {
    private int dist;
    private Corrida corrida;
    private CyclicBarrier barreira;

    public Corredor(int dist, Corrida corrida, CyclicBarrier barreira) {
        this.dist = dist;
        this.corrida = corrida;
        this.barreira = barreira;
    }

    @Override
    public void run() {
        try {
            while(dist > 0) {
                dist--;
                Thread.sleep((int) (Math.random()*1000));
            }
            int lugar = corrida.cheguei();
            System.out.println("chegou" + getName());
            barreira.await();
            System.out.println(getName() + " : " + lugar + "o lugar");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}