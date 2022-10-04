Feature: google search validation
	i want to check the user redirect between pages and return the same number of results on each page

	Scenario: Google search validation
		Given the user in google  enter data
		When redirect to next page count the result
		Then validate the second page with third page
