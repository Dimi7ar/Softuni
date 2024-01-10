using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Formula1.Core.Contracts;
using Formula1.Models.Contracts;
using Formula1.Models.Contracts._FormulaOneCar;
using Formula1.Models.Contracts._Pilot;
using Formula1.Models.Contracts._Race;
using Formula1.Repositories;
using Formula1.Repositories.Contracts;
using Formula1.Utilities;

namespace Formula1.Core
{
    public class Controller : IController
    {
        private FormulaOneCarRepository cars;
        private PilotRepository pilots;
        private RaceRepository races;

        public Controller()
        {
            this.cars = new FormulaOneCarRepository();
            this.pilots = new PilotRepository();
            this.races = new RaceRepository();
        }

        public string AddCarToPilot(string pilotName, string carModel)
        {
            var pilot = this.pilots.FindByName(pilotName);
            var car = this.cars.FindByName(carModel);
            if (pilot == null || pilot.CanRace)
            {
                throw new InvalidOperationException(string.Format(ExceptionMessages.PilotDoesNotExistOrHasCarErrorMessage, pilotName));
            }

            if (car == null)
            {
                throw new NullReferenceException(string.Format(ExceptionMessages.CarDoesNotExistErrorMessage, carModel));
            }

            pilot.AddCar(car);
            this.cars.Remove(car);
            return string.Format(OutputMessages.SuccessfullyPilotToCar, pilot.FullName, car.GetType().Name, car.Model);
        }

        public string AddPilotToRace(string raceName, string pilotFullName)
        {
            var pilot = this.pilots.FindByName(pilotFullName);
            var race = this.races.FindByName(raceName);
            if (race == null)
            {
                throw new NullReferenceException(string.Format(ExceptionMessages.RaceDoesNotExistErrorMessage, raceName)); ;
            }

            ICollection<IPilot> duplicatePilot = race.Pilots.Where(x => x.FullName == pilotFullName).ToList();
            if (pilot == null || !pilot.CanRace || duplicatePilot.Count > 0)
            {
                throw new InvalidOperationException(string.Format(ExceptionMessages.PilotDoesNotExistErrorMessage, pilotFullName));
            }
            race.AddPilot(pilot);
            return string.Format(OutputMessages.SuccessfullyAddPilotToRace, pilot.FullName, race.RaceName);
        }

        public string CreateCar(string type, string model, int horsepower, double engineDisplacement)
        {
            IFormulaOneCar car = this.cars.FindByName(model);
            if (car != null)
            {
                throw new InvalidOperationException(string.Format(ExceptionMessages.CarExistErrorMessage, model));
            }

            if (type == "Ferrari")
            {
                car = new Ferrari(model, horsepower, engineDisplacement);
            }
            else if (type == "Williams")
            {
                car = new Williams(model, horsepower, engineDisplacement);
            }
            else
            {
                throw new InvalidOperationException(string.Format(ExceptionMessages.InvalidTypeCar, type));
            }

            this.cars.Add(car);
            return string.Format(OutputMessages.SuccessfullyCreateCar, car.GetType().Name, car.Model);

        }

        public string CreatePilot(string fullName)
        {
            IPilot pilot = this.pilots.FindByName(fullName);
            if (pilot != null)
            {
                throw new InvalidOperationException(string.Format(ExceptionMessages.PilotExistErrorMessage, fullName));
            }
            this.pilots.Add(new Pilot(fullName));
            return string.Format(OutputMessages.SuccessfullyCreatePilot, fullName);
        }

        public string CreateRace(string raceName, int numberOfLaps)
        {
            IRace race = this.races.FindByName(raceName);
            if (race != null)
            {
                throw new InvalidOperationException(string.Format(ExceptionMessages.RaceExistErrorMessage, raceName));
            }
            race = new Race(raceName, numberOfLaps);
            this.races.Add(race);
            return string.Format(OutputMessages.SuccessfullyCreateRace, raceName);
        }

        public string PilotReport()
        {
            var pilotWins = this.pilots.Models.OrderByDescending(x => x.NumberOfWins).ToList();
            var result = new StringBuilder();
            foreach (var pilot in pilotWins)
            {
                result.AppendLine($"Pilot {pilot.FullName} has {pilot.FullName} wins.");
            }
            return result.ToString().TrimEnd();
        }

        public string RaceReport()
        {
            List<IRace> list = this.races.Models.Where(x => x.TookPlace).ToList();
            var result = new StringBuilder();
            foreach (IRace race in list)
            {
                result.AppendLine(race.RaceInfo());
            }
            return result.ToString().TrimEnd();
        }

        public string StartRace(string raceName)
        {
            var race = this.races.FindByName(raceName);
            if (race == null)
            {
                throw new NullReferenceException(string.Format(ExceptionMessages.RaceDoesNotExistErrorMessage, raceName));
            }

            if (race.TookPlace)
            {
                throw new InvalidOperationException(string.Format(ExceptionMessages.RaceTookPlaceErrorMessage, race.RaceName));
            }

            if (race.Pilots.Count < 3)
            {
                throw new InvalidOperationException(string.Format(ExceptionMessages.InvalidRaceParticipants, race.RaceName));
            }

            List<IPilot> sortedPilot = race.Pilots.OrderByDescending(x => x.Car.RaceScoreCalculator(race.NumberOfLaps)).ToList();

            sortedPilot[0].WinRace();
            race.TookPlace = true;

            StringBuilder sb = new StringBuilder();

            sb.AppendLine(string.Format(OutputMessages.PilotFirstPlace, sortedPilot[0].FullName, raceName));
            sb.AppendLine(string.Format(OutputMessages.PilotSecondPlace, sortedPilot[1].FullName, raceName));
            sb.AppendLine(string.Format(OutputMessages.PilotThirdPlace, sortedPilot[2].FullName, raceName));

            return sb.ToString().TrimEnd();
        }
    }
}
