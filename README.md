# SSBM COMPARATOR

## What is this and what can it do?

SSBM Comparator is a Java Swing desktop application that allows the user to view, compare and rank (sort) character data from the video game
Super Smash Bros. Melee. 
It allows the user to:
- Compare data of up to four characters at once
- Compare the data of a character to the average of all characters
- View the current tier list
- View individual character data
- Rank (sort) all of the damaging moves in the game by their:
    -> Damage 
    -> Startup Frames 
    -> Active Frames
    -> Ending Frames
- Rank (sort) character attributes (such as fast falling speed), as well as data about non-damaging moves (such as spot dodge)

Check out the demo video below!
Please also see limitations section of this README as it makes reference to certain sections of this video. 

https://youtu.be/J__8x26bR50

----

## How do I install/use it?

You can head over to the "releases" section on the right of your screen (or alternatively, click here: https://github.com/AnthCol/SSBM-Comparator/releases/tag/v1.0), and download the .exe file from the zip there. There isn't a mini application where you choose where to install it. Just download, extract into a folder (or not) wherever you want and then create a shortcut so it's easier to find. 

**Heads up (WARNING)** -> Make sure to update the Java version on your device to version ???? - a recent one (I wrote it on Java 18). 
Otherwise, if you try to run the program, you will get stuck in an infinite error loop and have to 
restart your computer. 

----

## Why was this made?

I made this app primarily for myself and my friend who plays this game with me. 
Sometimes we like to chat about certain matchups/interactions/etc. and having an app like this where you could quickly look up data was ideal for that, so I made it!

----

## What did I learn from doing this?

This was my first ever experience using Java (and Java Swing), so I learned how to use the language a little bit. I don't have the OOP part down yet though. 

Outside of that, I think the most important thing that I learned from doing this project was to plan your projects out in advance. What I mean by this, is to document all the things you want to add, how you want them to look, and what programming techniques you want to use to accomplish those things. 
I didn't do any of this, outside of having an idea of what I wanted in my head, and got to coding immediately. This resulted in source code that is much longer than it should be, and much messier than it should be. 

Lastly, I learned that I really enjoy designing and creating GUI apps :) 

----

## How long did it take to make? (for v1.0)

May 10th, 2022 to July 8th, 2022

----

## Why is the source code so ugly?

This is a combination of lack of Java & OOP knowledge, as well as poor planning of the app itself. Once I started programming, I found it quite easy to just keep tagging on more and more features, and once that happened the code got messy very quickly since some of the features were not planned from the start. 

----

## What are the limitations and issues of this program?
### <u>Some of these things might be added/fixed in the future.</u> 


There are a large number of limitations in this program compared to what a *perfect* version of it would be like. For me (and my friends) personal needs though, it does the job well enough. 

The most important limitation with this app is that it does not include the weaker hits of moves. There are many moves where if they linger after you use them or if you hit them in a certain spot, they will do less damage, but this application only includes the data for the strong hits. 

The app is also missing some graphical elements. This isn't particularly an *issue*, but it would be very nice to see gifs of the moves playing with their hit/hurtboxes showing (like on https://meleeframedata.com). 

Like mentioned previously in the README, in the video you see me click on the "weight" attribute twice. That is a problem that I need to fix so that it displays the correct values on the initial click in that section *after* ranking damaging moves. 
Furthermore, I also need to update the "How To Use" section shown in the video so that it displays correct information. Most currently is correct, but there are a few things that need to be changed. 

Also, there are some **notes for the user** that are about very specific values below:
- The data for PLDIF (Perfect Ledgedash Invincibility Frames [aka GALINT]) is outdated
- **IMPORTANT - if a number is -1 in charData.txt or in the application itself is not available/doesnt exist/unable to be calculated (bowser down b active frames for example)**
- kirbys rapid jab is jab 3
- falcos active frames are for the laser, the end lag is how long it takes him to get down
- IC's projectile stays out for 61 frames, this is not included in the data, as there frame data is for the hammer that they swing out (which has a hitbox of its own, not just the ice)
- links rapid jab is not included in the data 
- links arrow charge data is *without holding down b*
- links arrow data active frames is for the arrow itself 
- same goes for links boomerang + catching data is not included 
- links active frames for down B is how long the bomb will stick around until it explodes in his hand 
- luigi and mario neutral b active frames number for the fireball
- mewtwo's jab2 is rapid jab, there is no jab 3
- mewtwo's neutral b damage is for its maximum charge - frame data is also for minimum charge time -> active frames are not for the shadow ball but for mewtwos animation itself - the value of one may be incorrect here, it is worth checking in the future looking at the hitboxes. For now assume the ball hits on frame 1 of release, and that the active frames are one. 
- mewtwo's throw data was calculated by hand (by me, [except for dthrow]) from looking at a gif, very likely could be incorrect by a small margin (1-2) frames *his backthrow is especially likely to be incorrect because of the way the hitboxes are shown in the gif*.
- game and watch side b is the default animation data, not corrected for any special effects of each potential number
- game and watch down B damage is maximum possible
- peach fsmash is the frame data from the gif on https://meleeframedata.com/peach calculated by hand by me - damage not included 
- peach turnip damage is listed as zero since there is so much variation
- the data refers to the pull itself, not the projectiles. The active frame of 1, is the first frame its in her hand. 
- pichu ftilt angle changes damage, damage listed as 8 on meleeframedata.com, not sure which one that is for. 
- pichu neutral B is active frames for the projectile, ending frames are likely incorrect, dont have full gif to work with atm, might look into it another time
- pikachu neutral B is active frames for the projectile, ending frames are correct though. 
- pichu/pikachu side B is no charge 
- pikachu up b hasno active frames or end frames because of the option to do it once or twice. see https://meleeframedata.com/pikachu for more. 
- no data for jigglypuff neutral b
- puff down b active frames may be one more than listed. Hard to tell with the gif on the website 
- roy neutral b damage is max charge. 
- samus neutral b damage is for maximum charge
- samus neutral b/side b/down b active frames are for the projectile, ending frames until she can move again
- sheiks neutral b data refers to throwing a full stack of needles, the damage is listed as 3% (which is the individual damage of each needle, although it technically changes based on distance)
- sheiks jab 3 is data for her rapid jab 
- yoshi up b active data is for the egg, ending frames are until he can act again
- young link rapid jab not included 
- young link neutral b active frames are for the projectile, ending frames are for how long it takes for him to move (same goes for his side b)
- young link down b ending frames are unlisted - incalculable with the gif - throwable after the active frames
- zelda side b data is for the shortest possible time it takes to cast the ability


There are also some aesthetic elements that could use an upgrade (for example some dropdown menus do not centre properly on the page )

----

## Special thanks to:
https://www.ssbwiki.com/Category:Head_icons_(SSBM) for the character head sprites.

https://meleeframedata.com and its creator Mitchell Meier (as well as all of the people that helped him make that website) for the data used to create this project. 