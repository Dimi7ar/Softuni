using System;
using System.Collections.Generic;
using System.Text;

namespace Formula1.Models.Contracts._Race
{
    public class Race : IRace
    {
        private string raceName;
        private int numberOfLaps;
        private bool tookPlace;
        private ICollection<IPilot> pilots;

        public Race(string raceName, int numberOfLaps)
        {
            this.RaceName = raceName;
            this.NumberOfLaps = numberOfLaps;
            this.TookPlace = false;
            this.pilots = new List<IPilot>();
        }

        public string RaceName
        {
            get => this.raceName;
            private set
            {
                if (string.IsNullOrWhiteSpace(value) || value.Length < 5)
                {
                    throw new ArgumentException($"Invalid race name: {value}.");
                }
                this.raceName = value;
            }
        }

        public int NumberOfLaps
        {
            get => this.numberOfLaps;
            private set
            {
                if (value < 1)
                {
                    throw new ArgumentException($"Invalid lap numbers: {value}.");
                }
                this.numberOfLaps = value;
            }
        }

        public bool TookPlace
        {
            get => this.tookPlace;
            set => this.tookPlace = value;
        }

        public ICollection<IPilot> Pilots
        {
            get => this.pilots;
        }

        public void AddPilot(IPilot pilot)
        {
            this.Pilots.Add(pilot);
        }

        public string RaceInfo()
        {
            var result = new StringBuilder();
            var place = this.TookPlace == true ? "Yes" : "No";
            result.AppendLine($"The {this.RaceName} race has:");
            result.AppendLine($"Participants: {this.Pilots.Count}");
            result.AppendLine($"Number of laps: {this.NumberOfLaps}");
            result.AppendLine($"Took place: {place}");
            return result.ToString().TrimEnd();
        }
    }
}
