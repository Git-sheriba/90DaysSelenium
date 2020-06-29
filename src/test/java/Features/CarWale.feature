Feature: Least KM ran car

Scenario: Finding least KM ran car

Given User opens the Browser
And user loads https://www.carwale.com/ 
And User maximises the browser
And User set the default implicit timeout
And user clicks on Used button
And user selects the City as Chennai 
And user selects budget min (8L) and max(12L) 
And user clicks Search 
And user select Cars with Photos under Only Show Cars With photos
And user select Manufacturer as Hyundai and Creta 
And user select Fuel Type as Petrol 
And user select Best Match as KM: Low to High 
And user validate the Cars are listed with KMs Low to High 
And Add the least KM ran car to Wishlist 
And Go to Wishlist 
When Click on More Details 
Then user should be able to see the overview page
Then the user print all the details under Overview 
Then user should close the browser