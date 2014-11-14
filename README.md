csp-595
=======

## Todo - Baseline
* p, Fix up inline css
* j, Assign categories (flavors) to coffee products
* j, Make many more items and flavors including images (items from starbucks, dd && www.mistobox.com)
* j, Testing logged in user order creation & cancellation.
* j, Testing non logged in user order creation & cancellation. (need to use URL to find order)
* j, Testing combinations of sort, categories, pagination, search on the products page. bound to have an error or two there

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
* In cmd, navigate to the {project} directory and run the env-setup.bat file that configures your env. (you may need to update this file to represent your directories. all of the env must be set)
* In the same cmd prompt, now run the following without quotes, 'ant''
* The project should compile and then deploy the necessary file to you tomcat directory for your viewing pleasures, (http://localhost/csp-595)

## Directory Structure

### bin
After a successful ant compile, the executable ouput appears here. You can effectively copy paste this directory into Tomcat.

### src
All of the java related source code for this project.

### WebContent
All of the jsp, css and libs for this project