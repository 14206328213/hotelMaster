import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws Exception{
        String d="2019-01-04";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date=sdf.parse("2019-01-04");
    }
}
