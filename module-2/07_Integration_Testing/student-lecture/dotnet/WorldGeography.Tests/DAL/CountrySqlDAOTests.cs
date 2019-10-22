using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;
using WorldGeography.DAL;
using WorldGeography.Models;
using WorldGeography.Tests.DAL;

namespace WorldGeography.Tests
{
    [TestClass]
    public class CountrySQLDALTests : WorldDAOTests
    {
        [TestMethod]
        public void GetCountriesTest_Should_ReturnAllCountries()
        {
            // Arrange
            CountrySqlDAO dao = new CountrySqlDAO(ConnectionString);

            // Act
            IList<Country> countries = dao.GetCountries();

            // Assert
            Assert.AreEqual(1, countries.Count);
        }

        [DataTestMethod]
        [DataRow("North America", 1)]    
        [DataRow("South America", 0)]
        [DataRow("Asia", 0)]
        public void GetCountriesByContinent_Should_ReturnCorrectNumberOfCountries(string continent, int expectedCount)
        {
            CountrySqlDAO dao = new CountrySqlDAO(ConnectionString);
            IList<Country> countries = dao.GetCountries(continent);
            Assert.AreEqual(expectedCount, countries.Count);
        }
    }
}
