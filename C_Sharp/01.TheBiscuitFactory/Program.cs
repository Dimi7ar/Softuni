using System;

namespace _01.TheBiscuitFactory
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int biscuitsPerDay = int.Parse(Console.ReadLine());
            int workersCount = int.Parse(Console.ReadLine());
            int competingFatory = int.Parse(Console.ReadLine());
            
            double totalBiscuits = 0;
            for (int i = 1; i <= 30; i++)
            {
                if (i % 3 == 0)
                {
                    totalBiscuits += Math.Floor((biscuitsPerDay * 0.75) * workersCount);
                }
                else
                {
                    totalBiscuits += workersCount * biscuitsPerDay;
                }
            }
            Console.WriteLine($"You have produced {totalBiscuits} biscuits for the past month.");


            double percent = Math.Abs(((totalBiscuits - competingFatory) / competingFatory) * 100);
            if (totalBiscuits > competingFatory)
            {
                Console.WriteLine($"You produce {percent:F2} percent more biscuits.");
            }
            else if (totalBiscuits < competingFatory)
            {
                Console.WriteLine($"You produce {percent:F2} percent less biscuits.");
            }

        }
    }
}
