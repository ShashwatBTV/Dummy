package Utilities;

import java.util.HashMap;

public class CommonData {

    HashMap<String, String> headers;

    public HashMap<String, String> getHeader(){
        headers = new HashMap();
        headers.put("accept", "application/json");
        headers.put("accept-encoding", "gzip");
        headers.put("Content-Type", "application/json");
        return headers;
    }
}