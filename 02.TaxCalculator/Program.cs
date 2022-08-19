using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http.Headers;

namespace _02.TaxCalculator
{
    internal class Program
    {
        static void Main(string[] args)
        {
            List<string> allCars = Console.ReadLine().Split(">>").ToList();
            double totalAgency = 0;
            for (int i = 0; i < allCars.Count; i++)
            {
                List<string> car = allCars[i].Split(' ').ToList();
                double euros = 0;
                string carModel = car[0];
                int years = int.Parse(car[1]);
                int km = int.Parse(car[2]);
                double increase = 0;
                if (car[0] == "family")
                {
                    euros += 50;
                    increase = km / 3000;
                    increase = increase * 12;
                    euros += increase;
                    euros -= years * 5;
                }
                else if (car[0] == "heavyDuty")
                {
                    euros += 80;
                    increase = km / 9000;                                                             w
                    increase = increase * 14;
                    euros += increase;
                    euros -= years * 8;
                }
                else if (car[0] == "sports")
                {
                    euros += 100;
                    increase = km / 2000;
                    increase = increase * 18;
                    euros += increase;
                    euros -= years * 9;
                }
                else
                {
                    Console.WriteLine("Invalid car type.");
                    continue;
                }

                totalAgency += euros;
                Console.WriteLine($"A {carModel} car will pay {euros:F2} euros in taxes.");
            }

            Console.WriteLine($"The National Revenue Agency will collect {totalAgency:F2} euros in taxes.");
        }
    }
}
