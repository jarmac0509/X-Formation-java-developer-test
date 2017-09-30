select country.Name
from country, city 
where country.CountryID = city.CountryID 
group by country.name
having sum(Population) > 400