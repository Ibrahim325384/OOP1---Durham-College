// Name: Ibrahim Khan
// Date: March 11, 2025
// Description: Learning to use enumerations

// import HoodieStyles.HoodieColour;
// import HoodieStyles.HoodieSize;
import HoodieStyles.*;

public class hoodie {
    // Attributes
    private HoodieColour myColour;
    private HoodieSize mySize;

    // Behaviours
    public hoodie(HoodieColour colour, HoodieSize size){
        myColour = colour;
        mySize = size;
    }

    // Overrides an existing method
    @Override
    public String toString(){
        return String.format("Hoodie: %s, %s", myColour, mySize);
    }
}
