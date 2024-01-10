using System;
using System.Collections.Generic;
using System.Linq;

namespace _03.TheAngryCat
{
    internal class Program
    {
        static void Main(string[] args)
        {
            List<int> items = Console.ReadLine().Split(", ").Select(int.Parse).ToList();
            int cat = int.Parse(Console.ReadLine());
            string type = Console.ReadLine();
            

            if (type == "cheap")
            {
                CheapOnes(items, cat);
            }
            else if (type == "expensive")
            {
                ExpensiveOnes(items, cat);
            }
        }

        static void CheapOnes(List<int> items, int cat)
        {
            int sumLeft = 0;
            int sumRight = 0;
            string position = "";
            int value = items[cat];
            // LEFT
            for (int i = 0; i < cat; i++)
            {
                if (items[i] < value)
                {
                    sumLeft += items[i];
                }
            }

            // RIGHT
            for (int i = cat + 1; i < items.Count; i++)
            {
                if (items[i] < value)
                {
                    sumRight += items[i];
                }
            }

            if (sumLeft >= sumRight)
            {
                position = "Left";
            }
            else
            {
                position = "Right";
            }

            int bigger = Math.Max(sumLeft, sumRight);
            
            Console.WriteLine($"{position} - {bigger}");
        }
        static void ExpensiveOnes(List<int> items, int cat)
        {
            int sumLeft = 0;
            int sumRight = 0;
            string position = "";
            int value = items[cat];
            // LEFT
            for (int i = 0; i < cat; i++)
            {
                if (items[i] >= value)
                {
                    sumLeft += items[i];
                }
            }

            // RIGHT
            for (int i = cat + 1; i < items.Count; i++)
            {
                if (items[i] >= value)
                {
                    sumRight += items[i];
                }
            }

            if (sumLeft >= sumRight)
            {
                position = "Left";
            }
            else
            {
                position = "Right";
            }

            int bigger = Math.Max(sumLeft, sumRight);

            Console.WriteLine($"{position} - {bigger}");
        }
    }
}
