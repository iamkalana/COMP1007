public class CovidApp
{
    public static void main(String[] args)
    {
        CovidCase obj = new CovidCase();
        obj.readFile("COVID19BE_CASES.csv");
        obj.mainMenu();



    }
}
