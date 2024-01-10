using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using PlanetWars.Models.MilitaryUnits;
using PlanetWars.Models.MilitaryUnits.Contracts;
using PlanetWars.Models.Planets.Contracts;
using PlanetWars.Models.Weapons;
using PlanetWars.Models.Weapons.Contracts;
using PlanetWars.Repositories;
using PlanetWars.Utilities.Messages;

namespace PlanetWars.Models.Planets
{
    public class Planet : IPlanet
    {
        private string name;
        private double budget;
        private double militaryPower;
        private UnitRepository unitRepository;
        private WeaponRepository weaponRepository;

        public Planet(string name, double budget)
        {
            this.Name = name;
            this.Budget = budget;
            this.unitRepository = new UnitRepository();
            this.weaponRepository = new WeaponRepository();
            
        }

        public string Name
        {
            get => this.name;
            private set
            {
                if (string.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException(ExceptionMessages.InvalidPlanetName);
                }
                this.name = value;
            }
        }

        public double Budget
        {
           get => this.budget;
           private set
           {
               if (value < 0)
               {
                   throw new ArgumentException(ExceptionMessages.InvalidBudgetAmount);
               }
               this.budget = value;
           }
        }

        public double MilitaryPower => this.militaryPower = CalcPower(Army, Weapons);

        public IReadOnlyCollection<IMilitaryUnit> Army => unitRepository.Models;

        public IReadOnlyCollection<IWeapon> Weapons => weaponRepository.Models;

        public void AddUnit(IMilitaryUnit unit)
        {
            this.unitRepository.AddItem(unit);
        }

        public void AddWeapon(IWeapon weapon)
        {
            this.weaponRepository.AddItem(weapon);
        }

        public string PlanetInfo()
        {
            var sb = new StringBuilder();
            sb.AppendLine($"Planet: {this.Name}");
            sb.AppendLine($"--Budget: {this.Budget} billion QUID");
            if (this.Army.Count == 0)
            {
                sb.Append("--Forces: No units");
            }
            else
            {
                
                sb.Append("--Forces: ");
                List<string> combatlist = new List<string>();
                foreach (var unit in this.Army)
                {
                    combatlist.Add(unit.GetType().Name);
                }

                sb.Append(string.Join(", ", combatlist));
            }
            if (this.Weapons.Count == 0)
            {
                sb.AppendLine();
                sb.Append("--Combat equipment: No weapons");
            }
            else
            {
                sb.AppendLine();
                sb.Append("--Combat equipment: ");
                List<string> combatlist = new List<string>();
                foreach (var unit in this.Weapons)
                {
                    combatlist.Add(unit.GetType().Name);
                }

                sb.Append(string.Join(", ", combatlist));

            }

            sb.AppendLine();
            sb.AppendLine($"--Military Power: {this.MilitaryPower}");
            return sb.ToString().TrimEnd();
        }

        public void Profit(double amount)
        {
            this.Budget += amount;
        }

        public void Spend(double amount)
        {
            if (this.Budget < amount)
            {
                throw new InvalidOperationException(ExceptionMessages.UnsufficientBudget);
            }
            this.Budget -= amount;
        }

        public void TrainArmy()
        {
            foreach (var unit in this.unitRepository.Models)
            {
                unit.IncreaseEndurance();
            }
        }

        private double CalcPower(IReadOnlyCollection<IMilitaryUnit> Army, IReadOnlyCollection<IWeapon> Weapons)
        {
            double unitsSum = 0;
            foreach (var unit in Army)
            {
                unitsSum += unit.EnduranceLevel;
            }

            double weaponSum = 0;
            foreach (var weapon in Weapons)
            {
                weaponSum += weapon.DestructionLevel;
            }

            double totalSum = unitsSum + weaponSum;
            if (Army.Any(u => u.GetType() == typeof(AnonymousImpactUnit)))
            {
                totalSum += totalSum * 0.30;
            }

            if (Weapons.Any(w => w.GetType() == typeof(NuclearWeapon)))
            {
                totalSum += totalSum * 0.45;
            }
            return totalSum;
        }
    }
}
