public class StableMarriage
{
    private int N, engagedCount;
    private String[][] menPref;
    private String[][] womenPref;
    private String[] men;
    private String[] women;
    private String[] womenPartner;
    private boolean[] menEngaged;
 
    /** Constructor **/
    public StableMarriage(String[] m, String[] w, String[][] mp, String[][] wp)
    {
        N = mp.length;
        engagedCount = 0;
        men = m;
        women = w;
        menPref = mp;
        womenPref = wp;
        menEngaged = new boolean[N];
        womenPartner = new String[N];
        calcMatches();
    }
    /** function to calculate all matches **/
    private void calcMatches()
    {
        int iteration = 1;
        while (engagedCount < N)
        {
            int free;
            for (free = 0; free < N; free++)
                if (!menEngaged[free])
                    break;
 
            for (int i = 0; i < N && !menEngaged[free]; i++)
            {
                int index = womenIndexOf(menPref[free][i]);
                if (womenPartner[index] == null)
                {
                    womenPartner[index] = men[free];
                    menEngaged[free] = true;
                    engagedCount++;
                    System.out.println(men[free] + " is temporarily matched with " + women[index]);
                }
                else
                {
                    String currentPartner = womenPartner[index];
                    if (morePreference(currentPartner, men[free], index))
                    {
                        System.out.println(men[free] + " proposes and " + women[index] + " who was earlier engaged to " + currentPartner + 
                                    " but now chooses " + men[free] + " as her new partner.");
                        womenPartner[index] = men[free];
                        menEngaged[free] = true;
                        menEngaged[menIndexOf(currentPartner)] = false;
                    }else {
                        System.out.println(men[free] + " proposes but " + women[index] + " prefers her current partner " + currentPartner + " over " + men[free]);
                    }
                }
            }            
        }
        printCouples();
    }
    /** function to check if women prefers new partner over old assigned partner **/
    private boolean morePreference(String curPartner, String newPartner, int index)
    {
        for (int i = 0; i < N; i++)
        {
            if (womenPref[index][i].equals(newPartner))
                return true;
            if (womenPref[index][i].equals(curPartner))
                return false;
        }
        return false;
    }
    /** get men index **/
    private int menIndexOf(String str)
    {
        for (int i = 0; i < N; i++)
            if (men[i].equals(str))
                return i;
        return -1;
    }
    /** get women index **/
    private int womenIndexOf(String str)
    {
        for (int i = 0; i < N; i++)
            if (women[i].equals(str))
                return i;
        return -1;
    }
    /** print couples **/
    public void printCouples()
    {
        System.out.println();
        System.out.println("Couples are : ");
        for (int i = 0; i < N; i++)
        {
            System.out.println(womenPartner[i] +" "+ women[i]);
        }
    }
    /** main function **/
    public static void main(String[] args) 
    {
        /** list of men **/
        String[] m ={"Victor", "Wyatt", "Xavier", "Yancey", "Zeus"} ;
        /** list of women **/
        String[] w ={"Amy", "Bertha", "Clare", "Diane", "Erika"};;
 
        /** men preference **/
        String[][] mp = {
            {"Amy", "Bertha", "Clare", "Diane", "Erika"},  // Victor's preferences
            {"Bertha", "Clare", "Diane", "Amy", "Erika"},  // Wyatt's preferences
            {"Clare", "Diane", "Amy", "Bertha", "Erika"},  // Xavier's preferences
            {"Diane", "Amy", "Bertha", "Clare", "Erika"},  // Yancey's preferences
            {"Amy", "Bertha", "Clare", "Diane", "Erika"}   // Zeus's preferences
        };
        /** women preference **/                      
        String[][] wp = {
            {"Wyatt", "Xavier", "Yancey", "Zeus", "Victor"},   // Amy's preferences
            {"Xavier", "Yancey", "Zeus", "Victor", "Wyatt"},   // Bertha's preferences
            {"Yancey", "Zeus", "Victor", "Wyatt", "Xavier"},   // Clare's preferences
            {"Zeus", "Victor", "Wyatt", "Xavier", "Yancey"},   // Dianne's preferences
            {"Victor", "Wyatt", "Xavier", "Yancey", "Zeus"}    // Erika's preferences
        };
 
        StableMarriage gs = new StableMarriage(m, w, mp, wp);                        
    }
}