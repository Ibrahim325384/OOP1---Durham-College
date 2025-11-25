// Name: Ibrahim Khan
// Date: March 11, 2025
// Description: Learning to use enumerations

// import HoodieStyles.HoodieColour;
// import HoodieStyles.HoodieSize;
import HoodieStyles.*;
import College.CollegeProgram;
import College.*;
import static HoodieStyles.HoodieSize.*;
import static HoodieStyles.HoodieColour.*;
import static College.CollegeProgram.*;

public class Main {
    public static void main(String[] args) {
        enumerationDemo();
        inheritanceDemo();

        // Modify inheritance demo for the following:
        // Red XS Computer Design DEGREE
        // where degree is 4 years

        // make size look like XS and 32 for chest size when reported

        // list the CollegeProgram options

    }
    static void enumerationDemo(){

        hoodie[] inventory = {
                new hoodie(charcoal, medium),
                new hoodie(HoodieColour.green, extraLarge),
                new hoodie(charcoal, large),
                new hoodie(brown, HoodieSize.small),
                // Added stuff
                new hoodie(red, extraSmall),
                new hoodie(HoodieColour.red, HoodieSize.extraSmall)
        };

        for (CollegeProgram list: CollegeProgram.values()){
            System.out.println("\nCollege Program List: " + list.toString());
        }

        System.out.println("Here is the current inventory: ");
        for (hoodie item: inventory){
            System.out.println("\t" + item.toString());
        }
        System.out.println("\nCustom hoodie colours: ");
        for (HoodieColour option: HoodieColour.values()){
            System.out.println(option + " ");
        }
        System.out.println("\nCustom hoodie sizes: ");
        int index = 0;
        for (; index < HoodieSize.values().length - 1; index++){
            System.out.println(HoodieSize.values()[index].toString() + ", ");
        }
        System.out.println(HoodieSize.values()[index].toString());

        System.out.println("\nCollege programs: ");
        int index1 = 0;
        for (; index1 < CollegeProgram.values().length - 1; index1++){
            System.out.println("\t" + CollegeProgram.values()[index1].toString() + ", ");
        }
        System.out.println(HoodieSize.values()[index1].toString());
    }

    static void inheritanceDemo(){
        hoodie[] inventory = {
                new hoodie(green, large),
                new ProgramHoodie(cfnd, grey, small),
                new ProgramHoodie(cpa, brown, medium),
                new hoodie(grey, extraLarge),
                new ProgramHoodie(cdeg, red, extraSmall)
        };
    }
}