package MyCollections;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
public class InternetCode {

    public static void main(String[] args) throws IOException {
        String LocalHostIp = InetAddress.getLocalHost().getHostAddress();
        Process p = Runtime.getRuntime().exec("ping "+ LocalHostIp);
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "GBK"))){
            String line;

            while((line=br.readLine())!=null){
                if(line.length()!=0)
                    sb.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(sb.toString());
    }
}
