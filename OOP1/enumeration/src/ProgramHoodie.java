// Name: Ibrahim Khan
// Date: March 11, 2025
// Description: Learning to use enumerations

import College.*;
import HoodieStyles.*;

public class ProgramHoodie extends hoodie {


    // Attributes
    private CollegeProgram myProgram;

    // Constructors
    public ProgramHoodie(CollegeProgram program, HoodieColour colour, HoodieSize size){
        super(colour, size);
        myProgram = program;
    }
    @Override
    // Accessor
    public String toString(){
        return String.format("%s %s", myProgram.toString(), super.toString());
    }


}
