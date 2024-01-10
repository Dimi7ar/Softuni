using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Formula1.Models.Contracts;
using Formula1.Repositories.Contracts;

namespace Formula1.Repositories
{
    public class FormulaOneCarRepository : IRepository<IFormulaOneCar>
    {
        private List<IFormulaOneCar> cars;

        public FormulaOneCarRepository() => cars = new List<IFormulaOneCar>();

        public IReadOnlyCollection<IFormulaOneCar> Models => this.cars;

        public void Add(IFormulaOneCar model)
        {
            this.cars.Add(model);
        }

        public IFormulaOneCar FindByName(string name)
        {
            var race = Models.FirstOrDefault(r => r.Model == name);
            if (race == null)
            {
                return null;
            }

            return race;
        }

        public bool Remove(IFormulaOneCar model)
        {
            if (cars.Contains(model))
            {
                cars.Remove(model);
                return true;
            }
            return false;
        }
    }
}
