csp-595
=======

## Todo - Baseline
* Add sort (products)
* Add search (products)
* Add multiple flavors (categories)
* Orders - Recent orders, show orders < 1 week old
* Orders - Delivered, show orders where delivered date is past current date
* Orders - Cancel Orders that are not delivered
* Fix up inline css
* Make many more items and flavors including images

## Todo - New future Stuff
* During checkout, have option for shipping speed
* During checkout, show taxes
* During checkout, have coupon
* During checkout, show read only summary screen of cart items + shipping info + cost and everything else 
* Homepage show random promotional discounted items
* Homepage return user use cookies to recommend recently viewed things
* Save wishlist
* Wishlist can be public or private

## Examples Shopping Cart Pages
* http://www.amazon.com/
* http://www.bestbuy.com/
* http://www.newegg.com/

## Coffee Data Page
Ok, coffee! Let's make a page like this
* http://www.mistobox.com/mistobox-shop-s/1477.htm

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

### src
All of the java related source code for this project.

### WebContent
All of the jsp, css and libs for this project