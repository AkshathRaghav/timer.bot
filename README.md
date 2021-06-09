# timer.bot
A Discord bot which can be used as a timer and a stopwatch 

<hr>
* Watch this [tutorial](https://www.youtube.com/watch?v=jGrD8AZfTig) (till 08:00) to set your project up in Eclipse/IntelliJ 
* Since many things in JDA have been deprecated since this video was made, dont copy code from it
* Now, after making the folder for your classes, just add the two files above to it. 
* Make sure to add the token from the Discord Developer Portal ( Applications --> Bot --> Copy Token ) where indicated in the Bot class
* If you want to change the prefix, go to [Bot](https://github.com/AkshathRaghav/timer.bot/blob/main/src/Bot.java) class and change the prefix constant 
* The commands :c s and :c n are fairly quick for me to type out, but in case you wish to have more of a stopwatch offset, or a different command, go to [Commands](https://github.com/AkshathRaghav/timer.bot/blob/main/src/Commands.java) class and change the .equalsIgnoreCase() at lines 18, 25, and 40
* If you wish to change the task which the timer does, then replace lines 44-46 in [Commands](https://github.com/AkshathRaghav/timer.bot/blob/main/src/Commands.java) 
<hr>
