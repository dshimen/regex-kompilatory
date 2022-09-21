package dshimen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //(aa)*bb(a|b)(a)?
    public static void main(String[] args) throws IOException {
        System.out.println("Program sprawdza czy dany ciąg liter AB spełnia wyrażenie {aa}bb(a|b)[a]");
        String dataString = "";
        while(!dataString.equals("quit") && !dataString.equals("q")){
            System.out.print("Wpisz ciąg znaków składający się tylko z liter a i b: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            dataString = reader.readLine().toLowerCase();
            if(analyzeString(dataString)){
                System.out.println("Podany ciąg znaków spełania zadany regex (State A)");
            }else {
                System.out.println("Podany ciąg nie spełnia zadanego regexu (State N)");
            }
        }
    }
    public static boolean analyzeString(String dataString){
        char [] dataChar = dataString.toCharArray();
        int state = 0;
        for(int i = 0; i < dataChar.length; i++){
            if(dataChar[i] == 'a'){
                if(state == 0){
                    state = 1;
                }else if(state == 1){
                    state = 2;
                }else if(state == 2){
                    state = 1;
                }else if(state == 4){
                    state = 5;
                }else if(state == 5){
                    state = 6;
                }
                else {
                    return false;
                }
            }else if(dataChar[i] == 'b'){
                if(state == 0){
                    state = 3;
                }
                else if(state == 2){
                    state = 3;
                }else if(state == 3){
                    state = 4;
                } else if(state == 4){
                    state = 5;
                }
                else {
                    return false;
                }
            }else{
                return false;
            }
        }
        if(state == 6 || state == 5){
            return true;
        }else {
            return false;
        }
    }
}
