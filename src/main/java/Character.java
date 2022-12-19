package src; 


/*
 * FIXME
 * 
 * 
 * Maybe make toString() methods here?
 * 
 */

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

    // FIXME make these private later 
    public String characterName; 
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
    public float[] misc; 


    public Character(){
        characterName = new String(); 
        jabs = new int[3][4]; 
        tilts = new int[3][4]; 
        dashAttack = new int[4]; 
        smashAttacks = new int[3][4]; 
        aerials = new int[5][4]; 
        specialAttacksGrounded = new int[5][4]; 
        specialAttacksAerial = new int[5][4];
        grabs = new int[2][2];  
        grabThrows = new int[4][3]; 
        dodgesRolls = new int[4][4]; 
        misc = new float[8]; 
        initialize(); 
    }
/* 
    private void initialize(){
        characterName = ""; 
        variableLoop(jabs, jabs.length, jabs[0].length);  // jabs 
        variableLoop(tilts, tilts.length, tilts[0].length); // tilts
        for (int i = 0; i < dashAttack.length; i++){ // READ HERE BECAUSE 1D ARRAY     // dash attack
            dashAttack[i] = 1; 
        } 
        variableLoop(smashAttacks, smashAttacks.length, smashAttacks[0].length);     // smash attacks
        variableLoop(aerials, aerials.length, aerials[0].length);    // aerials
        variableLoop(specialAttacksGrounded, specialAttacksGrounded.length, specialAttacksGrounded[0].length);     // specialAttacksGroudned
        variableLoop(specialAttacksAerial, specialAttacksAerial.length, specialAttacksAerial[0].length);     // specialATtacksAerial
        variableLoop(grabs, grabs.length, grabs[0].length);    // grabs
        variableLoop(grabThrows, grabThrows.length, grabThrows[0].length);    // grabthrows
        variableLoop(dodgesRolls, dodgesRolls.length, dodgesRolls[0].length);     // dodges & rolls
        for (int i = 0; i < misc.length; i++){      // READ HERE BECAUSE FLOATS     // misc
            misc[i] = (float)1.00; 
        }
    }
*/
/* 
    private void variableLoop(int[][] array, int outer, int inner){
        for (int i = 0; i < outer; i++){
            for (int x = 0; x < inner; x++){
                array[i][x] = 1; 
            }
        }
    }
*/
    public void setCharName(String name){
        characterName = name; 
    }

    // FIXME GETTERS AND SETTERS FOR EVERYTHING  

}
