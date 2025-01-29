package helpers;

import java.util.ArrayList;
import java.util.Arrays;

public class ExtractCredentials {

    /**
     * <p>This method gets the String where the usernames/passwords that are listed and convert it to ArrayList.<p/>
     * <p>By using method <code>.split("\\R")</code> with regex <code>"\\R"</code> each credential will be separated
     * to a unique array element</p>
     * <p>Then we convert Array to ArrayList by using method <code>Arrays.asList(credentialsArray)</code></p>
     * <p>Last step is to remove first redundant element = "Accepted usernames are:" or "Password for all users:"
     * from the ArrayList</p>
     * @param credentials is a String variable which contains credentials separated by the line brake
     * @return ArrayList of the credentials
     */
    public static ArrayList<String> extract(String credentials){
        String[] credentialsArray = credentials.split("\\R");

        ArrayList<String> credentialsArrayList = new ArrayList<>(Arrays.asList(credentialsArray));

        if(!credentialsArrayList.isEmpty() && credentialsArrayList.get(0).equals("Accepted usernames are:")||
                credentialsArrayList.get(0).equals("Password for all users:")){
            credentialsArrayList.remove(0);
        }

        return credentialsArrayList;
    }
}
