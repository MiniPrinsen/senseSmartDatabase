/*TJENA?????*/
import java.io.*;
import javax.servlet.*;
import java.net.URLEncoder;
import javax.servlet.http.*;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class MessageServlet extends HttpServlet {
	private int hej = 5;
        private int hej2 = 2;
    
    private PrintWriter out;
    String storedText = "";
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

        MongoDatabase database = mongoClient.getDatabase("touchpoints");

        MongoCollection collec1 = database.getCollection("touchpoints");
       

        FindIterable<Document> iter = collec1.find();
        MongoCursor it;
        
        Document as;
    
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
    throws ServletException, IOException {
        
        out = response.getWriter();
        
        
        
        out.println("TJENA ALLA HAHAa");
        String message = request.getParameter("message");
        getValuez();
        if (message != null){
            out.println("SA DU "+message+"??????");
        }
        /*Bot bot = new Bot();
        
        if (message != null){
            try {
                
              message = URLEncoder.encode(message, "UTF-8");
            } catch (UnsupportedEncodingException e) {
            }
            out.println(bot.getReply(message));
        }
        else{
            
                getValue();
        }*/
    }
    
    public void hello(){
        out.println("HEJ");
    }
    
       /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Server</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Server at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    public String getValue() throws IOException {
        it = iter.iterator();
        
        while (it.hasNext()){
        as = (Document)it.next();
        storedText = as.toString();
        out.println("NAME: "+as.getString("name"));
        out.println("COORDINATES: "+as.get("coordinates"));
        out.println("PICTURE: "+as.get("picture")+"\n");
      
  //then
        	
        if (as.get("toucnpoints") != null){
        }
//out.println(storedText);
        }
    return "";
    }
    
       public static boolean inRadius(double lat1, double lng1, double lat2, double lng2, int radius) {
        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        float dist = (float) (earthRadius * c);

        if (dist < radius)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
       
       
       public void doStuff(){
        try{   	
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			
         // Now connect to your databases
        
         out.println("Connect to database successfully");
         
         MongoDatabase database = mongoClient.getDatabase("test");
         
            MongoCollection<Document> collection = database.getCollection("cityobjects");
            out.println(collection.find().toString());
          
        /*
         collection.insertOne(new Document("address",
                new Document()
                        .append("salutation", Arrays.asList("helllo", "hej", 
                                "HEJ, kul att du är här!", "Tjena!")
                )));
	*/
      }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      }
        
   }
       
       public void getValuez(){
        String storedText = "";
        
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

        MongoDatabase database = mongoClient.getDatabase("test");

        MongoCollection collec1 = database.getCollection("cityobjects"); 
        
        
        FindIterable<Document> iter = collec1.find();
        
        MongoCursor it;
        
        it = iter.iterator();
        
        Document as;
        
        
        while (it.hasNext()){
            
            as = (Document)it.next();
            storedText = as.toString();
            as.remove("_id");
            out.println(as.toJson()+"HEJ");
//            out.println(as.get("salutation"));

           /* if (as.get("name") != null){
                 String hej = (as.get("name")).toString();
                     out.println("NAME: " + hej);
                 
            }
            
            if (as.get("coord") != null){
                 String hej = (as.get("coord")).toString();
                 out.println("\tCOORDS:\t\t\t" + hej);
                 
            }
              
            if (as.get("tumbnail") != null){
                 String hej = (as.get("tumbnail")).toString();
                 out.println("\tTMBNAIL:\t\t" + hej);
                 
            }
                
            if (as.get("image") != null){
                 String hej = (as.get("image")).toString();
                 out.println("\tIMG:\t\t\t" + hej);
                 
            }*/
           
 
        
        //}
        
        
        
        
    
        
        
        }
       }



}
    