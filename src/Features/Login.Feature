Feature: Testing Login Functionality 
@Login 
Scenario: valid username and password 
	Given user enters weburl 
	When user enters username and password 
	Then user should log in 
	
@Multiplelogin 
Scenario Outline: Multiple Login 
	Given User is on Home Page of fk 
	When User Navigate to LogIn Page 
	And User enters "<username>" and "<password>" 
	Then Message should display login successfully 
	Examples: 
	
		| username   | password |
		| jakhotiyaabhishek@gmail.com | Abhishek@123 |
		| 7040007049 | mom$123 |
		| 9665732659 | tom |
		@Profile 
		Scenario: My profile functionality 
			Given user clicks on my profile 
			When user navigated to my profile section 
			And User enters data for profile updation 
			Then User data should get updated 
