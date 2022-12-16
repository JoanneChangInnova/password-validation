## Password Validation Service

This solution uses two patterns: strategy and factory.  
The strategy pattern lets us select the correct validation behavior at runtime. Inside this project, we have one possible behavior: validate password but are open for other behaviors such as validate email, which can be implemented differently.  
The factory pattern is used for creating new objects. We can use this to determine which validator object gets returned.  
`ValidationService` incorporates two patterns: fetches the appropriate validator by passing the Input type and executes the validate() method that applies to the selected strategy.


### How to access

Download repository zip > Extract zip > Open IntelliJ > On the menu bar, File > Open > Navigate to the directory where pom.xml is.

run test:    

    mvn test 
