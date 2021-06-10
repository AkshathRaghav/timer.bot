import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import javax.security.auth.login.LoginException;

public class Bot {
    public static JDA jda ;
    public final static String prefix = ":c" ;
    public static void main(String[] args) throws LoginException {
        jda = JDABuilder.createDefault("<Insert token here>").build();
        jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
        jda.getPresence().setActivity(Activity.playing("with time for you"));
        jda.addEventListener(new Commands());

    }
}
