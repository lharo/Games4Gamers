package com.lharo.g4g.Games4Gamers.controllers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;
import com.lharo.g4g.Games4Gamers.models.CatalogoTipoProducto;
import com.lharo.g4g.Games4Gamers.models.Producto;
import com.lharo.g4g.Games4Gamers.services.MailService;
import com.lharo.g4g.Games4Gamers.services.ProductoService;
import com.lharo.g4g.Games4Gamers.services.UserService;
import com.lharo.g4g.Games4Gamers.util.Mail;
import com.lharo.g4g.Games4Gamers.util.MailUtil;
import com.lharo.g4g.Games4Gamers.util.User;

@Controller
public class StaticController {
	
	private ProductoService productoService;
	private MailService mailService;
	private UserService usuarioService;

	@Autowired(required=true)
	@Qualifier(value="productoService")
	public void setProductoService(ProductoService productoService){
		this.productoService = productoService;
	}

	@Autowired(required=true)
	@Qualifier(value="mailService")
	public void setMailService(MailService mailService){
		this.mailService = mailService;
	}

	
	@RequestMapping(value = "/management", method = RequestMethod.GET)
	public String enterManagement(Model model) {
		return "management";
	}
	@RequestMapping(value = "/store", method = RequestMethod.GET)
	public String enterStore(Model model) {
		model.addAttribute("listProduct", this.productoService.listProductos());
		return "store";
	}
   @RequestMapping("/orderProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
    	model.addAttribute("product", this.productoService.getProductoById(id));
        return "orderProduct";
    }
   @RequestMapping("/orderProductBought/{id}/{quantity}")
   public String buyProduct(@PathVariable("id") int id, @PathVariable("quantity") int quantity ,Model model){
   		this.productoService.buyProduct(id, quantity);
	   return "redirect:/store";   
   	}
   @RequestMapping("/reporting")
   public String generateReports(Model model){
	   return "report";
   	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String listProductos(Model model) {
    	model.addAttribute("mapProduct", this.productoService.getProductHashMap());
		return "dashboard";
	}
	
	@RequestMapping(value = "/")
	public String listProducts(Model model) {
		model.addAttribute("usuario", new User());
		return "logIn";
	}
	
	@RequestMapping("/mailForm/{id}")
	public String sendMail(@PathVariable("id") int id, Model model){
		model.addAttribute("type", id);
		model.addAttribute("mail", new Mail());
		return "mailForm";
	}
	
	@RequestMapping("mailForm/sendMail")
	public String sendMail(@ModelAttribute("mail") Mail m){
		Gson gson = new Gson();
		System.out.println(gson.toJson(m));
		MailUtil mailUtil = new MailUtil();
		if(mailUtil.sendMail(m.getReceivers(), m.getMsg(), m.getSubject())) return "report";
		else return "mailForm";
	}
	
	@RequestMapping("mailForm/sendBirthdayMail")
	public String sendBirthdayMail(@ModelAttribute("mail") Mail m){
		Gson gson = new Gson();
		m.setSubject("Happy BirthDay");
		m.setMsg("Happy Birthday from the games4gamers team, use the code BIRTHDAYBOI for a 10% discount on your next order.");
		System.out.println(gson.toJson(m));
		MailUtil mailUtil = new MailUtil();
		if(mailUtil.sendMail(m.getReceivers(), m.getMsg(), m.getSubject())) return "report";
		else return "mailForm";
	}
	
	@RequestMapping("mailForm/mailForm/sendMassiveSpam")
	public String sendMassiveSpam(@ModelAttribute("mail") Mail m){
		
		List<String> users = this.usuarioService.getAllUsersMails();//new ArrayList<String>();
		
		Gson gson = new Gson();
		m.setSubject("Que oferton!!");
		m.setMsg("We are having a massive sale with 10% of discount on all our products");
		m.setReceivers((String[]) users.toArray());
		MailUtil mailUtil = new MailUtil();
		if(mailUtil.sendMail(m.getReceivers(), m.getMsg(), m.getSubject())) return "report";
		else return "mailForm";
	}
	
	@RequestMapping("mailForm/generateReport")
	public ResponseEntity<InputStreamResource> getPDF(){
	
		Document document = new Document();
		try {
			//PdfWriter.getInstance(document, new FileOutputStream("DynamicReport.pdf"));
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

			document.open();
			Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
			Chunk chunk = new Chunk("Hello World", font);
			 
			document.add(chunk);
			document.close();

			//byte[] contents = byteArrayOutputStream.toByteArray();
			InputStream is = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

			HttpHeaders respHeaders = new HttpHeaders();
			MediaType mediaType = MediaType.parseMediaType("application/pdf");
			respHeaders.setContentType(mediaType);
			respHeaders.setContentDispositionFormData("attachment", "DinamicRport.pdf");
			InputStreamResource isr = new InputStreamResource(is);
			return new ResponseEntity<InputStreamResource>(isr, respHeaders, HttpStatus.OK);
		}catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}	

}