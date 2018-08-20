import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class getProject1 extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException{
        try {
            URL url = new URL ("http://localhost:7070/api/v2/projects/1");
            //String encoding = Base64.getEncoder().encodeToString(("test1:test1").getBytes("UTF-8"));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            //           connection.setRequestProperty ("Authorization", "Apikey" + api);
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader in   =
                    new BufferedReader (new InputStreamReader (content));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        res.getWriter().write("<html><body>Hi there. This is a response to getProject</body></html>");
    }
}
