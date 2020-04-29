
/**
 * CSC-226 Concurrency Example Based on a sample program from C. Horstmann's Big
 * Java
  *
 * DESCRIPTION: This program runs two threads: 1) deposits $ and <br/>
 * 2) withdraws $ from the same bank account
 *
 * Demonstrates: Possible race condition caused by competition synchronization
 *
 */
 

package concurrencyeg1;

/**
 *
 * @author Anita
 */
public class ConcurrencyEg1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      BankAccount account = new BankAccount();
      final double AMOUNT = 100;
      final int REPETITIONS = 10;
      final int THREADS = 10;

      for (int i = 1; i <= THREADS; i++) {
         DepositRunnable d = new DepositRunnable(account, AMOUNT, REPETITIONS);
         WithdrawRunnable w = new WithdrawRunnable(account, AMOUNT, REPETITIONS);

         Thread dt = new Thread(d);
         Thread wt = new Thread(w);

         dt.start();
         wt.start();
      }
   }

}

