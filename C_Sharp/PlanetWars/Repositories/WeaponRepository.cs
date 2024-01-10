using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using PlanetWars.Models.Weapons.Contracts;
using PlanetWars.Repositories.Contracts;

namespace PlanetWars.Repositories
{
    public class WeaponRepository : IRepository<IWeapon>
    {
        private List<IWeapon> weapons;
        public WeaponRepository() => this.weapons = new List<IWeapon>();
        public IReadOnlyCollection<IWeapon> Models => this.weapons;

        public void AddItem(IWeapon model)
        {
            this.weapons.Add(model);
        }

        public IWeapon FindByName(string name)
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
            this.weapons.Remove(weaponToRemove);
            return true;
        }
    }
}
