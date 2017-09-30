select country.Name
from country
left join city on country.CountryID = city.CountryID 
left join building on city.CityID = building.CityID
group by country.Name
having count(BuildingID) = 0