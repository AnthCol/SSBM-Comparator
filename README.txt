<<<< SSBM COMPARATOR >>>>

<<<<<<<<<< WHAT IS THIS? >>>>>>>>>>

SSBM Comparator is a Java Swing desktop application that allows the user to view, compare and rank (sort) character data from the video game
Super Smash Bros. Melee. 
It allows the user to:
- Compare data of up to four characters at once
- Compare the data of a character to the average of all characters
- View the current tier list
- View individual character data
- Rank (sort) all of the damage moves in the game by their:
    -> Damage 
    -> Startup Frames 
    -> Active Frames
    -> Ending Frames
- Rank (sort) character attributes (such as fast falling speed), as well as data about non-damaging moves (such as spot dodge)
 


<<<<<<<<<< WHY WAS THIS MADE? >>>>>>>>>>

Mainly for my personal use when discussing the game with friends, or when thinking about it on my own. 



<<<<<<<<<< HOW LONG DID IT TAKE TO MAKE? >>>>>>>>>>

May 10th, 2022 to **unfinished**



<<<<<<<<<< DEMO VIDEO >>>>>>>>>>

Link here: **unfinished**



<<<<<<<<<< WHY IS THE SOURCE CODE SO GROSS? >>>>>>>>>>

This project was my self-taught introduction to Java and OOP, before writing this I only had experience with C and HTML/CSS. As such it reflects my lack of experience. 
    -> Will I fix it?
    Maybe. The app works as intended and runs at an acceptable speed, so there isn't a lot of motivation for me to go back 
    and make it pretty. 
    Honestly, I think if I were to fix it, I would rewrite the entire thing. 
    Any updates I make to it in the future will just be to the tier list which are pretty easy changes to make. 
    The rest of the data isn't going to change as the game and it's data has been around since late 2001. 
    The only changes I would consider going back to make are the ones in the limitations section below (but again, they
    would likely come with a complete rework). 



<<<<<<<<<< WHAT DID I LEARN FROM MAKING THIS? >>>>>>>>>>

Like mentioned before, this was my first introduction to Java, OOP, and GUI development. On top of those things, I think the most important thing I learned
from this experience is that if I ever am developing something this large again, make sure to plan a large chunk (or all of it) out before
going straight into coding. I found through making this that there were a lot of times that if I planned something before hand, I would have saved myself a
lot of time that ended up being used to re-design things. 



<<<<<<<<<< WHAT ARE THE LIMITATIONS OF THE PROGRAM? >>>>>>>>>>

The character data only includes strong hits of moves. Moves that linger and do less damage over time, as well as moves that have weak hitboxes or multiple hits are not included in the 
data set for this application (> for multiple hits, only the first hit data is shown). This may be something I go to allow for in the future, we'll see. 

There are no visuals to show hitboxes of moves. As such, there is no way for the user to compare how large a hitbox is, or any data regarding that. 
Again, I may include data about character model sizes, as well as hitbox & hurtbox sizes, but we'll see. 

            **NOTES FOR THE USER:**
            > kirbys rapid jab is jab 3
            > falcos active frames are for the laser, the end lag is how long it takes him to get down
            > IC's projectile stays out for 61 frames, this is not included in the data, as there
                frame data is for the hammer that they swing out (which has a hitbox of its own, not just
                the ice)
            > links rapid jab is not included in the data 
            > links arrow charge data is *without holding down b*
            > links arrow data active frames is for the arrow itself 
            > same goes for links boomerang + catching data is not included 
            > links active frames for down B is how long the bomb will stick around until it explodes in his hand 
            > luigi and mario neutral b active frames number for the fireball
            > mewtwo's jab2 is rapid jab, there is no jab 3
            > mewtwo's neutral b damage is for its maximum charge - frame data is also for minimum charge time -> active frames are not for the 
                shadow ball but for mewtwos animation itself - the value of one may be incorrect here, it is worth checking in the future looking
                at the hitboxes. For now assume the ball hits on frame 1 of release, and that the active frames are one. 
            > mewtwo's throw data was calculated by hand (by me, [except for dthrow]) from looking at a gif, very likely could be incorrect by a small margin (1-2) frames. 
                *his backthrow is especially likely to be incorrect because of the way the hitboxes are shown in the gif*
            > 

<<<<<<<<<< SPECIAL THANKS TO: >>>>>>>>>>

https://www.ssbwiki.com/Category:Head_icons_(SSBM) for the character head sprites.

https://meleeframedata.com and its creator Mitchell Meier (as well as all of the people that helped him make that website) for the data used to create this project. 

    


