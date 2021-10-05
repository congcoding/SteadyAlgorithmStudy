using System;

public class Example
{
    public static void Main()
    {
        String[] s;

        Console.Clear();
        s = Console.ReadLine().Split(' ');

        int a = Int32.Parse(s[0]);
        int b = Int32.Parse(s[1]);
        
        for(var i=0; i < b; i++)
        {
            for(var j=0; j < a; j++)
            {
                Console.Write(string.Format("{0}", "*"));
            }
            
            Console.WriteLine("");
        }  
    }
}
