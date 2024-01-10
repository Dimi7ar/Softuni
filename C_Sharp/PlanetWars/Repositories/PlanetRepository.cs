using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using PlanetWars.Models.Planets.Contracts;
using PlanetWars.Repositories.Contracts;

namespace PlanetWars.Repositories
{
    public class PlanetRepository : IRepository<IPlanet>
    {
        private List<IPlanet> weapons;
        public PlanetRepository() => this.weapons = new List<IPlanet>();
        public IReadOnlyCollection<IPlanet> Models => this.weapons;

        public void AddItem(IPlanet model)
        {
            this.weapons.Add(model);
        }

        public IPlanet FindByName(string name)
        {
            var weapon = Models.FirstOrDefault(r => r.Name == name);
            if (weapon == null)
            {
                return null;
            }

            return weapon;
        }

        public bool RemoveItem(string name)
        {
            var weaponToRemove = Models.FirstOrDefault(r => r.Name == name);
            if (weaponToRemove == null)
            {
                return false;
            }
            this.weapons.Remove(weaponToRemove);
            return true;
        }
    }
}
