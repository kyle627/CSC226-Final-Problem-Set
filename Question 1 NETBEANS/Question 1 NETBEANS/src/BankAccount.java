/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
*/
package concurrencyeg1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class BankAccount
{
   private double balance;
   private double newBalance;
   private Lock balanceChangeLock;

   /**
      Constructs a bank account with a zero balance.
   */
   public BankAccount()
   {
      balanceChangeLock = new ReentrantLock();
      balance = 0;
      newBalance = 0;
   }

   /**
      Deposits money into the bank account.
      //@param amount the amount to deposit
   */
   public void deposit(double amount) {
      balanceChangeLock.lock();
      try{
         balance += amount;

         newBalance  = balance;
         System.out.print("Depositing " + amount + " , new balance is " + newBalance + amount + "\n");
      } finally {
         balanceChangeLock.unlock();
      }
   }
   
   /**
      Withdraws money from the bank account.
      //@param amount the amount to withdraw
   */
   public void withdraw(double amount) {
      balanceChangeLock.lock();
      try{
         balance += amount;
         newBalance  = balance;
         System.out.print("Withdrawing " + amount + ", new balance is " + newBalance + "\n");
      } finally {
         balanceChangeLock.unlock();
      }


   }
   
   /**
      Gets the current balance of the bank account.
      @return the current balance
   */
   public double getBalance()
   {
      return balance;
   }

}
