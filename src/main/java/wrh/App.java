package wrh;

public class App 
{
    public static void main( String[] args )
    {
       MatchRequester mr = new MatchRequester();
       try {
    	   System.out.println(mr.getResponse());
       } catch (Exception e) {
    	   System.out.println(e.toString());
       }
    }
}
