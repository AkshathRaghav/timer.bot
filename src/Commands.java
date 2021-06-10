import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.* ;
import java.awt.event.*;
import javax.swing.Timer;
import static java.lang.Math.abs;

public class Commands extends ListenerAdapter {
    Dictionary<String, Long> times = new Hashtable<String, Long>();
    Dictionary<String, Boolean> timestart = new Hashtable<>();
    ArrayList<String> timerlist = new ArrayList<>() ;

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String content = event.getMessage().getContentRaw() ;
        String[] arg = event.getMessage().getContentRaw().split(" ");
        
        // starts the stopwatch 
        if  ( arg.length == 2 && (arg[0] + arg[1]).equalsIgnoreCase(Bot.prefix + "s") ) {
            times.put(Objects.requireNonNull(event.getMember()).getEffectiveName(), System.currentTimeMillis()) ;
            timestart.put(Objects.requireNonNull(event.getMember()).getEffectiveName(), true) ;

        }

        // ends the stopwatch ( offset of 2 for the time taken to type ) 
        else if  ( arg.length == 2 && (arg[0] + arg[1]).equalsIgnoreCase(Bot.prefix + "n") ) {
            String n = Objects.requireNonNull(event.getMember()).getEffectiveName() ;
            if (timestart.get(n) == null) {
                event.getChannel().sendMessage("Hey " + event.getMember().getAsMention() + ", start the stopwatch first").queue();
            }
            else {
                double time = ((double) System.currentTimeMillis() - times.get(n)) / 1000;
                EmbedBuilder info = new EmbedBuilder();
                info.setColor(0Xa80d2c);
                info.addField(n + "'s time : ", String.valueOf(abs(time)) + "seconds", true);
                event.getChannel().sendMessage(info.build()).queue();
                timestart.remove(n);
                times.remove(n) ; 
                info.clear();
            }

        }
        else if ( arg.length == 3 && (arg[0] + arg[1]).equalsIgnoreCase(Bot.prefix + "-t")  ) {
            timerlist.add(Objects.requireNonNull(event.getMember()).getEffectiveName()) ;
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    // You can change this to do whatever you want 
                    // timerlist.remove(0) gives the first person who was added in 
                    event.getChannel().sendMessage("Timer's up, " + timerlist.remove(0)).queue(); 
                }
            };
            Timer timer = new Timer(Integer.parseInt(String.valueOf(arg[2].charAt(arg[2].length()-1))) * 1000, taskPerformer);
            timer.setRepeats(false); // no repeat 
            timer.start();
        }
        
    }
}
