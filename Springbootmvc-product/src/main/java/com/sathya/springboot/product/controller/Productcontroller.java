package com.sathya.springboot.product.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.sathya.springboot.product.entity.Productentity;
import com.sathya.springboot.product.model.Product;
import com.sathya.springboot.product.service.Productservicee;





@Controller
public class Productcontroller {
	
	@Autowired
	Productservicee productservice;

	@GetMapping("/getallproducts")
	public String GetallProducts(Model model)
	{
		List<Productentity> productEntity=productservice.getallproducts();
		model.addAttribute("products", productEntity);
		return "productlist";
	}
	@GetMapping("/getsearchform")
	public String getsearchform()
	{
		return "Searchform";
		
	}
	@PostMapping("/SearchById")
	public String SearchById(@RequestParam Long id, Model model)
	{
		Productentity product =productservice.SearchById(id);
		model.addAttribute("product",product);
		return "Searchform";
		
		}
	@GetMapping("/pro")
	public String getproductform() {
		return "add-product";
		
	}
	 @PostMapping ("/saveproduct")
	public String saveproduct(Product product) {
		 productservice.saveproductdetails(product);
		System.out.println(product);
		return "success";
	}
	 
	 @GetMapping("/delete/{id}")
	 public String deleteById(@PathVariable("id") Long id) {
       productservice.deleteproductbyid(id);
       return "redirect:/getallproducts";
       
		 
	 }
	 @GetMapping("/edit/{id}")
     public String editProductForm(@PathVariable("id") Long id, Model model) 
     {
         Productentity product = productservice.SearchById(id); 
         model.addAttribute("product", product); 
         model.addAttribute("id", id);
         return "edit"; 
     }
     
     @PostMapping("/editproductsave/{id}")
     public String updateProduct(@PathVariable Long id, Product productModel) {
         productservice.updateProduct( productModel,id);
         return "redirect:/getallproducts"; 
     }
}
	 
	 
	 
	 
	 


     

    

	 

	 
	 
	 

		 
	 	
	 
	 
	 







