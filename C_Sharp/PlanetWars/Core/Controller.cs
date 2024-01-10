using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using PlanetWars.Core.Contracts;
using PlanetWars.Models.MilitaryUnits;
using PlanetWars.Models.MilitaryUnits.Contracts;
using PlanetWars.Models.Planets;
using PlanetWars.Models.Weapons;
using PlanetWars.Models.Weapons.Contracts;
using PlanetWars.Repositories;
using PlanetWars.Utilities.Messages;

namespace PlanetWars.Core
{
    public class Controller : IController
    {
        private readonly PlanetRepository planetRepository;
        public Controller() => planetRepository = new PlanetRepository();
        
        public string CreatePlanet(string name, double budget)
        {
            if (this.planetRepository.FindByName(name) != null)
            {
                return string.Format(OutputMessages.ExistingPlanet, name);
            }

            var planet = new Planet(name, budget);
            this.planetRepository.AddItem(planet);
            return string.Format(OutputMessages.NewPlanet, name);
        }
        public string AddUnit(string unitTypeName, string planetName)
        {
            var planet = this.planetRepository.FindByName(planetName);

            if (planet == null)
            {
                throw new InvalidOperationException(string.Format(ExceptionMessages.UnexistingPlanet, planetName));
            }

            if (unitTypeName != nameof(AnonymousImpactUnit) && unitTypeName != nameof(SpaceForces) && unitTypeName != nameof(StormTroopers))
            {
                throw new InvalidOperationException(string.Format(ExceptionMessages.ItemNotAvailable, unitTypeName));
            }

            if (planet.Army.Any(k => k.GetType().Name == unitTypeName))
            {
                throw new InvalidOperationException(string.Format(ExceptionMessages.UnitAlreadyAdded, unitTypeName,
                    planetName));
            }

            IMilitaryUnit unit = unitTypeName switch
            {
                nameof(AnonymousImpactUnit) => new AnonymousImpactUnit(),
                nameof(SpaceForces) => new SpaceForces(),
                nameof(StormTroopers) => new StormTroopers(),
                _ => throw new InvalidOperationException(string.Format(ExceptionMessages.ItemNotAvailable, unitTypeName))
            };
            if (planet.Budget >= unit.Cost)
            {
                planet.AddUnit(unit);
            }
            planet.Spend(unit.Cost);
            return string.Format(OutputMessages.UnitAdded, unitTypeName, planetName);
        }

        public string AddWeapon(string planetName, string weaponTypeName, int destructionLevel)
        {
            var planet = this.planetRepository.FindByName(planetName);

            if (planet == null)
            {
                throw new InvalidOperationException(string.Format(ExceptionMessages.UnexistingPlanet, planetName));
            }
            

            if (weaponTypeName != nameof(BioChemicalWeapon) && weaponTypeName != nameof(NuclearWeapon) && weaponTypeName != nameof(SpaceMissiles))
            {
                throw new InvalidOperationException(string.Format(ExceptionMessages.ItemNotAvailable, weaponTypeName));
            }
            if (planet.Weapons.Any(k => k.GetType().Name == weaponTypeName))
            {
                throw new InvalidOperationException(string.Format(ExceptionMessages.WeaponAlreadyAdded, weaponTypeName,
                    planetName));
            }


            IWeapon unit = weaponTypeName switch
            {
                nameof(BioChemicalWeapon) => new BioChemicalWeapon(destructionLevel),
                nameof(NuclearWeapon) => new NuclearWeapon(destructionLevel),
                nameof(SpaceMissiles) => new SpaceMissiles(destructionLevel),
                _ => throw new InvalidOperationException(string.Format(ExceptionMessages.ItemNotAvailable, weaponTypeName))
            };
            if (planet.Budget >= unit.Price)
            {
                planet.AddWeapon(unit);
            }

            planet.Spend(unit.Price);
            return string.Format(OutputMessages.WeaponAdded, planetName, weaponTypeName);
        }
        public string SpecializeForces(string planetName)
        {
            var planet = this.planetRepository.FindByName(planetName);

            if (planet == null)
            {
                throw new InvalidOperationException(string.Format(ExceptionMessages.UnexistingPlanet, planetName));
            }

            if (planet.Army.Count == 0)
            {
                throw new InvalidOperationException(ExceptionMessages.NoUnitsFound);
            }

            if (planet.Budget >= 1.25)
            {
                planet.TrainArmy();
            }
            planet.Spend(1.25);
            return string.Format(OutputMessages.ForcesUpgraded, planetName);
        }

        public string SpaceCombat(string planetOne, string planetTwo)
        {
            var planetAlpha = this.planetRepository.FindByName(planetOne);
            var planetBeta = this.planetRepository.FindByName(planetTwo);
            bool samePower = planetAlpha.MilitaryPower == planetBeta.MilitaryPower;
            if (samePower)
            {
                bool planetAlphaWeapon = planetAlpha.Weapons.Any(w => w.GetType().Name == nameof(NuclearWeapon)); 
                bool planetBetaWeapon = planetBeta.Weapons.Any(w => w.GetType().Name == nameof(NuclearWeapon));
                if ((!planetAlphaWeapon && !planetBetaWeapon) || (planetAlphaWeapon && planetBetaWeapon))
                {
                   planetAlpha.Spend(planetAlpha.Budget/2);
                   planetBeta.Spend(planetBeta.Budget/2);
                   return string.Format(OutputMessages.NoWinner);
                }
                else if (planetAlphaWeapon)
                {
                    var loserHalf = planetBeta.Budget / 2;
                    planetAlpha.Spend(planetAlpha.Budget / 2);
                    planetAlpha.Profit(loserHalf);
                    planetBeta.Spend(planetBeta.Budget / 2);
                    double loserSum = 0;
                    foreach (var unit in planetBeta.Army)
                    {
                        loserSum += unit.Cost;
                    }
                    foreach (var unit in planetBeta.Weapons)
                    {
                        loserSum += unit.Price;
                    }
                    planetAlpha.Profit(loserSum);
                    planetRepository.RemoveItem(planetTwo);
                    return string.Format(OutputMessages.WinnigTheWar, planetAlpha.Name, planetBeta.Name);
                }
                else if (planetBetaWeapon)
                {
                    var loserHalf = planetAlpha.Budget / 2;
                    planetBeta.Spend(planetBeta.Budget / 2);
                    planetBeta.Profit(loserHalf);
                    planetAlpha.Spend(planetAlpha.Budget / 2);
                    double loserSum = 0;
                    foreach (var unit in planetAlpha.Army)
                    {
                        loserSum += unit.Cost;
                    }
                    foreach (var unit in planetAlpha.Weapons)
                    {
                        loserSum += unit.Price;
                    }
                    planetBeta.Profit(loserSum);
                    planetRepository.RemoveItem(planetTwo);
                    return string.Format(OutputMessages.WinnigTheWar, planetBeta.Name, planetAlpha.Name);
                }
            }
            else
            {
                if (planetAlpha.MilitaryPower > planetBeta.MilitaryPower)
                {
                    var loserHalf = planetBeta.Budget / 2;
                    planetAlpha.Spend(planetAlpha.Budget / 2);
                    planetAlpha.Profit(loserHalf);
                    planetBeta.Spend(planetBeta.Budget / 2);
                    double loserSum = 0;
                    foreach (var unit in planetBeta.Army)
                    {
                        loserSum += unit.Cost;
                    }
                    foreach (var unit in planetBeta.Weapons)
                    {
                        loserSum += unit.Price;
                    }
                    planetAlpha.Profit(loserSum);
                    planetRepository.RemoveItem(planetTwo);
                    return string.Format(OutputMessages.WinnigTheWar, planetAlpha.Name, planetBeta.Name);
                }
                else
                {
                    var loserHalf = planetAlpha.Budget / 2;
                    planetBeta.Spend(planetBeta.Budget / 2);
                    planetBeta.Profit(loserHalf);
                    planetAlpha.Spend(planetAlpha.Budget / 2);
                    double loserSum = 0;
                    foreach (var unit in planetAlpha.Army)
                    {
                        loserSum += unit.Cost;
                    }
                    foreach (var unit in planetAlpha.Weapons)
                    {
                        loserSum += unit.Price;
                    }
                    planetBeta.Profit(loserSum);
                    planetRepository.RemoveItem(planetTwo);
                    return string.Format(OutputMessages.WinnigTheWar, planetBeta.Name, planetAlpha.Name);
                }
            }

            return "Invalid Planets";
        }

        public string ForcesReport()
        {
            var planets = this.planetRepository.Models.OrderByDescending(p => p.MilitaryPower).ThenBy(n => n.Name)
                .ToList();
            var sb = new StringBuilder();
            sb.AppendLine("***UNIVERSE PLANET MILITARY REPORT***");
            foreach (var planet in planets)
            {
                sb.AppendLine(planet.PlanetInfo());
            }
            return sb.ToString().TrimEnd();
        }
    }
}
