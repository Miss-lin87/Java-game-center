import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class general_functions {
        static boolean regex_find_text(String text_input, String text_seartch){
        Pattern sertch = Pattern.compile(text_seartch);
        Matcher text = sertch.matcher(text_input);
        Boolean found = text.find();
    return found;
    }
}