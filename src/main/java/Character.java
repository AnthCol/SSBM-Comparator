package src; 


/*
 * FIXME
 * 
 * Make a character screen where you select a character and then show how every single one of their damaging moves
 * ranks amongst the whole cast
 * 
 * Something like:
 * Ness
 * Picture
 * Select: (speed or damage)
 * 
 * Jab: 2nd
 * 
 * 
 * Dtilt: 1st
 * 
 * 
 * type of thing 
 * 
 */



public class Character {

    // FIXME maybe make these private later? with setters?
    // FIXME maybe make some toString() methods somewhere 
    public String characterName; 
    public String spritePath;  // printing path: assets\charData.txt
    public int[][] jabs;
    public int[][] tilts;
    public int[] dashAttack;
    public int[][] smashAttacks;
    public int[][] aerials;
    public int[][] specialAttacksGrounded; 
    public int[][] specialAttacksAerial;
    public int[][] grabs; 
    public int[][] grabThrows; 
    public int[][] dodgesRolls; 
    public int[] airDodge; 
    public float[] misc; 

    public String getCharName(){
        return characterName; 
    }

    public Character(){
        characterName = new String(); 
        spritePath = new String(); 
        jabs = new int[3][4]; 
        tilts = new int[3][4]; 
        dashAttack = new int[4]; 
        smashAttacks = new int[3][4]; 
        aerials = new int[5][4]; 
        specialAttacksGrounded = new int[4][4]; 
        specialAttacksAerial = new int[4][4];
        grabs = new int[2][2];  
        grabThrows = new int[4][4]; 
        dodgesRolls = new int[3][3]; 
        airDodge = new int[4]; 
        misc = new float[8]; 
    }
}



/* 
 * IMPORTANT INFO FROM OLD VERSION:
 *     indices for float array:
    0 - jab1 dmg
    1 - jab1 startup
    2 - jab1 active
    3 - jab1 ending
    4 - 7 -> jab2
    8 - 11 -> jab3
    12 - 15 -> ftilt
    16 - 19 -> utilt
    20 - 23 -> dtilt
    24 - 27 -> dashAttack
    28 - 31 -> fsmash
    32 - 35 -> usmash
    36 - 39 -> dsmash  
    40 - 43 -> nair
    44 - 47 -> fair 
    48 - 51 -> bair
    52 - 55 -> uair
    56 - 59 -> dair
    60 - 63 -> neutralBGrounded
    64 - 67 -> neutralBAerial
    68 - 71 -> sideBGrounded
    72 - 75 -> sideBAerial
    76 - 79 -> upBGrounded
    80 - 83 -> upBAerial
    84 - 87 -> downBGrounded
    88 - 91 -> downBAerial
    // for the grabs 0 = startup, 1 = total frames
    92 - 93 -> standGrab
    94 - 95 -> dashGrab
    // back to normal now
    96 - 99 -> fthrow
    100 - 103 -> bthrow
    104 - 107 -> dthrow
    108 - 111 -> uthrow
    // in the following: 0 = startup, 1 = invuln (Active), 2 = end
    112 - 114 -> spotDodge
    115 - 117 -> backRoll
    118 - 120 -> forwardroll
    // for airdodge, 0 = startup, 1 = active, 2 = end, 3 = special land lag 
    121 - 124 -> airDodge
    125 -> weight
    126 -> ffSpeed
    127 -> dashSpeed
    128 -> runSpeed
    129 -> wavedashLen // rank
    130 -> pldif // perfect ledgefash intangibility frames
    131 -> jumpSquat
    132 -> wallJump // 1 yes, 0 no. 
 * 
*/