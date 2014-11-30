// Get the browser-specific request object, either for
// Firefox, Safari, Opera, Mozilla, Netscape, IE 8, or IE 7 (top entry);
// or for Internet Explorer 5 and 6 (bottom entry). 

function getRequestObject() {
  if (window.XMLHttpRequest) {
    return (new XMLHttpRequest());
  } else if (window.ActiveXObject) {
    return (new ActiveXObject("Microsoft.XMLHTTP"));
  } else {
    // Don't throw Error: this part is for very old browsers,
    // and Error was implemented starting in JavaScript 1.5.
    return (null);
  }
}

// Make an HTTP request to the given address.
// Display result in an alert box.

function ajaxAlert(address) {
  var request = getRequestObject();
  request.onreadystatechange = function() {
    showResponseAlert(request);
  };
  request.open("GET", address, true);
  request.send(null);
}

// Put response text in alert box.

function showResponseAlert(request) {
  if ((request.readyState == 4) && (request.status == 200)) {
    alert(request.responseText);
  }
}

// Make an HTTP request to the given address.
// Display result in the HTML element that has given ID.

function ajaxResult(address, resultRegion) {
  var request = getRequestObject();
  request.onreadystatechange = function() {
    showResponseText(request, resultRegion);
  };
  request.open("GET", address, true);
  request.send(null);
}

// Put response text in the HTML element that has given ID.

function showResponseText(request, resultRegion) {
  if ((request.readyState == 4) && (request.status == 200)) {
    htmlInsert(resultRegion, request.responseText);
  }
}

// Insert the html data into the element that has the specified id.

function htmlInsert(id, htmlData) {
  document.getElementById(id).innerHTML = htmlData;
}

// Trick so that the Firebug console.log function will
// be ignored (instead of crashing) in Internet Explorer.
// Also see Firebug Lite and Faux Console if you want
// logging to actually do something in IE.
// Firebug Lite: http://getfirebug.com/lite.html
// Faux Console: http://icant.co.uk/sandbox/fauxconsole/

try {
  console.log("Loading script");
} catch (e) {
  console = {
    log : function() {
    }
  };
}

window.onload = function() {

  document.getElementById('container').onclick = function(e) {
    var searchResults = document.getElementById('search-results');
    if (searchResults) {
      searchResults.innerHTML = '';
    }
  }

};

function searchAutoComplete() {
  var searchField = document.getElementById("se");
  var url = "search?s=" + escape(searchField.value);
  doAjax(url, 'search-results');
}

function doAjaxForItem() {
  var searchField = document.getElementById("sortItemUrl");
  var url = "product" + searchField.value;
  doAjax(url, 'replaceMe');
}

function doAjaxForPrice() {
  var searchField = document.getElementById("sortPriceUrl");
  var url = "product" + searchField.value;
  doAjax(url, 'replaceMe');
}

function doAjaxForPagination(page) {
  var searchField = document.getElementById("paginationUrl");
  debugger;
  var url = "product" + searchField.value + "&p=" + page;
  doAjax(url, 'replaceMe');
}

function doAjax(url, domElement) {
  var request = getRequestObject();
  request.onreadystatechange = function() {
    showResponseText(request, domElement);
  };
  request.open("GET", url, true);
  request.send(null);
}
