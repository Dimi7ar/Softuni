using System;
using System.Collections.Generic;
using System.Linq;
using Formula1.Models.Contracts;
using Formula1.Repositories.Contracts;

namespace Formula1.Repositories
{
    public class RaceRepository : IRepository<IRace>
    {
        private List<IRace> races;
        public RaceRepository() => this.races = new List<IRace>();
        public IReadOnlyCollection<IRace> Models => this.races;

        public void Add(IRace model)
        {
            races.Add(model);
        }

        public IRace FindByName(string name)
        {
            var race = Models.FirstOrDefault(r => r.RaceName == name);
            if (race == null)
            {
                return null;
            }

            return race;
        }

        public bool Remove(IRace model)
        {
            if (races.Contains(model))
            {
                races.Remove(model);
                return true;
            }
            return false;
        }
    }
}
