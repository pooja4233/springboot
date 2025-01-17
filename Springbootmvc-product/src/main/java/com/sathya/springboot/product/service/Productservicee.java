package com.sathya.springboot.product.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.springboot.product.entity.Productentity;
import com.sathya.springboot.product.model.Product;
import com.sathya.springboot.product.repository.productrepository;

@Service

public class Productservicee {
	@Autowired
	productrepository productrepository;
	public void saveproductdetails (Product productmodel) {
		double stockValue = productmodel.getPRICE() * productmodel.getQUANTITY();
        double discountPrice = productmodel.getPRICE() * productmodel.getDISCOUNTRATE() / 100;
        double taxRate = productmodel.getPRICE();
        double offerPrice = productmodel.getPRICE() - discountPrice;
        double finalPrice = offerPrice + taxRate;

        Productentity productEntity = new Productentity();

        productEntity.setNAME(productmodel.getNAME());
        productEntity.setPRICE(productmodel.getPRICE());
        productEntity.setQUANTITY(productmodel.getQUANTITY());
        productEntity.setSTOCKVALUE(stockValue);
        productEntity.setDISCOUNTPRICE(discountPrice);
        productEntity.setTAXRATE(taxRate);
        productEntity.setOFFERPRICE(offerPrice);
        productEntity.setFINALPRICE(finalPrice);
        productEntity.setBRAND(productmodel.getBRAND());
        productEntity.setMADEIN(productmodel.getMADEIN());
        productEntity.setDISCOUNTRATE(productmodel.getDISCOUNTRATE());
        

        productrepository.save(productEntity);
        
        }
        
        
	
    

	public  List<Productentity> getallproducts() {
      List<Productentity>products=productrepository.findAll();
		return products;
	}

	

	public Productentity SearchById(Long id) {
		Optional<Productentity> optionalData= productrepository.findById(id);
			if(optionalData.isPresent()) 
			{
				Productentity product=optionalData.get();
				return product;
			}
			else
			{
				return null;
				}
		}
		
		
		public void deleteproductbyid(Long id){
			productrepository.deleteById(id);
		}
		
		
public void editproductSave(Product product) {
	Productentity products= new Productentity();
	products.setNAME(product.getNAME());
	products.setMADEIN(product.getMADEIN());
	products.setBRAND(product.getBRAND());
	products.setPRICE(product.getPRICE());
	products.setQUANTITY(product.getQUANTITY());
	products.setDISCOUNTRATE(product.getDISCOUNTRATE());
	 	
}

public void updateProduct(Product productModel, Long id) {
	Optional<Productentity> optional= productrepository.findById(id);
	if(optional.isPresent())
	{
		Productentity productentity=optional.get();
		productentity.setNAME(productModel.getNAME());
		productentity.setMADEIN(productModel.getMADEIN());
		productentity.setBRAND(productModel.getBRAND());
		productentity.setPRICE(productModel.getPRICE());
		productentity.setQUANTITY(productModel.getQUANTITY());
		productentity.setDISCOUNTRATE(productModel.getDISCOUNTRATE());
		
		double stockValue = productModel.getPRICE() * productModel.getQUANTITY();
        double discountPrice = productModel.getPRICE() * productModel.getDISCOUNTRATE() / 100;
        double taxPrice = productModel.getPRICE();
        double offerPrice = productModel.getPRICE() - discountPrice;
        double finalPrice = offerPrice + taxPrice;
        
        
        productentity.setSTOCKVALUE(stockValue);
        productentity.setDISCOUNTPRICE(discountPrice);
        productentity.setOFFERPRICE(offerPrice);
        productentity.setFINALPRICE(finalPrice);
        
        productrepository.save(productentity);
		
	}
	
}

	
}






				
			






		
		


		
		
		


