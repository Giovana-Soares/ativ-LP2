package multihreads;

import java.security.SecureRandom;

public class readBuffer implements Runnable{
  private static final SecureRandom
  generator = new SecureRandom();
  private final buffer sharedLocation;

  public readBuffer(buffer sharedLocation){
    this.sharedLocation = sharedLocation;
  }
  public void run(){
    int sum = 0;
    for(int count = 1; count <=10; count ++){
      try{
        Thread.sleep(generator.nextInt(3000));
        sum += sharedLocation.getBuffer();
        System.out.printf("\t\t\t%2d%n", sum);
      }
      catch(InterreruptedException e){
        Thread.currentThread().interrupt();
      }
    }
    System.out.printf("%n%s %d%n%S%n",
              "Leitura do total de valores: ",
              sum, "Leitura finalizada!");
  }
}