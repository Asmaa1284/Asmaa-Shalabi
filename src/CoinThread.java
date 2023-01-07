import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class CoinThread extends Thread {
   private Coin coin;

   public CoinThread(Coin coin) {
      this.coin = coin;
   }

   public void run() {
      coin.flip();
 }
   public static synchronized String generatePassword(String username) {
       String shortName = (username.length()<4) ? username : username.substring(0,4);
       Random generator = new Random();
       int randomDigits = generator.nextInt(900) + 100;
       System.out.println(shortName + randomDigits);
       return shortName + randomDigits;
    }

   public static void main(String[] args) {

      ConcurrentHashMap<String, String> usernamePasswordMap = new ConcurrentHashMap<>();
//      String userNameToCheck = "jmasters";
//      usernamePasswordMap.computeIfAbsent(
//           userNameToCheck, 
//           userName->generatePassword(userName)
//      );
      String userNameToCheck1 = "jmasters";
      String existingPassword = usernamePasswordMap.get(userNameToCheck1);
      System.out.println(usernamePasswordMap.toString());
      System.out.println(usernamePasswordMap.get(userNameToCheck1));
      if(existingPassword == null) {    
           //usernamePasswordMap.put(userNameToCheck1, generatePassword(userNameToCheck1));
           usernamePasswordMap.computeIfAbsent(
                   userNameToCheck1, 
                   userName->generatePassword(userName)
              );
           
      }
      System.out.println(usernamePasswordMap.toString());
      System.out.println("hello");

      

      
   }
}
