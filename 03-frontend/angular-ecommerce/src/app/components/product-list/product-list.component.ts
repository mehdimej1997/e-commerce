import { Product } from './../../common/product';
import { ProductService } from './../../services/product.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[];
  /*add Category ID */
  currentCategoryId: number;

  constructor(private productService: ProductService,
              /*Inject active route for accessing route param */
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
    this.listProduct();
  });
}
  listProduct(){
      // check for id pramater is available
    const hasCategoryID: boolean = this.route.snapshot.paramMap.has('id');
    if(hasCategoryID){
      // get the id paramand convert string to number
      this.currentCategoryId = +this.route.snapshot.paramMap.get('id');
    }
    else{
      // not available default category1
      this.currentCategoryId = 1;
    }

    //get products for given id
    this.productService.getProductList(this.currentCategoryId).subscribe(
      data => {
        this.products = data;
      }
    )
  }
}
