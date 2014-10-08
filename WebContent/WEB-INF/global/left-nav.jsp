<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="col-2 left-nav">
  <nav >
    <h4><a href="product">Shop</a></h4>
    <ol>

      <li>
        <h5>
          <a href="product?c=0,1,2,3,4,5">Coffee</a>
        </h5>
      </li>

      <li><a href="product?c=2,3">-- Store</a></li>
      <li><a href="product?c=2">---- Starbucks</a></li>
      <li><a href="product?c=3">---- Dunkin Donuts</a></li>
      <li><a href="product?c=0,1">-- Region</a></li>
      <li><a href="product?c=0">---- African</a></li>
      <li><a href="product?c=1">---- Local</a></li>
      <li><a href="product?c=4,5">-- Bean Type</a></li>
      <li><a href="product?c=4">---- Blend</a></li>
      <li><a href="product?c=5">---- Decaf</a></li>

      <li>
        <h5>
          <a href="product?c=6,7">Accessories</a>
        </h5>
      </li>
      <li><a href="product?c=6">-- Grinder</a></li>
      <li><a href="product?c=7">-- Filter</a></li>

    </ol>
  </nav>
</div>