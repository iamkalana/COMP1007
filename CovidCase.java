import java.util.*;
import java.io.*;


public class CovidCase
{

    //Class Fields
    private String country;
    private String province;
    private String region;
    private String ageGroup;
    private String sex;
    private int cases;
    private Date theDate;

    //Create Object Arrays
    private static Date dateArray[];
    private static CovidCase covidCaseArray[];

    //No Of Objects
    int n = 101113;

    //Scanner
    Scanner sc = new Scanner(System.in);


    //Constructors With Parameters
    public CovidCase(String pCountry, String pProvince, String pRegion, String pAgeGroup, String pSex, int pCases) 
    {
        country  = pCountry;
        province = pProvince;
        region   = pRegion;
     
        if (!(pAgeGroup.isEmpty()))
        {
            ageGroup = pAgeGroup;
        }

        if ((pSex.equals("M")) || (pSex.equals("F")) || (pSex.equals("NA")))
        {
            sex = pSex;
        }

        if (pCases > 0)
        {
            cases = pCases;
        }
    }

    //Copy Constructor
    public CovidCase(CovidCase pCovidCase)
    {
        country = pCovidCase.getCountry();
        province = pCovidCase.getProvince();
        region = pCovidCase.getRegion();
        ageGroup = pCovidCase.getAgeGroup();
        sex = pCovidCase.getSex();
        cases = pCovidCase.getCases();

    }

    //Default Constructor
    public CovidCase() 
    {
        country  = "Default";
        province = "Default";
        region   = "Default";
        ageGroup = "Default";
        sex      = "Default";
        cases    = 0;
    }


    //Accessors
    public String getCountry() 
    {

        return country;
    }

    public String getProvince() 
    {

        return province;
    }

    public String getRegion() 
    {

        return region;
    }

    public String getAgeGroup() 
    {

        return ageGroup;
    }

    public String getSex() 
    {

        return sex;
    }

    public int getCases() 
    {

        return cases;
    }


    //Mutators
    public void setCountry(String pCountry) 
    {

        country = pCountry;
    }

    public void setProvince(String pProvince) 
    {

        province = pProvince;
    }

    public void setRegion(String pRegion) 
    {

        region = pRegion;
    }

    public void setAgeGroup(String pAgeGroup) 
    {

        ageGroup = pAgeGroup;
    }

    public void setSex(String pSex) 
    {

        sex = pSex;
    }

    public void setCases(int pCases) 
    {

        cases = pCases;
    }


    //Reading the File and adding data to constructors
    public void readFile(String pFile) 
    {
        String line;
        FileInputStream stream = null;
        InputStreamReader reader;
        BufferedReader bfrReader;


        try 
        {

            stream = new FileInputStream(pFile);
            reader = new InputStreamReader(stream);
            bfrReader = new BufferedReader(reader);

            //To skip first row
            bfrReader.readLine();

            //Declare Object count
            dateArray = new Date[n];
            covidCaseArray = new CovidCase[n];

            int i = 0;

            while ((line = bfrReader.readLine()) != null) 
            {

                //Split Array
                String[] splitArray = line.split(",");
                //System.out.println(line);

                //To Date class
                dateArray[i] = new Date(Integer.parseInt(splitArray[0]), Integer.parseInt(splitArray[1]), Integer.parseInt(splitArray[2]));
                //To CovidCase class
                covidCaseArray[i] = new CovidCase(splitArray[3], splitArray[4], splitArray[5], splitArray[6], splitArray[7], Integer.parseInt(splitArray[8]));

                i++;

            }

            //Close File Stream
            stream.close();

        }

        //Catch Errors
        catch (IOException e) 
        {
            if (stream != null) 
            {
                try 
                {
                    stream.close();
                } 
                catch (IOException ex2) 
                {

                }
            }
            System.out.println("ERROR While File Processing  ERROR CODE: " + e.getMessage());
        }
    }


    /****************************************************************************************
    METHOD: Main Menu
    IMPORT: NONE
    EXPORT: NONE
    PURPOSE: Display Main menu
    ****************************************************************************************/

    public void mainMenu() 
    {

        System.out.println(""); //line space
        System.out.println("*************************************************************************************************************************");
        System.out.println("**********                                COVID-19 Data Analysis Program                                       **********");
        System.out.println("*************************************************************************************************************************");
        System.out.println(""); //line space


        System.out.println("Welcome to the COVID-19 Data Analysis Program. Make a selection from the menu below regarding the information you would like to see.");
        System.out.println(""); //line space
        System.out.println("Please select from the menu below");
        System.out.println(""); //line space


        //User choice
        int userChoiceOne;

        do 
        {
            System.out.println("*************************************************************************************************************************");
            System.out.println("**********                                             Main Menu                                               **********");
            System.out.println("*************************************************************************************************************************");
            System.out.println(""); //line space
            System.out.println("\t> 1. Statistics of entire nation");
            System.out.println("\t> 2. Statistics or regions");
            System.out.println("\t> 3. Exit.");

            System.out.println(""); //line space
            System.out.print("Your choice: ");
            System.out.println(""); //line space

            //get user input
            userChoiceOne = sc.nextInt();

            switch (userChoiceOne) 
            {
                case 1:
                    optionOne();

                    break;

                case 2:
                    optionTwo();

                    break;

                case 3:
                    System.out.println(""); //line space
                    System.out.println("**********************************************Thank you, Have a nice day :)**********************************************");
                    System.out.println(""); //line space

                    break;

                default:
                    System.out.println("Your input is not valid. Please try again...");


            }

        }
        while (userChoiceOne != 3);


    }


    /****************************************************************************************
    METHOD: OptionOne
    IMPORT: NONE
    EXPORT: NONE
    PURPOSE: Display option one menu
    ****************************************************************************************/


    public void optionOne() 
    {

        System.out.println(""); //line space
        System.out.println("Statistics for the entire nation: select from the menu below: ");
        System.out.println(""); //line space

        int userChoiceTwo;

        do 
        {
            System.out.println("\t> 1. Display the total number of COVID-19 cases.");
            System.out.println("\t> 2. Display the number of COVID-19 cases: Males.");
            System.out.println("\t> 3. Display the number of COVID-19 cases: Females.");
            System.out.println("\t> 4. Display the number of COVID-19 cases: 0-9 age group.");
            System.out.println("\t> 5. Display the number of COVID-19 cases: 10-19 age group.");
            System.out.println("\t> 6. Display the number of COVID-19 cases: 20-29 age group.");
            System.out.println("\t> 7. Display the number of COVID-19 cases: 30-39 age group.");
            System.out.println("\t> 8. Display the number of COVID-19 cases: 40-49 age group.");
            System.out.println("\t> 9. Display the number of COVID-19 cases: 50-59 age group.");
            System.out.println("\t> 10. Display the number of COVID-19 cases: 60-69 age group.");
            System.out.println("\t> 11. Display the number of COVID-19 cases: 70-79 age group.");
            System.out.println("\t> 12. Display the number of COVID-19 cases: 80-89 age group.");
            System.out.println("\t> 13. Display the number of COVID-19 cases: 90+ age group.");

            System.out.println(""); //line space
            System.out.print("Your choice: ");
            System.out.println(""); //line space

            //get user input
            userChoiceTwo = sc.nextInt(); //line space

            int count = 0;

            switch (userChoiceTwo) 
            {
                case 1:
                    for (int k = 0; k < n; k++) 
                    {
                    
                        count = count + covidCaseArray[k].getCases();

                    }
                    System.out.println(""); //line space
                    System.out.println("Total number of COVID-19 cases: " + count);
                    break;

                case 2:
                    for (int k = 0; k < n; k++) 
                    {
                        String data = covidCaseArray[k].getSex();
                        int cases = covidCaseArray[k].getCases();
                        if (data.equals("M")) 
                        {
                            count = count + cases;
                        }

                    }
                    System.out.println(""); //line space
                    System.out.println("Total number of male cases: " + count);
                    break;

                case 3:
                    for (int k = 0; k < n; k++) 
                    {
                        String data = covidCaseArray[k].getSex();
                        int cases = covidCaseArray[k].getCases();
                        if (data.equals("F")) 
                        {
                            count = count + cases;
                        }

                    }
                    System.out.println(""); //line space
                    System.out.println("Total number of female cases: " + count);
                    break;

                case 4:
                    for (int k = 0; k < n; k++) 
                    {
                        String data = covidCaseArray[k].getAgeGroup();
                        int cases = covidCaseArray[k].getCases();
                        if (data.equals("0-9")) 
                        {
                            count = count + cases;
                        }

                    }
                    System.out.println(""); //line space
                    System.out.println("Total number of cases for 0-9: " + count);
                    break;

                case 5:
                    for (int k = 0; k < n; k++) 
                    {
                        String data = covidCaseArray[k].getAgeGroup();
                        int cases = covidCaseArray[k].getCases();
                        if (data.equals("10-19")) 
                        {
                            count = count + cases;
                        }

                    }
                    System.out.println(""); //line space
                    System.out.println("Total number of cases for 10-19: " + count);
                    break;

                case 6:
                    for (int k = 0; k < n; k++) 
                    {
                        String data = covidCaseArray[k].getAgeGroup();
                        int cases = covidCaseArray[k].getCases();
                        if (data.equals("20-29")) 
                        {
                            count = count + cases;
                        }

                    }
                    System.out.println(""); //line space
                    System.out.println("Total number of cases for 20-29: " + count);
                    break;

                case 7:
                    for (int k = 0; k < n; k++) 
                    {
                        String data = covidCaseArray[k].getAgeGroup();
                        int cases = covidCaseArray[k].getCases();
                        if (data.equals("30-39")) 
                        {
                            count = count + cases;
                        }

                    }
                    System.out.println(""); //line space
                    System.out.println("Total number of cases for 30-39: " + count);
                    break;

                case 8:
                    for (int k = 0; k < n; k++) 
                    {
                        String data = covidCaseArray[k].getAgeGroup();
                        int cases = covidCaseArray[k].getCases();
                        if (data.equals("40-49")) 
                        {
                            count = count + cases;
                        }

                    }
                    System.out.println(""); //line space
                    System.out.println("Total number of cases for 40-49: " + count);
                    break;

                case 9:
                    for (int k = 0; k < n; k++) 
                    {
                        String data = covidCaseArray[k].getAgeGroup();
                        int cases = covidCaseArray[k].getCases();
                        if (data.equals("50-59")) 
                        {
                            count = count + cases;
                        }

                    }
                    System.out.println(""); //line space
                    System.out.println("Total number of cases for 50-59: " + count);
                    break;

                case 10:
                    for (int k = 0; k < n; k++) 
                    {
                        String data = covidCaseArray[k].getAgeGroup();
                        int cases = covidCaseArray[k].getCases();
                        if (data.equals("60-69")) 
                        {
                            count = count + cases;
                        }

                    }
                    System.out.println(""); //line space
                    System.out.println("Total number of cases for 60-69: " + count);
                    break;

                case 11:
                    for (int k = 0; k < n; k++) 
                    {
                        String data = covidCaseArray[k].getAgeGroup();
                        int cases = covidCaseArray[k].getCases();
                        if (data.equals("70-79")) 
                        {
                            count = count + cases;
                        }

                    }
                    System.out.println(""); //line space
                    System.out.println("Total number of cases for 70-79: " + count);
                    break;

                case 12:
                    for (int k = 0; k < n; k++) 
                    {
                        String data = covidCaseArray[k].getAgeGroup();
                        int cases = covidCaseArray[k].getCases();
                        if (data.equals("80-89")) 
                        {
                            count = count + cases;
                        }

                    }
                    System.out.println(""); //line space
                    System.out.println("Total number of cases for 80-89: " + count);
                    break;

                case 13:
                    for (int k = 0; k < n; k++) 
                    {
                        String data = covidCaseArray[k].getAgeGroup();
                        int cases = covidCaseArray[k].getCases();
                        if (data.equals("90+")) 
                        {
                            count = count + cases;
                        }

                    }
                    System.out.println(""); //line space
                    System.out.println("Total number of cases for 90+: " + count);
                    break;

                default:
                    System.out.println(""); //line space
                    System.out.println("Your input is not valid. Please try again...");
                    System.out.println(""); //line space
            }

        }
        while (!(userChoiceTwo == 1 || userChoiceTwo == 2 || userChoiceTwo == 3 || userChoiceTwo == 4 || userChoiceTwo == 5 || userChoiceTwo == 6 || userChoiceTwo == 7 || userChoiceTwo == 8 || userChoiceTwo == 9 || 
                 userChoiceTwo == 10 || userChoiceTwo == 11 || userChoiceTwo == 12 || userChoiceTwo == 13));

        //line break
        System.out.println(""); //line space
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println(""); //line space

        // Ask user Yes or No
        char userChoice;
        do 
        {
                System.out.print("Would you like to make another selection (Y or N)? ");

                //get user input (As an upper case letter and first letter of the word)
                userChoice = sc.next().toUpperCase().charAt(0);

                if (userChoice == 'Y') 
                {
                    optionOne();

                } else if (userChoice == 'N') 
                {
                    System.out.println(""); //line space
                    System.out.println("You are returning to main menu... ");
                    System.out.println(""); //line space

                } else 
                {
                    System.out.println(""); //line space
                    System.out.println("Your input is not valid. Please try again...");
                    System.out.println(""); //line space
                }


        }
        while (!(userChoice == 'Y' || userChoice == 'N'));

        System.out.println(""); //line space
    }



    /****************************************************************************************
    METHOD: optionTwo
    IMPORT: NONE
    EXPORT: NONE
    PURPOSE: Display option two menu
    ****************************************************************************************/

    public void optionTwo() 
    {

        //Menu break
        System.out.println("");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("");

        System.out.println("Statistics by Region: select from the menu below:");
        System.out.println("");

        System.out.println("Which region would you like statistics for?");
        System.out.println("");


        int userChoiceThree;

        do 
        {
            System.out.println("\t> 1. Flanders");
            System.out.println("\t> 2. Brussels");
            System.out.println("\t> 3. Wallonia");
            System.out.println("\t> 4. Unknown");

            System.out.println(""); //line space
            System.out.print("Your choice: ");
            System.out.println(""); //line space

            userChoiceThree = sc.nextInt();

            switch (userChoiceThree) 
            {
                case 1:
                    regionData("Flanders");
                    break;
                case 2:
                    regionData("Brussels");
                    break;
                case 3:
                    regionData("Wallonia");
                    break;
                case 4:
                    naCases();
                    break;

                default:
                    System.out.println(""); //line space
                    System.out.println("Your input is not valid. Please try again...");
                    System.out.println(""); //line space

            }


        }
        while ((userChoiceThree != 1) && (userChoiceThree != 2) && (userChoiceThree != 3) && (userChoiceThree != 4));


    }

    /****************************************************************************************
    METHOD: regionData
    IMPORT: pRegion
    EXPORT: NONE
    PURPOSE: Display counted regional data
    ****************************************************************************************/

    public void regionData(String pRegion) 
    {

        System.out.println(""); //line space

        System.out.println("Total number COVID-19 cases for " + pRegion + " is:" + rCases("CASES", pRegion));
        System.out.println("Total number COVID-19 male cases for " + pRegion + " is:" + rCases("M", pRegion));
        System.out.println("Total number COVID-19 female cases for " + pRegion + " is:" + rCases("F", pRegion));
        System.out.println("Total number COVID-19 cases in 0-9 age group for " + pRegion + " is:" + rCases("0-9", pRegion));
        System.out.println("Total number COVID-19 cases in 10-19 age group for " + pRegion + " is:" + rCases("10-19", pRegion));
        System.out.println("Total number COVID-19 cases in 20-29 age group for " + pRegion + " is:" + rCases("20-29", pRegion));
        System.out.println("Total number COVID-19 cases in 30-39 age group for " + pRegion + " is:" + rCases("30-39", pRegion));
        System.out.println("Total number COVID-19 cases in 40-49 age group for " + pRegion + " is:" + rCases("40-49", pRegion));
        System.out.println("Total number COVID-19 cases in 50-59 age group for " + pRegion + " is:" + rCases("50-59", pRegion));
        System.out.println("Total number COVID-19 cases in 60-69 age group for " + pRegion + " is:" + rCases("60-69", pRegion));
        System.out.println("Total number COVID-19 cases in 70-79 age group for " + pRegion + " is:" + rCases("70-79", pRegion));
        System.out.println("Total number COVID-19 cases in 80-89 age group for " + pRegion + " is:" + rCases("80-89", pRegion));
        System.out.println("Total number COVID-19 cases in 90+ age group for " + pRegion + " is:" + rCases("90+", pRegion));

        System.out.println(""); //line space

        // Ask user Yes or No
        char userChoice;
        do 
        {
            System.out.print("Would you like to make another selection (Y or N)? ");

            //get user input (As an upper case letter and first letter of the word)
            userChoice = sc.next().toUpperCase().charAt(0);

            if (userChoice == 'Y') 
            {
                optionTwo();

            } else if (userChoice == 'N') 
            {
                System.out.println(""); //line space
                System.out.println("You are returning to main menu...");
                System.out.println(""); //line space

            } else 
            {
                System.out.println(""); //line space
                System.out.println("Your input is not valid. Please try again...");
                System.out.println(""); //line space
            }


        }
        while (!(userChoice == 'Y' || userChoice == 'N'));

    }

    /****************************************************************************************
    METHOD: rCases
    IMPORT: pOption, pRegion
    EXPORT: count
    PURPOSE: Count regional cases
    ****************************************************************************************/

    public int rCases(String pOption, String pRegion) 
    {
        int count = 0;

        for (int k = 0; k < n; k++) 
        {

            String region = covidCaseArray[k].getRegion();
            String sex = covidCaseArray[k].getSex();
            String age = covidCaseArray[k].getAgeGroup();
            int cases = covidCaseArray[k].getCases();

            if (region.equals(pRegion)) 
            {

                switch (pOption) 
                {

                    case "CASES":
                        count = count + cases;
                        break;

                    case "M":
                        if (sex.equals("M")) 
                        {
                            count = count + cases;
                        }
                        break;
                    case "F":
                        if (sex.equals("F")) 
                        {
                            count = count + cases;
                        }
                        break;
                    case "0-9":
                        if (age.equals("0-9")) 
                        {
                            count = count + cases;
                        }
                        break;
                    case "10-19":
                        if (age.equals("10-19")) 
                        {
                            count = count + cases;
                        }
                        break;
                    case "20-29":
                        if (age.equals("20-29")) 
                        {
                            count = count + cases;
                        }
                        break;
                    case "30-39":
                        if (age.equals("30-39")) 
                        {
                            count = count + cases;
                        }
                        break;
                    case "40-49":
                        if (age.equals("40-49")) 
                        {
                            count = count + cases;
                        }
                        break;
                    case "50-59":
                        if (age.equals("50-59")) 
                        {
                            count = count + cases;
                        }
                        break;
                    case "60-69":
                        if (age.equals("60-69")) 
                        {
                            count = count + cases;
                        }
                        break;
                    case "70-79":
                        if (age.equals("70-79")) 
                        {
                            count = count + cases;
                        }
                        break;
                    case "80-89":
                        if (age.equals("80-89")) 
                        {
                            count = count + cases;
                        }
                        break;
                    case "90+":
                        if (age.equals("90+")) 
                        {
                            count = count + cases;
                        }
                        break;

                }

            }

        }


        return count;
    }

    /****************************************************************************************
    METHOD: naCases
    IMPORT: NONE
    EXPORT: NONE
    PURPOSE: Count unknown cases
    ****************************************************************************************/

    public void naCases()
    {
        int pCount = 0;
        int rCount = 0;
        int sCount = 0;
        int aCount = 0;

        for (int k = 0; k < n; k++) {
            String province = covidCaseArray[k].getProvince();
            String region = covidCaseArray[k].getRegion();
            String sex = covidCaseArray[k].getSex();
            String age = covidCaseArray[k].getAgeGroup();
            int cases = covidCaseArray[k].getCases();

            if (province.equals("NA"))
            {
                pCount = pCount + cases;
            }

            if (region.equals("NA"))
            {
                rCount = rCount + cases;
            }

            if (sex.equals("NA"))
            {
                sCount = sCount + cases;
            }

            if (age.equals("NA"))
            {
                aCount = aCount + cases;
            }

        }

        System.out.println("Total number of unknown province cases: " + pCount);
        System.out.println("Total number of unknown region cases: " + rCount);
        System.out.println("Total number of unknown gender cases: " + sCount);
        System.out.println("Total number of unknown age group cases: " + aCount);
        System.out.println(""); //line space

        // Ask user Yes or No
        char userChoice;
        do 
        {
            System.out.print("Would you like to make another selection (Y or N)? ");

            //get user input (As an upper case letter and first letter of the word)
            userChoice = sc.next().toUpperCase().charAt(0);

            if (userChoice == 'Y') 
            {
                optionTwo();

            } else if (userChoice == 'N') 
            {
                System.out.println(""); //line space
                System.out.println("You are returning to main menu...");
                System.out.println(""); //line space

            } else 
            {
                System.out.println(""); //line space
                System.out.println("Your input is not valid. Please try again...");
                System.out.println(""); //line space
            }


        }
        while (!(userChoice == 'Y' || userChoice == 'N'));


    }



}










