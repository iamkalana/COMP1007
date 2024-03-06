public class Date 
{
        //Class Fields
        private int dayOfMonth;
        private int monthOfYear;
        private int year;

        //Constructors With Parameters
        public Date(int pDayOfMonth, int pMonthOfYear, int pYear) 
        {
            if (pDayOfMonth <32)
            {
                dayOfMonth = pDayOfMonth;
            }

            if ((pMonthOfYear<13)&&(pMonthOfYear>0))
            {
                monthOfYear = pMonthOfYear;
            }

            if ((pYear==2020) || (pYear==2021))
            {
                year = pYear;
            }

        }


        //Copy Constructor
        public Date(Date pDate)
        {
         dayOfMonth = pDate.getDayOfMonth();
         monthOfYear = pDate.getMonthOfYear();
         year = pDate.getYear();
        }


        //Default Constructor
        public Date() 
        {
            dayOfMonth = 1;
            monthOfYear = 1;
            year = 2020;
        }


        //Accessors

        public int getDayOfMonth() 
        {

            return dayOfMonth;
        }

        public int getMonthOfYear() 
        {

            return monthOfYear;
        }

        public int getYear() 
        {

            return year;
        }


        //Mutators

        public void setDayOfMonth(int pDayOfMonth) 
        {

            dayOfMonth = pDayOfMonth;
        }

        public void setMonthOfYear(int pMonthOfYear) 
        {

            monthOfYear = pMonthOfYear;
        }

        public void setYear(int pYear) 
        {

            year = pYear;
        }


     public String toString()
     {
        String dateString;
               dateString = "Day = " + dayOfMonth + " Month = " + monthOfYear + " Year = " + year;
        return dateString;
     }


}
