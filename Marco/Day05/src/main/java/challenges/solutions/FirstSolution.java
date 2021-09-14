package challenges.solutions;

import challenges.Main;
import lombok.extern.log4j.Log4j2;

@Log4j2

public class FirstSolution {
    static int breadth = Main.SCAN.nextInt();
    static int height = Main.SCAN.nextInt();
    static boolean flag = true;
    static String exceptionMessage = "Breadth and height must be positive";
    static{
        try{
            if(breadth <= 0 || height <= 0){
                flag = false;
                throw new Exception(exceptionMessage);
            }
        }catch(Exception e){
            log.debug(e);
        }

    }
    public static void solve(){
        if(flag){
            int area = breadth * height;
            log.info(area);
        }
    }
    }

