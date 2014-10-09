csp-595
=======

## Philip - TODO
* Add sort button
* Add multiple flavors
* Replace comparable ints/doubles/longs with BigDecimal

## Examples Shopping Cart Pages
* http://www.amazon.com/ref=nav_logo
* http://www.bestbuy.com/site/index.jsp
* http://www.newegg.com/

## Coffee Data Page
Ok, coffee! Let's make a page like this
* http://www.mistobox.com/mistobox-shop-s/1477.htm

## Scrapping Tool
* Import.IO

## How to build and deploy the project
* Use Git to clone my repo into any one of your own directories on your computer. Here is the URL you use to perform the clone,(https://github.com/philippannenko/csp-595.git).
* In cmd, navigate to the {project}\bat directory and run the bat file that configures your env. (you may need to update this file to represent your directories. all of the env must be set)
* Navigate to {project}\ant directory (in the same cmd prompt!)
* Type the following command into cmd without the single quotes: 'ant'
* The project should compile and then deploy the necessary file to you tomcat directory for your viewing pleasures, (http://localhost/csp-595)

## Directory Structure

### ant
This builds, validates and depoys project to Tomcat.

### bat
This has executable batch files. Currently only one for setting windows env.

### bin
After a successful ant compile, the executable ouput appears here. You can effectively copy paste this directory into Tomcat.

### formatter
A batch file that will format your code according to the checkstyle provided.

### reports
Unit test and checkstyle reports will appear hear after a compile (for checkstyle) or junit tests.

### src
All of the java related source code for this project.

### sql
Future sql queries and ddls will be here.

### test
All of the unit test source code for this project.

### WebContent
All of the jsp, css and libs for this project