package src.com.dcv.feb.day54;

import java.util.Comparator;


class SortByAverage100kDescending implements Comparator<CountryData>
{
    public int compare(CountryData a, CountryData b)
    {
        return b.getAverageCasesPer100k() - a.getAverageCasesPer100k();
    }
}