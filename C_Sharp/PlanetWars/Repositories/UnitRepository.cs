using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using PlanetWars.Models.MilitaryUnits.Contracts;
using PlanetWars.Repositories.Contracts;

namespace PlanetWars.Repositories
{
    public class UnitRepository : IRepository<IMilitaryUnit>
    {
        private List<IMilitaryUnit> units;
        public UnitRepository() => this.units = new List<IMilitaryUnit>();
        public IReadOnlyCollection<IMilitaryUnit> Models => this.units;

        public void AddItem(IMilitaryUnit model)
        {
            this.units.Add(model);
        }

        public IMilitaryUnit FindByName(string name)
        {
            var weapon = Models.FirstOrDefault(r => r.GetType().Name == name);
            if (weapon == null)
            {
                return null;
            }

            return weapon;
        }

        public bool RemoveItem(string name)
        {
            var weaponToRemove = Models.FirstOrDefault(r => r.GetType().Name == name);
            if (weaponToRemove == null)
            {
                return false;
            }
            this.units.Remove(weaponToRemove);
            return true;
        }
    }
}
