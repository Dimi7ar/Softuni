using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Formula1.Models.Contracts;
using Formula1.Repositories.Contracts;

namespace Formula1.Repositories
{
    public class PilotRepository : IRepository<IPilot>
    {
        private List<IPilot> pilots;
        public PilotRepository() => this.pilots = new List<IPilot>();
            
        public IReadOnlyCollection<IPilot> Models => this.pilots;

        public void Add(IPilot model)
        {
            pilots.Add(model);
        }

        public IPilot FindByName(string name)
        {
            var race = Models.FirstOrDefault(r => r.FullName == name);
            if (race == null)
            {
                return null;
            }

            return race;
        }

        public bool Remove(IPilot model)
        {
            if (pilots.Contains(model))
            {
                pilots.Remove(model);
                return true;
            }
            return false;
        }
    }
}
