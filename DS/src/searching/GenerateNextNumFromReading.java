
package searching;

public class GenerateNextNumFromReading {
    public String generateNextNumFromReading(int n) {
        StringBuilder str = new StringBuilder("1");
        while(n-- > 1){
            StringBuilder temp = new StringBuilder();
            int count = 1;
            for(int i = 1; i < str.length(); i++){
                if(str.charAt(i) == str.charAt(i - 1))
                    count++;
                else{
                    // appending..
                    temp.append(count);
                    temp.append(str.charAt(i - 1));
                    count = 1;
                }
            }
            temp.append(count);
            temp.append(str.charAt(str.length() - 1));
            str = temp;
        }
        return str.toString();
    }
}
