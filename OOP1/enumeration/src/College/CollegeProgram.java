// Name: Ibrahim Khan
// Date: March 11, 2025
// Description: Learning to use enumerations
package College;

public enum CollegeProgram {
    cfnd(1), cpgm(2), cpa(3), csty(3), cdeg(4);

    // Attributes
    private int myLength = 0;

    // Constructor
    CollegeProgram(int years){myLength = years;}

    // Accessor
    public int getLength() {return myLength;}
    public String getCredential(){
        final String CREDS[] = {"", "Certificate", "Diploma", "Advanced Diploma", "Degree"};
        return CREDS[myLength];
    }
    public String getProgramName(){
        String programName = "";
        switch (this){
            case cfnd:
                programName = "Computer Foundations";
                break;
            case cpgm:
                programName = "Computer Programmer";
                break;
            case cpa:
                programName = "Computer Programmer Analyst";
                break;
            case csty:
                programName = "Computer Systems Technology";
                break;
            case cdeg:
                programName = "Computer Design";
                break;
        }
        return programName;
    }
    @Override
    public String toString() {return String.format("%s (%s)", getCredential(), getProgramName());}
}
