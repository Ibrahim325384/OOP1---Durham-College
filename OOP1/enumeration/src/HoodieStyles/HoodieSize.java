// Name: Ibrahim Khan
// Date: March 11, 2025
// Description: Learning to use enumerations
package HoodieStyles;

public enum HoodieSize {
    extraSmall(32, "XS"), small(36, "S"), medium(40, "M"),
    large(42, "L"), extraLarge(46, "XL");

    // Attributes
    private int myChestSize;
    private String mySizeCode;

    // Constructor
    HoodieSize(int chestSize, String sizeCode){
        myChestSize = chestSize;
        mySizeCode = sizeCode;
    }

    // Accessor
    public int chestSize() {return myChestSize;}
    public String sizeCode() {return mySizeCode;}
    @Override
    public String toString() {return String.format("%s, (%d)", mySizeCode, myChestSize);}
}
